package com.lsj.netsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.asycn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AsyncTaskActivity.class));
            }
        });

        Button button2 = findViewById(R.id.is);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,IntentServiceActivity.class));
            }
        });

    }






    private class DownloadFilesTask extends AsyncTask<URL,Integer,Long>{

        @Override
        protected Long doInBackground(URL... urls) {
            int count = urls.length;
            long totalSize = 0;
            for (int i = 0;i < count;i ++){
                totalSize += Downloader.downloadFile(urls[i]);
                publishProgress((int)((i / (float)count) * 100));
                if (isCancelled())
                    break;
            }
            return totalSize;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
        }

    }

    private static class Downloader {
        public static long downloadFile(URL url) {
            return 0;
        }
    }



}
