package com.demo.singleton;

import android.util.Log;

/**
 * Created by cheng on 2018/5/9.
 */

public class JingTai {
    private JingTai(){}
    public static synchronized JingTai getInstance(){
        return JingTaiInner.instance;
    }
    private static class JingTaiInner{
        private static final JingTai instance=new JingTai();
    }

    public void jingtai(){
        Log.e("qwer","静态内部类");
    }
}
