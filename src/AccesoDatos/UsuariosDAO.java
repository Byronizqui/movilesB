/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaNegocio.Usuarios;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class UsuariosDAO extends HibernateUtil implements IBaseDAO<Usuarios, Integer> {

    @Override
    public void save(Usuarios o) {
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
    public Usuarios merge(Usuarios o) {
        try {
            iniciaOperacion();
            o = (Usuarios) getSesion().merge(o);
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
    public void delete(Usuarios o) {
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
    public Usuarios findByOther(Usuarios o) {
        Usuarios usuarios = null;

        try {
            iniciaOperacion();
            List<Usuarios> aux;
            aux = findAll();
            for (Usuarios u : aux) {
                if (u.getCedula().equals(o.getCedula()) && u.getClave().equals(o.getClave())) {
                    usuarios = u;
                    return usuarios;
                }
            }
        } finally {
//            if (getSesion(). != null) {
//                getSesion().close();
//            }
        }
        return usuarios;
    }

    @Override
    public List<Usuarios> findAllByOther(String o, String p) {
        List<Usuarios> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Usuarios where c_categoria = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Usuarios> findAll() {
        List<Usuarios> listaUsuarios;
        try {
            iniciaOperacion();
            listaUsuarios = getSesion().createQuery("from Usuarios").list();
        } finally {
            getSesion().close();
        }
        return listaUsuarios;
    }

}
