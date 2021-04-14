package com.tbadhit.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

// Buka dokumentasi penggunaan shared pref
// mulai
// Codenya syncronus
public class SessionManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    // untuk key username & email :
    private String keyUsername = "username";
    private String keyEmail = "email";

    // Constructor (hasil klik kanan bukan ngetik)
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("com.tbadhit.webview.session", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void sessionLogin(String username, String email) {
        editor.putString(keyUsername, username);
        editor.putString(keyEmail, email);
        editor.apply();
    }

    public void sessionLogout() {
        editor.remove(keyUsername);
        editor.remove(keyEmail);
        editor.apply();
    }

    public String getUsername() {
        return sharedPreferences.getString(keyUsername, null);
    }

    public String getEmail() {
        return sharedPreferences.getString(keyEmail, null);
    }

    public boolean isLogin() {
        return !TextUtils.isEmpty(getUsername()) && !TextUtils.isEmpty(getEmail());
    }
    // Setelah membuat code di atas, bikin activity baru "LoginActivity" ->
}
