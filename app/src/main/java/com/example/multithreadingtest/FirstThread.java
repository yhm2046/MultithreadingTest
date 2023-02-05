package com.example.multithreadingtest;

/**
 * 2023.2.5 10:23
 * 继承Thread类创建线程
 */
public class FirstThread extends Thread{
    private int i;
    @Override
    public void run() {
        for(;i < 5; i++){
            System.out.println("FirstThread thread name:" + getName() + ":" + i);
        }
    }
}
