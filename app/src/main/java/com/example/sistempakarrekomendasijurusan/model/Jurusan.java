package com.example.sistempakarrekomendasijurusan.model;

import java.util.List;

public class Jurusan {
    public String nama;
    public List<String> akademik;
    public List<String> industri;
    public List<String> alternatif;

    public Jurusan(String nama, List<String> akademik, List<String> industri, List<String> alternatif) {
        this.nama = nama;
        this.akademik = akademik;
        this.industri = industri;
        this.alternatif = alternatif;
    }
}
