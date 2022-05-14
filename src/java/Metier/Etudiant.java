
package Metier;


public class Etudiant {
    
    private int id;
    private String cne,nom_etu,prenom_etu,date_naiss_etu,ville_naiss_etu,adresse_etu,ville_etu,email_etu,phone_etu,login;

    public Etudiant(int id,String cne, String nom_etu, String prenom_etu, String date_naiss_etu, String ville_naiss_etu, String adresse_etu, String ville_etu, String email_etu ,String phone_etu) {
        this.id = id;
        this.cne = cne;
        this.nom_etu = nom_etu;
        this.prenom_etu = prenom_etu;
        this.date_naiss_etu = date_naiss_etu;
        this.ville_naiss_etu = ville_naiss_etu;
        this.adresse_etu = adresse_etu;
        this.ville_etu = ville_etu;
        this.email_etu = email_etu;
        this.phone_etu = phone_etu;
    }

    public Etudiant(){} 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
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

    public String getDate_naiss_etu() {
        return date_naiss_etu;
    }

    public void setDate_naiss_etu(String date_naiss_etu) {
        this.date_naiss_etu = date_naiss_etu;
    }

    public String getVille_naiss_etu() {
        return ville_naiss_etu;
    }

    public void setVille_naiss_etu(String ville_naiss_etu) {
        this.ville_naiss_etu = ville_naiss_etu;
    }

    public String getAdresse_etu() {
        return adresse_etu;
    }

    public void setAdresse_etu(String adresse_etu) {
        this.adresse_etu = adresse_etu;
    }

    public String getVille_etu() {
        return ville_etu;
    }

    public void setVille_etu(String ville_etu) {
        this.ville_etu = ville_etu;
    }

    public String getEmail_etu() {
        return email_etu;
    }

    public void setEmail_etu(String email_etu) {
        this.email_etu = email_etu;
    }

    public String getPhone_etu() {
        return phone_etu;
    }

    public void setPhone_etu(String phone_etu) {
        this.phone_etu = phone_etu;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    
}
