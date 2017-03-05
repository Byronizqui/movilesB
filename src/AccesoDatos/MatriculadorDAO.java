/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Matriculador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class MatriculadorDAO extends HibernateUtil implements IBaseDAO<Matriculador, Integer>{

    @Override
    public void save(Matriculador o) {
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
    public Matriculador merge(Matriculador o) {
        try {
            iniciaOperacion();
            o = (Matriculador) getSesion().merge(o);
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
    public void delete(Matriculador o) {
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
    public Matriculador findByOther(Matriculador o) {
        Matriculador matriculador = null;

        try {
            iniciaOperacion();
            matriculador = (Matriculador) getSesion().get(Matriculador.class, o);
        } finally {
            getSesion().close();
        }
        return matriculador;
    }

    @Override
    public List<Matriculador> findAllByOther(String o, String p) {
        List<Matriculador> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Matriculador where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Matriculador> findAll() {
        List<Matriculador> listaMatriculador;
        try {
            iniciaOperacion();
            listaMatriculador = getSesion().createQuery("from Matriculador").list();
        } finally {
            getSesion().close();
        }
        return listaMatriculador;
    }
    
}
