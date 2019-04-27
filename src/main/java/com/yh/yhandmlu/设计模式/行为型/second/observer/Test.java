package com.yh.yhandmlu.设计模式.行为型.second.observer;

public class Test {

    public static void main(String[] args) {
        Subject subject = new SubjectMy();
        subject.add(new Observer1());
        subject.add(new Observer2());

        subject.operator();
    }
}
