<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>

<jsp:include page="cabecera.jsp"/>

<s:form name="form" namespace="/reporteAcademico" action="reporteAcademico" theme="bootstrap"
        cssClass="well form-horizontal">
    <div class="clearBoth"></div>
    <s:select name="model.identificador" key="nombreYApellido" theme="bootstrap"
              list="list"
              listValue="'(' + legajo + ') ' + persona.nombre + ' ' + persona.apellido"
              listKey="identificador"
              headerKey="0"
              headerValue="Seleccione">
    </s:select>
    <div style="clear: both"></div>
    <s:submit action="buscarReporteAcademico" key="boton.buscar" effect="highlight" cssClass="btn btn-success"/>
    <hr/>
    <table style="width: 100%">
        <caption style="text-align: center"><strong><s:text name="caption.carrerasYCursos"/></strong></caption>
        <thead>
        <tr>
            <th style="padding-right: 15px">
                <strong>
                    <s:text name="carrera"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="promedio"/>
                </strong>
            </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="promedios" status="obj">
            <tr>
                <s:if test="#obj.even == false">
                    <td style="background-color: #ffffff">
                        <s:property value="key.nombre"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="value"/>
                    </td>
                </s:if>
                <s:else>
                    <td>
                        <s:property value="key.nombre"/>
                    </td>
                    <td>
                        <s:property value="value"/>
                    </td>
                </s:else>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <hr/>
    <table style="width: 100%">
        <caption style="text-align: center"><strong><s:text name="caption.carrerasYCursos"/></strong></caption>
        <thead>
        <tr>
            <th style="padding-right: 15px">
                <strong>
                    <s:text name="carrera"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="curso"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="fechainscripcion"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="nota"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="estado"/>
                </strong>
            </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listaCursos" status="obj">
            <tr>
                <s:if test="#obj.even == false">
                    <td style="background-color: #ffffff">
                        <s:property value="curso.carrera.nombre"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="curso.nombre"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="fechainscripcion"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="nota"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:if test="nota >= notaaprobacion">
                            <s:text name="aprobado"/>
                        </s:if>
                        <s:else>
                            <s:text name="reprobado"/>
                        </s:else>
                    </td>
                </s:if>
                <s:else>
                    <td>
                        <s:property value="curso.carrera.nombre"/>
                    </td>
                    <td>
                        <s:property value="curso.nombre"/>
                    </td>
                    <td>
                        <s:property value="fechainscripcion"/>
                    </td>
                    <td>
                        <s:property value="nota"/>
                    </td>
                    <td>
                        <s:if test="nota >= notaaprobacion">
                            <s:text name="aprobado"/>
                        </s:if>
                        <s:else>
                            <s:text name="reprobado"/>
                        </s:else>
                    </td>
                </s:else>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:form>

<jsp:include page="pie.jsp"/>