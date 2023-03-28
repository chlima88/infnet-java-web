<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-flex flex-row aling-items-center justify-content-between">
  <h1 class="fs-2 fw-semibold mb-0">${param.title}</h1>
  <span class="fs-4 fw-semibold text-uppercase">${usuarioLogado.empresa} </span>
</div>
<hr class="mb-4">
<c:import url="/WEB-INF/jsp/alertas.jsp" />