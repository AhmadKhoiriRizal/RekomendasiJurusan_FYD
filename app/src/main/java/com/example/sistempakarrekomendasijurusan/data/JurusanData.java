package com.example.sistempakarrekomendasijurusan.data;

import com.example.sistempakarrekomendasijurusan.model.Jurusan;

import java.util.ArrayList;
import java.util.List;

public class JurusanData {

    public static List<Jurusan> getAllJurusan() {
        List<Jurusan> list = new ArrayList<>();

        // 1. Sains & STEM
        list.add(new Jurusan("Biologi", "Sains & STEM"));
        list.add(new Jurusan("Kimia", "Sains & STEM"));
        list.add(new Jurusan("Fisika", "Sains & STEM"));
        list.add(new Jurusan("Matematika", "Sains & STEM"));
        list.add(new Jurusan("Statistika", "Sains & STEM"));
        list.add(new Jurusan("Ilmu Lingkungan", "Sains & STEM"));
        list.add(new Jurusan("Geologi", "Sains & STEM"));
        list.add(new Jurusan("Astronomi", "Sains & STEM"));

        // 2. Teknologi & Teknik
        list.add(new Jurusan("Teknik Mesin", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Elektro", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Sipil", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Kimia", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Industri", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Lingkungan", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Komputer", "Teknologi & Teknik"));
        list.add(new Jurusan("Ilmu Komputer", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Biomedis", "Teknologi & Teknik"));
        list.add(new Jurusan("Bioteknologi", "Teknologi & Teknik"));
        list.add(new Jurusan("Teknik Otomotif", "Teknologi & Teknik"));
        list.add(new Jurusan("Arsitektur", "Teknologi & Teknik"));
        list.add(new Jurusan("Rekayasa Perangkat Lunak", "Teknologi & Teknik"));

        // 3. Bisnis & Manajemen
        list.add(new Jurusan("Administrasi Bisnis", "Bisnis & Manajemen"));
        list.add(new Jurusan("Akuntansi", "Bisnis & Manajemen"));
        list.add(new Jurusan("Keuangan", "Bisnis & Manajemen"));
        list.add(new Jurusan("Pemasaran", "Bisnis & Manajemen"));
        list.add(new Jurusan("Sumber Daya Manusia", "Bisnis & Manajemen"));
        list.add(new Jurusan("Manajemen Operasi", "Bisnis & Manajemen"));
        list.add(new Jurusan("Manajemen Hotel & Pariwisata", "Bisnis & Manajemen"));
        list.add(new Jurusan("Kewirausahaan", "Bisnis & Manajemen"));
        list.add(new Jurusan("Business Analytics", "Bisnis & Manajemen"));

        // 4. Komunikasi & Media
        list.add(new Jurusan("Ilmu Komunikasi", "Komunikasi & Media"));
        list.add(new Jurusan("Jurnalistik", "Komunikasi & Media"));
        list.add(new Jurusan("Public Relations", "Komunikasi & Media"));
        list.add(new Jurusan("Periklanan", "Komunikasi & Media"));
        list.add(new Jurusan("Penyiaran Radio & TV", "Komunikasi & Media"));

        // 5. Seni & Desain
        list.add(new Jurusan("Seni Rupa", "Seni & Desain"));
        list.add(new Jurusan("Musik", "Seni & Desain"));
        list.add(new Jurusan("Teater & Drama", "Seni & Desain"));
        list.add(new Jurusan("Film & Produksi Video", "Seni & Desain"));
        list.add(new Jurusan("Animasi & Multimedia", "Seni & Desain"));
        list.add(new Jurusan("Desain Grafis", "Seni & Desain"));
        list.add(new Jurusan("Desain Interior", "Seni & Desain"));
        list.add(new Jurusan("Desain Fashion", "Seni & Desain"));

        // 6. Kesehatan & Kedokteran
        list.add(new Jurusan("Keperawatan", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Farmasi", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Kedokteran", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Kedokteran Gigi", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Fisioterapi", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Terapis Okupasi", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Teknologi Laboratorium Medis", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Kesehatan Masyarakat", "Kesehatan & Kedokteran"));
        list.add(new Jurusan("Nutrisi", "Kesehatan & Kedokteran"));

        // 7. Ilmu Sosial & Humaniora
        list.add(new Jurusan("Psikologi", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Sosiologi", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Antropologi", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Ekonomi", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Ilmu Politik", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Hubungan Internasional", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Sejarah", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Pendidikan", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Studi Gender", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Filsafat", "Ilmu Sosial & Humaniora"));
        list.add(new Jurusan("Agama", "Ilmu Sosial & Humaniora"));

        // 8. Hukum & Kriminologi
        list.add(new Jurusan("Hukum", "Hukum & Kriminologi"));
        list.add(new Jurusan("Kriminologi", "Hukum & Kriminologi"));
        list.add(new Jurusan("Forensik", "Hukum & Kriminologi"));
        list.add(new Jurusan("Penegakan Hukum", "Hukum & Kriminologi"));

        // 9. Pertanian & Sumber Daya Alam
        list.add(new Jurusan("Pertanian", "Pertanian & Sumber Daya Alam"));
        list.add(new Jurusan("Agronomi", "Pertanian & Sumber Daya Alam"));
        list.add(new Jurusan("Hortikultura", "Pertanian & Sumber Daya Alam"));
        list.add(new Jurusan("Peternakan", "Pertanian & Sumber Daya Alam"));
        list.add(new Jurusan("Perikanan", "Pertanian & Sumber Daya Alam"));
        list.add(new Jurusan("Konservasi Sumber Daya Alam", "Pertanian & Sumber Daya Alam"));

        // 10. Lain-lain & Interdisipliner
        list.add(new Jurusan("Pendidikan Anak Usia Dini", "Lain-lain & Interdisipliner"));
        list.add(new Jurusan("Bahasa & Sastra", "Lain-lain & Interdisipliner"));
        list.add(new Jurusan("Linguistik", "Lain-lain & Interdisipliner"));
        list.add(new Jurusan("Studi Wilayah", "Lain-lain & Interdisipliner"));
        list.add(new Jurusan("Studi Gender & Keluarga", "Lain-lain & Interdisipliner"));
        list.add(new Jurusan("Rekreasi & Manajemen Olahraga", "Lain-lain & Interdisipliner"));
        list.add(new Jurusan("Teknologi Pendidikan", "Lain-lain & Interdisipliner"));
        list.add(new Jurusan("Teknologi Web", "Lain-lain & Interdisipliner"));

        return list;
    }
}
