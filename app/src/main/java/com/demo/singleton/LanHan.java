package com.demo.singleton;

import android.util.Log;

/**
 * Created by cheng on 2018/5/9.
 */

public class LanHan {
    private static LanHan instance;
    private LanHan(){}
    public static synchronized LanHan getInstance(){
        if (instance==null) instance=new LanHan();
        return instance;
    }

    public void lanhan(){
        Log.e("qwer","懒汉");
    }
}
