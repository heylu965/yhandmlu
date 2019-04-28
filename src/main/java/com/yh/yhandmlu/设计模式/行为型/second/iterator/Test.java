package com.yh.yhandmlu.设计模式.行为型.second.iterator;

public class Test {

    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println("previous:"+iterator.previous());
            System.out.println(iterator.next());
        }

        System.out.println("first:"+iterator.first());
    }
}
