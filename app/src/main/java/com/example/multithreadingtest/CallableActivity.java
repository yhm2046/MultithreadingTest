package com.example.multithreadingtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * test Callable interface
 * 适用于多个相同线程通常处理同一个系统资源的情况,符合面向对象设计模式
 */
public class CallableActivity extends AppCompatActivity {
    public static void main(String[] args) {

//        var rt = new CallableActivity();
//        FutureTask是一个可以用来实现异步回调的Java API类。
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() ->{
            var i = 0;
            for(; i < 20; i++){ //会顺序交替执行20次,何时候开机不确定
                System.out.println(Thread.currentThread().getName() + "的FutureTask循环变量i的值:" + i);
            }
            return i;
        } );
        for(var i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值:" + i);
            if(i == 5){
                new Thread(task,"有返回值的线程").start();
                System.out.println("有返回值的线程start...");
            }
        }
        try{
            System.out.println("子线程的返回值:" + task.get());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception : " + e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate...");
        main(null);
    }
}