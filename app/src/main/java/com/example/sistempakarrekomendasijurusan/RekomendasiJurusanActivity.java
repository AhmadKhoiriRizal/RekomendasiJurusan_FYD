package com.example.sistempakarrekomendasijurusan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

public class RekomendasiJurusanActivity extends AppCompatActivity {

    private Spinner spinnerBidang;
    private LinearLayout questionsContainer;
    private Button buttonProses;
    private Map<String, List<Pair<String, String>>> pertanyaanJurusanMap = new HashMap<>();
    private List<String> selectedJurusan = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private String selectedBidang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_jurusan);

        spinnerBidang = findViewById(R.id.spinnerBidang);
        questionsContainer = findViewById(R.id.questionsContainer);
        buttonProses = findViewById(R.id.buttonProses);
        Button buttonReset = findViewById(R.id.buttonReset); // Initialize the reset button

        setupData();
        setupSpinner();

        buttonProses.setOnClickListener(view -> {
            if (spinnerBidang.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Harap pilih bidang studi terlebih dahulu.", Toast.LENGTH_SHORT).show();
            } else {
                selectedBidang = spinnerBidang.getSelectedItem().toString();
                currentQuestionIndex = 0; // Reset question index
                tampilkanPertanyaan(); // Show the first question
            }
        });

        buttonReset.setOnClickListener(view -> resetJawaban()); // Set click listener for reset button
    }

    private void resetJawaban() {
        // Clear selected answers and reset UI
        selectedJurusan.clear();
        currentQuestionIndex = 0;
        spinnerBidang.setSelection(0); // Reset spinner to default
        questionsContainer.removeAllViews(); // Clear any displayed questions
        TextView textViewHasilRekomendasi = findViewById(R.id.textViewHasilRekomendasi);
        textViewHasilRekomendasi.setText("Hasil rekomendasi akan ditampilkan di sini."); // Reset result text
        Toast.makeText(this, "Semua jawaban telah diulang.", Toast.LENGTH_SHORT).show();
    }

    private void setupData() {
        // Initialize the map to hold questions and their corresponding majors

        // 🧪 Sains & STEM
        pertanyaanJurusanMap.put("Sains & STEM", Arrays.asList(
                new Pair<>("Apakah kamu tertarik dengan eksperimen laboratorium?", "Biologi"),
                new Pair<>("Apakah kamu menyukai matematika dan logika?", "Matematika & Statistika"),
                new Pair<>("Apakah kamu suka membaca buku tentang sains dan teknologi?", "Ilmu Lingkungan"),
                new Pair<>("Apakah kamu menikmati melakukan percobaan?", "Kimia"),
                new Pair<>("Apakah kamu suka memecahkan masalah ilmiah?", "Fisika"),
                new Pair<>("Apakah kamu tertarik dengan penelitian?", "Geologi"),
                new Pair<>("Apakah kamu suka belajar tentang fisika dan kimia?", "Astronomi"),
                new Pair<>("Apakah kamu sering mengikuti berita tentang penemuan ilmiah?", "Meteorologi"),
                new Pair<>("Apakah kamu suka menggunakan alat-alat ilmiah?", "Ilmu Lingkungan"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam penelitian ilmiah?", "Biologi"),
                new Pair<>("Apakah kamu suka belajar tentang biologi dan ekosistem?", "Biologi"),
                new Pair<>("Apakah kamu tertarik dengan teknologi baru?", "Ilmu Komputer"),
                new Pair<>("Apakah kamu suka melakukan analisis data?", "Matematika & Statistika"),
                new Pair<>("Apakah kamu ingin bekerja di bidang kesehatan atau teknologi?", "Teknologi Biomedis"),
                new Pair<>("Apakah kamu suka belajar tentang astronomi dan ruang angkasa?", "Astronomi")
        ));

        // 🛠️ Teknologi & Teknik
        pertanyaanJurusanMap.put("Teknologi & Teknik", Arrays.asList(
                new Pair<>("Apakah kamu suka memecahkan masalah teknis?", "Teknik Mesin"),
                new Pair<>("Apakah kamu tertarik membangun atau merancang sesuatu?", "Arsitektur"),
                new Pair<>("Apakah kamu menyukai komputer atau mesin?", "Ilmu Komputer"),
                new Pair<>("Apakah kamu suka belajar tentang perangkat keras dan perangkat lunak?", "Teknik Komputer"),
                new Pair<>("Apakah kamu tertarik dengan robotika?", "Teknik Biomedis"),
                new Pair<>("Apakah kamu suka melakukan proyek DIY (Do It Yourself)?", "Teknik Lingkungan"),
                new Pair<>("Apakah kamu ingin bekerja di bidang teknik?", "Teknik Sipil"),
                new Pair<>("Apakah kamu suka belajar tentang teknologi informasi?", "Teknik Elektro"),
                new Pair<>("Apakah kamu tertarik dengan desain produk?", "Teknik Industri"),
                new Pair<>("Apakah kamu suka melakukan analisis sistem?", "Rekayasa Perangkat Lunak"),
                new Pair<>("Apakah kamu ingin menciptakan aplikasi atau perangkat lunak?", "Ilmu Komputer"),
                new Pair<>("Apakah kamu suka belajar tentang energi terbarukan?", "Teknik Lingkungan"),
                new Pair<>("Apakah kamu tertarik dengan teknik sipil dan infrastruktur?", "Teknik Sipil"),
                new Pair<>("Apakah kamu suka belajar tentang otomotif?", "Teknik Otomotif"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam inovasi teknologi?", "Bioteknologi")
        ));

        // 🧩 Bisnis & Manajemen
        pertanyaanJurusanMap.put("Bisnis & Manajemen", Arrays.asList(
                new Pair<>("Apakah kamu suka mengelola keuangan atau bisnis?", "Akuntansi"),
                new Pair<>("Apakah kamu tertarik memimpin atau mengatur tim?", "Manajemen Hotel"),
                new Pair<>("Apakah kamu ingin menjadi pengusaha?", "Kewirausahaan"),
                new Pair<>("Apakah kamu suka belajar tentang strategi bisnis?", "Administrasi Bisnis"),
                new Pair<>("Apakah kamu tertarik dengan pemasaran dan penjualan?", "Pemasaran"),
                new Pair<>("Apakah kamu suka menganalisis pasar?", "Keuangan"),
                new Pair<>("Apakah kamu ingin bekerja di bidang manajemen?", "Manajemen Operasi"),
                new Pair<>("Apakah kamu suka belajar tentang perilaku konsumen?", "SDM"),
                new Pair<>("Apakah kamu tertarik dengan manajemen proyek?", "Manajemen Proyek"),
                new Pair<>("Apakah kamu suka bernegosiasi?", "Hukum Bisnis"),
                new Pair<>("Apakah kamu ingin belajar tentang manajemen sumber daya manusia?", "SDM"),
                new Pair<>("Apakah kamu suka belajar tentang hukum bisnis?", "Hukum Bisnis"),
                new Pair<>("Apakah kamu tertarik dengan inovasi dalam bisnis?", "Kewirausahaan"),
                new Pair<>("Apakah kamu suka belajar tentang analisis data bisnis?", "Keuangan"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam pengembangan bisnis?", "Administrasi Bisnis")
        ));

        // 💻 Komunikasi & Media
        pertanyaanJurusanMap.put("Komunikasi & Media", Arrays.asList(
                new Pair<>("Apakah kamu suka menulis atau berbicara di depan umum?", "Ilmu Komunikasi"),
                new Pair<>("Apakah kamu tertarik dengan media sosial atau penyiaran?", "Public Relations"),
                new Pair<>("Apakah kamu senang membuat konten kreatif?", "Jurnalistik"),
                new Pair<>("Apakah kamu suka belajar tentang jurnalisme?", "Jurnalistik"),
                new Pair<>("Apakah kamu tertarik dengan hubungan masyarakat?", "Public Relations"),
                new Pair<>("Apakah kamu suka belajar tentang pemasaran digital?", "Periklanan"),
                new Pair<>("Apakah kamu ingin bekerja di bidang media?", "Penyiaran TV/Radio"),
                new Pair<>("Apakah kamu suka membuat video atau podcast?", "Penyiaran TV/Radio"),
                new Pair<>("Apakah kamu tertarik dengan desain grafis?", "Desain Grafis"),
                new Pair<>("Apakah kamu suka belajar tentang komunikasi visual?", "Ilmu Komunikasi"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam industri film?", "Film & Produksi Video"),
                new Pair<>("Apakah kamu suka belajar tentang etika media?", "Ilmu Komunikasi"),
                new Pair<>("Apakah kamu tertarik dengan analisis media?", "Ilmu Komunikasi"),
                new Pair<>("Apakah kamu suka belajar tentang komunikasi antarbudaya?", "Ilmu Komunikasi"),
                new Pair<>("Apakah kamu ingin bekerja di bidang periklanan?", "Periklanan")
        ));

        // 🎭 Seni & Desain
        pertanyaanJurusanMap.put("Seni & Desain", Arrays.asList(
                new Pair<>("Apakah kamu suka menggambar, melukis, atau berkarya seni?", "Seni Rupa"),
                new Pair<>("Apakah kamu tertarik pada dunia desain atau teater?", "Desain Grafis"),
                new Pair<>("Apakah kamu punya imajinasi tinggi dan suka berekspresi visual?", "Desain Interior"),
                new Pair<>("Apakah kamu suka belajar tentang sejarah seni?", "Seni Rupa"),
                new Pair<>("Apakah kamu tertarik dengan seni pertunjukan?", "Teater & Drama"),
                new Pair<>("Apakah kamu suka belajar tentang desain produk?", "Desain Produk"),
                new Pair<>("Apakah kamu ingin bekerja di bidang seni?", "Seni Rupa"),
                new Pair<>("Apakah kamu suka membuat karya seni digital?", "Animasi & Multimedia"),
                new Pair<>("Apakah kamu tertarik dengan fotografi?", "Desain Grafis"),
                new Pair<>("Apakah kamu suka belajar tentang seni rupa?", "Seni Rupa"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam industri kreatif?", "Desain Grafis"),
                new Pair<>("Apakah kamu suka belajar tentang desain interior?", "Desain Interior"),
                new Pair<>("Apakah kamu tertarik dengan seni musik?", "Musik"),
                new Pair<>("Apakah kamu suka belajar tentang seni tari?", "Teater & Drama"),
                new Pair<>("Apakah kamu ingin belajar tentang animasi?", "Animasi & Multimedia")
        ));

        // 🏥 Kesehatan & Kedokteran
        pertanyaanJurusanMap.put("Kesehatan & Kedokteran", Arrays.asList(
                new Pair<>("Apakah kamu ingin membantu orang melalui dunia medis?", "Kedokteran"),
                new Pair<>("Apakah kamu tertarik dengan tubuh manusia dan kesehatannya?", "Kedokteran Gigi"),
                new Pair<>("Apakah kamu bisa bekerja di bawah tekanan dan dengan tim?", "Keperawatan"),
                new Pair<>("Apakah kamu suka belajar tentang penyakit dan pengobatan?", "Farmasi"),
                new Pair<>("Apakah kamu tertarik dengan penelitian medis?", "Teknologi Laboratorium"),
                new Pair<>("Apakah kamu ingin bekerja di rumah sakit atau klinik?", "Keperawatan"),
                new Pair<>("Apakah kamu suka belajar tentang gizi dan kesehatan?", "Nutrisi"),
                new Pair<>("Apakah kamu tertarik dengan psikologi dan kesehatan mental?", "Psikologi"),
                new Pair<>("Apakah kamu suka belajar tentang teknologi medis?", "Teknologi Laboratorium"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam kesehatan masyarakat?", "Kesehatan Masyarakat"),
                new Pair<>("Apakah kamu suka belajar tentang farmakologi?", "Farmasi"),
                new Pair<>("Apakah kamu tertarik dengan rehabilitasi?", "Fisioterapi"),
                new Pair<>("Apakah kamu suka belajar tentang etika medis?", "Kedokteran"),
                new Pair<>("Apakah kamu ingin bekerja di bidang kesehatan gigi?", "Kedokteran Gigi"),
                new Pair<>("Apakah kamu suka belajar tentang kebidanan?", "Kebidanan")
        ));

        // 👥 Ilmu Sosial & Humaniora
        pertanyaanJurusanMap.put("Ilmu Sosial & Humaniora", Arrays.asList(
                new Pair<>("Apakah kamu tertarik mempelajari manusia dan masyarakat?", "Sosiologi"),
                new Pair<>("Apakah kamu suka membaca tentang sejarah, politik, atau budaya?", "Ilmu Politik"),
                new Pair<>("Apakah kamu suka mendengarkan dan memahami sudut pandang orang lain?", "Psikologi"),
                new Pair<>("Apakah kamu tertarik dengan psikologi sosial?", "Psikologi"),
                new Pair<>("Apakah kamu suka belajar tentang sosiologi?", "Sosiologi"),
                new Pair<>("Apakah kamu ingin bekerja di bidang pendidikan?", "Pendidikan"),
                new Pair<>("Apakah kamu suka belajar tentang antropologi?", "Antropologi"),
                new Pair<>("Apakah kamu tertarik dengan studi gender?", "Studi Gender"),
                new Pair<>("Apakah kamu suka belajar tentang ekonomi?", "Ekonomi"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam penelitian sosial?", "Sosiologi"),
                new Pair<>("Apakah kamu suka belajar tentang filsafat?", "Filsafat"),
                new Pair<>("Apakah kamu tertarik dengan hukum dan keadilan?", "Hukum"),
                new Pair<>("Apakah kamu suka belajar tentang budaya dan tradisi?", "Antropologi"),
                new Pair<>("Apakah kamu ingin bekerja di bidang kebijakan publik?", "Ilmu Politik"),
                new Pair<>("Apakah kamu suka belajar tentang hubungan internasional?", "Hubungan Internasional")
        ));

        // 🏛️ Hukum & Kriminologi
        pertanyaanJurusanMap.put("Hukum & Kriminologi", Arrays.asList(
                new Pair<>("Apakah kamu suka berdiskusi tentang keadilan atau hukum?", "Hukum"),
                new Pair<>("Apakah kamu tertarik dengan dunia kriminal dan investigasi?", "Kriminologi"),
                new Pair<>("Apakah kamu punya rasa keadilan yang tinggi?", "Hukum"),
                new Pair<>("Apakah kamu suka belajar tentang sistem hukum?", "Hukum"),
                new Pair<>("Apakah kamu tertarik dengan hak asasi manusia?", "Hukum"),
                new Pair<>("Apakah kamu ingin bekerja di bidang hukum?", "Hukum"),
                new Pair<>("Apakah kamu suka belajar tentang etika hukum?", "Hukum"),
                new Pair<>("Apakah kamu tertarik dengan hukum internasional?", "Hukum"),
                new Pair<>("Apakah kamu suka belajar tentang forensik?", "Forensik"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam penegakan hukum?", "Hukum"),
                new Pair<>("Apakah kamu suka belajar tentang hukum pidana?", "Hukum"),
                new Pair<>("Apakah kamu tertarik dengan hukum perdata?", "Hukum"),
                new Pair<>("Apakah kamu suka belajar tentang hukum bisnis?", "Hukum"),
                new Pair<>("Apakah kamu ingin bekerja di lembaga pemerintah?", "Hukum"),
                new Pair<>("Apakah kamu suka belajar tentang kriminologi?", "Kriminologi")
        ));

        // 🌿 Pertanian & SDA
        pertanyaanJurusanMap.put("Pertanian & Sumber Daya Alam", Arrays.asList(
                new Pair<>("Apakah kamu suka alam dan ingin menjaga lingkungan?", "Konservasi"),
                new Pair<>("Apakah kamu tertarik dengan pertanian atau hewan?", "Pertanian"),
                new Pair<>("Apakah kamu suka bekerja di luar ruangan?", "Pertanian"),
                new Pair<>("Apakah kamu suka belajar tentang ekologi?", "Ilmu Lingkungan"),
                new Pair<>("Apakah kamu tertarik dengan pengelolaan sumber daya alam?", "Sumber Daya Alam"),
                new Pair<>("Apakah kamu ingin bekerja di bidang pertanian?", "Pertanian"),
                new Pair<>("Apakah kamu suka belajar tentang konservasi?", "Konservasi"),
                new Pair<>("Apakah kamu tertarik dengan teknologi pertanian?", "Teknologi Pertanian"),
                new Pair<>("Apakah kamu suka belajar tentang biologi pertanian?", "Pertanian"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam keberlanjutan?", "Konservasi"),
                new Pair<>("Apakah kamu suka belajar tentang pemeliharaan hewan?", "Peternakan"),
                new Pair<>("Apakah kamu tertarik dengan hortikultura?", "Hortikultura"),
                new Pair<>("Apakah kamu suka belajar tentang pengelolaan limbah?", "Lingkungan"),
                new Pair<>("Apakah kamu ingin bekerja di bidang kehutanan?", "Kehutanan"),
                new Pair<>("Apakah kamu suka belajar tentang perikanan?", "Perikanan")
        ));

        // 🧾 Lain-lain & Interdisipliner
        pertanyaanJurusanMap.put("Lain-lain & Interdisipliner", Arrays.asList(
                new Pair<>("Apakah kamu punya ketertarikan di berbagai bidang?", "Lain-lain"),
                new Pair<>("Apakah kamu suka mendalami bahasa, budaya, atau olahraga?", "Bahasa & Sastra"),
                new Pair<>("Apakah kamu ingin menggabungkan beberapa disiplin ilmu?", "Interdisipliner"),
                new Pair<>("Apakah kamu suka belajar tentang teknologi baru?", "Teknologi Pendidikan"),
                new Pair<>("Apakah kamu tertarik dengan studi lintas disiplin?", "Interdisipliner"),
                new Pair<>("Apakah kamu suka belajar tentang inovasi?", "Inovasi"),
                new Pair<>("Apakah kamu ingin bekerja di bidang yang beragam?", "Lain-lain"),
                new Pair<>("Apakah kamu suka belajar tentang sejarah dan budaya?", "Sejarah"),
                new Pair<>("Apakah kamu tertarik dengan pendidikan multikultural?", "Pendidikan"),
                new Pair<>("Apakah kamu suka belajar tentang seni dan sains?", "Seni & Sains"),
                new Pair<>("Apakah kamu ingin berkontribusi dalam proyek interdisipliner?", "Interdisipliner"),
                new Pair<>("Apakah kamu suka belajar tentang kebijakan publik?", "Kebijakan Publik"),
                new Pair<>("Apakah kamu tertarik dengan studi lingkungan?", "Lingkungan"),
                new Pair<>("Apakah kamu suka belajar tentang teknologi pendidikan?", "Teknologi Pendidikan"),
                new Pair<>("Apakah kamu ingin bekerja di bidang yang kreatif dan inovatif?", "Kreatif")
        ));

        // Assign the updated map to the original pertanyaanMap
    }

    private void setupSpinner() {
        List<String> bidangList = new ArrayList<>();
        bidangList.add("Pilih bidang studi kamu");
        bidangList.addAll(pertanyaanJurusanMap.keySet());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, bidangList);
        spinnerBidang.setAdapter(adapter);
    }

    private void tampilkanPertanyaan() {
        List<Pair<String, String>> pertanyaanList = pertanyaanJurusanMap.get(selectedBidang);
        if (currentQuestionIndex < pertanyaanList.size()) {
            Pair<String, String> pair = pertanyaanList.get(currentQuestionIndex);
            String question = pair.first;

            new AlertDialog.Builder(this, R.style.MyAlertDialogTheme)
                    .setTitle("Pertanyaan " + (currentQuestionIndex + 1))
                    .setMessage(question)
                    .setPositiveButton("Ya", (dialog, which) -> {
                        selectedJurusan.add(pair.second);
                        currentQuestionIndex++;
                        tampilkanPertanyaan(); // Show next question
                    })
                    .setNegativeButton("Tidak", (dialog, which) -> {
                        currentQuestionIndex++;
                        tampilkanPertanyaan(); // Show next question
                    })
                    .setCancelable(false)
                    .show();
        } else {
            prosesRekomendasi(); // All questions answered
        }
    }

    private void prosesRekomendasi() {
        Map<String, Integer> skorJurusan = new HashMap<>();

        for (String jurusan : selectedJurusan) {
            skorJurusan.put(jurusan, skorJurusan.getOrDefault(jurusan, 0) + 1);
        }

        // Sort by highest score
        List<Map.Entry<String, Integer>> hasil = new ArrayList<>(skorJurusan.entrySet());
        hasil.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Descending

        StringBuilder rekomendasiBuilder = new StringBuilder();
        int maxToShow = Math.min(2, hasil.size()); // Show top 2
        for (int i = 0; i < maxToShow; i++) {
            Map.Entry<String, Integer> entry = hasil.get(i);
            rekomendasiBuilder.append(entry.getKey())
                    .append(" \n(Skor: ").append(entry.getValue()).append(")\n\n");
        }

        String hasilRekomendasi = rekomendasiBuilder.length() > 0
                ? rekomendasiBuilder.toString()
                : "Tidak ada rekomendasi yang dapat ditentukan.";

        // Display results in the TextView
        TextView textViewHasilRekomendasi = findViewById(R.id.textViewHasilRekomendasi);
        textViewHasilRekomendasi.setText("\n Hasil rekomendasi untuk bidang \n" + selectedBidang + ":\n\n" + hasilRekomendasi);
    }
}
