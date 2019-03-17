<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>

<jsp:include page="cabecera.jsp"/>

<s:form name="form" namespace="/inscripcionMateria" action="inscripcionMateria" theme="bootstrap"
        cssClass="well form-horizontal">
    <div class="clearBoth"></div>
    <s:select name="model.identificador" key="nombreYApellido" theme="bootstrap"
              list="list"
              listValue="persona.nombre + ' ' + persona.apellido"
              listKey="identificador"
              headerKey="0"
              headerValue="Seleccione"
              onchange="fcCargarCarreras(this.value)"
              onblur="fcCargarCarreras(this.value)"
    >
    </s:select>
    <div class="clearBoth"></div>
    <s:select name="carrera.identificador" key="carrera" theme="bootstrap"
              list="listCarrera"
              listValue="carrera.nombre"
              listKey="carrera.identificador"
              headerKey="0"
              headerValue="Seleccione"
              onchange="fcCargarCursos(this.value)"
              onblur="fcCargarCursos(this.value)"
    >
    </s:select>
    <div class="clearBoth"></div>
    <s:select name="curso.identificador" key="curso" theme="bootstrap"
              list="listCurso"
              listValue="nombre"
              listKey="identificador"
              headerKey="0"
              headerValue="Seleccione"
    >
    </s:select>
    <div style="clear: both"></div>
    <s:submit action="aceptarInscripcionMateria" key="boton.aceptar" effect="highlight" cssClass="btn btn-success"/>
    <s:submit action="cancelarInscripcionMateria" key="boton.cancelar" effect="highlight" cssClass="btn btn-danger"/>
    <script type="text/javascript">
        function fcCargarCarreras(id) {
            window.location.href = 'inscripcionMateria/inscripcionMateriaCarrera.action?' +
                'model.identificador=' + $("[name='model.identificador']").val() +
                '&carrera.identificador=' + id;
        }
        function fcCargarCursos(id) {
            window.location.href = 'inscripcionMateria/inscripcionMateriaCurso.action?' +
                'model.identificador=' + $("[name='model.identificador']").val() +
                '&carrera.identificador=' + $("[name='carrera.identificador']").val() +
                '&curso.identificador=' + id;
        }
    </script>
</s:form>

<jsp:include page="pie.jsp"/>
