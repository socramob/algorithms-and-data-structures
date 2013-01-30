package org.socramob.avltree;


class LeererBaum<T extends Comparable<T>> implements Baum<T> {
    private static final LeererBaum INSTANCE = new LeererBaum();

    private LeererBaum() { }

    public static LeererBaum leererBaum() {
        return INSTANCE;
    }

    @Override
    public T value() {
        throw new IllegalAccessError("LeererBaum hat keinen Wert");
    }

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public Integer height() {
        return 0;
    }

    @Override
    public Baum<T> insert(T element) {
        return Zweig.createBlatt(element);
    }

    @Override
    public void visit(BaumVisitor visitor) {
        visitor.process(this);
    }

    @Override
    public Baum<T> delete(T element) throws ElementNotFound {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
