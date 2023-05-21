package tas_kagit_makas;

import static tas_kagit_makas.Oyun.ustamakas2;

public class UstaMakas extends Makas {

    public static double direnc = 2;

    public UstaMakas() {
        super(2);
        this.direnc = 2;

    }

    public UstaMakas(double direnc) {
        super(2);
        this.direnc = direnc;
    }

    @Override
    public void nesnePuaniGoster(int index, Oyuncu oyuncu) {

    }
    double j;

    @Override
    public double etkiHesapla(int index, Oyuncu oyuncu) {

        if (Oyun.bilgisayar1.nesneListesi.get(index).getClass().getSimpleName().equals("Tas")) {
            j = (keskinlik*direnc) / ((1 - a) * (Tas.katilik));
            return j;
        } else if (Oyun.bilgisayar1.nesneListesi.get(index).getClass().getSimpleName().equals("Kagit")) {
            j = (keskinlik*direnc) / (a * (Kagit.nufuz));
            return j;
        } else if (Oyun.bilgisayar1.nesneListesi.get(index).getClass().getSimpleName().equals("Makas")) {
            return 2;
        } else if (Oyun.bilgisayar1.nesneListesi.get(index).getClass().getSimpleName().equals("AgirTas")) {
            j = (keskinlik*direnc) / ((1 - a) * (AgirTas.katilik) * (AgirTas.sicaklik));
            return j;
        } else if (Oyun.bilgisayar1.nesneListesi.get(index).getClass().getSimpleName().equals("OzelKagit")) {
            j = (keskinlik*direnc) / (a * (OzelKagit.nufuz) * (OzelKagit.kalinlik));
            return j;
        } else if (Oyun.bilgisayar1.nesneListesi.get(index).getClass().getSimpleName().equals("UstaMakas")) {
            return 0;
        }

        return 0;
    }

    @Override
    public void durumGuncelle(Oyuncu bilgisayar1, int bilgisayarsecimiindexi, Oyuncu kullanici1, int oyuncusecimiindexi) {
        bilgisayar1.nesneListesi.get(bilgisayarsecimiindexi).setDayaniklilik(bilgisayar1.nesneListesi.get(bilgisayarsecimiindexi).getDayaniklilik() - ustamakas2.etkiHesapla(bilgisayarsecimiindexi, bilgisayar1));
        kullanici1.nesneListesi.get(oyuncusecimiindexi).setDayaniklilik(kullanici1.nesneListesi.get(oyuncusecimiindexi).getDayaniklilik() - ustamakas2.etkiHesapla(oyuncusecimiindexi, kullanici1));

        if (ustamakas2.etkiHesapla(bilgisayarsecimiindexi, bilgisayar1) > ustamakas2.etkiHesapla(oyuncusecimiindexi, kullanici1)) {
            kullanici1.nesneListesi.get(oyuncusecimiindexi).seviyePuani += 20;

        } else if (ustamakas2.etkiHesapla(bilgisayarsecimiindexi, bilgisayar1) < ustamakas2.etkiHesapla(oyuncusecimiindexi, kullanici1)) {
            bilgisayar1.nesneListesi.get(bilgisayarsecimiindexi).seviyePuani += 20;

        }
    }

    public double getDirenc() {
        return direnc;
    }

    public void setDirenc(double direnc) {
        this.direnc = direnc;
    }

}
