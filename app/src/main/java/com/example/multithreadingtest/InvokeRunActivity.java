package com.example.multithreadingtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 2023.2.14    Tuesday
 * 直接调用thread演示
 */
public class InvokeRunActivity extends AppCompatActivity {
    private int i;
    //重写run(),返回是该对象名字而不是进程名字
    public void run(){
        for(; i < 5; i++){
            System.out.println("run name:" + Thread.currentThread().getName() + " " + i);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i <10; i++){ //循环10次,直接调用run会当成普通程序顺序执行
            System.out.println("mainactivity getname:" + Thread.currentThread().getName()
                    + ":" + i);
            if(i == 2){
                new InvokeRunActivity().run();
                new InvokeRunActivity().run();
            }
        }
    }
}