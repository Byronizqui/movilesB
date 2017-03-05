/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import LogicaNegocio.Curso;
import java.util.List;

/**
 *
 * @author Byron
 */
public class CursoBL extends BaseBL implements IBaseBL<Curso, Integer>{

    public CursoBL() {
        super();
    }

    @Override
    public void save(Curso o) {
        this.getDao(o.getClass().getName()).save(o);
    }

    @Override
    public Curso merge(Curso o) {
        return (Curso) this.getDao(o.getClass().getName()).merge(o);
    }

    @Override
    public void delete(Curso o) {
        this.getDao(o.getClass().getName()).delete(o);
    }

    @Override
    public Curso findByOther(Curso o) {
        return (Curso) this.getDao(o.getClass().getName()).findByOther(o);
    }

    @Override
    public List<Curso> findAllByOther(String o, String p) {
        return this.getDao(Curso.class.getName()).findAllByOther(o, p);
    }

    @Override
    public List<Curso> findAll(String o) {
        return this.getDao(o).findAll();
    }
    
}
