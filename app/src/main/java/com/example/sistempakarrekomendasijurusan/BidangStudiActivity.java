package com.example.sistempakarrekomendasijurusan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private RadioGroup[] radioGroups = new RadioGroup[TOTAL_QUESTIONS];
    private Button buttonSubmit, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Memaksa tema terang (no dark mode)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_bidang_studi);

        // Inisialisasi semua RadioGroup (1 sampai 20)
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            String idName = "radioGroup" + (i + 1);
            int resId = getResources().getIdentifier(idName, "id", getPackageName());
            radioGroups[i] = findViewById(resId);
        }

        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonReset = findViewById(R.id.buttonReset);

        buttonSubmit.setOnClickListener(view -> prosesRekomendasi());
        buttonReset.setOnClickListener(view -> resetJawaban());
    }

    private boolean isCheckedYes(RadioGroup group) {
        int id = group.getCheckedRadioButtonId();
        if (id == -1) return false;
        RadioButton selected = findViewById(id);
        return selected.getText().toString().equalsIgnoreCase("Ya");
    }

    private void prosesRekomendasi() {
        // Cek jika belum semua dijawab
        for (RadioGroup group : radioGroups) {
            if (group.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Harap jawab semua pertanyaan.", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        HashMap<String, Integer> skor = new HashMap<>();
        // Inisialisasi semua kategori
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

        // Logika pemberian skor sesuai pertanyaan
        // Setiap if disesuaikan dengan pertanyaan (index 0 = Q1, dst)

        if (isCheckedYes(radioGroups[0])) skor.put("Sains & STEM", skor.get("Sains & STEM") + 1);
        if (isCheckedYes(radioGroups[1])) skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
        if (isCheckedYes(radioGroups[2])) skor.put("Bisnis & Manajemen", skor.get("Bisnis & Manajemen") + 1);
        if (isCheckedYes(radioGroups[3])) skor.put("Komunikasi & Media", skor.get("Komunikasi & Media") + 1);
        if (isCheckedYes(radioGroups[4])) skor.put("Seni & Desain", skor.get("Seni & Desain") + 1);
        if (isCheckedYes(radioGroups[5])) skor.put("Kesehatan & Kedokteran", skor.get("Kesehatan & Kedokteran") + 1);
        if (isCheckedYes(radioGroups[6])) skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
        if (isCheckedYes(radioGroups[7])) skor.put("Hukum & Kriminologi", skor.get("Hukum & Kriminologi") + 1);
        if (isCheckedYes(radioGroups[8])) skor.put("Pertanian & Sumber Daya Alam", skor.get("Pertanian & Sumber Daya Alam") + 1);
        if (isCheckedYes(radioGroups[9])) {
            skor.put("Lain-lain & Interdisipliner", skor.get("Lain-lain & Interdisipliner") + 1);
            skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
        }
        if (isCheckedYes(radioGroups[10])) skor.put("Bisnis & Manajemen", skor.get("Bisnis & Manajemen") + 1);
        if (isCheckedYes(radioGroups[11])) {
            skor.put("Komunikasi & Media", skor.get("Komunikasi & Media") + 1);
            skor.put("Seni & Desain", skor.get("Seni & Desain") + 1);
        }
        if (isCheckedYes(radioGroups[12])) {
            skor.put("Kesehatan & Kedokteran", skor.get("Kesehatan & Kedokteran") + 1);
            skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
        }
        if (isCheckedYes(radioGroups[13])) {
            skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
            skor.put("Sains & STEM", skor.get("Sains & STEM") + 1);
        }
        if (isCheckedYes(radioGroups[14])) skor.put("Hukum & Kriminologi", skor.get("Hukum & Kriminologi") + 1);
        if (isCheckedYes(radioGroups[15])) {
            skor.put("Pertanian & Sumber Daya Alam", skor.get("Pertanian & Sumber Daya Alam") + 1);
            skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
        }
        if (isCheckedYes(radioGroups[16])) skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
        if (isCheckedYes(radioGroups[17])) skor.put("Teknologi & Teknik", skor.get("Teknologi & Teknik") + 1);
        if (isCheckedYes(radioGroups[18])) {
            skor.put("Ilmu Sosial & Humaniora", skor.get("Ilmu Sosial & Humaniora") + 1);
            skor.put("Hukum & Kriminologi", skor.get("Hukum & Kriminologi") + 1);
        }
        if (isCheckedYes(radioGroups[19])) skor.put("Lain-lain & Interdisipliner", skor.get("Lain-lain & Interdisipliner") + 1);

        // Ambil semua skor dan urutkan dari tertinggi
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(skor.entrySet());
        Collections.sort(sortedList, (a, b) -> b.getValue().compareTo(a.getValue()));

// Ambil maksimal 3 teratas yang skornya > 0
        StringBuilder rekomendasiBuilder = new StringBuilder();
        int shown = 0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            if (entry.getValue() > 0) {
                rekomendasiBuilder.append("- ").append(entry.getKey()).append(" (skor: ").append(entry.getValue()).append(")\n");
                shown++;
                if (shown == 3) break;
            }
        }

        String hasilRekomendasi = rekomendasiBuilder.length() > 0
                ? rekomendasiBuilder.toString()
                : "Tidak ada rekomendasi yang dapat ditentukan.";


        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_rekomendasi_bidang_studi, null);

        TextView title = dialogView.findViewById(R.id.dialogTitle);
        TextView message = dialogView.findViewById(R.id.dialogMessage);

// Set teks rekomendasinya
        message.setText("Berdasarkan jawaban kamu, berikut bidang studi yang cocok:\n\n" + hasilRekomendasi);

        // Dialog pertama (hasil rekomendasi)
        new AlertDialog.Builder(this, R.style.MyAlertDialogTheme)
                .setView(dialogView)
                .setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Dialog konfirmasi
                        new AlertDialog.Builder(BidangStudiActivity.this, R.style.MyAlertDialogTheme)
                                .setTitle("Konfirmasi")
                                .setMessage("Apakah kamu yakin ingin kembali ke Menu?")
                                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog2, int which2) {
                                        // Pindah ke MenuActivity
                                        Intent intent = new Intent(BidangStudiActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                })
                                .setNegativeButton("Tidak", null) // Menutup dialog
                                .show();
                    }
                })
                .setCancelable(false)
                .show();
    }
    private void resetJawaban() {
        new AlertDialog.Builder(this, R.style.MyAlertDialogTheme)
                .setTitle("Konfirmasi Ulangi Jawaban")
                .setMessage("Apakah kamu yakin ingin mengulang semua jawaban? Semua pilihan akan dikosongkan.")
                .setPositiveButton("Ya, Ulangi", (dialog, which) -> {
                    for (RadioGroup group : radioGroups) {
                        if (group != null) group.clearCheck();
                    }
                    Toast.makeText(this, "Semua jawaban telah diulang.", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Batal", null)
                .show();
    }

}
