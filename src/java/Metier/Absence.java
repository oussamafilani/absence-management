
package Metier;



public class Absence {
    
    private String intitule_module,CNE,nom_etu,prenom_etu,justifiee,comm_abs,date_seance,heure_debut,heure_fin,type_seance;

    public Absence(String intitule_module,String CNE ,String nom_etu, String prenom_etu, String justifiee, String comm_abs, String date_seance, String heure_debut,String heure_fin ,String type_seance) {
        this.intitule_module = intitule_module;
        this.CNE = CNE;
        this.nom_etu = nom_etu;
        this.prenom_etu = prenom_etu;
        this.justifiee = justifiee;
        this.comm_abs = comm_abs;
        this.date_seance = date_seance;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.type_seance = type_seance;
    }

    public String getIntitule_module() {
        return intitule_module;
    }

    public void setIntitule_module(String intitule_module) {
        this.intitule_module = intitule_module;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public String getNom_etu() {
        return nom_etu;
    }

    public void setNom_etu(String nom_etu) {
        this.nom_etu = nom_etu;
    }

    public String getPrenom_etu() {
        return prenom_etu;
    }

    public void setPrenom_etu(String prenom_etu) {
        this.prenom_etu = prenom_etu;
    }

    public String getJustifiee() {
        return justifiee;
    }

    public void setJustifiee(String justifiee) {
        this.justifiee = justifiee;
    }

    public String getComm_abs() {
        return comm_abs;
    }

    public void setComm_abs(String comm_abs) {
        this.comm_abs = comm_abs;
    }

    public String getDate_seance() {
        return date_seance;
    }

    public void setDate_seance(String date_seance) {
        this.date_seance = date_seance;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getType_seance() {
        return type_seance;
    }

    public void setType_seance(String type_seance) {
        this.type_seance = type_seance;
    }
    
    
    
}
