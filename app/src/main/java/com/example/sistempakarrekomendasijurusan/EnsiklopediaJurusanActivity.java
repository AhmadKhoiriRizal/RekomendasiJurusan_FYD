package com.example.sistempakarrekomendasijurusan;

import android.os.Bundle;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sistempakarrekomendasijurusan.adapter.EnsiklopediaAdapter;

import java.util.*;

public class EnsiklopediaJurusanActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private EnsiklopediaAdapter adapter;
    private List<String> kategoriList;
    private Map<String, List<String>> dataMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensiklopedia_jurusan);

        expandableListView = findViewById(R.id.expandableListView);

        kategoriList = new ArrayList<>();
        dataMap = new LinkedHashMap<>();

        isiData();

        adapter = new EnsiklopediaAdapter(this, kategoriList, dataMap);
        expandableListView.setAdapter(adapter);
    }

    private void isiData() {
        kategoriList.add("🧪 Sains & STEM");
        kategoriList.add("🛠️ Teknologi & Teknik");
        kategoriList.add("🧩 Bisnis & Manajemen");
        kategoriList.add("💻 Komunikasi & Media");
        kategoriList.add("🎭 Seni & Desain");
        kategoriList.add("🏥 Kesehatan & Kedokteran");
        kategoriList.add("👥 Ilmu Sosial & Humaniora");
        kategoriList.add("🏛️ Hukum & Kriminologi");
        kategoriList.add("🌿 Pertanian & SDA");
        kategoriList.add("🧾 Lain-lain & Interdisipliner");

        dataMap.put("🧪 Sains & STEM", Arrays.asList(
                "Biologi", "Kimia", "Fisika", "Matematika & Statistika", "Ilmu Lingkungan",
                "Geologi", "Astronomi / Meteorologi"));

        dataMap.put("🛠️ Teknologi & Teknik", Arrays.asList(
                "Teknik Mesin", "Teknik Elektro", "Teknik Sipil", "Teknik Kimia", "Teknik Industri",
                "Teknik Lingkungan", "Teknik Komputer", "Ilmu Komputer", "Teknik Biomedis",
                "Bioteknologi", "Teknik Otomotif", "Arsitektur", "Rekayasa Perangkat Lunak"));

        dataMap.put("🧩 Bisnis & Manajemen", Arrays.asList(
                "Administrasi Bisnis", "Akuntansi", "Keuangan", "Pemasaran",
                "Sumber Daya Manusia", "Manajemen Operasi", "Manajemen Hotel & Pariwisata",
                "Kewirausahaan / Business Analytics"));

        dataMap.put("💻 Komunikasi & Media", Arrays.asList(
                "Ilmu Komunikasi", "Jurnalistik", "Public Relations", "Periklanan", "Penyiaran Radio & TV"));

        dataMap.put("🎭 Seni & Desain", Arrays.asList(
                "Seni Rupa", "Musik", "Teater & Drama", "Film & Produksi Video",
                "Animasi & Multimedia", "Desain Grafis", "Desain Interior", "Fashion"));

        dataMap.put("🏥 Kesehatan & Kedokteran", Arrays.asList(
                "Keperawatan", "Farmasi", "Kedokteran", "Kedokteran Gigi",
                "Fisioterapi", "Terapis Okupasi", "Teknologi Laboratorium Medis",
                "Kesehatan Masyarakat", "Nutrisi"));

        dataMap.put("👥 Ilmu Sosial & Humaniora", Arrays.asList(
                "Psikologi", "Sosiologi", "Antropologi", "Ekonomi", "Ilmu Politik",
                "Hubungan Internasional", "Sejarah", "Pendidikan", "Studi Gender & Etnis",
                "Filsafat & Agama"));

        dataMap.put("🏛️ Hukum & Kriminologi", Arrays.asList(
                "Hukum", "Kriminologi", "Forensik", "Penegakan Hukum"));

        dataMap.put("🌿 Pertanian & SDA", Arrays.asList(
                "Pertanian", "Agronomi & Hortikultura", "Peternakan & Perikanan", "Konservasi Sumber Daya Alam"));

        dataMap.put("🧾 Lain-lain & Interdisipliner", Arrays.asList(
                "Pendidikan", "Bahasa & Sastra", "Studi Wilayah", "Studi Gender & Keluarga",
                "Rekreasi & Manajemen Olahraga", "Teknologi Pendidikan", "Teknologi Web"));
    }
}
