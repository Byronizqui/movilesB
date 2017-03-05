/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Profesor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class ProfesorDAO extends HibernateUtil implements IBaseDAO<Profesor, Integer>{

    @Override
    public void save(Profesor o) {
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
    public Profesor merge(Profesor o) {
        try {
            iniciaOperacion();
            o = (Profesor) getSesion().merge(o);
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
    public void delete(Profesor o) {
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
    public Profesor findByOther(Profesor o) {
        Profesor profesor = null;

        try {
            iniciaOperacion();
            profesor = (Profesor) getSesion().get(Profesor.class, o);
        } finally {
            getSesion().close();
        }
        return profesor;
    }

    @Override
    public List<Profesor> findAllByOther(String o, String p) {
        List<Profesor> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Profesor where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Profesor> findAll() {
        List<Profesor> listaProfesor;
        try {
            iniciaOperacion();
            listaProfesor = getSesion().createQuery("from Profesor").list();
        } finally {
            getSesion().close();
        }
        return listaProfesor;
    }
    
}
