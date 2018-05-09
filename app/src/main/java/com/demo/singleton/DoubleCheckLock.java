package com.demo.singleton;

import android.util.Log;

/**
 * Created by cheng on 2018/5/9.
 */

public class DoubleCheckLock {
    private static DoubleCheckLock instance=null;
    private DoubleCheckLock(){}
    public static synchronized DoubleCheckLock getInstance(){
        if (instance==null){
            synchronized (DoubleCheckLock.class){
                if (null==instance){
                    instance=new DoubleCheckLock();
                }
            }
        }
        return instance;
    }

    public void dcl(){
        Log.e("qwer","dcl");
    }
}
