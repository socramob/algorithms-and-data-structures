package org.socramob.avltree;


public interface BaumVisitor<T extends Comparable<T>> {
    void process(LeererBaum<T> leererBaum);
    void process(Zweig<T> zweig);
}
