<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title><s:text name="cabecera.title"/></title>

    <sb:head></sb:head>
    <sj:head></sj:head>
</head>
<body>
<s:actionerror theme="bootstrap"/>
<s:form name="form" action="menu" theme="bootstrap" cssClass="well form-horizontal">
<a href="/abmPersona" class="btn btn-primary"
   title="pre a. Registre personas.">
    <s:text name="titulo.abmPersona"/>
</a>
<a href="/abmAlumno" class="btn btn-primary"
   title="a. Registre y edite alumnos en el modelo de base de datos anterior.">
    <s:text name="titulo.abmAlumno"/>
</a>
<a href="/reporteAcademico" class="btn btn-primary"
   title="b.i. Estado acad&iacute;mico de un alumno dado (inscripciones actuales a carreras y cursos,  estado de cursos anteriores, promedio general por carrera tomando los cursos ya aprobados)">
    <s:text name="titulo.reporteAcademico"/>
</a>
<a href="/reporteAsignatura" class="btn btn-primary"
   title="b.ii. Para una asignatura(curso) dado, los alumnos inscriptos y el docente correspondiente.">
    <s:text name="titulo.reporteAsignatura"/>
</a>
<a href="/inscripcionMateria" class="btn btn-primary"
   title="c. Permita a un alumno inscribirse a una materia.">
    <s:text name="titulo.inscripcionMateria"/>
</a>
</s:form>
