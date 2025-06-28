package com.collections;

import com.algorithms.leetcode.ListNode;

import java.util.LinkedList;

public class MyHashSet<T> {
    private LinkedList<T>[] list;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    int size;

    public MyHashSet() {
        this.list = new LinkedList[10];
        size = 0;
    }

    private int getIndex(T key){
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % list.length;
    }

    public T add(T key){
        int index = getIndex(key);
        if(size > list.length * LOAD_FACTOR) {
            resize();
        }

        if(list[index] == null) {
            list[index] = new LinkedList<>();
        }
        list[index].add(key);
        return key;

    }

    public boolean remove(T key){
        int index = getIndex(key);
        LinkedList<T> list1 = list[index];

        return list1 != null && list1.remove(key);
    }

    private void resize() {
        LinkedList<T>[] oldList = list;
        list = new LinkedList[oldList.length * 2];
        for(LinkedList<T> l : oldList){
            if(l != null){
                for(T key : l){
                   add(key);
                }
            }
        }
    }
}
