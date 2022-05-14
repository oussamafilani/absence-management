
package Metier;

public class Seance {
    
    private String intitule_module,date,heur_debut,heur_fin,type_seance;
    private int id;

    public Seance(String intitule_module, String date, String heur_debut, String heur_fin, String type_seance, int id) {
        this.intitule_module = intitule_module;
        this.date = date;
        this.heur_debut = heur_debut;
        this.heur_fin = heur_fin;
        this.type_seance = type_seance;
        this.id = id;
    }
    
    public Seance(){}

    public String getIntitule_module() {
        return intitule_module;
    }

    public void setIntitule_module(String intitule_module) {
        this.intitule_module = intitule_module;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeur_debut() {
        return heur_debut;
    }

    public void setHeur_debut(String heur_debut) {
        this.heur_debut = heur_debut;
    }

    public String getHeur_fin() {
        return heur_fin;
    }

    public void setHeur_fin(String heur_fin) {
        this.heur_fin = heur_fin;
    }

    public String getType_seance() {
        return type_seance;
    }

    public void setType_seance(String type_seance) {
        this.type_seance = type_seance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
