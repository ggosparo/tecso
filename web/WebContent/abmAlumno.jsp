<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>

<jsp:include page="cabecera.jsp"/>

<s:form name="form" namespace="/abmAlumno" action="abmAlumno" theme="bootstrap" cssClass="well form-horizontal">
    <s:textfield name="identificador" key="identificador" theme="bootstrap" readonly="true"
                 value="%{model.identificador}"/>
    <div class="clearBoth"></div>
    <s:textfield name="legajo" key="legajo" theme="bootstrap" value="%{model.legajo}"/>
    <div class="clearBoth"></div>
    <s:select name="persona.identificador" key="nombreYApellido" theme="bootstrap"
              list="personas"
              listValue="nombre + ' ' + apellido"
              listKey="identificador"
              headerKey="0"
              headerValue="Seleccione">
    </s:select>
    <div style="clear: both"></div>
    <s:submit action="aceptarAlumno" key="boton.aceptar" effect="highlight" cssClass="btn btn-success"/>
    <s:submit action="cancelarAlumno" key="boton.cancelar" effect="highlight" cssClass="btn btn-danger"/>
    <hr/>
    <table style="width: 100%">
        <caption style="text-align: center"><strong><s:text name="caption.listadoDeAlumnos"/></strong></caption>
        <thead>
        <tr>
            <th style="padding-right: 15px">
                <strong>
                    <s:text name="accion"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="legajo"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="nombreYApellido"/>
                </strong>
            </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="list" status="obj">
            <tr>
                <s:if test="#obj.even == false">
                    <td style="background-color: #ffffff" class="accion" >
                        <a href="abmAlumno/borrarAlumno.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:text name="boton.eliminar"/>
                        </a>
                    </td>
                    <td style="background-color: #ffffff">
                        <a href="abmAlumno/actualizarAlumno.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:property value="legajo"/>
                        </a>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="persona.nombre"/>&nbsp;<s:property value="persona.apellido"/>
                    </td>
                </s:if>
                <s:else>
                    <td class="accion">
                        <a href="abmAlumno/borrarAlumno.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:text name="boton.eliminar"/>
                        </a>
                    </td>
                    <td>
                        <a href="abmAlumno/actualizarAlumno.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:property value="legajo"/>
                        </a>
                    </td>
                    <td>
                        <s:property value="persona.nombre"/>&nbsp;<s:property value="persona.apellido"/>
                    </td>
                </s:else>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:form>

<jsp:include page="pie.jsp"/>