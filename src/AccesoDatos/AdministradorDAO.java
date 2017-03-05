/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Administrador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class AdministradorDAO extends HibernateUtil implements IBaseDAO<Administrador, Integer>{

    @Override
    public void save(Administrador o) {
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
    public Administrador merge(Administrador o) {
        try {
            iniciaOperacion();
            o = (Administrador) getSesion().merge(o);
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
    public void delete(Administrador o) {
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
    public Administrador findByOther(Administrador o) {
        Administrador administrador = null;

        try {
            iniciaOperacion();
            administrador = (Administrador) getSesion().get(Administrador.class, o);
        } finally {
            getSesion().close();
        }
        return administrador;
    }

    @Override
    public List<Administrador> findAllByOther(String o, String p) {
        List<Administrador> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Administrador where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Administrador> findAll() {
        List<Administrador> listaAdministrador;
        try {
            iniciaOperacion();
            listaAdministrador = getSesion().createQuery("from Administrador").list();
        } finally {
            getSesion().close();
        }
        return listaAdministrador;
    }
    
}
