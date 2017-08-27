package com.merveyanar.ilkprojeyardimcim;

/**
 * Created by 7 on 05.08.2017.
 */

public class AileModel   {


    public String getAileAd() {
        return aileAd;
    }

    public void setAileAd(String aileAd) {
        this.aileAd = aileAd;
    }

    public String getAileSoyad() {
        return aileSoyad;
    }

    public void setAileSoyad(String aileSoyad) {
        this.aileSoyad = aileSoyad;
    }

    public String getAileAdres() {
        return aileAdres;
    }

    public void setAileAdres(String aileAdres) {
        this.aileAdres = aileAdres;
    }

    public String getAileMail() {
        return aileMail;
    }

    public void setAileMail(String aileMail) {
        this.aileMail = aileMail;
    }

    public String getAileSifre() {
        return aileSifre;
    }

    public void setAileSifre(String aileSifre) {
        this.aileSifre = aileSifre;
    }

    public String getAileSifreTekrar() {
        return aileSifreTekrar;
    }

    public void setAileSifreTekrar(String aileSifreTekrar) {
        this.aileSifreTekrar = aileSifreTekrar;
    }

    public String getAileTelefon() {
        return aileTelefon;
    }

    public void setAileTelefon(String aileTelefon) {
        this.aileTelefon = aileTelefon;
    }

    public String getAileMedeniDurum() {
        return aileMedeniDurum;
    }

    public void setAileMedeniDurum(String aileMedeniDurum) {
        this.aileMedeniDurum = aileMedeniDurum;
    }

    public String getAileEgitimDurumu() {
        return aileEgitimDurumu;
    }

    public void setAileEgitimDurumu(String aileEgitimDurumu) {
        this.aileEgitimDurumu = aileEgitimDurumu;
    }

    public String getAileCinsiyet() {
        return aileCinsiyet;
    }

    public void setAileCinsiyet(String aileCinsiyet) {
        this.aileCinsiyet = aileCinsiyet;
    }

    public String getAileIl() {
        return aileIl;
    }

    public void setAileIl(String aileIl) {
        this.aileIl = aileIl;
    }

    public String getHastaAd() {
        return hastaAd;
    }

    public void setHastaAd(String hastaAd) {
        this.hastaAd = hastaAd;
    }

    public String getHastaSoyad() {
        return hastaSoyad;
    }

    public void setHastaSoyad(String hastaSoyad) {
        this.hastaSoyad = hastaSoyad;
    }

    public String getHastaCinsiyet() {
        return hastaCinsiyet;
    }

    public void setHastaCinsiyet(String hastaCinsiyet) {
        this.hastaCinsiyet = hastaCinsiyet;
    }

    public String getHastaEngel() {
        return hastaEngel;
    }

    public void setHastaEngel(String hastaEngel) {
        this.hastaEngel = hastaEngel;
    }

    public String getHastaDogumTarihi() {
        return hastaDogumTarihi;
    }

    public void setHastaDogumTarihi(String hastaDogumTarihi) {
        this.hastaDogumTarihi = hastaDogumTarihi;
    }

    public String getHastaFotograf() {
        return hastaFotograf;
    }

    public void setHastaFotograf(String hastaFotograf) {
        this.hastaFotograf = hastaFotograf;
    }

    public AileModel(String aileAd, String aileSoyad, String aileAdres, String aileMail, String aileSifre, String aileSifreTekrar, String aileTelefon, String aileMedeniDurum, String aileEgitimDurumu, String aileCinsiyet, String aileIl, String hastaAd, String hastaSoyad, String hastaCinsiyet, String hastaEngel, String hastaDogumTarihi, String hastaFotograf) {
        this.aileAd = aileAd;
        this.aileSoyad = aileSoyad;
        this.aileAdres = aileAdres;
        this.aileMail = aileMail;
        this.aileSifre = aileSifre;
        this.aileSifreTekrar = aileSifreTekrar;
        this.aileTelefon = aileTelefon;
        this.aileMedeniDurum = aileMedeniDurum;
        this.aileEgitimDurumu = aileEgitimDurumu;
        this.aileCinsiyet = aileCinsiyet;
        this.aileIl = aileIl;
        this.hastaAd = hastaAd;
        this.hastaSoyad = hastaSoyad;
        this.hastaCinsiyet = hastaCinsiyet;
        this.hastaEngel = hastaEngel;
        this.hastaDogumTarihi = hastaDogumTarihi;
        this.hastaFotograf = hastaFotograf;
    }

    public AileModel(String aileAd, String aileSoyad, String aileMail) {
    }

    private String aileAd;

    private String aileSoyad;
    private String aileAdres;
    private String aileMail;
    private String aileSifre;
    private String aileSifreTekrar;
    private String aileTelefon;
    private String aileMedeniDurum;
    private String aileEgitimDurumu;
    private String aileCinsiyet;
    private String aileIl;
    private String hastaAd;
    private String hastaSoyad;
    private String hastaCinsiyet;
    private String hastaEngel;
    private String hastaDogumTarihi;
    private String hastaFotograf;
}
