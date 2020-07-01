package com.lsj.netsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AsyncTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        final Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == button){
                    new MyAsyncTask("AsyncTask#1").execute();
                    new MyAsyncTask("AsyncTask#2").execute();
                    new MyAsyncTask("AsyncTask#3").execute();
                    new MyAsyncTask("AsyncTask#4").execute();
                    new MyAsyncTask("AsyncTask#5").execute();
                }
            }
        });

        final Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == button2){
                    new MyAsyncTask("AsyncTask#1").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"");
                    new MyAsyncTask("AsyncTask#2").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"");
                    new MyAsyncTask("AsyncTask#3").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"");
                    new MyAsyncTask("AsyncTask#4").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"");
                    new MyAsyncTask("AsyncTask#5").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"");
                }
            }
        });
    }


    private static class MyAsyncTask extends AsyncTask<String,Integer,String>{

        private static final String TAG = MyAsyncTask.class.getSimpleName();
        private String mName = "MyAsyncTask";

        public MyAsyncTask(String name){
            super();
            mName = name;
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return mName;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Log.d(TAG,s + "execute finish at " + df.format(new Date()));
        }
    }
}
