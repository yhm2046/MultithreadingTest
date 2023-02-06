package com.example.multithreadingtest;

/**
 * 2023.2.6 14:57
 * Using Runnable interface build Thread
 */
public class RunnableThread implements Runnable {
    private int i;
    @Override
    public void run() {
        for(;i < 5; i++){
            System.out.println("RunnableThread name:" + Thread.currentThread().getName() + ":" + i);
        }
    }
}
