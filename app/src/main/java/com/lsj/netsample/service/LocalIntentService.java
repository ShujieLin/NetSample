package com.lsj.netsample.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

public class LocalIntentService extends IntentService {

    private static final String TAG = LocalIntentService.class.getSimpleName();


    public LocalIntentService(){
        super(TAG);
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public LocalIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getStringExtra("task_action");
        Log.d(TAG,"receive task : " + action);
        SystemClock.sleep(3000);
        if ("com.lsj.action.TASK1".equals(action)){
            Log.d(TAG,"handle task : " + action);
        }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"service destroyed.");
        super.onDestroy();
    }
}
