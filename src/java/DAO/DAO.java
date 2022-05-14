package DAO;

import java.sql.*;
import java.util.*;
import Metier.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DAO {
    

    private Connection con=null;
    private ArrayList<Admin> list_admins ;
    private ArrayList<Enseignant> list_enseignant;
    private ArrayList<Etudiant> list_etudiant;
    private ArrayList<Module> list_module;
    private ArrayList<Seance> list_seance;
    public DAO(){
        list_admins = new ArrayList<Admin>();
        list_enseignant = new ArrayList<Enseignant>(); 
        list_etudiant = new ArrayList<Etudiant>();
        list_module = new ArrayList<Module>();
        list_seance = new ArrayList<Seance>();
    }
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/g_absences","root","");
            System.out.println("Connection Successful");
        }catch(Exception e){
            System.out.println("Oops something wrong connection: "+e.getMessage());
        }
        return con;
    }
    
    public boolean authentification(String user,String password){
        try{
            String query = "SELECT * FROM user WHERE login=? AND password=? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, user);
            smt.setString(2, password);
            ResultSet rst = smt.executeQuery();
            if(rst.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong auth: "+e.getMessage());
        }
        return false;
    }
    
    public boolean creatUser(String pseudo,String password,String type){
        try{
            String query = "INSERT INTO user(login,password,type_user) VALUES (?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,pseudo);
            smt.setString(2,password);
            smt.setString(3,type);
            int id = smt.executeUpdate();
            if(id!=0){
               System.out.println("good insertion user"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong createuser: "+e.getMessage());
        }
        return false;
    }
    
    public boolean creatEtudiant(Etudiant e){
        try{
            String query = "INSERT INTO etudiant(id_user,CNE,nom_etu,prenom_etu,date_naiss_etu,ville_naiss_etu,adresse_etu,ville_etu,email_etu,phone_etu) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,e.getId());
            smt.setString(2, e.getCne());
            smt.setString(3, e.getNom_etu());
            smt.setString(4, e.getPrenom_etu());
            smt.setString(5, e.getDate_naiss_etu());
            smt.setString(6, e.getVille_naiss_etu());
            smt.setString(7, e.getAdresse_etu());
            smt.setString(8, e.getVille_etu());
            smt.setString(9, e.getEmail_etu());
            smt.setString(10, e.getPhone_etu());
            int id = smt.executeUpdate();
            if(id!=0){
               System.out.println("good insertion etudiant"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong create etud: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean creatAdmin(Admin a){
        try{
            String query = "INSERT INTO admin(id_user,nom_admin,prenom_admin,email_admin) VALUES(?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, a.getId());
            smt.setString(2, a.getNom_admin());
            smt.setString(3, a.getPrenom_admin());
            smt.setString(4, a.getEmail_admin());
            int id = smt.executeUpdate();
            if(id!=0){
               System.out.println("good insertion admin"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong create admin: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean createEnseignant(Enseignant e){
        try{
            String query = "INSERT INTO enseignant(id_user,nom_ens,prenom_ens,adresse_ens,ville_ens,email_ens,phone_ens) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, e.getId());
            smt.setString(2, e.getNom_ens());
            smt.setString(3, e.getPrenom_ens());
            smt.setString(4, e.getAdresse_ens());
            smt.setString(5, e.getVille_ens());
            smt.setString(6, e.getEmail_ens());
            smt.setString(7, e.getPhone_ens());
            int id = smt.executeUpdate();
            if(id!=0){
               System.out.println("good insertion enseignant"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong create enseignant: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean creatModule(Module m){
        try{
            String query = "INSERT INTO module(intitule_module) VALUES (?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, m.getIntitule_module());
            int id = smt.executeUpdate();
            if(id!=0){
               System.out.println("good insertion module"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong create module: "+ex.getMessage());
        }
        return false;
    }
    
    public int getModulID(String intitule){
        int id=0;
        try{
            String query = "SELECT id_module FROM module WHERE intitule_module=? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,intitule);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                id = rs.getInt("id_module");
                System.out.println("getModulid ");
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getModulid: "+e.getMessage());
        }
        return id;
    }
    
    /*public Enseignant getEnseignantByID(int id){
        Enseignant ens = new Enseignant();
        try{
            String query = "SELECT id_user, nom_ens, prenom_ens, adresse_ens, ville_ens, email_ens, phone_ens FROM enseignant WHERE id_user = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                ens.setId(id);
                ens.setNom_ens(rs.getString("nom_ens"));
                ens.setPrenom_ens(rs.getString("prenom_ens"));
                ens.setAdresse_ens(rs.getString("adresse_ens"));
                ens.setVille_ens(rs.getString("ville_ens"));
                ens.setEmail_ens(rs.getString("email_ens"));
                ens.setPhone_ens(rs.getString("phone_ens"));
                return ens;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getEnseignantByID: "+e.getMessage());
        }
        return ens;
    }*/
    
    public ArrayList<Admin> getAdmins(){
        try{
            String query="SELECT Admin.id_user,User.login, nom_admin, prenom_admin, email_admin  FROM Admin,User WHERE User.id_user=Admin.id_user";
            Statement smt = con.createStatement();
            ResultSet result = smt.executeQuery(query);
            while(result.next()){
                Admin admin = new Admin(result.getInt("id_user"),result.getString("login"),result.getString("nom_admin"),result.getString("prenom_admin"),
                        result.getString("email_admin"));
                list_admins .add(admin);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getADmins: "+e.getMessage());
        }
        return list_admins ;
    }
    
    public ArrayList<Enseignant> getEnseignant(){
        try{
            String query="SELECT Enseignant.id_user,User.login, nom_ens,prenom_ens,adresse_ens,ville_ens,email_ens,phone_ens FROM Enseignant, User WHERE User.id_user=Enseignant.id_user";
            Statement smt = con.createStatement();
            ResultSet result = smt.executeQuery(query);
            while(result.next()){
                Enseignant ens = new Enseignant(result.getInt("id_user"),result.getString("login"),result.getString("nom_ens"),
                        result.getString("prenom_ens"),result.getString("adresse_ens"),result.getString("ville_ens")
                        ,result.getString("email_ens"),result.getString("phone_ens"));
                list_enseignant.add(ens);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong create ensei: "+e.getMessage());
        }
        return list_enseignant ;
    }
    
    public ArrayList<Etudiant> getEtudiant(){
        int i=0;
        try{
            String query="SELECT Etudiant.id_user,User.login, cne,nom_etu,prenom_etu,date_naiss_etu,ville_naiss_etu,adresse_etu,ville_etu,email_etu,phone_etu FROM Etudiant, User WHERE User.id_user=Etudiant.id_user";
            Statement smt = con.createStatement();
            ResultSet result = smt.executeQuery(query);
            while(result.next()){
                Etudiant etd = new Etudiant(result.getInt("id_user"),result.getString("cne"),result.getString("nom_etu"),result.getString("prenom_etu"),result.getString("date_naiss_etu"), 
                        result.getString("ville_naiss_etu"),result.getString("adresse_etu"),result.getString("ville_etu"),
                        result.getString("email_etu"),result.getString("phone_etu"));
                list_etudiant.add(etd);
                i++;
            }
            System.out.println("row count "+i);
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println("Oops something wrong getEtu: "+e.getMessage());
        }
        return list_etudiant ;
    }
    
    public ArrayList<Module> getModule(){
        try{
            String query = "SELECT id_module,intitule_module FROM module";
            Statement smt = con.createStatement();
            ResultSet result = smt.executeQuery(query);
            while(result.next()){
                Module m = new Module(result.getString("id_module"),result.getString("intitule_module"));
                list_module.add(m);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getMO: "+e.getMessage());
        }
        return list_module;
    }
    
    public boolean updateModule(int id,String intitule){
        try{
            String query = "UPDATE module SET intitule_module=? WHERE id_module=? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, intitule);
            smt.setInt(2, id);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good update module"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong updateModule: "+e.getMessage());
        }
        return false;
    }
    
    public boolean deletteModule(int id){
        try{
            String query = "DELETE FROM module WHERE id_module=? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good delete module"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong deletteModule: "+e.getMessage());
        }
        return false;
    }
    
    public boolean deletAffectModul(int idM){
        try{
            String query = "DELETE FROM affecter WHERE id_module=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idM);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good deletAffectModul"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong deletAffectModul: "+e.getMessage());
        }
        return false;
    }
    
    public boolean deletAffectEnsei(int idE){
        try{
            String query = "DELETE FROM affecter WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idE);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good deletAffectEnsei"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong deletAffectEnsei: "+e.getMessage());
        }
        return false;
    }
    
    public boolean affectCour(int idE,int idM){
        try{
            String query = "INSERT INTO affecter(id_user,id_module) VALUES (?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idE);
            smt.setInt(2, idM);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good affectCour"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong affectCour: "+e.getMessage());
        }
        return false;
    }
    
    public boolean updatUser(String login,String pass,int id){
        try{
            String query = "UPDATE user SET login=?,password=? WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, login);
            smt.setString(2, pass);
            smt.setInt(3, id);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good updatUser"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong updatUser: "+e.getMessage());
        }
        return false;
    }
    
    public boolean updatAdmin(Admin a){
        try{
            String query = "UPDATE admin SET nom_admin=?,prenom_admin=?,email_admin=? WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, a.getNom_admin());
            smt.setString(2, a.getPrenom_admin());
            smt.setString(3, a.getEmail_admin());
            smt.setInt(4, a.getId());
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good updatAdmin"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong updatAdmin: "+e.getMessage());
        }
        return false;
    }
    
    public boolean deletAdmin(int id){
        try{
            String query = "DELETE FROM admin WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good deletAdmin"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong deletAdmin: "+e.getMessage());
        }
        return false;
    }
    
    public boolean updatUserType(int id,String type){
        try{
            String query = "UPDATE user SET type_user=? WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, type);
            smt.setInt(2, id);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good updatUserType"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong updatUserType: "+e.getMessage());
        }
        return false;
    }
    
    public Admin getAdminsById(int id){
        Admin admin = new Admin();
        try{
            String query="SELECT login,nom_admin,prenom_admin,email_admin  FROM Admin,user WHERE Admin.id_user=? AND user.id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            smt.setInt(2, id);
            ResultSet result = smt.executeQuery();
            while(result.next()){
                admin.setId(id);
                admin.setLogin(result.getString("login"));
                admin.setNom_admin(result.getString("nom_admin"));
                admin.setPrenom_admin(result.getString("prenom_admin"));
                admin.setEmail_admin(result.getString("email_admin"));
                System.out.println("good getAdminsById");
                return admin;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getAdminsById: "+e.getMessage());
        }
        return admin ;
    }
    
    public boolean adminToEnseignant(Admin a){
        try{
            String query = "INSERT INTO enseignant(id_user,nom_ens,prenom_ens,adresse_ens,ville_ens,email_ens,phone_ens) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, a.getId());
            smt.setString(2, a.getNom_admin());
            smt.setString(3, a.getPrenom_admin());
            smt.setString(4, "");
            smt.setString(5, "");
            smt.setString(6, a.getEmail_admin());
            smt.setString(7, "");
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good adminToEnseignant"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong adminToEnseignant: "+e.getMessage());
        }
        return false;
    }
    
    public boolean adminToEtudiant(Admin a){
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
            Date date = new Date();
            String query = "INSERT INTO etudiant(id_user,CNE,nom_etu,prenom_etu,date_naiss_etu,ville_naiss_etu,adresse_etu,ville_etu,email_etu,phone_etu) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, a.getId());
            smt.setString(2, "0");
            smt.setString(3, a.getNom_admin());
            smt.setString(4, a.getPrenom_admin());
            smt.setString(5, dateFormat.format(date));
            smt.setString(6, "");
            smt.setString(7, "");
            smt.setString(8, "");
            smt.setString(9, a.getEmail_admin());
            smt.setString(10,"" );
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good adminToEtudiant"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong adminToEtudiant: "+e.getMessage());
        }
        return false;
    }
    
    public Enseignant getEnseignantsById(int id){
        Enseignant enseignant=new Enseignant();
        try{
            String query="SELECT login,nom_ens,prenom_ens,adresse_ens,ville_ens,email_ens,phone_ens FROM enseignant e,user WHERE e.id_user=? AND user.id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            smt.setInt(2, id);
            ResultSet result = smt.executeQuery();
            while(result.next()){
                enseignant.setId(id);
                enseignant.setLogin(result.getString("login"));
                enseignant.setNom_ens(result.getString("nom_ens"));
                enseignant.setPrenom_ens(result.getString("prenom_ens"));
                enseignant.setAdresse_ens(result.getString("adresse_ens"));
                enseignant.setVille_ens(result.getString("ville_ens"));
                enseignant.setEmail_ens(result.getString("email_ens"));
                enseignant.setPhone_ens(result.getString("phone_ens"));
                System.out.println("good getEnseignantsById");
                return enseignant;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getEnseignantsById: "+e.getMessage());
        }
        return enseignant ;
    }
    
    public boolean enseignantToAdmin(Enseignant e){
        try{
            String query = "INSERT INTO admin(id_user,nom_admin,prenom_admin,email_admin) VALUES (?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, e.getId());
            smt.setString(2, e.getNom_ens());
            smt.setString(3, e.getPrenom_ens());
            smt.setString(4, e.getEmail_ens());
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good enseignantToAdmin"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong enseignantToAdmin: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean enseignantToEtudiant(Enseignant e){
        try{
            String query = "INSERT INTO etudiant(id_user,CNE,nom_etu,prenom_etu,date_naiss_etu,ville_naiss_etu,adresse_etu,ville_etu,email_etu,phone_etu) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, e.getId());
            smt.setString(2, "0");
            smt.setString(3, e.getNom_ens());
            smt.setString(4, e.getPrenom_ens());
            smt.setString(5, null);
            smt.setString(6, e.getVille_ens());
            smt.setString(7, e.getAdresse_ens());
            smt.setString(8, e.getVille_ens());
            smt.setString(9, e.getEmail_ens());
            smt.setString(10, e.getPhone_ens());
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good enseignantToEtudiant"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong enseignantToEtudiant: "+ex.getMessage());
        }
        return false;
    }
    
    public Etudiant getEtudiantsById(int id){
        Etudiant etudiant=new Etudiant();
        try{
            String query="SELECT login,CNE,nom_etu,prenom_etu,date_naiss_etu,ville_naiss_etu,adresse_etu,ville_etu,email_etu,phone_etu FROM etudiant,user WHERE etudiant.id_user=? AND user.id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            smt.setInt(2, id);
            ResultSet result = smt.executeQuery();
            while(result.next()){
                etudiant.setId(id);
                etudiant.setLogin(result.getString("login"));
                etudiant.setCne(result.getString("CNE"));
                etudiant.setNom_etu(result.getString("nom_etu"));
                System.out.println("le nom "+etudiant.getNom_etu());
                etudiant.setPrenom_etu(result.getString("prenom_etu"));
                etudiant.setDate_naiss_etu(result.getString("date_naiss_etu"));
                etudiant.setVille_naiss_etu(result.getString("ville_naiss_etu"));
                etudiant.setAdresse_etu(result.getString("adresse_etu"));
                etudiant.setVille_etu(result.getString("ville_etu"));
                etudiant.setEmail_etu(result.getString("email_etu"));
                etudiant.setPhone_etu(result.getString("phone_etu"));
                System.out.println("good getEtudiantsById");
                return etudiant;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getEtudiantsById: "+e.getMessage());
        }
        return etudiant ;
    }
    
    public boolean etudiantToAdmin(Etudiant e){
        try{
            String query = "INSERT INTO admin(id_user,nom_admin,prenom_admin,email_admin) VALUES (?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, e.getId());
            smt.setString(2, e.getNom_etu());
            smt.setString(3, e.getPrenom_etu());
            smt.setString(4, e.getEmail_etu());
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good etudiantToAdmin"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong etudiantToAdmin: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean etudiantToEnseignant(Etudiant e){
        try{
            String query = "INSERT INTO enseignant(id_user,nom_ens,prenom_ens,adresse_ens,ville_ens,email_ens,phone_ens) VALUES (?,?,?,?,?,?,?) ";
            PreparedStatement smt = con.prepareStatement(query);
            System.out.println("good 1");
            smt.setInt(1, e.getId());
            smt.setString(2, e.getNom_etu());
            smt.setString(3, e.getPrenom_etu());
            smt.setString(4, e.getAdresse_etu());
            smt.setString(5, e.getVille_etu());
            smt.setString(6, e.getEmail_etu());
            smt.setString(7, e.getPhone_etu());
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good etudiantToEnseignant"); 
               return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong etudiantToEnseignant: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean deletEtudiant(int id){
        try{
            String query = "DELETE FROM etudiant WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            smt.executeUpdate();
            System.out.println("good deletEtudiant");
            return true;
        }catch(Exception ex){
            System.out.println("Oops something wrong deletEtudiant: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean deletEnseignat(int id){
        try{
            String query = "DELETE FROM enseignant WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            smt.executeUpdate();
            System.out.println("good deletEnseignat");
            return true;
        }catch(Exception ex){
            System.out.println("Oops something wrong deletEnseignat: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean updatEnseignant(Enseignant e){
        try{
            String query = "UPDATE enseignant SET nom_ens=?,prenom_ens=?,adresse_ens=?,ville_ens=?,email_ens = ?, phone_ens = ?  WHERE id_user=? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,e.getNom_ens() );
            smt.setString(2,e.getPrenom_ens() );
            smt.setString(3,e.getAdresse_ens() );
            smt.setString(4,e.getVille_ens() );
            smt.setString(5,e.getEmail_ens() );
            smt.setString(6,e.getPhone_ens() );
            smt.setInt(7,e.getId() );
            int i=smt.executeUpdate();
            if(i!=0){
                System.out.println("good updatEnseignant");
                return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong updatEnseignant: "+ex.getMessage());
        }
        return false;
    }
    
    public boolean updatEtudiant(Etudiant e){
        try{
            String query = "UPDATE etudiant SET CNE=?,nom_etu=?,prenom_etu=?,date_naiss_etu=?,ville_naiss_etu=?,adresse_etu=?,ville_etu=?,email_etu=?,phone_etu=? WHERE  id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,e.getCne());
            smt.setString(2,e.getNom_etu());
            smt.setString(3,e.getPrenom_etu());
            smt.setString(4,e.getDate_naiss_etu());
            smt.setString(5,e.getVille_naiss_etu());
            smt.setString(6,e.getAdresse_etu());
            smt.setString(7,e.getVille_etu());
            smt.setString(8,e.getEmail_etu());
            smt.setString(9,e.getPhone_etu());
            smt.setInt(10,e.getId());
            int i=smt.executeUpdate();
            if(i!=0){
                System.out.println("good updatEtudiant");
                return true;
            }
        }catch(Exception ex){
            System.out.println("Oops something wrong updatEtudiant: "+ex.getMessage());
        }
        return false;
    }
    

    
    public boolean deletEtudierEtudiant(int idEt){
        try{
            String query = "DELETE FROM etudier WHERE id_user=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idEt);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good deletAffectEtudiant"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong deletAffectEtudiant: "+e.getMessage());
        }
        return false;
    }
    
    public boolean deletEtudierModul(int idM){
        try{
            String query = "DELETE FROM etudier WHERE id_module=?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idM);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good deletEtudierModul"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong deletEtudierModul: "+e.getMessage());
        }
        return false;
    }
    public boolean etudierModul(int idEt,int idM){
        try{
            String query = "INSERT INTO etudier(id_user,id_module) VALUES (?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idEt);
            smt.setInt(2, idM);
            int i = smt.executeUpdate();
            if(i!=0){
               System.out.println("good etudierModul"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong etudierModul: "+e.getMessage());
        }
        return false;
    }
    
    public String getUserType(String login,String pass){
        String type ="";
        try{
            String query="SELECT type_user FROM user WHERE login = ? AND password = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,login);
            smt.setString(2,pass);
            ResultSet result = smt.executeQuery();
            if(result.next()){
                type = result.getString("type_user");
                System.out.println("good getUserType: "+type); 
                return type;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getUserType: "+e.getMessage());
        }
        return type;
    }
    
    public int getUserId(String login){
        int id=0;
        try{
            String query = "SELECT id_user FROM user WHERE login=? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,login);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                id = rs.getInt("id_user");
                System.out.println("good getId ");
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getId: "+e.getMessage());
        }
        return id;
    }
    
    public ArrayList<Module> getVosModule(int id){
        try{
            String query = "SELECT * FROM Module, Affecter, Enseignant WHERE Module.id_module=Affecter.id_module AND Enseignant.id_user=? AND Affecter.id_user=? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,id);
            smt.setInt(2,id);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Module mdule = new Module(rs.getString("id_module"),rs.getString("intitule_module"));
                list_module.add(mdule);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getVosModule: "+e.getMessage());
        }
        return list_module;
    }
    
    public ArrayList<Seance> getVosSeance(int id){
        try{
            String query = "SELECT DISTINCT * FROM Seance, Module, Enseignant WHERE Seance.id_module = Module.id_module AND Seance.id_user= ? AND Enseignant.id_user= ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,id);
            smt.setInt(2,id);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Seance seance = new Seance(rs.getString("intitule_module"),rs.getString("date_seance"),rs.getString("heure_debut"),rs.getString("heure_fin"),
                rs.getString("type_seance"),rs.getInt("id_seance"));
                list_seance.add(seance);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getVosSeance: "+e.getMessage());
        }
        return list_seance;
    }
    
    public boolean creatSeance(Seance s,int idM,int idU){
        try{
            String query = "INSERT INTO seance(id_module,id_user,date_seance,heure_debut,heure_fin,type_seance) VALUES (?,?,?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,idM);
            smt.setInt(2, idU);
            smt.setString(3,s.getDate());
            smt.setString(4,s.getHeur_debut());
            smt.setString(5,s.getHeur_fin());
            smt.setString(6,s.getType_seance());
            int i = smt.executeUpdate();
            if(i!=0){
                System.out.println("good creatSeance");
                return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong creatSeance: "+e.getMessage());
        }
        return false;
    }
    
    public ArrayList<Absence> getAbs(int id){
        ArrayList<Absence> table = new ArrayList<Absence>();
        try{
            String query = "SELECT DISTINCT module.intitule_module,etudiant.CNE, etudiant.nom_etu , "
                    + "etudiant.prenom_etu,absence.justifiee, absence.comm_abs,seance.date_seance,"
                    + " seance.heure_debut, seance.heure_fin, seance.type_seance "
                    + "FROM enseignant, affecter, module, etudier, etudiant, seance, absence "
                    + "WHERE affecter.id_user = enseignant.id_user AND affecter.id_module = module.id_module AND etudier.id_user = etudiant.id_user "
                    + "AND seance.id_module = module.id_module AND seance.id_seance = absence.id_seance"
                    + " AND absence.id_user = etudiant.id_user AND enseignant.id_user = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1,id);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Absence ab = new Absence(rs.getString("intitule_module"),rs.getString("CNE"),rs.getString("nom_etu"),rs.getString("prenom_etu"),
                rs.getString("justifiee"),rs.getString("comm_abs"),rs.getString("date_seance"),rs.getString("heure_debut"),rs.getString("heure_fin"),
                rs.getString("type_seance"));
                table.add(ab);
                System.out.println("Oops something good getAbs: ");
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getAbs: "+e.getMessage());
        }
        return table;
    }
    
    public ArrayList<Etudiant> getCneEtudiant(int id){
        try{
            String query = "SELECT DISTINCT etudiant.CNE FROM enseignant, affecter , module, etudier, etudiant, seance, absence"
                    + " WHERE affecter.id_user = enseignant.id_user "
                    + "AND affecter.id_module = module.id_module "
                    + "AND etudier.id_user = etudiant.id_user "
                    + "AND seance.id_module = module.id_module "
                    + "AND seance.id_seance = absence.id_seance "
                    + "AND absence.id_user = etudiant.id_user "
                    + "AND enseignant.id_user =? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Etudiant etudiant = new Etudiant(0,rs.getString("cne"),null,null,null,null,null,null,null,null);
                list_etudiant.add(etudiant);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getCneEtudiant: "+e.getMessage());
        }
        return list_etudiant;
    }
    
    public ArrayList<Absence> getAbsEt(int id,String cne){
        ArrayList<Absence> table = new ArrayList<Absence>();
        try{
            String query = "SELECT DISTINCT module.intitule_module, etudiant.CNE, etudiant.nom_etu , etudiant.prenom_etu, " +
                            " absence.justifiee, absence.comm_abs, " +
                            " seance.date_seance, seance.heure_debut, seance.heure_fin, seance.type_seance " +
                            " FROM enseignant, affecter, module, etudier, etudiant, seance, absence " +
                            " WHERE affecter.id_user = enseignant.id_user " +
                            " AND affecter.id_module = module.id_module " +
                            " AND etudier.id_user = etudiant.id_user " +
                            " AND seance.id_module = module.id_module " +
                            " AND seance.id_seance = absence.id_seance " +
                            " AND absence.id_user = etudiant.id_user " +
                            " AND enseignant.id_user = ? " +
                            " AND etudiant.cne = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            smt.setString(2, cne);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Absence ab = new Absence(rs.getString("intitule_module"),rs.getString("CNE"),rs.getString("nom_etu"),rs.getString("prenom_etu"),
                rs.getString("justifiee"),rs.getString("comm_abs"),rs.getString("date_seance"),rs.getString("heure_debut"),rs.getString("heure_fin"),
                rs.getString("type_seance"));
                table.add(ab);
                System.out.println("good getAbsEt");
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getAbsEt: "+e.getMessage());
        }
        return table;
    }
    
    public ArrayList<Seance> getAbsSeance(int idU,String date,String heur_deb,String heur_fin){
        try{
            String query = "SELECT * FROM Enseignant, Affecter, Seance, Module, Etudier, Etudiant WHERE Enseignant.id_user = Seance.id_user AND Module.id_module = Seance.id_module "
                    + "AND Affecter.id_module = Module.id_module AND Affecter.id_user = Enseignant.id_user AND Etudier.id_module = Module.id_module"
                    + " AND Etudier.id_user = Etudiant.id_user AND Enseignant.id_user = ? AND Seance.date_seance = ? AND Seance.heure_debut = ? AND Seance.heure_fin = ? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idU);
            smt.setString(2, date);
            smt.setString(3, heur_deb);
            smt.setString(4, heur_fin);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                Seance seance = new Seance(rs.getString("intitule_module"),rs.getString("date_seance"),rs.getString("heure_debut"),rs.getString("heure_fin"),
                rs.getString("type_seance"),rs.getInt("id_seance"));
                list_seance.add(seance);
                System.out.println("good getAbsSeance");
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getAbsSeance: "+e.getMessage());
        }
        return list_seance;
    }
    
    public ArrayList<Etudiant> getAbsEt(int idU,String date,String heur_deb,String heur_fin){
        try{
            String query = "SELECT * FROM Enseignant, Affecter, Seance, Module, Etudier, Etudiant WHERE " +
            "Enseignant.id_user = Seance.id_user AND Module.id_module = Seance.id_module AND " +
            "Affecter.id_module = Module.id_module AND Affecter.id_user = Enseignant.id_user  " +
            "AND " +
            "Etudier.id_module = Module.id_module AND Etudier.id_user = Etudiant.id_user AND  " +
            "Enseignant.id_user = ? AND Seance.date_seance = ? AND Seance.heure_debut = ? AND Seance.heure_fin = ? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idU);
            smt.setString(2, date);
            smt.setString(3, heur_deb);
            smt.setString(4, heur_fin);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Etudiant etd = new Etudiant(rs.getInt("Etudiant.id_user"),rs.getString("cne"),rs.getString("nom_etu"),rs.getString("prenom_etu"),null,null,null,null,null,null);
                list_etudiant.add(etd);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getAbsEt: "+e.getMessage());
        }
        return list_etudiant;
    }
    
    public int getSeanceId(String date,String heur_deb,String heur_fin){
        int id=0;
        try{
            String query = "SELECT id_seance FROM seance WHERE date_seance=? AND seance.heure_debut = ? AND seance.heure_fin = ? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, date);
            smt.setString(2, heur_deb);
            smt.setString(3, heur_fin);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                id = rs.getInt("id_seance");
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getSeanceId: "+e.getMessage());
        }
        return id;
    }    
    public boolean checkAbsence(int idS,int idE){
        try{
            String query = "select * from Absence where id_seance = ? and id_user = ? ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idS);
            smt.setInt(2, idE);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong checkAbsence: "+e.getMessage());
        }
        return false;
    }
    
    public boolean createAbsence(int idS,int idU,String justifier,String commentaire){
        try{
            String query = "INSERT INTO absence(id_seance,id_user,justifiee,comm_abs) VALUES (?,?,?,?)";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, idS);
            smt.setInt(2, idU);
            smt.setString(3, justifier);
            smt.setString(4, commentaire);
            int id = smt.executeUpdate();
            if(id!=0){
               System.out.println("good createAbsence"); 
               return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong createAbsence: "+e.getMessage());
        }
        return false;
    }
    
    public ArrayList<Absence> getEtudiantAbs(int id){
        ArrayList<Absence> table = new ArrayList<Absence>();
        try{
           String query = "SELECT * FROM Absence, Seance, Module, Etudier, Etudiant " +
                        "WHERE Absence.id_seance = Seance.id_seance " +
                        "AND Module.id_module = Seance.id_module " +
                        "AND Etudier.id_module = Module.id_module " +
                        "AND Etudier.id_user = Etudiant.id_user " +
                        "AND Absence.id_user = ? " +
                        "AND Etudiant.id_user = ?  ";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setInt(1, id);
            smt.setInt(2, id);
            ResultSet rs = smt.executeQuery();
            while(rs.next()){
                Absence ab = new Absence(rs.getString("intitule_module"),null,rs.getString("nom_etu"),rs.getString("prenom_etu"),
                rs.getString("justifiee"),rs.getString("comm_abs"),rs.getString("date_seance"),rs.getString("heure_debut"),rs.getString("heure_fin"),
                rs.getString("type_seance"));
                table.add(ab);
            }
        }catch(Exception e){
            System.out.println("Oops something wrong getEtudiantAbs: "+e.getMessage());
        }
        return table;
    }
    
    public boolean check(String login,String pass){
        try{
            String query = "SELECT * FROM user WHERE login = ? AND password = ?";
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1,login);
            smt.setString(2, pass);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            System.out.println("Oops something wrong check: "+e.getMessage());
        }
        return false;
    }
    
}
