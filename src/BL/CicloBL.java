/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Ciclo;
import java.util.List;

/**
 *
 * @author Byron
 */
public class CicloBL extends BaseBL implements IBaseBL<Ciclo, Integer>{

    public CicloBL() {
        super();
    }

    @Override
    public void save(Ciclo o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Ciclo merge(Ciclo o) {
        return (Ciclo) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Ciclo o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Ciclo findByOther(Ciclo o) {
        return (Ciclo) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Ciclo> findAllByOther(String o, String p) {
        return this.getDao(Ciclo.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Ciclo> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
