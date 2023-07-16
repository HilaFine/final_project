package dev.hilaferberfine.mysecretfamilyrecipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dev.hilaferberfine.mysecretfamilyrecipeapp.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    private int splashScreenTime = 3000;
    private int timrInterval = 100;
    private int progress = 0;
    private Runnable runnable;
    private Handler handler;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.progressBar2.setMax(splashScreenTime);
        binding.progressBar2.setProgress(progress);
        handler = new Handler(Looper.getMainLooper());
        runnable = () -> {
            if (progress < splashScreenTime) {
                progress += timrInterval;
                binding.progressBar2.setProgress(progress);
                handler.postDelayed(runnable, timrInterval);
            } else {
                //FirebaseApp.initializeApp(this);
                /*FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {

                 */
                startActivity(new Intent(SplashActivity.this, LogInActivity.class));
                finish();
            }


        };
        handler.postDelayed(runnable, timrInterval);
    }
}