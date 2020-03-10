package com.a11yflagsecurepoc.victim;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class SecureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);

        setContentView(R.layout.activity_secure);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            final TextView token = (TextView) findViewById(R.id.securetoken);

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
