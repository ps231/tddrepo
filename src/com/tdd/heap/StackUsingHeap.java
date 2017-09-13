package com.tdd.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//implement stack api using a heap structure
public class StackUsingHeap {
    public static void main(final String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(8);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}

class MyStack<T> {

    private PriorityQueue<HeapElement<T>> heap = new PriorityQueue<HeapElement<T>>(Comparator.comparingInt(o1 -> o1.getCount()));
    private int count = 1;

    public void push(T number) {
        heap.add(new HeapElement<>(count++, number));
    }

    public T pop() {
        return heap.poll().getElement();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

class HeapElement<T> {

    private int count;
    private T element;

    public HeapElement(int count, T element) {
        this.count = count;
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public int getCount() {
        return count;
    }
}