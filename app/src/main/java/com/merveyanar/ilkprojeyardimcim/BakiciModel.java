package com.merveyanar.ilkprojeyardimcim;

import java.util.Date;

/**
 * Created by 7 on 05.08.2017.
 */

public class BakiciModel {

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

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
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

    public String getIlceSecim() {
        return ilceSecim;
    }

    public void setIlceSecim(String ilceSecim) {
        this.ilceSecim = ilceSecim;
    }

    public BakiciModel(int id, String ad, String soyad, Date dogumTarihi, String adres, String email, String sifre, String uyruk, String medeniDurum, String kanGrubu, String egitimDurumu, String fotograf, String sertifika, String deneyimBilgileri, String cinsiyet, String bakimTercihi, String ilSecim, String ilceSecim) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
        this.adres = adres;
        this.email = email;
        this.sifre = sifre;
        this.uyruk = uyruk;
        this.medeniDurum = medeniDurum;
        this.kanGrubu = kanGrubu;
        this.egitimDurumu = egitimDurumu;
        this.fotograf = fotograf;
        this.sertifika = sertifika;
        this.deneyimBilgileri = deneyimBilgileri;
        this.cinsiyet = cinsiyet;
        this.bakimTercihi = bakimTercihi;
        this.ilSecim = ilSecim;
        this.ilceSecim = ilceSecim;
    }

    public BakiciModel(){

    }
}
