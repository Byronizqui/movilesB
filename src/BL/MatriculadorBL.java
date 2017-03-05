/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Matriculador;
import java.util.List;

/**
 *
 * @author Byron
 */
public class MatriculadorBL extends BaseBL implements IBaseBL<Matriculador, Integer>{

    public MatriculadorBL() {
        super();
    }

    @Override
    public void save(Matriculador o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Matriculador merge(Matriculador o) {
        return (Matriculador) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Matriculador o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Matriculador findByOther(Matriculador o) {
        return (Matriculador) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Matriculador> findAllByOther(String o, String p) {
        return this.getDao(Matriculador.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Matriculador> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
