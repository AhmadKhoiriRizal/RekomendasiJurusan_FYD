package com.example.sistempakarrekomendasijurusan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private CardView cardBidangStudi, cardRekomendasiJurusan, cardKuisMinatBakat,
            cardKampusFavorit, cardEnsiklopediaJurusan, cardPetaKarier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Memaksa tema terang (no dark mode)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main); // Pastikan nama file XML sesuai

        // Inisialisasi semua CardView
        cardBidangStudi = findViewById(R.id.cardBidangStudi);
        cardRekomendasiJurusan = findViewById(R.id.cardRekomendasiJurusan);
        cardKuisMinatBakat = findViewById(R.id.cardKuisMinatBakat);
        cardKampusFavorit = findViewById(R.id.cardKampusFavorit);
        cardEnsiklopediaJurusan = findViewById(R.id.cardEnsiklopediaJurusan);
        cardPetaKarier = findViewById(R.id.cardPetaKarier);

        // Event click untuk setiap CardView
        cardBidangStudi.setOnClickListener(view -> {
            Toast.makeText(this, "Navigasi ke Bidang Studi", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, BidangStudiActivity.class));
        });

        cardRekomendasiJurusan.setOnClickListener(view -> {
            Toast.makeText(this, "Navigasi ke Rekomendasi Jurusan", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, RekomendasiJurusanActivity.class));
        });

        cardKuisMinatBakat.setOnClickListener(view -> {
            Toast.makeText(this, "Navigasi ke Kuis Minat & Bakat", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, KuisMinatBakatActivity.class));
        });

        cardKampusFavorit.setOnClickListener(view -> {
            Toast.makeText(this, "Navigasi ke Kampus Favorit", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, KampusFavoritActivity.class));
        });

        cardEnsiklopediaJurusan.setOnClickListener(view -> {
            Toast.makeText(this, "Navigasi ke Ensiklopedia Jurusan", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(this, EnsiklopediaJurusanActivity.class));
        });

        cardPetaKarier.setOnClickListener(view -> {
            Toast.makeText(this, "Navigasi ke Peta Karier", Toast.LENGTH_SHORT).show();
            // startActivity(new Intent(this, PetaKarierActivity.class));
        });
    }
}