<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<ul class="nav nav-tabs">
    <li role="presentation"
        <c:if test="${param.locale == 'ga_ga'}" >class="active"</c:if>><a
        href="?locale=ga_ga">ga</a></li>
    <li role="presentation"
        <c:if test="${param.locale == 'es_es'}" >class="active"</c:if>><a
        href="?locale=es_es">es</a></li>
    <li role="presentation"
        <c:if test="${param.locale == 'en_en'}" >class="active"</c:if>><a
        href="?locale=en_en">en</a></li>
</ul>