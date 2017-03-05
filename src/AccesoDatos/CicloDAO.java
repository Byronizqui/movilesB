/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Ciclo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class CicloDAO extends HibernateUtil implements IBaseDAO<Ciclo, Integer>{

    @Override
    public void save(Ciclo o) {
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
    public Ciclo merge(Ciclo o) {
        try {
            iniciaOperacion();
            o = (Ciclo) getSesion().merge(o);
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
    public void delete(Ciclo o) {
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
    public Ciclo findByOther(Ciclo o) {
        Ciclo ciclo = null;

        try {
            iniciaOperacion();
            ciclo = (Ciclo) getSesion().get(Ciclo.class, o);
        } finally {
            getSesion().close();
        }
        return ciclo;
    }

    @Override
    public List<Ciclo> findAllByOther(String o, String p) {
        List<Ciclo> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Ciclo where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Ciclo> findAll() {
        List<Ciclo> listaCiclo;
        try {
            iniciaOperacion();
            listaCiclo = getSesion().createQuery("from Ciclo").list();
        } finally {
            getSesion().close();
        }
        return listaCiclo;
    }
    
}
