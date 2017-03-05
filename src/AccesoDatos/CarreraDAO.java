/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Carrera;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class CarreraDAO extends HibernateUtil implements IBaseDAO<Carrera, Integer>{

    @Override
    public void save(Carrera o) {
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
    public Carrera merge(Carrera o) {
        try {
            iniciaOperacion();
            o = (Carrera) getSesion().merge(o);
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
    public void delete(Carrera o) {
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
    public Carrera findByOther(Carrera o) {
        Carrera carrera = null;

        try {
            iniciaOperacion();
            carrera = (Carrera) getSesion().get(Carrera.class, o);
        } finally {
            getSesion().close();
        }
        return carrera;
    }

    @Override
    public List<Carrera> findAllByOther(String o, String p) {
        List<Carrera> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Carrera where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Carrera> findAll() {
        List<Carrera> listaCarrera;
        try {
            iniciaOperacion();
            listaCarrera = getSesion().createQuery("from Carrera").list();
        } finally {
            getSesion().close();
        }
        return listaCarrera;
    }
    
}
