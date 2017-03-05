/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Alumno;
import java.util.List;

/**
 *
 * @author Byron
 */
public class AlumnoBL extends BaseBL implements IBaseBL<Alumno, Integer>{

    public AlumnoBL() {
        super();
    }

    @Override
    public void save(Alumno o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Alumno merge(Alumno o) {
        return (Alumno) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Alumno o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Alumno findByOther(Alumno o) {
        return (Alumno) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Alumno> findAllByOther(String o, String p) {
        return this.getDao(Alumno.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Alumno> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
