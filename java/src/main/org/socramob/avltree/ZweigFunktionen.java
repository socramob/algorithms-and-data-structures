package org.socramob.avltree;


import static org.socramob.avltree.Zweig.createGabel;

class ZweigFunktionen {
    static <T extends Comparable<T>> Baum<T> balanciereAus(Zweig<T> baum) {
        if (baum.hatLinksUebergewicht()) {
            return komplexeRechtsrotation(baum);
        }
        if (baum.hatRechtsUebergewicht()) {
            return komplexeLinksrotation(baum);
        }
        return baum;
    }

    static <T extends Comparable<T>> Baum<T> komplexeRechtsrotation(Zweig<T> baum) {
        Zweig<T> linkerZweig = baum.linkerZweig();
        if (linkerZweig.istRechtslastig()) {
            return einfacheRechtsrotation(baum.withLinkerTeilbaum(einfacheLinksrotation(linkerZweig)));
        } else {
            return einfacheRechtsrotation(baum);
        }
    }

    static <T extends Comparable<T>> Baum<T> komplexeLinksrotation(Zweig<T> baum) {
        Zweig<T> rechterZweig = baum.rechterZweig();
        if (rechterZweig.istLinkslastig()) {
            return einfacheLinksrotation(baum.withRechterTeilbaum(einfacheRechtsrotation(rechterZweig)));
        } else {
            return einfacheLinksrotation(baum);
        }
    }

    static <T extends Comparable<T>> Baum<T> einfacheRechtsrotation(Zweig<T> baum) {
        return createGabel(baum.links().value(),
                baum.links().linkerTeilbaum(),
                createGabel(baum.value,
                        baum.links().rechterTeilbaum(),
                        baum.rechterTeilbaum()));
    }

    static <T extends Comparable<T>> Baum<T> einfacheLinksrotation(Zweig<T> baum) {
        return createGabel(baum.rechts().value(),
                createGabel(baum.value,
                        baum.linkerTeilbaum(),
                        baum.rechts().linkerTeilbaum()),
                baum.rechts().rechterTeilbaum());
    }

}
