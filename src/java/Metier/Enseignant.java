
package Metier;


public class Enseignant {
    
    private int id;
    private String login,nom_ens,prenom_ens,adresse_ens,ville_ens,email_ens,phone_ens;

    public Enseignant(int id,String login, String nom_ens, String prenom_ens, String adresse_ens, String ville_ens,String email_ens, String phone_ens) {
        this.id = id;
        this.login = login;
        this.nom_ens = nom_ens;
        this.prenom_ens = prenom_ens;
        this.adresse_ens = adresse_ens;
        this.ville_ens = ville_ens;
        this.email_ens = email_ens;
        this.phone_ens = phone_ens;
    }
    
    public Enseignant(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom_ens() {
        return nom_ens;
    }

    public void setNom_ens(String nom_ens) {
        this.nom_ens = nom_ens;
    }

    public String getPrenom_ens() {
        return prenom_ens;
    }

    public void setPrenom_ens(String prenom_ens) {
        this.prenom_ens = prenom_ens;
    }

    public String getAdresse_ens() {
        return adresse_ens;
    }

    public void setAdresse_ens(String adresse_ens) {
        this.adresse_ens = adresse_ens;
    }

    public String getVille_ens() {
        return ville_ens;
    }

    public void setVille_ens(String ville_ens) {
        this.ville_ens = ville_ens;
    }
    
    public String getEmail_ens() {
        return email_ens;
    }

    public void setEmail_ens(String email_ens) {
        this.email_ens = email_ens;
    }

    public String getPhone_ens() {
        return phone_ens;
    }

    public void setPhone_ens(String phone_ens) {
        this.phone_ens = phone_ens;
    }

    
    
}
