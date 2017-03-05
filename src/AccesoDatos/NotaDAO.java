/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Nota;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class NotaDAO extends HibernateUtil implements IBaseDAO<Nota, Integer>{

    @Override
    public void save(Nota o) {
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
    public Nota merge(Nota o) {
        try {
            iniciaOperacion();
            o = (Nota) getSesion().merge(o);
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
    public void delete(Nota o) {
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
    public Nota findByOther(Nota o) {
        Nota nota = null;

        try {
            iniciaOperacion();
            nota = (Nota) getSesion().get(Nota.class, o);
        } finally {
            getSesion().close();
        }
        return nota;
    }

    @Override
    public List<Nota> findAllByOther(String o, String p) {
        List<Nota> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Nota where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Nota> findAll() {
        List<Nota> listaNota;
        try {
            iniciaOperacion();
            listaNota = getSesion().createQuery("from Nota").list();
        } finally {
            getSesion().close();
        }
        return listaNota;
    }
    
}
