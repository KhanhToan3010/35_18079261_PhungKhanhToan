package com.example.a35_18079261_phungkhanhtoan;

import android.app.Service;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MyBinder myBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class MyBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }


    public double TinhTien(double a, double b, double c, double d){
        return a+ b + c +d;
    }
}