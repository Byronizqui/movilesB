/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Alumno;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class AlumnoDAO extends HibernateUtil implements IBaseDAO<Alumno, Integer>{

    @Override
    public void save(Alumno o) {
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
    public Alumno merge(Alumno o) {
        try {
            iniciaOperacion();
            o = (Alumno) getSesion().merge(o);
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
    public void delete(Alumno o) {
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
    public Alumno findByOther(Alumno o) {
        Alumno alumno = null;

        try {
            iniciaOperacion();
            alumno = (Alumno) getSesion().get(Alumno.class, o);
        } finally {
            getSesion().close();
        }
        return alumno;
    }

    @Override
    public List<Alumno> findAllByOther(String o, String p) {
        List<Alumno> lista = null;
        try {
            iniciaOperacion();
            Query query = getSesion().createQuery("from Alumno where nombre = '" + o + "'");//Esto esta por verse
            lista = query.list();
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Alumno> findAll() {
        List<Alumno> listaAlumno;
        try {
            iniciaOperacion();
            listaAlumno = getSesion().createQuery("from Alumno").list();
        } finally {
            getSesion().close();
        }
        return listaAlumno;
    }
    
}
