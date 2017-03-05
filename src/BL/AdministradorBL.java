/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Administrador;
import java.util.List;

/**
 *
 * @author Byron
 */
public class AdministradorBL extends BaseBL implements IBaseBL<Administrador, Integer>{

    public AdministradorBL() {
        super();
    }
    
    @Override
    public void save(Administrador o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Administrador merge(Administrador o) {
        return (Administrador) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Administrador o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Administrador findByOther(Administrador o) {
        return (Administrador) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Administrador> findAllByOther(String o, String p) {
        return this.getDao(Administrador.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Administrador> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
