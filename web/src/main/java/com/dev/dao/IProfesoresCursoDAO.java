package com.dev.dao;

import com.dev.model.Persona;

import java.util.List;

public interface IProfesoresCursoDAO {

    Persona getByCurso(int identificador);
}