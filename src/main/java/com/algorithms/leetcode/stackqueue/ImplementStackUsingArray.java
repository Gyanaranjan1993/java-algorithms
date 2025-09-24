package com.algorithms.leetcode.stackqueue;

public class ImplementStackUsingArray {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public ImplementStackUsingArray(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1; // Stack is initially empty
    }

    public void push(int n){
        if(top == capacity - 1) throw new RuntimeException("Stack is full");
        stack[++top] = n;
    }

    public int pop() {
        if(top <= 0) throw new RuntimeException("Stack is empty");
        return stack[top--];
    }

    public int peek() {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
