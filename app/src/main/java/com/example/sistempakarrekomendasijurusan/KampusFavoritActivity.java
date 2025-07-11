package com.example.sistempakarrekomendasijurusan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistempakarrekomendasijurusan.adapter.KampusAdapter;

import java.util.ArrayList;
import java.util.List;

public class KampusFavoritActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KampusAdapter adapter;
    private List<String> daftarKampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kampus_favorit);

        recyclerView = findViewById(R.id.recyclerKampus);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        daftarKampus = getKampusFavorit();
        adapter = new KampusAdapter(daftarKampus);
        recyclerView.setAdapter(adapter);
    }

    private List<String> getKampusFavorit() {
        List<String> kampus = new ArrayList<>();
        kampus.add("1. Universitas Indonesia (UI)");
        kampus.add("2. Institut Teknologi Bandung (ITB)");
        kampus.add("3. Universitas Gadjah Mada (UGM)");
        kampus.add("4. Institut Pertanian Bogor (IPB)");
        kampus.add("5. Universitas Airlangga (UNAIR)");
        kampus.add("6. Universitas Padjadjaran (UNPAD)");
        kampus.add("7. Universitas Diponegoro (UNDIP)");
        kampus.add("8. Universitas Brawijaya (UB)");
        kampus.add("9. Universitas Sebelas Maret (UNS)");
        kampus.add("10. Institut Teknologi Sepuluh Nopember (ITS)");
        kampus.add("11. Universitas Hasanuddin (UNHAS)");
        kampus.add("12. Universitas Pendidikan Indonesia (UPI)");
        kampus.add("13. Universitas Negeri Yogyakarta (UNY)");
        kampus.add("14. Universitas Sumatera Utara (USU)");
        kampus.add("15. Universitas Sriwijaya (UNSRI)");
        kampus.add("16. Universitas Lampung (UNILA)");
        kampus.add("17. Universitas Negeri Semarang (UNNES)");
        kampus.add("18. Universitas Andalas (UNAND)");
        kampus.add("19. Universitas Jenderal Soedirman (UNSOED)");
        kampus.add("20. Universitas Negeri Malang (UM)");
        kampus.add("21. Universitas Negeri Surabaya (UNESA)");
        kampus.add("22. Universitas Islam Indonesia (UII)");
        kampus.add("23. Universitas Atma Jaya Yogyakarta (UAJY)");
        kampus.add("24. Universitas Katolik Parahyangan (UNPAR)");
        kampus.add("25. Universitas Kristen Petra (UKP)");
        kampus.add("26. Universitas Tarumanagara (UNTAR)");
        kampus.add("27. Universitas Trisakti");
        kampus.add("28. Universitas Bina Nusantara (BINUS)");
        kampus.add("29. Universitas Pelita Harapan (UPH)");
        kampus.add("30. Universitas Ciputra");
        kampus.add("31. Universitas Sanata Dharma (USD)");
        kampus.add("32. Universitas Muhammadiyah Yogyakarta (UMY)");
        kampus.add("33. Universitas Islam Negeri Syarif Hidayatullah Jakarta (UIN Jakarta)");
        kampus.add("34. Universitas Islam Negeri Sunan Kalijaga Yogyakarta (UIN Suka)");
        kampus.add("35. Universitas Negeri Makassar (UNM)");
        kampus.add("36. Universitas Jember (UNEJ)");
        kampus.add("37. Universitas Mulawarman (UNMUL)");
        kampus.add("38. Universitas Negeri Padang (UNP)");
        kampus.add("39. Universitas Syiah Kuala (UNSYIAH)");
        kampus.add("40. Universitas Negeri Medan (UNIMED)");
        kampus.add("41. Universitas Negeri Jakarta (UNJ)");
        kampus.add("42. Universitas Pancasila");
        kampus.add("43. Universitas Islam Negeri Alauddin Makassar (UIN Alauddin)");
        kampus.add("44. Universitas Tarumanagara");
        kampus.add("45. Universitas 17 Agustus 1945 Jakarta (UNTAR)");
        kampus.add("46. Universitas Brawijaya");
        kampus.add("47. Universitas Nasional (UNAS)");
        kampus.add("48. Universitas Katolik Indonesia Atma Jaya (Jakarta)");
        kampus.add("49. Universitas Pelita Harapan (UPH)");
        kampus.add("50. Universitas Paramadina");
        return kampus;
    }
}
