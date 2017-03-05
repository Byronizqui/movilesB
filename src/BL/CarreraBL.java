/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Carrera;
import java.util.List;

/**
 *
 * @author Byron
 */
public class CarreraBL extends BaseBL implements IBaseBL<Carrera, Integer>{

    public CarreraBL() {
        super();
    }

    @Override
    public void save(Carrera o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Carrera merge(Carrera o) {
        return (Carrera) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Carrera o) {
         this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Carrera findByOther(Carrera o) {
        return (Carrera) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Carrera> findAllByOther(String o, String p) {
        return this.getDao(Carrera.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Carrera> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
