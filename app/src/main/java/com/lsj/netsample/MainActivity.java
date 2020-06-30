package com.lsj.netsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public abstract class Employee
    {
        private String name;
        private String address;
        private int number;

        public abstract double computePay();

        //其余代码
    }

    /* 文件名 : Animal.java */
    interface Animal {
        public void eat();
        public void travel();
    }

}
