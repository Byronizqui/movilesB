/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Grupo;
import java.util.List;

/**
 *
 * @author Byron
 */
public class GrupoBL extends BaseBL implements IBaseBL<Grupo, Integer>{

    public GrupoBL() {
        super();
    }

    @Override
    public void save(Grupo o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Grupo merge(Grupo o) {
        return (Grupo) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Grupo o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Grupo findByOther(Grupo o) {
        return (Grupo) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Grupo> findAllByOther(String o, String p) {
        return this.getDao(Grupo.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Grupo> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
