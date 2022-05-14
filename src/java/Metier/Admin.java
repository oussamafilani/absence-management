
package Metier;


public class Admin {
    
    private int id;
    private String login,nom_admin,prenom_admin,email_admin,password;

    public Admin(int id,String login, String nom_admin, String prenom_admin, String email_admin) {
        this.id = id;
        this.login = login;
        this.nom_admin = nom_admin;
        this.prenom_admin = prenom_admin;
        this.email_admin = email_admin;
    }
    public Admin(int id,String login, String nom_admin, String prenom_admin, String email_admin,String password) {
        this.id = id;
        this.login = login;
        this.nom_admin = nom_admin;
        this.prenom_admin = prenom_admin;
        this.email_admin = email_admin;
        this.password = password;
    }

    public Admin() {}

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

    public String getNom_admin() {
        return nom_admin;
    }

    public void setNom_admin(String nom_admin) {
        this.nom_admin = nom_admin;
    }

    public String getPrenom_admin() {
        return prenom_admin;
    }

    public void setPrenom_admin(String prenom_admin) {
        this.prenom_admin = prenom_admin;
    }

    public String getEmail_admin() {
        return email_admin;
    }

    public void setEmail_admin(String email_admin) {
        this.email_admin = email_admin;
    }

    
}
