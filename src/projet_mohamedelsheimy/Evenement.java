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
public class Evenement {

    private String nom;
    private Date debut;
    private Date fin;

    //constructor
    public Evenement(String nom, Date debut, Date fin) throws ErreurEvenement {
        setNom(nom);
        this.debut = debut;
        setFin(fin);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ErreurEvenement {
        if (nom.equals(null)) {
            throw new ErreurEvenement("Le nom d’un évènement ne doit pas être vide");
        } else {
            this.nom = nom;
        }
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) throws ErreurEvenement {
        boolean verification = true;
        LocalDateTime dateFin = LocalDateTime.of(fin.getAnnee(), fin.getMois(), fin.getJour(), fin.getHeure(), fin.getMinute());
        LocalDateTime dateDebut = LocalDateTime.of(debut.getAnnee(), debut.getMois(), debut.getJour(), debut.getHeure(), debut.getMinute());

        if (dateDebut.isEqual(dateFin)) {
            verification = false;
            throw new ErreurEvenement("Un évènement ne peut pas avoir une durée nulle");
        }
        if (dateDebut.isAfter(dateFin)) {
            verification = false;
            throw new ErreurEvenement("Date de Debut doit etre avant date de Fin");
        }
        if (verification == true) {
            this.fin = fin;
        }

    }//

    @Override
    public String toString() {
        return "Evenement{" + "nom=" + nom + ", debut=" + debut + ", fin=" + fin + '}';
    }

}
