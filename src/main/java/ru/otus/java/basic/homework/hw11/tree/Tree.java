package ru.otus.java.basic.homework.hw11.tree;

import java.util.*;

public class Tree<T extends Comparable<T>> implements SearchTree<T> {

    private final Node<T> root;

    public Tree(List<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
        this.root = createTree(list, 0, list.size() - 1);
    }

    private Node<T> createTree(List<T> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node<T> node = new Node<>(list.get(mid));
        node.setLeftChild(createTree(list, start, mid - 1));
        node.setRightChild(createTree(list, mid + 1, end));
        return node;
    }

    private List<T> getSortedList(List<T> list, Node<T> node) {
        if (node != null) {
            getSortedList(list, node.getLeftChild());
            list.add(node.getCurrent());
            getSortedList(list, node.getRightChild());
        }
        return list;
    }

    @Override
    public T find(T element) {
        return root.find(element);
    }

    @Override
    public List<T> getSortedList() {
        List<T> list = new ArrayList<>();

        return getSortedList(list, root);
    }

    public void print() {
        root.print();
    }

    static class Node<Y extends Comparable<Y>> {
        private final Y current;
        private Node<Y> leftChild;
        private Node<Y> rightChild;

        public Node(Y current) {
            this.current = current;
        }

        public Node<Y> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<Y> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<Y> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<Y> rightChild) {
            this.rightChild = rightChild;
        }

        public Y getCurrent() {
            return current;
        }

        public Y find(Y element) {
            var comparatorResult = current.compareTo(element);
            if (comparatorResult == 0) {
                return current;
            }
            if (comparatorResult < 0) {
                if (rightChild == null) {
                    return null;
                }
                return rightChild.find(element);

            }
            if (leftChild == null) {
                return null;
            }
            return leftChild.find(element);

        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            traversePreOrder(sb, this, "", "");
            System.out.println(sb.toString());
        }

        private void traversePreOrder(StringBuilder sb, Node<Y> node, String padding, String pointer) {
            if (node != null) {
                sb.append(padding);
                sb.append(pointer);
                sb.append(node.getCurrent().toString());
                sb.append("\n");

                StringBuilder paddingBuilder = new StringBuilder(padding);
                paddingBuilder.append("│  ");

                String paddingForBoth = paddingBuilder.toString();
                String pointerForRight = "└──";
                String pointerForLeft = (node.getRightChild() != null) ? "├──" : "└──";
                traversePreOrder(sb, node.getLeftChild(), paddingForBoth, pointerForLeft);
                traversePreOrder(sb, node.getRightChild(), paddingForBoth, pointerForLeft);
            }
        }
    }

}
