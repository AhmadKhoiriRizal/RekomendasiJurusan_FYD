package com.example.sistempakarrekomendasijurusan;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistempakarrekomendasijurusan.adapter.PetaKarierAdapter;
import com.example.sistempakarrekomendasijurusan.model.Jurusan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PetaKarierActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PetaKarierAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta_karier);

        recyclerView = findViewById(R.id.recyclerPetaKarier);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Map<String, List<Jurusan>> data = getPetaKarierData();
        adapter = new PetaKarierAdapter(data);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(jurusan -> {
            String message = "Akademik/Riset:\n- " + String.join("\n- ", jurusan.akademik) +
                    "\n\nIndustri:\n- " + String.join("\n- ", jurusan.industri) +
                    "\n\nAlternatif:\n- " + String.join("\n- ", jurusan.alternatif);

            new AlertDialog.Builder(this)
                    .setTitle(jurusan.nama)
                    .setMessage(message)
                    .setPositiveButton("Tutup", null)
                    .show();
        });
    }

    private Map<String, List<Jurusan>> getPetaKarierData() {
        Map<String, List<Jurusan>> map = new LinkedHashMap<>();

        // Contoh untuk Sains & STEM (lengkap dengan contoh pekerjaan)
        List<Jurusan> sainsStem = new ArrayList<>();
        sainsStem.add(new Jurusan(
                "Biologi (umum, seluler, zoologi, mikrobiologi)",
                List.of("Dosen Biologi", "Peneliti Seluler", "Akademisi Zoologi"),
                List.of("Ahli Biologi Lapangan", "Teknisi Laboratorium Mikrobiologi"),
                List.of("Konsultan Lingkungan", "Penulis Populer Ilmu Biologi")
        ));

        sainsStem.add(new Jurusan(
                "Kimia (umum, biokimia)",
                List.of("Dosen Kimia", "Peneliti Biokimia"),
                List.of("Analis Laboratorium Kimia", "Ahli Formulasi Produk"),
                List.of("Konsultan Kimia Industri", "Pengusaha Produk Kimia Organik")
        ));

        sainsStem.add(new Jurusan(
                "Fisika (umum, terapan)",
                List.of("Dosen Fisika", "Peneliti Fisika Terapan"),
                List.of("Engineer R&D", "Analis Data Fisika"),
                List.of("Konsultan Teknologi", "Penulis Buku Sains Populer")
        ));

        sainsStem.add(new Jurusan(
                "Matematika & Statistika",
                List.of("Dosen Matematika", "Peneliti Statistik"),
                List.of("Data Analyst", "Aktuaris"),
                List.of("Konsultan Data", "Pengusaha Software Statistik")
        ));

        sainsStem.add(new Jurusan(
                "Ilmu Lingkungan / Environmental Science",
                List.of("Dosen Ilmu Lingkungan", "Peneliti Konservasi"),
                List.of("Spesialis Pengelolaan Limbah", "Analis Risiko Lingkungan"),
                List.of("Aktivis Lingkungan", "Konsultan Ekowisata")
        ));

        sainsStem.add(new Jurusan(
                "Geologi / Ilmu Bumi",
                List.of("Dosen Geologi", "Peneliti Seismologi"),
                List.of("Geolog Lapangan", "Konsultan Pertambangan"),
                List.of("Guide Wisata Alam", "Penulis Ilmu Bumi")
        ));

        sainsStem.add(new Jurusan(
                "Astronomi / Meteorologi",
                List.of("Dosen Astronomi", "Peneliti Meteorologi"),
                List.of("Meteorolog", "Ahli Cuaca dan Iklim"),
                List.of("Penyiar Cuaca", "Penulis Populer Astronomi")
        ));

        map.put("🧪 Sains & STEM", sainsStem);

        // Tambahkan kategori Teknologi & Teknik
        List<Jurusan> teknologiTeknik = new ArrayList<>();
        teknologiTeknik.add(new Jurusan(
                "Teknik Mesin",
                List.of("Dosen Teknik Mesin", "Peneliti Material", "Akademisi Mekanika"),
                List.of("Engineer Produksi", "Teknisi Perawatan Mesin", "Desainer Produk Industri"),
                List.of("Konsultan Teknik", "Pengusaha Perangkat Mekanik")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Elektro / Telekomunikasi",
                List.of("Dosen Teknik Elektro", "Peneliti Telekomunikasi"),
                List.of("Engineer Jaringan", "Teknisi Telekomunikasi", "Spesialis Otomasi"),
                List.of("Konsultan IT", "Pengembang Produk Elektronik")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Sipil",
                List.of("Dosen Teknik Sipil", "Peneliti Struktur Bangunan"),
                List.of("Engineer Konstruksi", "Surveyor", "Manajer Proyek Konstruksi"),
                List.of("Konsultan Perencanaan", "Pengusaha Properti")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Kimia",
                List.of("Dosen Teknik Kimia", "Peneliti Proses Kimia"),
                List.of("Engineer Proses", "Analis Kualitas", "Manajer Produksi Kimia"),
                List.of("Konsultan Lingkungan", "Pengusaha Produk Kimia")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Industri",
                List.of("Dosen Teknik Industri", "Peneliti Manajemen Produksi"),
                List.of("Engineer Produksi", "Analis Rantai Pasok", "Manajer Operasi"),
                List.of("Konsultan Efisiensi", "Wirausahawan Industri")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Lingkungan",
                List.of("Dosen Teknik Lingkungan", "Peneliti Pengelolaan Limbah"),
                List.of("Engineer Pengolahan Air", "Spesialis Pengelolaan Sampah"),
                List.of("Aktivis Lingkungan", "Konsultan Ekologi")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Komputer",
                List.of("Dosen Teknik Komputer", "Peneliti Sistem Embedded"),
                List.of("Engineer Hardware", "Teknisi IT", "Pengembang Sistem"),
                List.of("Konsultan IT", "Pengusaha Startup Teknologi")
        ));

        teknologiTeknik.add(new Jurusan(
                "Ilmu Komputer",
                List.of("Dosen Ilmu Komputer", "Peneliti Algoritma"),
                List.of("Software Developer", "Data Scientist", "System Analyst"),
                List.of("Konsultan Teknologi", "Pengusaha IT")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Biomedis",
                List.of("Dosen Teknik Biomedis", "Peneliti Alat Medis"),
                List.of("Engineer Perangkat Medis", "Spesialis Perawatan Alat Kesehatan"),
                List.of("Konsultan Bioteknologi", "Wirausaha Alat Kesehatan")
        ));

        teknologiTeknik.add(new Jurusan(
                "Bioteknologi",
                List.of("Dosen Bioteknologi", "Peneliti Genetika"),
                List.of("Ahli Produksi Bioteknologi", "Teknisi Laboratorium"),
                List.of("Konsultan Pertanian", "Pengusaha Produk Bioteknologi")
        ));

        teknologiTeknik.add(new Jurusan(
                "Teknik Otomotif",
                List.of("Dosen Teknik Otomotif", "Peneliti Kendaraan"),
                List.of("Engineer Perancangan Otomotif", "Teknisi Servis Kendaraan"),
                List.of("Konsultan Modifikasi", "Pengusaha Bengkel")
        ));

        teknologiTeknik.add(new Jurusan(
                "Arsitektur",
                List.of("Dosen Arsitektur", "Peneliti Desain Bangunan"),
                List.of("Arsitek", "Desainer Interior", "Manajer Proyek"),
                List.of("Konsultan Desain", "Pengusaha Konstruksi")
        ));

        teknologiTeknik.add(new Jurusan(
                "Rekayasa Perangkat Lunak",
                List.of("Dosen Rekayasa Perangkat Lunak", "Peneliti Software"),
                List.of("Software Engineer", "Quality Assurance", "Project Manager IT"),
                List.of("Konsultan IT", "Wirausaha Aplikasi")
        ));

        map.put("🛠️ Teknologi & Teknik", teknologiTeknik);

        // Tambahkan kategori Bisnis & Manajemen
        List<Jurusan> bisnisManajemen = new ArrayList<>();
        bisnisManajemen.add(new Jurusan(
                "Administrasi Bisnis",
                List.of("Dosen Administrasi Bisnis", "Peneliti Manajemen"),
                List.of("Manajer Proyek", "Business Analyst", "Manajer Kantor"),
                List.of("Konsultan Bisnis", "Wirausaha Startup")
        ));

        bisnisManajemen.add(new Jurusan(
                "Akuntansi",
                List.of("Dosen Akuntansi", "Peneliti Pajak"),
                List.of("Akuntan Publik", "Auditor", "Analis Keuangan"),
                List.of("Konsultan Pajak", "Pengusaha Jasa Keuangan")
        ));

        bisnisManajemen.add(new Jurusan(
                "Keuangan",
                List.of("Dosen Keuangan", "Peneliti Investasi"),
                List.of("Analis Investasi", "Manajer Risiko", "Penasihat Keuangan"),
                List.of("Konsultan Keuangan Pribadi", "Wirausaha Investasi")
        ));

        bisnisManajemen.add(new Jurusan(
                "Pemasaran",
                List.of("Dosen Pemasaran", "Peneliti Perilaku Konsumen"),
                List.of("Marketing Manager", "Brand Manager", "Digital Marketer"),
                List.of("Konsultan Pemasaran", "Pengusaha Produk")
        ));

        bisnisManajemen.add(new Jurusan(
                "Sumber Daya Manusia",
                List.of("Dosen HR", "Peneliti Organisasi"),
                List.of("HR Manager", "Rekrutmen Specialist", "Trainer Karyawan"),
                List.of("Konsultan SDM", "Wirausaha Pelatihan")
        ));

        bisnisManajemen.add(new Jurusan(
                "Manajemen Operasi / Rantai Pasok",
                List.of("Dosen Manajemen Operasi", "Peneliti Logistik"),
                List.of("Manajer Rantai Pasok", "Logistik Coordinator", "Analis Operasi"),
                List.of("Konsultan Efisiensi Operasi", "Pengusaha Logistik")
        ));

        bisnisManajemen.add(new Jurusan(
                "Manajemen Hotel & Pariwisata",
                List.of("Dosen Pariwisata", "Peneliti Perhotelan"),
                List.of("Manajer Hotel", "Event Organizer", "Tourism Manager"),
                List.of("Konsultan Pariwisata", "Pengusaha Hotel/Resort")
        ));

        bisnisManajemen.add(new Jurusan(
                "Kewirausahaan / Business Analytics",
                List.of("Dosen Kewirausahaan", "Peneliti Analitik Bisnis"),
                List.of("Entrepreneur", "Business Analyst", "Startup Founder"),
                List.of("Konsultan Bisnis", "Mentor Startup")
        ));

        map.put("🧩 Bisnis & Manajemen", bisnisManajemen);

        // Tambahkan kategori Komunikasi & Media
        List<Jurusan> komunikasiMedia = new ArrayList<>();
        komunikasiMedia.add(new Jurusan(
                "Ilmu Komunikasi (umum, digital, internasional)",
                List.of("Dosen Ilmu Komunikasi", "Peneliti Media Digital"),
                List.of("Spesialis Media Sosial", "Manajer Konten Digital", "Public Relations Officer"),
                List.of("Konsultan Komunikasi", "Pembicara Publik")
        ));

        komunikasiMedia.add(new Jurusan(
                "Jurnalistik (cetak, siaran, multimedia)",
                List.of("Dosen Jurnalistik", "Peneliti Media"),
                List.of("Reporter", "Editor", "Produser Siaran"),
                List.of("Penulis Lepas", "Pembuat Konten Independen")
        ));

        komunikasiMedia.add(new Jurusan(
                "Public Relations",
                List.of("Dosen PR", "Peneliti Hubungan Masyarakat"),
                List.of("PR Manager", "Event Coordinator", "Media Relations Specialist"),
                List.of("Konsultan PR", "Pengusaha Event Organizer")
        ));

        komunikasiMedia.add(new Jurusan(
                "Periklanan",
                List.of("Dosen Periklanan", "Peneliti Perilaku Konsumen"),
                List.of("Creative Director", "Copywriter", "Account Executive"),
                List.of("Konsultan Brand", "Pendiri Agency Iklan")
        ));

        komunikasiMedia.add(new Jurusan(
                "Penyiaran Radio & TV",
                List.of("Dosen Penyiaran", "Peneliti Media Broadcast"),
                List.of("Penyiar Radio", "Produser TV", "Teknisi Siaran"),
                List.of("Host Podcast", "Pembuat Film Independen")
        ));

        map.put("💻 Komunikasi & Media", komunikasiMedia);

        // Tambahkan kategori Seni & Desain
        List<Jurusan> seniDesain = new ArrayList<>();
        seniDesain.add(new Jurusan(
                "Seni Rupa / Studio Arts",
                List.of("Dosen Seni Rupa", "Peneliti Sejarah Seni"),
                List.of("Seniman Profesional", "Kurator Galeri", "Desainer Produk"),
                List.of("Pengajar Seni Privat", "Kritikus Seni")
        ));

        seniDesain.add(new Jurusan(
                "Musik (teori, komposisi, performa)",
                List.of("Dosen Musik", "Peneliti Musikologi"),
                List.of("Musisi Profesional", "Komposer", "Pengajar Musik"),
                List.of("Penyelenggara Konser", "Produser Musik Independen")
        ));

        seniDesain.add(new Jurusan(
                "Teater & Drama",
                List.of("Dosen Teater", "Peneliti Drama"),
                List.of("Aktor/Aktris", "Sutradara", "Penulis Naskah"),
                List.of("Pengelola Teater Komunitas", "Pelatih Akting")
        ));

        seniDesain.add(new Jurusan(
                "Film & Produksi Video",
                List.of("Dosen Film", "Peneliti Media"),
                List.of("Sutradara Film", "Editor Video", "Produser"),
                List.of("YouTuber", "Pembuat Film Independen")
        ));

        seniDesain.add(new Jurusan(
                "Animasi & Multimedia",
                List.of("Dosen Animasi", "Peneliti Multimedia"),
                List.of("Animator", "Desainer Game", "Video Editor"),
                List.of("Freelancer Animasi", "Pengembang Konten Multimedia")
        ));

        seniDesain.add(new Jurusan(
                "Desain Grafis, Interior, Fashion",
                List.of("Dosen Desain", "Peneliti Desain"),
                List.of("Desainer Grafis", "Desainer Interior", "Desainer Fashion"),
                List.of("Konsultan Desain", "Pengusaha Brand Fashion")
        ));

        map.put("🎭 Seni & Desain", seniDesain);

        // Tambahkan kategori Kesehatan & Kedokteran
        List<Jurusan> kesehatanKedokteran = new ArrayList<>();
        kesehatanKedokteran.add(new Jurusan(
                "Keperawatan",
                List.of("Dosen Keperawatan", "Peneliti Keperawatan"),
                List.of("Perawat Klinis", "Perawat ICU", "Manajer Rumah Sakit"),
                List.of("Konsultan Kesehatan", "Pengajar Keperawatan")
        ));

        kesehatanKedokteran.add(new Jurusan(
                "Farmasi",
                List.of("Dosen Farmasi", "Peneliti Farmasi"),
                List.of("Apoteker", "Analis Farmasi", "Manajer Produksi Obat"),
                List.of("Konsultan Obat", "Wirausaha Produk Herbal")
        ));

        kesehatanKedokteran.add(new Jurusan(
                "Kedokteran & Kedokteran Gigi",
                List.of("Dokter Spesialis", "Peneliti Medis"),
                List.of("Dokter Umum", "Dokter Gigi", "Spesialis Bedah"),
                List.of("Konsultan Kesehatan", "Penulis Buku Medis")
        ));

        kesehatanKedokteran.add(new Jurusan(
                "Fisioterapi, Terapis Okupasi",
                List.of("Dosen Fisioterapi", "Peneliti Rehabilitasi"),
                List.of("Fisioterapis", "Terapis Okupasi", "Manajer Klinik Rehabilitasi"),
                List.of("Konsultan Kesehatan", "Pelatih Rehabilitasi")
        ));

        kesehatanKedokteran.add(new Jurusan(
                "Teknologi Laboratorium Medis",
                List.of("Dosen Teknologi Laboratorium", "Peneliti Diagnostik"),
                List.of("Teknisi Laboratorium", "Analis Medis"),
                List.of("Konsultan Kesehatan", "Pengembang Alat Diagnostik")
        ));

        kesehatanKedokteran.add(new Jurusan(
                "Kesehatan Masyarakat & Nutrisi",
                List.of("Dosen Kesehatan Masyarakat", "Peneliti Gizi"),
                List.of("Ahli Gizi", "Konsultan Kesehatan Masyarakat", "Manajer Program Kesehatan"),
                List.of("Aktivis Kesehatan", "Wirausaha Produk Nutrisi")
        ));

        map.put("🏥 Kesehatan & Kedokteran", kesehatanKedokteran);

        // Tambahkan kategori Ilmu Sosial & Humaniora
        List<Jurusan> ilmuSosialHumaniora = new ArrayList<>();
        ilmuSosialHumaniora.add(new Jurusan(
                "Psikologi",
                List.of("Dosen Psikologi", "Peneliti Psikologi Klinis"),
                List.of("Psikolog Klinis", "Konselor", "HR Specialist"),
                List.of("Penulis Buku Psikologi", "Trainer Pengembangan Diri")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Sosiologi",
                List.of("Dosen Sosiologi", "Peneliti Sosial"),
                List.of("Analis Kebijakan", "Sosiolog Lapangan"),
                List.of("Konsultan Sosial", "Penggiat Komunitas")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Antropologi",
                List.of("Dosen Antropologi", "Peneliti Budaya"),
                List.of("Antropolog Lapangan", "Konsultan Budaya"),
                List.of("Penulis Buku Antropologi", "Pengelola Museum")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Ekonomi",
                List.of("Dosen Ekonomi", "Peneliti Ekonomi"),
                List.of("Ekonom", "Analis Keuangan", "Penasihat Investasi"),
                List.of("Konsultan Bisnis", "Pengusaha")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Ilmu Politik / Hubungan Internasional",
                List.of("Dosen Ilmu Politik", "Peneliti Hubungan Internasional"),
                List.of("Diplomat", "Analis Kebijakan Publik", "Konsultan Politik"),
                List.of("Aktivis Politik", "Penulis Opini")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Sejarah",
                List.of("Dosen Sejarah", "Peneliti Sejarah"),
                List.of("Arkeolog", "Kurator Museum", "Penulis Sejarah"),
                List.of("Pemandu Wisata Sejarah", "Pembuat Dokumenter")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Pendidikan",
                List.of("Dosen Pendidikan", "Peneliti Kurikulum"),
                List.of("Guru", "Konsultan Pendidikan", "Manajer Sekolah"),
                List.of("Pelatih Pendidikan", "Penulis Buku Pendidikan")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Studi Gender & Etnis",
                List.of("Dosen Studi Gender", "Peneliti Sosial"),
                List.of("Konsultan Kesetaraan Gender", "Aktivis HAM"),
                List.of("Penulis", "Pengelola Program Sosial")
        ));

        ilmuSosialHumaniora.add(new Jurusan(
                "Filsafat & Agama",
                List.of("Dosen Filsafat", "Peneliti Agama"),
                List.of("Filsuf", "Pengajar Agama", "Konselor Spiritual"),
                List.of("Penulis Buku", "Pembicara Publik")
        ));

        map.put("👥 Ilmu Sosial & Humaniora", ilmuSosialHumaniora);

        // Tambahkan kategori Hukum & Kriminologi
        List<Jurusan> hukumKriminologi = new ArrayList<>();
        hukumKriminologi.add(new Jurusan(
                "Hukum (LLB, pre-law)",
                List.of("Dosen Hukum", "Peneliti Hukum"),
                List.of("Pengacara", "Notaris", "Hakim"),
                List.of("Konsultan Hukum", "Aktivis HAM")
        ));

        hukumKriminologi.add(new Jurusan(
                "Kriminologi / Criminal Justice",
                List.of("Dosen Kriminologi", "Peneliti Kriminal"),
                List.of("Analis Kriminal", "Petugas Penegak Hukum"),
                List.of("Konsultan Keamanan", "Penulis Buku Kriminologi")
        ));

        hukumKriminologi.add(new Jurusan(
                "Forensik & Penegakan Hukum",
                List.of("Dosen Forensik", "Peneliti Forensik"),
                List.of("Ahli Forensik", "Teknisi Laboratorium Forensik"),
                List.of("Konsultan Forensik", "Pengacara Spesialis Forensik")
        ));

        map.put("🏛️ Hukum & Kriminologi", hukumKriminologi);

        // Tambahkan kategori Pertanian & Sumber Daya Alam
        List<Jurusan> pertanianSda = new ArrayList<>();
        pertanianSda.add(new Jurusan(
                "Pertanian",
                List.of("Dosen Pertanian", "Peneliti Pertanian"),
                List.of("Petani Modern", "Manajer Perkebunan"),
                List.of("Konsultan Pertanian", "Wirausaha Agroindustri")
        ));

        pertanianSda.add(new Jurusan(
                "Agronomi & Hortikultura",
                List.of("Dosen Agronomi", "Peneliti Hortikultura"),
                List.of("Spesialis Tanaman", "Manajer Kebun Buah"),
                List.of("Konsultan Tanaman", "Pengusaha Bibit")
        ));

        pertanianSda.add(new Jurusan(
                "Peternakan & Perikanan",
                List.of("Dosen Peternakan", "Peneliti Perikanan"),
                List.of("Peternak", "Manajer Perikanan"),
                List.of("Konsultan Peternakan", "Wirausaha Produk Hewani")
        ));

        pertanianSda.add(new Jurusan(
                "Konservasi Sumber Daya Alam",
                List.of("Dosen Konservasi", "Peneliti Lingkungan"),
                List.of("Pengelola Taman Nasional", "Spesialis Konservasi"),
                List.of("Aktivis Lingkungan", "Konsultan Ekowisata")
        ));

        map.put("🌿 Pertanian & Sumber Daya Alam", pertanianSda);

        // Tambahkan kategori Lain-lain & Interdisipliner
        List<Jurusan> lainLainInterdisipliner = new ArrayList<>();
        lainLainInterdisipliner.add(new Jurusan(
                "Pendidikan (PAUD hingga Perguruan Tinggi)",
                List.of("Dosen Pendidikan", "Peneliti Kurikulum"),
                List.of("Guru", "Konsultan Pendidikan", "Manajer Sekolah"),
                List.of("Pelatih Pendidikan", "Pengembang Modul Pembelajaran")
        ));

        lainLainInterdisipliner.add(new Jurusan(
                "Bahasa & Sastra (terjemahan, linguistik, sastranegara)",
                List.of("Dosen Bahasa", "Peneliti Linguistik"),
                List.of("Penerjemah", "Editor", "Penulis Kreatif"),
                List.of("Pengajar Bahasa", "Content Creator")
        ));

        lainLainInterdisipliner.add(new Jurusan(
                "Studi Wilayah / Area Studies",
                List.of("Dosen Studi Wilayah", "Peneliti Sosial Budaya"),
                List.of("Analis Kebijakan Luar Negeri", "Konsultan Budaya"),
                List.of("Diplomat", "Penulis dan Pengajar")
        ));

        lainLainInterdisipliner.add(new Jurusan(
                "Studi Gender & Keluarga",
                List.of("Dosen Studi Gender", "Peneliti Sosial"),
                List.of("Konsultan Kesetaraan Gender", "Aktivis Sosial"),
                List.of("Penulis", "Pelatih Kesadaran Gender")
        ));

        lainLainInterdisipliner.add(new Jurusan(
                "Rekreasi & Manajemen Olahraga",
                List.of("Dosen Olahraga", "Peneliti Kesehatan"),
                List.of("Pelatih Olahraga", "Manajer Event Olahraga"),
                List.of("Konsultan Kesehatan", "Pengusaha Fitness")
        ));

        lainLainInterdisipliner.add(new Jurusan(
                "Teknologi Pendidikan",
                List.of("Dosen Teknologi Pendidikan", "Peneliti E-learning"),
                List.of("Instructional Designer", "Pengembang Aplikasi Pendidikan"),
                List.of("Konsultan Pendidikan Digital", "Trainer Teknologi Pendidikan")
        ));

        lainLainInterdisipliner.add(new Jurusan(
                "Teknologi Web",
                List.of("Dosen Ilmu Komputer", "Peneliti Teknologi Web"),
                List.of("Web Developer", "Frontend/Backend Engineer"),
                List.of("Freelancer Teknologi", "Pengusaha Startup Digital")
        ));

        map.put("🧾 Lain-lain & Interdisipliner", lainLainInterdisipliner);

        // Tambahkan kategori lain sesuai kebutuhan...

        return map;
    }
}
