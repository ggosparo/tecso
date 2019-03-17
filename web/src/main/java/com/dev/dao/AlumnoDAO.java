package com.dev.dao;

import com.dev.model.Alumno;
import com.dev.model.Persona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO implements IAlumnoDAO {

    private SessionFactory sf;

    public AlumnoDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Alumno getByIdentificador(int identificador) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Alumno where identificador=:identificador");
        query.setInteger("identificador", identificador);
        Alumno obj = (Alumno) query.uniqueResult();
        tx.commit();
        session.close();
        return obj;
    }

    @Override
    public List<Alumno> getByNombreApellido(String nombre) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String tmp[] = nombre.split(" ");
        String consulta = "select Alumno from Alumno where ";
        for (String t : tmp) {
            t = t.replaceAll("'", "\\'");
            consulta += "nombre like '%" + t + "%' or apellido like '%" + t + "%' or ";
        }
        Query query = session.createQuery(consulta.substring(0, consulta.length() - 4));
        List<Alumno> obj = query.list();
        tx.commit();
        session.close();
        return obj;
    }

    @Override
    public int getLastIdentificador() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String consulta = " select max (identificador) from Alumno";
        Query query = session.createQuery(consulta);
        List<Integer> obj = query.list();
        tx.commit();
        session.close();
        if (obj != null) {
            return obj.get(0);
        } else {
            return 0;
        }
    }

    @Override
    public boolean save(Alumno obj) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Integer resultado = 0;
        if (obj.getPersona() != null && obj.getPersona().getIdentificador() > 0) {
            PersonaDAO persona = new PersonaDAO(sf);
            Persona p = persona.getByIdentificador(obj.getPersona().getIdentificador());
            if (p != null) {
                obj.setPersona(p);
                if (obj.getIdentificador() == 0) {
                    obj.setIdentificador(getLastIdentificador() + 1);
                    resultado = (Integer) session.save(obj);
                } else {
                    session.update(obj);
                    resultado = 1;
                }
            }
        }
        tx.commit();
        session.close();
        return resultado >= 1;
    }

    @Override
    public boolean delete(Alumno obj) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Integer resultado = 0;
        if (obj.getIdentificador() > 0) {
            session.delete(obj);
            resultado = 1;
        }
        tx.commit();
        session.close();
        return resultado >= 1;
    }

    @Override
    public List<Alumno> getList() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String consulta = "  from Alumno";
        Query query = session.createQuery(consulta);
        List<Alumno> obj = query.list();
        tx.commit();
        session.close();
        if (obj != null) {
            return obj;
        } else {
            return new ArrayList<Alumno>();
        }
    }
}
