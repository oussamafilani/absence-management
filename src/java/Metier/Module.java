
package Metier;


public class Module {
    
    private String id_module,intitule_module;

    public Module(String id_module, String intitule_module) {
        this.id_module = id_module;
        this.intitule_module = intitule_module;
    }

    public Module() {
    }

    public String getId_module() {
        return id_module;
    }

    public void setId_module(String id_module) {
        this.id_module = id_module;
    }

    public String getIntitule_module() {
        return intitule_module;
    }

    public void setIntitule_module(String intitule_module) {
        this.intitule_module = intitule_module;
    }
    
    
}
