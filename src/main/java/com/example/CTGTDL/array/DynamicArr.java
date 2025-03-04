package com.example.CTGTDL.array;

import java.util.Iterator;

public class DynamicArr<T> implements Iterable<T> {

    private T[] arr;
    private int capacity = 0;
    private int size = 0;
    public DynamicArr(){
        this(10);
    }
    public DynamicArr(int capacity) {
        if(capacity<0) throw new  IllegalArgumentException("Cannot negative + "+ capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }
    public int getSize() {
        return this.size;
    }
    public boolean  isEmpty() {
        return getSize()==0;
    }

    public  T get(int index) {
        return arr[index];
    }
    public void set(int index, T element){
        arr[index] = element;
    }
    public void clear(){
        for (int i =0; i < size; i++){
            arr[i]=null;
        }
        size=0;
    }
    public void add(T element) {
        if (size >= capacity-1){
            if (capacity==0) capacity=1;
            else {
                capacity*=2;
            }
            T[] newArr =(T[])  new Object[capacity];
            for (int i = 0; i<arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        };

        arr[size++]= element;
    }
    public void removeAt(int index){
        if (index>= size || index<=0) throw new IndexOutOfBoundsException();
        T[] newArr = (T[]) new Object[size-1];

        for (int oldArrIndex = 0, newArrIndex = 0; oldArrIndex < size; oldArrIndex++, newArrIndex++){
            if (oldArrIndex == index) newArrIndex--;
            else arr[newArrIndex] = arr[oldArrIndex];
        }
        arr = newArr;
        capacity = --size;

    }
    
    public void remove (Object object) {
        int removeIndex = indexOf(object);
        removeAt(removeIndex);

    }

    public int indexOf(Object object) {
        for (int i = 0; i< size; i++) {
            if (object == null) {
                if (arr[i] == null) return -1;
            }
            else {
                if (object.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean contains (Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < getSize();
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");
            for(int i = 0; i < size-1; i++){
                sb.append(arr[i]).append(",");
            }
            sb.append(arr[size-1]).append("]");
            return sb.toString();
        }
    }
}
