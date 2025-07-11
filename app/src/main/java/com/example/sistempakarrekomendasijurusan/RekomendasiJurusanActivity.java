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
    private List<RadioGroup> radioGroups = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi_jurusan);

        spinnerBidang = findViewById(R.id.spinnerBidang);
        questionsContainer = findViewById(R.id.questionsContainer);
        buttonProses = findViewById(R.id.buttonProses);

        setupData();
        setupSpinner();

        buttonProses.setOnClickListener(view -> prosesRekomendasi());
    }

    private void setupData() {
        // Initialize the map to hold questions and their corresponding majors

        // 🧪 Sains & STEM
        pertanyaanJurusanMap.put("Sains & STEM", Arrays.asList(
                new Pair<>("1. Apakah kamu tertarik dengan eksperimen laboratorium?", "Biologi"),
                new Pair<>("2. Apakah kamu menyukai matematika dan logika?", "Matematika & Statistika"),
                new Pair<>("3. Apakah kamu suka membaca buku tentang sains dan teknologi?", "Ilmu Lingkungan"),
                new Pair<>("4. Apakah kamu menikmati melakukan percobaan?", "Kimia"),
                new Pair<>("5. Apakah kamu suka memecahkan masalah ilmiah?", "Fisika"),
                new Pair<>("6. Apakah kamu tertarik dengan penelitian?", "Geologi"),
                new Pair<>("7. Apakah kamu suka belajar tentang fisika dan kimia?", "Astronomi"),
                new Pair<>("8. Apakah kamu sering mengikuti berita tentang penemuan ilmiah?", "Meteorologi"),
                new Pair<>("9. Apakah kamu suka menggunakan alat-alat ilmiah?", "Ilmu Lingkungan"),
                new Pair<>("10. Apakah kamu ingin berkontribusi dalam penelitian ilmiah?", "Biologi"),
                new Pair<>("11. Apakah kamu suka belajar tentang biologi dan ekosistem?", "Biologi"),
                new Pair<>("12. Apakah kamu tertarik dengan teknologi baru?", "Ilmu Komputer"),
                new Pair<>("13. Apakah kamu suka melakukan analisis data?", "Matematika & Statistika"),
                new Pair<>("14. Apakah kamu ingin bekerja di bidang kesehatan atau teknologi?", "Teknologi Biomedis"),
                new Pair<>("15. Apakah kamu suka belajar tentang astronomi dan ruang angkasa?", "Astronomi")
        ));

        // 🛠️ Teknologi & Teknik
        pertanyaanJurusanMap.put("Teknologi & Teknik", Arrays.asList(
                new Pair<>("1. Apakah kamu suka memecahkan masalah teknis?", "Teknik Mesin"),
                new Pair<>("2. Apakah kamu tertarik membangun atau merancang sesuatu?", "Arsitektur"),
                new Pair<>("3. Apakah kamu menyukai komputer atau mesin?", "Ilmu Komputer"),
                new Pair<>("4. Apakah kamu suka belajar tentang perangkat keras dan perangkat lunak?", "Teknik Komputer"),
                new Pair<>("5. Apakah kamu tertarik dengan robotika?", "Teknik Biomedis"),
                new Pair<>("6. Apakah kamu suka melakukan proyek DIY (Do It Yourself)?", "Teknik Lingkungan"),
                new Pair<>("7. Apakah kamu ingin bekerja di bidang teknik?", "Teknik Sipil"),
                new Pair<>("8. Apakah kamu suka belajar tentang teknologi informasi?", "Teknik Elektro"),
                new Pair<>("9. Apakah kamu tertarik dengan desain produk?", "Teknik Industri"),
                new Pair<>("10. Apakah kamu suka melakukan analisis sistem?", "Rekayasa Perangkat Lunak"),
                new Pair<>("11. Apakah kamu ingin menciptakan aplikasi atau perangkat lunak?", "Ilmu Komputer"),
                new Pair<>("12. Apakah kamu suka belajar tentang energi terbarukan?", "Teknik Lingkungan"),
                new Pair<>("13. Apakah kamu tertarik dengan teknik sipil dan infrastruktur?", "Teknik Sipil"),
                new Pair<>("14. Apakah kamu suka belajar tentang otomotif?", "Teknik Otomotif"),
                new Pair<>("15. Apakah kamu ingin berkontribusi dalam inovasi teknologi?", "Bioteknologi")
        ));

        // 🧩 Bisnis & Manajemen
        pertanyaanJurusanMap.put("Bisnis & Manajemen", Arrays.asList(
                new Pair<>("1. Apakah kamu suka mengelola keuangan atau bisnis?", "Akuntansi"),
                new Pair<>("2. Apakah kamu tertarik memimpin atau mengatur tim?", "Manajemen Hotel"),
                new Pair<>("3. Apakah kamu ingin menjadi pengusaha?", "Kewirausahaan"),
                new Pair<>("4. Apakah kamu suka belajar tentang strategi bisnis?", "Administrasi Bisnis"),
                new Pair<>("5. Apakah kamu tertarik dengan pemasaran dan penjualan?", "Pemasaran"),
                new Pair<>("6. Apakah kamu suka menganalisis pasar?", "Keuangan"),
                new Pair<>("7. Apakah kamu ingin bekerja di bidang manajemen?", "Manajemen Operasi"),
                new Pair<>("8. Apakah kamu suka belajar tentang perilaku konsumen?", "SDM"),
                new Pair<>("9. Apakah kamu tertarik dengan manajemen proyek?", "Manajemen Proyek"),
                new Pair<>("10. Apakah kamu suka bernegosiasi?", "Hukum Bisnis"),
                new Pair<>("11. Apakah kamu ingin belajar tentang manajemen sumber daya manusia?", "SDM"),
                new Pair<>("12. Apakah kamu suka belajar tentang hukum bisnis?", "Hukum Bisnis"),
                new Pair<>("13. Apakah kamu tertarik dengan inovasi dalam bisnis?", "Kewirausahaan"),
                new Pair<>("14. Apakah kamu suka belajar tentang analisis data bisnis?", "Keuangan"),
                new Pair<>("15. Apakah kamu ingin berkontribusi dalam pengembangan bisnis?", "Administrasi Bisnis")
        ));

        // 💻 Komunikasi & Media
        pertanyaanJurusanMap.put("Komunikasi & Media", Arrays.asList(
                new Pair<>("1. Apakah kamu suka menulis atau berbicara di depan umum?", "Ilmu Komunikasi"),
                new Pair<>("2. Apakah kamu tertarik dengan media sosial atau penyiaran?", "Public Relations"),
                new Pair<>("3. Apakah kamu senang membuat konten kreatif?", "Jurnalistik"),
                new Pair<>("4. Apakah kamu suka belajar tentang jurnalisme?", "Jurnalistik"),
                new Pair<>("5. Apakah kamu tertarik dengan hubungan masyarakat?", "Public Relations"),
                new Pair<>("6. Apakah kamu suka belajar tentang pemasaran digital?", "Periklanan"),
                new Pair<>("7. Apakah kamu ingin bekerja di bidang media?", "Penyiaran TV/Radio"),
                new Pair<>("8. Apakah kamu suka membuat video atau podcast?", "Penyiaran TV/Radio"),
                new Pair<>("9. Apakah kamu tertarik dengan desain grafis?", "Desain Grafis"),
                new Pair<>("10. Apakah kamu suka belajar tentang komunikasi visual?", "Ilmu Komunikasi"),
                new Pair<>("11. Apakah kamu ingin berkontribusi dalam industri film?", "Film & Produksi Video"),
                new Pair<>("12. Apakah kamu suka belajar tentang etika media?", "Ilmu Komunikasi"),
                new Pair<>("13. Apakah kamu tertarik dengan analisis media?", "Ilmu Komunikasi"),
                new Pair<>("14. Apakah kamu suka belajar tentang komunikasi antarbudaya?", "Ilmu Komunikasi"),
                new Pair<>("15. Apakah kamu ingin bekerja di bidang periklanan?", "Periklanan")
        ));

        // 🎭 Seni & Desain
        pertanyaanJurusanMap.put("Seni & Desain", Arrays.asList(
                new Pair<>("1. Apakah kamu suka menggambar, melukis, atau berkarya seni?", "Seni Rupa"),
                new Pair<>("2. Apakah kamu tertarik pada dunia desain atau teater?", "Desain Grafis"),
                new Pair<>("3. Apakah kamu punya imajinasi tinggi dan suka berekspresi visual?", "Desain Interior"),
                new Pair<>("4. Apakah kamu suka belajar tentang sejarah seni?", "Seni Rupa"),
                new Pair<>("5. Apakah kamu tertarik dengan seni pertunjukan?", "Teater & Drama"),
                new Pair<>("6. Apakah kamu suka belajar tentang desain produk?", "Desain Produk"),
                new Pair<>("7. Apakah kamu ingin bekerja di bidang seni?", "Seni Rupa"),
                new Pair<>("8. Apakah kamu suka membuat karya seni digital?", "Animasi & Multimedia"),
                new Pair<>("9. Apakah kamu tertarik dengan fotografi?", "Desain Grafis"),
                new Pair<>("10. Apakah kamu suka belajar tentang seni rupa?", "Seni Rupa"),
                new Pair<>("11. Apakah kamu ingin berkontribusi dalam industri kreatif?", "Desain Grafis"),
                new Pair<>("12. Apakah kamu suka belajar tentang desain interior?", "Desain Interior"),
                new Pair<>("13. Apakah kamu tertarik dengan seni musik?", "Musik"),
                new Pair<>("14. Apakah kamu suka belajar tentang seni tari?", "Teater & Drama"),
                new Pair<>("15. Apakah kamu ingin belajar tentang animasi?", "Animasi & Multimedia")
        ));

        // 🏥 Kesehatan & Kedokteran
        pertanyaanJurusanMap.put("Kesehatan & Kedokteran", Arrays.asList(
                new Pair<>("1. Apakah kamu ingin membantu orang melalui dunia medis?", "Kedokteran"),
                new Pair<>("2. Apakah kamu tertarik dengan tubuh manusia dan kesehatannya?", "Kedokteran Gigi"),
                new Pair<>("3. Apakah kamu bisa bekerja di bawah tekanan dan dengan tim?", "Keperawatan"),
                new Pair<>("4. Apakah kamu suka belajar tentang penyakit dan pengobatan?", "Farmasi"),
                new Pair<>("5. Apakah kamu tertarik dengan penelitian medis?", "Teknologi Laboratorium"),
                new Pair<>("6. Apakah kamu ingin bekerja di rumah sakit atau klinik?", "Keperawatan"),
                new Pair<>("7. Apakah kamu suka belajar tentang gizi dan kesehatan?", "Nutrisi"),
                new Pair<>("8. Apakah kamu tertarik dengan psikologi dan kesehatan mental?", "Psikologi"),
                new Pair<>("9. Apakah kamu suka belajar tentang teknologi medis?", "Teknologi Laboratorium"),
                new Pair<>("10. Apakah kamu ingin berkontribusi dalam kesehatan masyarakat?", "Kesehatan Masyarakat"),
                new Pair<>("11. Apakah kamu suka belajar tentang farmakologi?", "Farmasi"),
                new Pair<>("12. Apakah kamu tertarik dengan rehabilitasi?", "Fisioterapi"),
                new Pair<>("13. Apakah kamu suka belajar tentang etika medis?", "Kedokteran"),
                new Pair<>("14. Apakah kamu ingin bekerja di bidang kesehatan gigi?", "Kedokteran Gigi"),
                new Pair<>("15. Apakah kamu suka belajar tentang kebidanan?", "Kebidanan")
        ));

        // 👥 Ilmu Sosial & Humaniora
        pertanyaanJurusanMap.put("Ilmu Sosial & Humaniora", Arrays.asList(
                new Pair<>("1. Apakah kamu tertarik mempelajari manusia dan masyarakat?", "Sosiologi"),
                new Pair<>("2. Apakah kamu suka membaca tentang sejarah, politik, atau budaya?", "Ilmu Politik"),
                new Pair<>("3. Apakah kamu suka mendengarkan dan memahami sudut pandang orang lain?", "Psikologi"),
                new Pair<>("4. Apakah kamu tertarik dengan psikologi sosial?", "Psikologi"),
                new Pair<>("5. Apakah kamu suka belajar tentang sosiologi?", "Sosiologi"),
                new Pair<>("6. Apakah kamu ingin bekerja di bidang pendidikan?", "Pendidikan"),
                new Pair<>("7. Apakah kamu suka belajar tentang antropologi?", "Antropologi"),
                new Pair<>("8. Apakah kamu tertarik dengan studi gender?", "Studi Gender"),
                new Pair<>("9. Apakah kamu suka belajar tentang ekonomi?", "Ekonomi"),
                new Pair<>("10. Apakah kamu ingin berkontribusi dalam penelitian sosial?", "Sosiologi"),
                new Pair<>("11. Apakah kamu suka belajar tentang filsafat?", "Filsafat"),
                new Pair<>("12. Apakah kamu tertarik dengan hukum dan keadilan?", "Hukum"),
                new Pair<>("13. Apakah kamu suka belajar tentang budaya dan tradisi?", "Antropologi"),
                new Pair<>("14. Apakah kamu ingin bekerja di bidang kebijakan publik?", "Ilmu Politik"),
                new Pair<>("15. Apakah kamu suka belajar tentang hubungan internasional?", "Hubungan Internasional")
        ));

        // 🏛️ Hukum & Kriminologi
        pertanyaanJurusanMap.put("Hukum & Kriminologi", Arrays.asList(
                new Pair<>("1. Apakah kamu suka berdiskusi tentang keadilan atau hukum?", "Hukum"),
                new Pair<>("2. Apakah kamu tertarik dengan dunia kriminal dan investigasi?", "Kriminologi"),
                new Pair<>("3. Apakah kamu punya rasa keadilan yang tinggi?", "Hukum"),
                new Pair<>("4. Apakah kamu suka belajar tentang sistem hukum?", "Hukum"),
                new Pair<>("5. Apakah kamu tertarik dengan hak asasi manusia?", "Hukum"),
                new Pair<>("6. Apakah kamu ingin bekerja di bidang hukum?", "Hukum"),
                new Pair<>("7. Apakah kamu suka belajar tentang etika hukum?", "Hukum"),
                new Pair<>("8. Apakah kamu tertarik dengan hukum internasional?", "Hukum"),
                new Pair<>("9. Apakah kamu suka belajar tentang forensik?", "Forensik"),
                new Pair<>("10. Apakah kamu ingin berkontribusi dalam penegakan hukum?", "Hukum"),
                new Pair<>("11. Apakah kamu suka belajar tentang hukum pidana?", "Hukum"),
                new Pair<>("12. Apakah kamu tertarik dengan hukum perdata?", "Hukum"),
                new Pair<>("13. Apakah kamu suka belajar tentang hukum bisnis?", "Hukum"),
                new Pair<>("14. Apakah kamu ingin bekerja di lembaga pemerintah?", "Hukum"),
                new Pair<>("15. Apakah kamu suka belajar tentang kriminologi?", "Kriminologi")
        ));

        // 🌿 Pertanian & SDA
        pertanyaanJurusanMap.put("Pertanian & Sumber Daya Alam", Arrays.asList(
                new Pair<>("1. Apakah kamu suka alam dan ingin menjaga lingkungan?", "Konservasi"),
                new Pair<>("2. Apakah kamu tertarik dengan pertanian atau hewan?", "Pertanian"),
                new Pair<>("3. Apakah kamu suka bekerja di luar ruangan?", "Pertanian"),
                new Pair<>("4. Apakah kamu suka belajar tentang ekologi?", "Ilmu Lingkungan"),
                new Pair<>("5. Apakah kamu tertarik dengan pengelolaan sumber daya alam?", "Sumber Daya Alam"),
                new Pair<>("6. Apakah kamu ingin bekerja di bidang pertanian?", "Pertanian"),
                new Pair<>("7. Apakah kamu suka belajar tentang konservasi?", "Konservasi"),
                new Pair<>("8. Apakah kamu tertarik dengan teknologi pertanian?", "Teknologi Pertanian"),
                new Pair<>("9. Apakah kamu suka belajar tentang biologi pertanian?", "Pertanian"),
                new Pair<>("10. Apakah kamu ingin berkontribusi dalam keberlanjutan?", "Konservasi"),
                new Pair<>("11. Apakah kamu suka belajar tentang pemeliharaan hewan?", "Peternakan"),
                new Pair<>("12. Apakah kamu tertarik dengan hortikultura?", "Hortikultura"),
                new Pair<>("13. Apakah kamu suka belajar tentang pengelolaan limbah?", "Lingkungan"),
                new Pair<>("14. Apakah kamu ingin bekerja di bidang kehutanan?", "Kehutanan"),
                new Pair<>("15. Apakah kamu suka belajar tentang perikanan?", "Perikanan")
        ));

        // 🧾 Lain-lain & Interdisipliner
        pertanyaanJurusanMap.put("Lain-lain & Interdisipliner", Arrays.asList(
                new Pair<>("1. Apakah kamu punya ketertarikan di berbagai bidang?", "Lain-lain"),
                new Pair<>("2. Apakah kamu suka mendalami bahasa, budaya, atau olahraga?", "Bahasa & Sastra"),
                new Pair<>("3. Apakah kamu ingin menggabungkan beberapa disiplin ilmu?", "Interdisipliner"),
                new Pair<>("4. Apakah kamu suka belajar tentang teknologi baru?", "Teknologi Pendidikan"),
                new Pair<>("5. Apakah kamu tertarik dengan studi lintas disiplin?", "Interdisipliner"),
                new Pair<>("6. Apakah kamu suka belajar tentang inovasi?", "Inovasi"),
                new Pair<>("7. Apakah kamu ingin bekerja di bidang yang beragam?", "Lain-lain"),
                new Pair<>("8. Apakah kamu suka belajar tentang sejarah dan budaya?", "Sejarah"),
                new Pair<>("9. Apakah kamu tertarik dengan pendidikan multikultural?", "Pendidikan"),
                new Pair<>("10. Apakah kamu suka belajar tentang seni dan sains?", "Seni & Sains"),
                new Pair<>("11. Apakah kamu ingin berkontribusi dalam proyek interdisipliner?", "Interdisipliner"),
                new Pair<>("12. Apakah kamu suka belajar tentang kebijakan publik?", "Kebijakan Publik"),
                new Pair<>("13. Apakah kamu tertarik dengan studi lingkungan?", "Lingkungan"),
                new Pair<>("14. Apakah kamu suka belajar tentang teknologi pendidikan?", "Teknologi Pendidikan"),
                new Pair<>("15. Apakah kamu ingin bekerja di bidang yang kreatif dan inovatif?", "Kreatif")
        ));

        // Assign the updated map to the original pertanyaanMap
    }

    private void setupSpinner() {
        List<String> bidangList = new ArrayList<>();
        bidangList.add("Pilih bidang studi kamu"); // Prompt pertama
        bidangList.addAll(pertanyaanJurusanMap.keySet()); // Baru tambahkan bidang-bidang

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, bidangList);
        spinnerBidang.setAdapter(adapter);

        spinnerBidang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // Jika pilihan "Pilih bidang studi kamu", kosongkan pertanyaan
                    questionsContainer.removeAllViews();
                    radioGroups.clear();
                } else {
                    // Tampilkan pertanyaan sesuai bidang yang dipilih
                    tampilkanPertanyaan(bidangList.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void tampilkanPertanyaan(String bidang) {
        questionsContainer.removeAllViews();
        radioGroups.clear();

        List<Pair<String, String>> pertanyaanList = pertanyaanJurusanMap.get(bidang);
        for (Pair<String, String> pair : pertanyaanList) {
            String q = pair.first;

            TextView textView = new TextView(this);
            textView.setText(q);
            questionsContainer.addView(textView);

            RadioGroup group = new RadioGroup(this);
            group.setOrientation(RadioGroup.HORIZONTAL);

            RadioButton ya = new RadioButton(this);
            ya.setText("Ya");

            RadioButton tidak = new RadioButton(this);
            tidak.setText("Tidak");

            group.addView(ya);
            group.addView(tidak);

            questionsContainer.addView(group);
            radioGroups.add(group);
        }
    }

    private void prosesRekomendasi() {
        int bidangPos = spinnerBidang.getSelectedItemPosition();
        if (bidangPos == 0) {
            Toast.makeText(this, "Harap pilih bidang studi terlebih dahulu.", Toast.LENGTH_SHORT).show();
            return;
        }

        String bidang = spinnerBidang.getSelectedItem().toString();
        List<Pair<String, String>> pertanyaanList = pertanyaanJurusanMap.get(bidang);
        if (pertanyaanList == null) {
            Toast.makeText(this, "Bidang studi tidak valid.", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Integer> skorJurusan = new HashMap<>();

        for (int i = 0; i < pertanyaanList.size(); i++) {
            RadioGroup group = radioGroups.get(i);
            int checkedId = group.getCheckedRadioButtonId();
            if (checkedId == -1) {
                Toast.makeText(this, "Harap jawab semua pertanyaan.", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selected = findViewById(checkedId);
            if (selected.getText().toString().equalsIgnoreCase("Ya")) {
                String jurusan = pertanyaanList.get(i).second;
                skorJurusan.put(jurusan, skorJurusan.getOrDefault(jurusan, 0) + 1);
            }
        }

        // Urutkan berdasarkan skor tertinggi
        List<Map.Entry<String, Integer>> hasil = new ArrayList<>(skorJurusan.entrySet());
        hasil.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Descending

        StringBuilder rekomendasiBuilder = new StringBuilder();
        int maxToShow = Math.min(2, hasil.size()); // Hanya 2 teratas, atau kurang jika datanya < 2
        for (int i = 0; i < maxToShow; i++) {
            Map.Entry<String, Integer> entry = hasil.get(i);
            rekomendasiBuilder.append(i + 1).append(". ").append(entry.getKey())
                    .append(" (Skor: ").append(entry.getValue()).append(")\n");
        }

        String hasilRekomendasi = rekomendasiBuilder.length() > 0
                ? rekomendasiBuilder.toString()
                : "Tidak ada rekomendasi yang dapat ditentukan.";

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_rekomendasi_jurusan, null);

        TextView title = dialogView.findViewById(R.id.dialogTitle);
        TextView message = dialogView.findViewById(R.id.dialogMessage);

// Set judul dan pesan
        title.setText("Hasil Rekomendasi");
        message.setText("2 Rekomendasi jurusan teratas untuk bidang " + bidang + ":\n\n" + hasilRekomendasi);

        // Dialog pertama (hasil rekomendasi)
        new androidx.appcompat.app.AlertDialog.Builder(this, R.style.MyAlertDialogTheme)
                .setView(dialogView)
                .setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Dialog konfirmasi
                        new AlertDialog.Builder(RekomendasiJurusanActivity.this, R.style.MyAlertDialogTheme)
                                .setTitle("Konfirmasi")
                                .setMessage("Apakah kamu yakin ingin kembali ke Menu?")
                                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog2, int which2) {
                                        // Pindah ke MenuActivity
                                        Intent intent = new Intent(RekomendasiJurusanActivity.this, MainActivity.class);
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

}
