package com.example.sistempakarrekomendasijurusan.model;

public class Jurusan {
    private String nama;
    private String kategori;

    public Jurusan(String nama, String kategori) {
        this.nama = nama;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }
}
