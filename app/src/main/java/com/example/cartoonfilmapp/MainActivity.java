package com.example.cartoonfilmapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // GIF için ImageView
        ImageView gifImageView = findViewById(R.id.gifImageView);
        Glide.with(this)
                .load(R.raw.el_salla)
                .into(gifImageView);


        TextView internetStatusText = findViewById(R.id.internet_StatusText);
        TextView databaseStatusText = findViewById(R.id.database_StatusText);


        if (isInternetAvailable()) {
            internetStatusText.setText("İnternete bağlandı!");
        } else {
            internetStatusText.setText("İnternet bağlantısı yok!");
        }


        initializeDatabase(databaseStatusText);


        Button goToSecondPageButton = findViewById(R.id.btnGoToSecondPage);
        goToSecondPageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }


    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnected();
        }
        return false;
    }


    private void initializeDatabase(TextView databaseStatusText) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.addInitialCartoons();
        databaseStatusText.setText("Veritabanı güncellendi!");
    }
}
