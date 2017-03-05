/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Profesor;
import java.util.List;

/**
 *
 * @author Byron
 */
public class ProfesorBL extends BaseBL implements IBaseBL<Profesor, Integer>{

    public ProfesorBL() {
        super();
    }

    @Override
    public void save(Profesor o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Profesor merge(Profesor o) {
        return (Profesor) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Profesor o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Profesor findByOther(Profesor o) {
        return (Profesor) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Profesor> findAllByOther(String o, String p) {
        return this.getDao(Profesor.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Profesor> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
