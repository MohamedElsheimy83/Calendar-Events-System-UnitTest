/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_mohamedelsheimy;

import java.time.LocalDateTime;

/**
 *
 * @author Mohamed
 */
public class Date {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;

    //constructor
    public Date(int jour, int mois, int annee, int heure, int minute) throws ErreurDate {
        //Une date doit être postérieure au 1er janvier 2022, 0h00
        LocalDateTime dateA = LocalDateTime.of(annee, mois, jour, heure, minute);
        LocalDateTime dateB = LocalDateTime.of(2022, 01, 01, 00, 00);
        if (dateA.isAfter(dateB)) {
            this.jour = jour;
            this.mois = mois;
            this.annee = annee;
            this.heure = heure;
            this.minute = minute;
        }//
        //La création d’une date erronée lève l’exception ErreurDate.
        else {
            throw new ErreurDate("Une date doit être postérieure au 1er janvier 2022, 0h00");
        }//

    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Date{" + "jour=" + jour + ", mois=" + mois + ", annee=" + annee + ", heure=" + heure + ", minute=" + minute + '}';
    }
}
