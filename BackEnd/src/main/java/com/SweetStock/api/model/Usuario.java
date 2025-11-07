
package com.SweetStock.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import org.springframework.security.crypto.bycrypt.ByCryptPasswordEncoder;
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String password;
    private String rol; 
    
    public Usuario(){}
    
    public Usuario(String nombre, String password, String rol){
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getRol(){
        return rol;
    }
    
    public void setRol(String rol){
        this.rol = rol;
    }
}
