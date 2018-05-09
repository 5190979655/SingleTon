package com.demo.singleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 饿汉式：是在声明静态对象时就已经初始化。
     */
    public void ehan(View view) {
        EHan instance = EHan.getInstance();
        instance.ehan();
    }

    /**
     *懒汉式：实名一个静态对象，并且在用户第一次调用getInstance 时进行初始化，优点：单例只有在使用时才会被实例化，
     * 一定程度上节约了资源。缺点：是第一次加载时需要及时进行实例化，反应稍慢，最大的问题是每次调用getInstance 都进行同步，
     * 造成不必要的同步开销。一般不建议这么用。。
     */
    public void lanhan(View view) {
        LanHan instance = LanHan.getInstance();
        instance.lanhan();
    }

    /**
     *  DCL  介绍

     DCL 在getInstance 方法中 对instance 进行两次判空：相信很多人对此都有些疑惑。为什么要判断两次，
     第一个判空是为了避免不必要的同步，第二层判断是为了在null 情况下创建实例。instance=new Singleton();
     语句看起来是有代码，单实际是一个原子操作，最终会被编译成多条汇编指令，大致做了三件事：

     1.给Singleton 分配内存

     2.调用Singleton 的构造函数，初始化成员字段

     3.将instance 对象指向分配的内存空间（此时instance 就不是null 了）

     但是jdk 1.5 以后java 编译器允许乱序执行 。所以执行顺序可能是1-3-2 或者 1-2-3.如果是前者先执行3 的话 切换到其他线程，
     instance 此时 已经是非空了，此线程就会直接取走instance ，直接使用，这样就回出错。DCL 失效。解决方法 SUN 官方已经给我们了。
     将instance 定义成 privatevolatilestatic Singleton instance =null: 即可

     DCL 的优点，资源利用率高，第一次执行getInstance 时才会被实例化，效率高。缺点：第一次加载反应慢，
     也由于java 内存 模型的原因偶尔会失败，在高并发环境下，有一定缺陷，虽然发生概率很小。(很常用)

     */
    public void dcl(View view) {
        DoubleCheckLock lock = DoubleCheckLock.getInstance();
        lock.dcl();
    }

    /**
     * 静态内部类单例模式：加载singleton 类时不会初始化instance 只有在调用getInstance 方法时，才会导致instance 被初始化,这个方法不仅能够确保线程安全，
     * 也能够保证 单例对象的唯一性,同时也延迟了单例的实例化，是推荐使用的单例模式实现方式。
     */
    public void jingtai(View view) {
        JingTai jingTai = JingTai.getInstance();
        jingTai.jingtai();
    }

    /**
     * 枚举单例：它在任何情况下都是单例的，也是最简单的。
     */
    public void meiju(View view) {
        MeiJu instance = MeiJu.INSTANCE;
        instance.meiju();
    }
}
