package LogicaNegocio;
// Generated Mar 3, 2017 5:54:26 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.Set;




/**
 * Administrador generated by hbm2java
 */
public class Administrador extends Usuarios  implements java.io.Serializable {


     private Integer id;
     private Usuarios usuarios;
     private Double salario;

    public Administrador() {
    }

    public Administrador(Integer id, Usuarios usuarios, Double salario, String cedula, String nombre, String clave, String email, Date fechaNac, Integer type, Set matriculadors, Set administradors, Set profesors, Set alumnos) {
        super(cedula, nombre, clave, email, fechaNac, type, matriculadors, administradors, profesors, alumnos);
        this.id = id;
        this.usuarios = usuarios;
        this.salario = salario;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public Double getSalario() {
        return this.salario;
    }
    
    public void setSalario(Double salario) {
        this.salario = salario;
    }




}


