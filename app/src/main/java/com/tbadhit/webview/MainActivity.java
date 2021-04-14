package com.tbadhit.webview;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
// Start!
// Saat create project pilih template Navigator Drawer Activity
// Setelah create project coba running dlu
// Fragment adalah tampilan yang di hidup di activity
// Buka resource "menu" lalu klik "activity_main_drawer" dan tambahkan layoutnya ->
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    // (ACCDRAW)
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                // (ADDED)
                // Tambahkan "R.id.nav_webview" (Added)
                // Setelah di tambah masuk ke package "navigation" klik "mobile_navigation.xml", dan tambahkan webview fragment (klik logo hp+)
                // setelah itu edit layout mobile_navigation.xmlnya
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_webview)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // (ACCDRAW)
        sessionManager = new SessionManager(MainActivity.this);
        // Setelah membuat kode di atas, masuk ke layout "activity_main"

        // (AFTERNHM)
        // setelah atur layout "nav_header_main" (Bikin ketika login data username sama emalnya masuk ke bagian drawer)
        View view = navigationView.getHeaderView(0);
        TextView tvUserName = view.findViewById(R.id.tv_username);
        TextView tvEmail = view.findViewById(R.id.tv_email);

        tvUserName.setText(sessionManager.getUsername());
        tvEmail.setText(sessionManager.getEmail());
        //-------------------------------------------
        // Setelah membuat kode di atas.. (Bikin logout) masuk ke resource "main.xml" di dalam package "menu" ->
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // (LOGOUT)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            sessionManager.sessionLogout();

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        // (CL)
        if (item.getItemId() == R.id.action_settings) {

            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        //---------------------------
        // END OF CUSTOM LANGUAGE (Selesai Deh!!).
        return super.onOptionsItemSelected(item);
    }
    // END OF SHARED PREFFERENCES (lanjut bikin custom icon aplikasi)
    // CUSTOM ICON APLIKASI :
    // klik kanan pada "res" pilih (New -> Image Asset) bikin icon dsitu.
    // Lalu masuk ke AndroidManifest tambahkan yang diberi komen (ICON) ->

    // NEXT CUSTOM LANGUAGE :
    // klik kanan pada values (res/values) lalu (New/Values Resource Files) beri nama strings
    // untuk "Available qualifiers" pilih "Local" lalu klik button ">>" lalu "Languagenya" pilih "Indonesia" dan "Specify Region" pilih "Indonesia"
    // kalo sudah buka file strings.xml yang tadi di buat ->


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}