package br.com.insure.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import br.com.insure.R;

/**
 * Created by Lucas on 27/11/2016.
 */
public class AppSplashScreenActivity extends Activity {

    private final int SPLASH_TIMEOUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_splash_screen);

        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        iniciarAplicacao();
    }

    private void iniciarAplicacao() {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(AppSplashScreenActivity.this, BemVindoActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}