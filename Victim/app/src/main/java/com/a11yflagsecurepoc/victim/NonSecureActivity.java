package com.a11yflagsecurepoc.victim;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NonSecureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonsecure);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            final TextView token = (TextView) findViewById(R.id.nonsecuretoken);

            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            token.setText(Integer.toString(Integer.valueOf(token.getText().toString()) + 1));
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        Log.e("a11ypoc", Log.getStackTraceString(e));
                    }
                }
            };
            t.start();
        } catch (Exception e) {
            Log.e("a11ypoc", Log.getStackTraceString(e));
        }
    }

}