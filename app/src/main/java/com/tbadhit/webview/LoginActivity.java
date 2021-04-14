package com.tbadhit.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.tbadhit.webview.databinding.ActivityLoginBinding;

// Bikin layout
//..
// Codenya syncronus
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SessionManager sessionManager = new SessionManager(LoginActivity.this);

        binding.btnLogin.setOnClickListener(v -> {

            String username = binding.edtUsername.getText().toString();
            String email = binding.edtEmail.getText().toString();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
            } else if (username.equals("tubagus") && email.equals("tubagus@gmail.com")) {
                // input data session
                sessionManager.sessionLogin(username, email);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Username / email salah", Toast.LENGTH_SHORT).show();
            }

        });
        // Selesai membuat login (manual)
        // Setelah membuat login, masuk ke "MainActivity" tambahkan kode dengan komen (ACCDRAW) ->

    }
}