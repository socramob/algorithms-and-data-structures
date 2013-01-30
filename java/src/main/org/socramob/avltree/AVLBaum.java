package org.socramob.avltree;


import static org.socramob.avltree.LeererBaum.leererBaum;

public class AVLBaum<T extends Comparable<T>> {

    private Baum<T> _content = leererBaum();

    public AVLBaum() { }

    public boolean empty() {
        return _content.empty();
    }

    public boolean insert(T element) {
        try {
            _content = _content.insert(element);
            return true;
        } catch (DuplicateEntryException e) {
            return false;
        }
    }

    public boolean delete(T element) {
        _content = _content.delete(element);
        return false;
    }

    public Integer height() {
        return _content.height();
    }

    public void visit(BaumVisitor<T> baumVisitor) {
        _content.visit(baumVisitor);
    }
}
