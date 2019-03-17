<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjdt" uri="/struts-jquery-datatables-tags" %>

<jsp:include page="cabecera.jsp"/>

<s:form name="form" namespace="/abmPersona" action="/abmPersona" theme="bootstrap" cssClass="well form-horizontal">
    <s:textfield name="identificador" key="identificador" theme="bootstrap" readonly="true"
                 value="%{model.identificador}"/>
    <div class="clearBoth"></div>
    <s:select name="tipodoc" key="tipodoc" theme="bootstrap"
              list="#{'DNI':'DNI', 'DNU':'DNU', 'Libreta Civica':'Libreta Civica'}">
    </s:select>
    <div class="clearBoth"></div>
    <s:textfield name="documento" key="documento" theme="bootstrap" value="%{model.documento}"/>
    <div class="clearBoth"></div>
    <s:textfield name="nombre" key="nombre" theme="bootstrap"/>
    <div class="clearBoth"></div>
    <s:textfield name="apellido" key="apellido" theme="bootstrap"/>
    <div class="clearBoth"></div>
    <s:textfield name="direccion" key="direccion" theme="bootstrap"/>
    <div class="clearBoth"></div>
    <sj:datepicker
            id="fechanac"
            name="fechanac"
            parentTheme="bootstrap"
            key="fechanac"
            cssClass="form-control"
            showOn="focus"
    />
    <div style="clear: both"></div>
    <s:submit action="aceptarPersona" key="boton.aceptar" effect="highlight" cssClass="btn btn-success"/>
    <s:submit action="cancelarPersona" key="boton.cancelar" effect="highlight" cssClass="btn btn-danger"/>
    <hr/>
    <table style="width: 100%">
        <caption style="text-align: center"><strong><s:text name="caption.listadoDePersonas"/></strong></caption>
        <thead>
        <tr>
            <th style="padding-right: 15px">
                <strong>
                    <s:text name="accion"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="nombreYApellido"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="direccion"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="tipodoc"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="documento"/>
                </strong>
            </th>
            <th>
                <strong>
                    <s:text name="fechanac"/>
                </strong>
            </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="list" status="obj">
            <tr>
                <s:if test="#obj.even == false">
                    <td style="background-color: #ffffff" class="accion">
                        <a href="abmPersona/borrarPersona.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:text name="boton.eliminar"/>
                        </a>
                    </td>
                    <td style="background-color: #ffffff">
                        <a href="abmPersona/actualizarPersona.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:property value="nombre"/>&nbsp;<s:property value="apellido"/>
                        </a>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="direccion"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="tipodoc"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="documento"/>
                    </td>
                    <td style="background-color: #ffffff">
                        <s:property value="fechanac"/>
                    </td>
                </s:if>
                <s:else>
                    <td style="padding-right: 15px" class="odd">
                        <a href="abmPersona/borrarPersona.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:text name="boton.eliminar"/>
                        </a>
                    </td>
                    <td class="odd">
                        <a href="abmPersona/actualizarPersona.action?identificador=<s:property value="identificador"/>"
                           class="btn-link">
                            <s:property value="nombre"/>&nbsp;<s:property value="apellido"/>
                        </a>
                    </td>
                    <td class="odd" d>
                        <s:property value="direccion"/>
                    </td>
                    <td class="odd">
                        <s:property value="tipodoc"/>
                    </td>
                    <td class="odd">
                        <s:property value="documento"/>
                    </td>
                    <td class="odd">
                        <s:property value="fechanac"/>
                    </td>
                </s:else>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:form>

<jsp:include page="pie.jsp"/>