/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Nota;
import java.util.List;

/**
 *
 * @author Byron
 */
public class NotaBL extends BaseBL implements IBaseBL<Nota, Integer>{

    public NotaBL() {
        super();
    }

    @Override
    public void save(Nota o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Nota merge(Nota o) {
        return (Nota) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Nota o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Nota findByOther(Nota o) {
        return (Nota) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Nota> findAllByOther(String o, String p) {
        return this.getDao(Nota.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Nota> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
