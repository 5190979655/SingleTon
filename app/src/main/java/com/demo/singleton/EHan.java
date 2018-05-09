package com.demo.singleton;

import android.util.Log;

/**
 * 饿汉
 * Created by cheng on 2018/5/9.
 */

public class EHan {
    private static EHan instance=new EHan();
    private EHan(){}
    public static synchronized EHan getInstance(){
        return instance;
    }

    public void ehan(){
        Log.e("qwer","恶汉");
    }
}
