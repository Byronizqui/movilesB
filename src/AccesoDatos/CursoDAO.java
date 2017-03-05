/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import LogicaNegocio.Curso;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 *
 * @author Byron
 */
public class CursoDAO extends HibernateUtil implements IBaseDAO<Curso, Integer>{

    @Override
    public void save(Curso o) {
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
    public Curso merge(Curso o) {
        try {
            iniciaOperacion();
            o = (Curso) getSesion().merge(o);
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
    public void delete(Curso o) {
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
    public Curso findByOther(Curso o) {
        Curso curso = null;

        try {
            iniciaOperacion();
            curso = (Curso) getSesion().get(Curso.class, o);
        } finally {
            getSesion().close();
        }
        return curso;
    }

    @Override
    public List<Curso> findAllByOther(String o, String p) {
        List<Curso> lista = null;
        try {
            iniciaOperacion();
            switch (o){
                case "name": {
                    Query query = getSesion().createQuery("from Curso where nombre = '" + p + "'");//Esto esta por verse
                    lista = query.list();
                }
                case "code": {
                    Query query = getSesion().createQuery("from Curso where codigo = '" + p + "'");//Esto esta por verse
                    lista = query.list();
                }
            }
        } finally {
            getSesion().close();
        }

        return lista;
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> listaCurso;
        try {
            iniciaOperacion();
            listaCurso = getSesion().createQuery("from Curso").list();
        } finally {
            getSesion().close();
        }
        return listaCurso;
    }
    
}
