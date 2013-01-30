package org.socramob.avltree;


import static org.socramob.avltree.LeererBaum.leererBaum;

class Zweig<T extends Comparable<T>> implements Baum<T> {

    final T value;
    private final Baum<T> linkerTeilbaum;
    private final Baum<T> rechterTeilbaum;

    public static <T extends Comparable<T>> Zweig<T> createGabel(T value, Baum<T> linkerTeilbaum, Baum<T> rechterTeilbaum) {
        return new Zweig<T>(value, linkerTeilbaum, rechterTeilbaum);
    }

    private Zweig(T value, Baum<T> linkerTeilbaum, Baum<T> rechterTeilbaum) {
        this.value = value;
        this.linkerTeilbaum = linkerTeilbaum;
        this.rechterTeilbaum = rechterTeilbaum;
    }


    public static <T extends Comparable<T>> Zweig<T> createBlatt(T value) {
        return new Zweig<T>(value);
    }

    private Zweig(T value) {
        this(value, leererBaum(), leererBaum());
    }

    Zweig<T> rechts() {
        return rechterZweig();
    }

    Zweig<T> links() {
        return linkerZweig();
    }

    boolean istLinkslastig() {
        return balance() < 0;
    }

    boolean istRechtslastig() {
        return balance() > 0;
    }

    boolean hatLinksUebergewicht() {
        return balance() < -1;
    }

    boolean hatRechtsUebergewicht() {
        return balance() > 1;
    }

    @Override
    public T value() {
        return value;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public Integer height() {
        return max(linkerTeilbaum().height(), rechterTeilbaum().height()) + 1;
    }

    @Override
    public String toString() {
        return String.format("Zweig[%d]:h=%d,delta_h=%d", value, height(), balance());
    }

    public int balance() {
        return (-linkerTeilbaum().height() + rechterTeilbaum().height());
    }

    private static Integer max(Integer x, Integer y) {
        return x > y ? x : y;
    }

    @Override
    public Baum<T> insert(T element) throws DuplicateEntryException {
        if (element.compareTo(value) == 0) {
            throw new DuplicateEntryException(element);
        }
        if (element.compareTo(value) > 0) {
            return ZweigFunktionen.balanciereAus(createGabel(value, linkerTeilbaum(), rechterTeilbaum().insert(element)));
        } else {
            return ZweigFunktionen.balanciereAus(createGabel(value, linkerTeilbaum().insert(element), rechterTeilbaum()));
        }
    }

    @Override
    public void visit(BaumVisitor visitor) {
        visitor.process(this);
    }

    @Override
    public Baum<T> delete(T element) throws ElementNotFound {
        if (rechterTeilbaum().empty() && linkerTeilbaum.empty()) {
            return leererBaum();
        } else if (rechterTeilbaum().empty()) {
            return linkerTeilbaum();
        } else if(linkerTeilbaum().empty()) {
            return rechterTeilbaum();
        } else {
            T nachfolger = linkerZweig().groesstesElement();
            return ZweigFunktionen.balanciereAus(createGabel(nachfolger, linkerZweig().delete(nachfolger), rechterTeilbaum()));
        }
    }

    private T groesstesElement() {
        if(rechterTeilbaum().empty()) {
            return this.value();
        }
        return rechterZweig().groesstesElement();
    }

    Zweig<T> withRechterTeilbaum(Baum<T> neuerRechterTeilbaum) {
        return createGabel(value(), linkerTeilbaum(), neuerRechterTeilbaum);
    }

    Zweig<T> withLinkerTeilbaum(Baum<T> neuerLinkerTeilbaum) {
        return createGabel(value(), neuerLinkerTeilbaum, rechterTeilbaum());
    }

    Zweig<T> rechterZweig() {
        return (Zweig<T>) rechterTeilbaum();
    }

    Zweig<T> linkerZweig() {
        return (Zweig<T>) linkerTeilbaum();
    }

    public Baum<T> linkerTeilbaum() {
        return linkerTeilbaum;
    }

    public Baum<T> rechterTeilbaum() {
        return rechterTeilbaum;
    }
}
