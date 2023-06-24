package pl.umk.mat.jakuburb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Ulamek {
    private int liczbaCalkowita;
    private int licznik;
    private int mianownik;


//    public Ulamek(int liczbaCalkowita){
//        this.liczbaCalkowita = liczbaCalkowita;
//    }
//
//    public Ulamek(int liczbaCalkowita, int licznik, int mianownik) {
//        this.licznik = licznik;
//        this.liczbaCalkowita = liczbaCalkowita;
//        this.mianownik = mianownik;
//    }

    public Ulamek(int licznik, int mianownik){

        int licznikNew = licznik;
        int mianownikNew = mianownik;

        for(Integer i: porownajTablice(pierwiastkiAll(licznik), pierwiastkiAll(mianownik))){
            licznikNew /= i;
            mianownikNew /= i;
        }

        this.licznik = licznikNew;
        this.mianownik = mianownikNew;
    }

//    public static Ulamek zrobPieknyUlamek(Ulamek ulamek){
//        int licznik = ulamek.getLicznik();
//        int mianownik = ulamek.getMianownik();
//
//
//        int liczbaCalkowitaNew = (int)Math.floor(licznik/mianownik);
//        int licznikNew = licznik%mianownik;
//        int mianownikNew = mianownik;
//
//        ulamek.setLicznik(licznikNew);
//        ulamek.setMianownik(mianownikNew);
//        ulamek.setLiczbaCalkowita(liczbaCalkowitaNew);
//
//
//        return ulamek;
//    }

//    public static Ulamek convertToUlamek(double liczba){
//        Ulamek ulamek = new Ulamek();
//
//        ulamek.setLiczbaCalkowita((int)Math.floor(liczba));
//
//        double value = liczba - Math.floor(liczba);
//
//        value = Double.
//
//        System.out.println();
//        System.out.println((liczba - Math.floor(liczba)));
//        System.out.println(Math.floor(liczba));
//
//        return ulamek;
//    }


    public ArrayList<Integer> porownajTablice(ArrayList<Integer> a, ArrayList<Integer> b){
       HashSet<Integer> aSet = new HashSet<>(a);
       HashSet<Integer> bSet = new HashSet<>(b);

       aSet.retainAll(bSet);

       ArrayList<Integer> aaa = new ArrayList<>(aSet);

       return aaa;
    }

    public ArrayList<Integer> pierwiastkiAll(int value){
        ArrayList<Integer> array = new ArrayList<>();

        while(true){
            int v = pierwiastek(value);


            value /= v;

            if(v==-1)break;
            array.add(v);
        }

        return array;
    }

    private int pierwiastek(int value){

        for(int i=2;i<=value;i++) {
            if(value%i==0) return i;
        }

        return -1;
    }


    public static Ulamek dodaj(Ulamek a, Ulamek b){
        int newLicznik = a.getLicznik() * b.getMianownik() + a.getMianownik() * b.getLicznik();
        int newMianownik = a.getMianownik() * b.getMianownik();

        return new Ulamek(newLicznik, newMianownik);
    }

    public static Ulamek odejmij(Ulamek a, Ulamek b){
        int newLicznik = a.getLicznik() * b.getMianownik() - a.getMianownik() * b.getLicznik();
        int newMianownik = a.getMianownik() * b.getMianownik();

        return new Ulamek(newLicznik, newMianownik);
    }

    public static Ulamek pomnurz(Ulamek a, Ulamek b){
        int newLicznik = a.getLicznik() * b.getLicznik();
        int newMianownik = a.getMianownik() * b.getMianownik();

        return new Ulamek(newLicznik, newMianownik);
    }

    public static Ulamek podziel(Ulamek a, Ulamek b){
        int newLicznik = a.getLicznik() * b.getMianownik();
        int newMianownik = a.getMianownik() * b.getLicznik();

        return new Ulamek(newLicznik, newMianownik);
    }

    public int getLicznik() {
        return licznik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public void setMianownik(int mianownik) {
        this.mianownik = mianownik;
    }

    public int getLiczbaCalkowita() {
        return liczbaCalkowita;
    }

    public void setLiczbaCalkowita(int liczbaCalkowita) {
        this.liczbaCalkowita = liczbaCalkowita;
    }
}
