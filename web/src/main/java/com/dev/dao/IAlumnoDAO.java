package com.dev.dao;

import com.dev.model.Alumno;
import com.dev.model.Persona;

import java.util.List;

public interface IAlumnoDAO {

    Alumno getByIdentificador(int identificador);

    List<Alumno> getByNombreApellido(String nombre);

    int getLastIdentificador();

    boolean save(Alumno persona);

    boolean delete(Alumno persona);

    List<Alumno> getList();

}