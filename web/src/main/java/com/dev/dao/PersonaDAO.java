package com.dev.dao;

import com.dev.model.Persona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements IPerosnaDAO {

    private SessionFactory sf;

    public PersonaDAO(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Persona getByIdentificador(int identificador) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Persona where identificador=:identificador");
        query.setInteger("identificador", identificador);
        Persona obj = (Persona) query.uniqueResult();
        tx.commit();
        session.close();
        return obj;
    }

    @Override
    public List<Persona> getByNombreApellido(String nombre) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String tmp[] = nombre.split(" ");
        String consulta = "select Persona from Persona where ";
        for (String t : tmp) {
            t = t.replaceAll("'", "\\'");
            consulta += "nombre like '%" + t + "%' or apellido like '%" + t + "%' or ";
        }
        Query query = session.createQuery(consulta.substring(0, consulta.length() - 4));
        List<Persona> obj = query.list();
        tx.commit();
        session.close();
        return obj;
    }

    @Override
    public int getLastIdentificador() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String consulta = " select max (identificador) from Persona";
        Query query = session.createQuery(consulta);
        List<Integer> obj = query.list();
        tx.commit();
        session.close();
        if (obj != null) {
            System.out.println("Datos recibidos desde la base de datos::" + obj);
            return obj.get(0);
        } else {
            return 0;
        }
    }

    @Override
    public boolean save(Persona obj) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Integer resultado;
        if (obj.getIdentificador() == 0) {
            obj.setIdentificador(getLastIdentificador() + 1);
            resultado = (Integer) session.save(obj);
        } else {
            session.update(obj);
            resultado = 1;
        }
        tx.commit();
        session.close();
        return resultado >= 1;
    }

    @Override
    public boolean delete(Persona obj) {
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
    public List<Persona> getList() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String consulta = "  from Persona";
        Query query = session.createQuery(consulta);
        List<Persona> obj = query.list();
        tx.commit();
        session.close();
        if (obj != null) {
            System.out.println("Datos recibidos desde la base de datos::" + obj.size());
            return obj;
        } else {
            return new ArrayList<Persona>();
        }
    }


}
