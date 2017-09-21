package com.merveyanar.ilkprojeyardimcim;

import java.io.Serializable;

public class BakiciModel implements Serializable {
    private String ad;
    private String soyad;
    private String dogumTarihi;
    private String adres;
    private String email;
    private String sifre;
    private String sifretekrar;
    private String uyruk;
    private String medeniDurum;
    private String egitimDurumu;
    private String fotograf;
    private String sertifika;
    private String deneyimBilgileri;
    private String cinsiyet;
    private String bakimTercihi;
    private String ilSecim;
//    private String ilceSecim ;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getSifretekrar() {
        return sifretekrar;
    }

    public void setSifretekrar(String sifretekrar) {
        this.sifretekrar = sifretekrar;
    }

    public String getUyruk() {
        return uyruk;
    }

    public void setUyruk(String uyruk) {
        this.uyruk = uyruk;
    }

    public String getMedeniDurum() {
        return medeniDurum;
    }

    public void setMedeniDurum(String medeniDurum) {
        this.medeniDurum = medeniDurum;
    }


    public String getEgitimDurumu() {
        return egitimDurumu;
    }

    public void setEgitimDurumu(String egitimDurumu) {
        this.egitimDurumu = egitimDurumu;
    }

    public String getFotograf() {
        return fotograf;
    }

    public void setFotograf(String fotograf) {
        this.fotograf = fotograf;
    }

    public String getSertifika() {
        return sertifika;
    }

    public void setSertifika(String sertifika) {
        this.sertifika = sertifika;
    }

    public String getDeneyimBilgileri() {
        return deneyimBilgileri;
    }

    public void setDeneyimBilgileri(String deneyimBilgileri) {
        this.deneyimBilgileri = deneyimBilgileri;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getBakimTercihi() {
        return bakimTercihi;
    }

    public void setBakimTercihi(String bakimTercihi) {
        this.bakimTercihi = bakimTercihi;
    }

    public String getIlSecim() {
        return ilSecim;
    }

    public void setIlSecim(String ilSecim) {
        this.ilSecim = ilSecim;
    }

    public BakiciModel(String ad, String soyad, String dogumTarihi, String adres, String email, String sifre, String sifretekrar, String uyruk, String medeniDurum, String egitimDurumu, String fotograf, String sertifika, String deneyimBilgileri, String cinsiyet, String bakimTercihi, String ilSecim) {
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
        this.adres = adres;
        this.email = email;
        this.sifre = sifre;
        this.sifretekrar = sifretekrar;
        this.uyruk = uyruk;
        this.medeniDurum = medeniDurum;
        this.egitimDurumu = egitimDurumu;
        this.fotograf = fotograf;
        this.sertifika = sertifika;
        this.deneyimBilgileri = deneyimBilgileri;
        this.cinsiyet = cinsiyet;
        this.bakimTercihi = bakimTercihi;
        this.ilSecim = ilSecim;

    }

    public BakiciModel(String ad, String soyad, String dogumTarihi, String adres, String email, String medeniDurum, String egitimDurumu, String cinsiyet, String bakimTercihi, String ilSecim) {
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
        this.adres = adres;
        this.email = email;
        this.medeniDurum = medeniDurum;
        this.egitimDurumu = egitimDurumu;
        this.cinsiyet = cinsiyet;
        this.bakimTercihi = bakimTercihi;
        this.ilSecim = ilSecim;
    }

    public BakiciModel() {

    }
}
