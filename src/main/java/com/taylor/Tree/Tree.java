package com.taylor.Tree;

public interface Tree<E> {
    void preOrderTraverse(E e);

    void infixOrderTraverse(E e);

    void postOrderTraverse(E e);
}
