package com.dev.dao;

import com.dev.model.Persona;

import java.util.List;

public interface IPerosnaDAO {

    Persona getByIdentificador(int identificador);

    List<Persona> getByNombreApellido(String nombre);

    int getLastIdentificador();

    boolean save(Persona persona);

    boolean delete(Persona persona);

    List<Persona> getList();

}