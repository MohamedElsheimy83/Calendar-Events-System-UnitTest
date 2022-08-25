/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_mohamedelsheimy;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
public class Agenda {

    private ArrayList<Evenement> evenements = new ArrayList<Evenement>();

    //constructor
    public Agenda() {
    }

    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(ArrayList<Evenement> evenements) {
        this.evenements = evenements;
    }

    public boolean ajouter(Evenement e) {
        //verifier si la list est vide
        if (evenements.isEmpty()) {
            evenements.add(e);
            return true;
        } else {
            LocalDateTime dateDebutNew = null;
            LocalDateTime dateFinNew = null;
            LocalDateTime dateDebut = null;
            LocalDateTime dateFin = null;
            Boolean verifier_Nom_Date = true;

            for (int i = 0; i < evenements.size(); i++) {

                dateDebutNew = LocalDateTime.of(e.getDebut().getAnnee(), e.getDebut().getMois(), e.getDebut().getJour(), e.getDebut().getHeure(), e.getDebut().getMinute());
                dateFinNew = LocalDateTime.of(e.getFin().getAnnee(), e.getFin().getMois(), e.getFin().getJour(), e.getFin().getHeure(), e.getFin().getMinute());
                dateDebut = LocalDateTime.of(evenements.get(i).getDebut().getAnnee(), evenements.get(i).getDebut().getMois(), evenements.get(i).getDebut().getJour(), evenements.get(i).getDebut().getHeure(), evenements.get(i).getDebut().getMinute());
                dateFin = LocalDateTime.of(evenements.get(i).getFin().getAnnee(), evenements.get(i).getFin().getMois(), evenements.get(i).getFin().getJour(), evenements.get(i).getFin().getHeure(), evenements.get(i).getFin().getMinute());
                //verifier que le nom ajoutee n'existe pas et il n’est pas de conflit avec aucun des évènements déjà présents dans l’agenda
                if (e.getNom().equals(evenements.get(i).getNom())
                        || dateDebutNew.equals(dateDebut)
                        || (dateDebutNew.isAfter(dateDebut) && dateDebutNew.isBefore(dateFin))
                        || dateDebutNew.equals(dateFin)
                        || dateFinNew.equals(dateDebut)
                        || (dateFinNew.isAfter(dateDebut) && dateFinNew.isBefore(dateFin))
                        || dateFinNew.equals(dateFin)) {
                    verifier_Nom_Date = false;
                    return false;
                }//              

            }//for

            if (verifier_Nom_Date == true) {
                evenements.add(e);
                return true;
            }//if

        }//else
        return false;
    }//ajouter

    public boolean supprimer(String nom) {
        for (int i = 0; i < evenements.size(); i++) {
            if (nom.equals(evenements.get(i).getNom())) {
                evenements.remove(i);
                return true;
            }//if       
        }//for

        return false;
    }

    public String chercherEvenement(Date d) {
        LocalDateTime dateCherche = LocalDateTime.of(d.getAnnee(), d.getMois(), d.getJour(), d.getHeure(), d.getMinute());
        LocalDateTime dateDebut = null;
        LocalDateTime dateFin = null;
        for (int i = 0; i < evenements.size(); i++) {
            dateDebut = LocalDateTime.of(evenements.get(i).getDebut().getAnnee(), evenements.get(i).getDebut().getMois(), evenements.get(i).getDebut().getJour(), evenements.get(i).getDebut().getHeure(), evenements.get(i).getDebut().getMinute());
            dateFin = LocalDateTime.of(evenements.get(i).getFin().getAnnee(), evenements.get(i).getFin().getMois(), evenements.get(i).getFin().getJour(), evenements.get(i).getFin().getHeure(), evenements.get(i).getFin().getMinute());

            if (dateCherche.equals(dateDebut)
                    || (dateCherche.isAfter(dateDebut) && dateCherche.isBefore(dateFin))
                    || dateCherche.equals(dateFin)) {
                return evenements.get(i).getNom();
            }//         
        }//for
        return "vide";
    }

    public Date dateDebut(String nom) throws ErreurAgenda {
        boolean dateExiste = false;
        for (int i = 0; i < evenements.size(); i++) {
            if (nom.equals(evenements.get(i).getNom())) {
                dateExiste = true;
                return evenements.get(i).getDebut();
            }
        }//for

        if (dateExiste == false) {
            throw new ErreurAgenda("L'évènement recherchée n'existe pas dans l'agenda");
        }
        return null;
    }

    public Date dateFin(String nom) throws ErreurAgenda {
        boolean dateExiste = false;
        for (int i = 0; i < evenements.size(); i++) {
            if (nom.equals(evenements.get(i).getNom())) {
                dateExiste = true;
                return evenements.get(i).getFin();
            }
        }//for

        if (dateExiste == false) {
            throw new ErreurAgenda("L'évènement recherchée n'existe pas dans l'agenda");
        }
        return null;
    }

    public boolean prevu(String nom) {
        for (int i = 0; i < evenements.size(); i++) {
            if (nom.equals(evenements.get(i).getNom())) {
                return true;
            }//if       
        }//for
        return false;
    }

    @Override
    public String toString() {
        return "Agenda{" + "evenements=" + evenements + '}';
    }
}
