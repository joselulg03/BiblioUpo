package modelo;
// Generated 28-abr-2024 16:05:02 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SistemaOperativo generated by hbm2java
 */
public class SistemaOperativo  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Set portatils = new HashSet(0);

    public SistemaOperativo() {
    }

	
    public SistemaOperativo(String nombre) {
        this.nombre = nombre;
    }
    public SistemaOperativo(String nombre, Set portatils) {
       this.nombre = nombre;
       this.portatils = portatils;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getPortatils() {
        return this.portatils;
    }
    
    public void setPortatils(Set portatils) {
        this.portatils = portatils;
    }




}


