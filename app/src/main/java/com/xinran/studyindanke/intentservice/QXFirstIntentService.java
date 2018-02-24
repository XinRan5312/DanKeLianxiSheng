package com.xinran.studyindanke.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by houqixin on 2018/2/24.
 *
 * IntentService与Service的区别：
 *
 　　Service不是独立的进程，也不是独立的线程，它是依赖于应用程序的主线程的，不建议在Service中编写耗时的逻辑和操作，否则会引起ANR。

 　　IntentService 它创建了一个独立的工作线程来处理所有的通过onStartCommand()传递给服务的intents（把intent插入到工作队列中）。通过工作队列把intent逐个发送给onHandleIntent()。不需要主动调用stopSelft()来结束服务。因为，在所有的intent被处理完后，系统会自动关闭服务。

 　　 默认实现的onBind()返回null。
 */

public class QXFirstIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public QXFirstIntentService(String name) {
        //给线程起个有意义的名字
        super("myIntentService");
    }

    /**
     * IntentService继承与Service，用来处理异步请求。客户端可以通过startService(Intent)方法传递请求给IntentService。IntentService在onCreate()函数中通过HandlerThread单独开启一个线程来依次处理所有Intent请求对象所对应的任务。　 　　 　　这样以免事务处理阻塞主线程（ＡＮＲ）。执行完所一个Intent请求对象所对应的工作之后，如果没有新的Intent请求达到，则自动停止Service；否则执行下一个Intent请求所对应的任务。　 　　 　　IntentService在处理事务时，还是采用的Handler方式，创建一个名叫ServiceHandler的内部Handler，并把它直接绑定到HandlerThread所对应的子线程。 ServiceHandler把处理一个intent所对应的事务都封装到叫做onHandleIntent的虚函数；因此我们直接实现虚函数onHandleIntent，再在里面根据Intent的不同进行不同的事务处理就可以了。 另外，IntentService默认实现了Onbind（）方法，返回值为null。


     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        /**
         * 　　IntentService在onCreate()函数中通过HandlerThread单独开启一个线程来依次处理所有Intent请求对象所对应的任务。　 　　 　　通过onStartCommand()传递给服务intent被依次插入到工作队列中。工作队列又把intent逐个发送给onHandleIntent()。
         */

        //根据Intent的不同进行不同的事务处理
        String taskName = intent.getExtras().getString("taskName");
        switch (taskName) {
            case "task1":
                Log.i("myIntentService", "do task1");
                break;
            case "task2":
                Log.i("myIntentService", "do task2");
                break;
            default:
                break;
        }
    }
    //--------------------用于打印生命周期--------------------
    @Override
    public void onCreate() {
        Log.i("myIntentService", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("myIntentService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("myIntentService", "onDestroy");
        super.onDestroy();
    }
}
