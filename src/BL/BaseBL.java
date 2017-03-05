/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import AccesoDatos.AdministradorDAO;
import AccesoDatos.AlumnoDAO;
import AccesoDatos.CarreraDAO;
import AccesoDatos.CicloDAO;
import AccesoDatos.CursoDAO;
import AccesoDatos.GrupoDAO;
import AccesoDatos.IBaseDAO;
import AccesoDatos.MatriculadorDAO;
import AccesoDatos.NotaDAO;
import AccesoDatos.ProfesorDAO;
import AccesoDatos.UsuariosDAO;
import java.util.LinkedHashMap;

/**
 *
 * @author Byron
 */
public class BaseBL {
    private final LinkedHashMap<String, IBaseDAO> daos;

    public BaseBL() {
        daos = new LinkedHashMap();
        daos.put("LogicaNegocio.Alumno", new AlumnoDAO());
        daos.put("LogicaNegocio.Carrera", new CarreraDAO());
        daos.put("LogicaNegocio.Ciclo", new CicloDAO());
        daos.put("LogicaNegocio.Curso", new CursoDAO());
        daos.put("LogicaNegocio.Grupo", new GrupoDAO());
        daos.put("LogicaNegocio.Matriculador", new MatriculadorDAO());
        daos.put("LogicaNegocio.Nota", new NotaDAO());
        daos.put("LogicaNegocio.Profesor", new ProfesorDAO());
        daos.put("LogicaNegocio.Usuarios", new UsuariosDAO());
        daos.put("LogicaNegocio.Administrador", new AdministradorDAO());
    }
    
    public IBaseDAO getDao(String className){
        return daos.get(className);
    }
}
