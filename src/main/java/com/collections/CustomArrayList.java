package com.collections;

public class CustomArrayList {

    static int DEFAULT_CAPACITY = 10;
    int[] arr;
    int size;


    public CustomArrayList(){
        arr = new int[DEFAULT_CAPACITY];
    }

    public int add(int a){
        arr = ensureCapacity();
        arr[size++] = a;
        return a;
    }

    public int remove(int index) {
        checkIndex(index);
        int removed = arr[index];

        int[] newArr = new int[size - 1];

        for(int i =0, j=0; i< size ; i++, j++ ){
            if(arr[i] != removed) {
                newArr[j] = arr[i];
                j++;
            }
        }

        arr = newArr;
        return removed;
    }

    public int[] ensureCapacity() {
        if(size == arr.length){
            int newSize = size + (size >> 1);
            int[] newArr = new int[newSize];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }

        return arr;
    }

    public int get(int index) {
        checkIndex(index);
        return arr[index];
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index "+ index + "Out of bounds");
    }


}
