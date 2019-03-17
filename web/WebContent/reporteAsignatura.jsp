<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>

<jsp:include page="cabecera.jsp"/>

<s:form name="form" namespace="/reporteAsignatura" action="reporteAsignatura" theme="bootstrap"
        cssClass="well form-horizontal">
    <div class="clearBoth"></div>
    <s:select name="model.identificador" key="nombre" theme="bootstrap"
              list="list"
              listValue="nombre"
              listKey="identificador"
              headerKey="0"
              headerValue="Seleccione">
    </s:select>
    <div style="clear: both"></div>
    <s:submit action="buscarReporteAsignatura" key="boton.buscar" effect="highlight" cssClass="btn btn-success"/>
    <hr/>
    <s:textfield key="nombreYApellido" value="%{profesorNombreApellido}" readonly="true"/>
    <hr/>
    <table style="width: 100%">
        <caption style="text-align: center"><strong><s:text name="caption.alumnos"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <s:text name="total"/>:<s:property value="listaCursos.size"/></strong></caption>
        <thead>
        <tr>
            <th style="padding-right: 15px">
                <strong>
                    <s:text name="nombreYApellido"/>
                </strong>
            </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listaCursos" status="obj">
            <tr>
                <s:if test="#obj.even == false">
                    <td style="background-color: #ffffff">
                        <s:property value="alumno.persona.nombre"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property
                            value="alumno.persona.apellido"/>
                    </td>
                </s:if>
                <s:else>
                    <td>
                        <s:property value="alumno.persona.nombre"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property
                            value="alumno.persona.apellido"/>
                    </td>
                </s:else>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:form>

<jsp:include page="pie.jsp"/>