package com.example.multithreadingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
            System.out.println("mainactivity getname:" + Thread.currentThread().getName()
                    + ":" + i);
            if(i == 2){
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }
}