package modelo;
// Generated 28-abr-2024 16:05:02 by Hibernate Tools 4.3.1



/**
 * Rol generated by hbm2java
 */
public class Rol  implements java.io.Serializable {


     private Integer id;
     private String dominio;
     private String tipo;

    public Rol() {
    }

    public Rol(String dominio, String tipo) {
       this.dominio = dominio;
       this.tipo = tipo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDominio() {
        return this.dominio;
    }
    
    public void setDominio(String dominio) {
        this.dominio = dominio;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


