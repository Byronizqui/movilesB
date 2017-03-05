/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Grupo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class GrupoDAO extends HibernateUtil implements IBaseDAO<Grupo, Integer>{

    @Override
    public void save(Grupo o) {
        try {
            iniciaOperacion();
            getSesion().save(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Grupo merge(Grupo o) {
        try {
            iniciaOperacion();
            o = (Grupo) getSesion().merge(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
        return o;
    }

    @Override
    public void delete(Grupo o) {
        try {
            iniciaOperacion();
            getSesion().delete(o);
            getTransac().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            getSesion().close();
        }
    }

    @Override
    public Grupo findByOther(Grupo o) {
        Grupo grupo = null;

        try {
            iniciaOperacion();
            grupo = (Grupo) getSesion().get(Grupo.class, o);
        } finally {
            getSesion().close();
        }
        return grupo;
    }

    @Override
    public List<Grupo> findAllByOther(String o, String p) {
        List<Grupo> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Grupo where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Grupo> findAll() {
        List<Grupo> listaGrupo;
        try {
            iniciaOperacion();
            listaGrupo = getSesion().createQuery("from Grupo").list();
        } finally {
            getSesion().close();
        }
        return listaGrupo;
    }
    
}
