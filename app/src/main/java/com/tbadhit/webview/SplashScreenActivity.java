package com.tbadhit.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tbadhit.webview.databinding.ActivitySplashScreenBinding;

// bikin layout
// bikin binding
public class SplashScreenActivity extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // (APPBAROFF)
        getSupportActionBar().hide();

        binding.lottieAnimation.setAnimation("AndroidWave.json");
        // yang bakal jalanin animasi
        binding.lottieAnimation.playAnimation();

        // (SP)
        SessionManager sessionManager = new SessionManager(SplashScreenActivity.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // SEBELUM SP
                //Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                //startActivity(intent);
                //finish();

                // (SP)
                Intent intent;
                if(sessionManager.isLogin()){
                    intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
                // Setelah membuat kode di atas, masuk ke "LoginActivity" ->
            }
        }, 3000);
        // Setelah bikin code di atas, masuk ke "AndroidManifest.xml" ubah tag intent ke dalam tag "SplashScreenActivity" ->
        // Setelah atur manifest, hapus appbar aplikasinya dengan cara tambahkan code yang tag (APPBAROFF)
        // END OF SPLASH SCREEN (lanjut Shared Preferences)

        // SharedPreference :
        // Bikin class java dengan nama "SessionManager" ->
    }
}