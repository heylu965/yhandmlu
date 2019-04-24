package com.yh.yhandmlu.设计模式.结构型.facade;

public class Computer {

    private CPU cpu;

    private Disk disk;

    private Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    public void startUp(){
        System.out.println("Computer startUp...");
        cpu.startUp();
        disk.startUp();
        memory.startUp();
    }

    public void shutDown(){
        System.out.println("Computer shutDown...");
        cpu.shutDown();
        disk.shutDown();
        memory.shutDown();
    }
}
