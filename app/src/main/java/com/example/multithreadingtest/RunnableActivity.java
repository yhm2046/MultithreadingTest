package com.example.multithreadingtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * build at 2023.2.8    Wednesday
 * 疯狂java讲义P736,16.2.2
 */
public class RunnableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        某次结果:
 mainactivity getname:main:0
 mainactivity getname:main:1
 mainactivity getname:main:2
 mainactivity getname:main:3
 mainactivity getname:main:4
 mainactivity getname:main:5
 FirstThread thread name:Thread-2:0
 mainactivity getname:main:6
 FirstThread thread name:Thread-2:1
 mainactivity getname:main:7
 FirstThread thread name:Thread-2:2
 FirstThread thread name:Thread-3:0
 FirstThread thread name:Thread-2:3
 mainactivity getname:main:8
 FirstThread thread name:Thread-2:4
 mainactivity getname:main:9
 FirstThread thread name:Thread-3:1
 FirstThread thread name:Thread-3:2
 FirstThread thread name:Thread-3:3
 FirstThread thread name:Thread-3:4
        * */
        for(int i = 0; i <10; i++){ //循环10次,从第2次开始执行线程,每次运行见过不一样
            System.out.println("main:" + Thread.currentThread().getName()
                    + ":" + i);
            if(i == 2){ //线程执行次数跟机器有关,1个线程执行5次,2个6次,3个七次
                var st = new RunnableThread();
                new Thread(st,"a").start();
                new Thread(st,"b").start();
                new Thread(st,"c").start();
            }
        }
    }
}