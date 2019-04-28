package com.yh.yhandmlu.设计模式.行为型.second.iterator;

public class MyCollection implements Collection{

    private String[] arr = {"1","2","3"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return arr[i];
    }

    @Override
    public int size() {
        return arr.length;
    }
}
