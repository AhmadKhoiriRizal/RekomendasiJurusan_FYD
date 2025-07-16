package com.example.sistempakarrekomendasijurusan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BidangStudiActivity extends AppCompatActivity {

    private static final int TOTAL_QUESTIONS = 20;
    private int currentQuestionIndex = 0;
    private HashMap<String, Integer> skor = new HashMap<>();
    private String[] questions = {
            "Apakah kamu suka eksperimen atau penelitian?",
            "Apakah kamu tertarik pada teknologi dan cara kerja mesin?",
            "Apakah kamu suka mengelola uang atau menjalankan bisnis?",
            "Apakah kamu suka menulis, berbicara, atau membuat konten media?",
            "Apakah kamu suka menggambar, bermain musik, atau membuat karya kreatif?",
            "Apakah kamu peduli dengan kesehatan orang lain?",
            "Apakah kamu suka memahami perilaku manusia dan masyarakat?",
            "Apakah kamu tertarik dengan hukum, keadilan, atau penyelidikan?",
            "Apakah kamu suka dengan alam, tanaman, atau lingkungan hidup?",
            "Apakah kamu suka banyak hal dan sulit memilih satu?",
            "Apakah kamu suka memimpin proyek atau tim?",
            "Apakah kamu suka mengedit video atau membuat konten visual?",
            "Apakah kamu tertarik pada dunia kesehatan mental?",
            "Apakah kamu suka merancang atau membangun sesuatu?",
            "Apakah kamu suka meneliti hukum atau peraturan?",
            "Apakah kamu tertarik dengan teknologi pertanian atau makanan?",
            "Apakah kamu ingin mengajar atau menjadi dosen/guru?",
            "Apakah kamu suka hal-hal berbau teknologi komputer dan software?",
            "Apakah kamu ingin bekerja di pemerintahan atau sektor publik?",
            "Apakah kamu suka dengan pekerjaan yang fleksibel dan beragam bidang?"
    };

    private TextView textViewHasilRekomendasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_bidang_studi);

        textViewHasilRekomendasi = findViewById(R.id.textViewHasilRekomendasi);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        Button buttonReset = findViewById(R.id.buttonReset);

        // Inisialisasi semua kategori
        initSkor();

        buttonSubmit.setOnClickListener(view -> {
            currentQuestionIndex = 0; // Reset index pertanyaan
            showNextQuestion();
        });

        buttonReset.setOnClickListener(view -> resetJawaban());
    }

    private void initSkor() {
        skor.put("Sains & STEM", 0);
        skor.put("Teknologi & Teknik", 0);
        skor.put("Bisnis & Manajemen", 0);
        skor.put("Komunikasi & Media", 0);
        skor.put("Seni & Desain", 0);
        skor.put("Kesehatan & Kedokteran", 0);
        skor.put("Ilmu Sosial & Humaniora", 0);
        skor.put("Hukum & Kriminologi", 0);
        skor.put("Pertanian & Sumber Daya Alam", 0);
        skor.put("Lain-lain & Interdisipliner", 0);
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < TOTAL_QUESTIONS) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogTheme);
            builder.setTitle("Pertanyaan " + (currentQuestionIndex + 1));
            builder.setMessage(questions[currentQuestionIndex]);

            builder.setPositiveButton("Ya", (dialog, which) -> {
                processAnswer(true);
                currentQuestionIndex++;
                showNextQuestion();
            });

            builder.setNegativeButton("Tidak", (dialog, which) -> {
                processAnswer(false);
                currentQuestionIndex++;
                showNextQuestion();
            });

            builder.setCancelable(false);
            builder.show();
        } else {
            tampilkanHasilRekomendasi();
        }
    }

    private void processAnswer(boolean answer) {
        if (answer) {
            // Logika pemberian skor sesuai pertanyaan
            switch (currentQuestionIndex) {
                case 0:
                    skor.put("Sains & STEM", skor.get("Sains & STEM") + 1);
                    break;
                case 1:
                    skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
                    break;
                case 2:
                    skor.put("Bisnis & Manajemen", skor.get("Bisnis & Manajemen") + 1);
                    break;
                case 3:
                    skor.put("Komunikasi & Media", skor.get("Komunikasi & Media") + 1);
                    break;
                case 4:
                    skor.put("Seni & Desain", skor.get("Seni & Desain") + 1);
                    break;
                case 5:
                    skor.put("Kesehatan & Kedokteran", skor.get("Kesehatan & Kedokteran") + 1);
                    break;
                case 6:
                    skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
                    break;
                case 7:
                    skor.put("Hukum & Kriminologi", skor.get("Hukum & Kriminologi") + 1);
                    break;
                case 8:
                    skor.put("Pertanian & Sumber Daya Alam", skor.get("Pertanian & Sumber Daya Alam") + 1);
                    break;
                case 9:
                    skor.put("Lain-lain & Interdisipliner", skor.get("Lain-lain & Interdisipliner") + 1);
                    skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
                    break;
                case 10:
                    skor.put("Bisnis & Manajemen", skor.get("Bisnis & Manajemen") + 1);
                    break;
                case 11:
                    skor.put("Komunikasi & Media", skor.get("Komunikasi & Media") + 1);
                    skor.put("Seni & Desain", skor.get("Seni & Desain") + 1);
                    break;
                case 12:
                    skor.put("Kesehatan & Kedokteran", skor.get("Kesehatan & Kedokteran") + 1);
                    skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
                    break;
                case 13:
                    skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
                    skor.put("Sains & STEM", skor.get("Sains & STEM") + 1);
                    break;
                case 14:
                    skor.put("Hukum & Kriminologi", skor.get("Hukum & Kriminologi") + 1);
                    break;
                case 15:
                    skor.put("Pertanian & Sumber Daya Alam", skor.get("Pertanian & Sumber Daya Alam") + 1);
                    skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
                    break;
                case 16:
                    skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
                    break;
                case 17:
                    skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
                    break;
                case 18:
                    skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
                    skor.put("Hukum & Kriminologi", skor.get("Hukum & Kriminologi") + 1);
                    break;
                case 19:
                    skor.put("Lain-lain & Interdisipliner", skor.get("Lain-lain & Interdisipliner") + 1);
                    break;
            }
        }
    }

    private void tampilkanHasilRekomendasi() {
        // Ambil semua skor dan urutkan dari tertinggi
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(skor.entrySet());
        Collections.sort(sortedList, (a, b) -> b.getValue().compareTo(a.getValue()));

        // Ambil maksimal 3 teratas yang skornya > 0
        StringBuilder rekomendasiBuilder = new StringBuilder();
        int shown = 0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            if (entry.getValue() > 0) {
                rekomendasiBuilder.append(entry.getKey()).append(" \n(skor: ").append(entry.getValue()).append(")\n\n");
                shown++;
                if (shown == 3) break;
            }
        }

        String hasilRekomendasi = rekomendasiBuilder.length() > 0
                ? rekomendasiBuilder.toString()
                : "Tidak ada rekomendasi yang dapat ditentukan.";

        // Tampilkan hasil rekomendasi di TextView
        textViewHasilRekomendasi.setText("\n Berdasarkan jawaban kamu, berikut bidang studi yang cocok:\n\n" + hasilRekomendasi);
    }

    private void resetJawaban() {
        currentQuestionIndex = 0; // Reset index pertanyaan
        initSkor(); // Reset skor
        textViewHasilRekomendasi.setText("Hasil rekomendasi akan ditampilkan di sini."); // Reset hasil
        Toast.makeText(this, "Semua jawaban telah diulang.", Toast.LENGTH_SHORT).show();
    }
}
