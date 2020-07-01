package com.lsj.netsample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lsj.netsample.service.LocalIntentService;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        final Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == button){

                    Intent service = new Intent(IntentServiceActivity.this, LocalIntentService.class);
                    service.putExtra("task_action","com.lsj.action.TASK1");
                    startService(service);
                    service.putExtra("task_action","com.lsj.action.TASK2");
                    startService(service);
                    service.putExtra("task_action","com.lsj.action.TASK3");
                    startService(service);

                }
            }
        });

    }

//    public class LocalIntentService extends IntentService{
//
//        private final String TAG = LocalIntentService.class.getSimpleName();
//
//        /**
//         * Creates an IntentService.  Invoked by your subclass's constructor.
//         *
//         * @param name Used to name the worker thread, important only for debugging.
//         */
//        public LocalIntentService(String name) {
//            super(name);
//        }
//
//        @Override
//        protected void onHandleIntent(@Nullable Intent intent) {
//            String action = intent.getStringExtra("task_action");
//            Log.d(TAG,"receive task : " + action);
//            SystemClock.sleep(3000);
//            if ("com.lsj.action.TASK1".equals(action)){
//                Log.d(TAG,"handle task : " + action);
//            }
//        }
//
//        @Override
//        public void onDestroy() {
//            Log.d(TAG,"service destroyed.");
//            super.onDestroy();
//        }
//    }

}
