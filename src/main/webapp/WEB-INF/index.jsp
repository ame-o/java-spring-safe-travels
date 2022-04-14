<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c"%>

<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index JSP</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
<section class="section">
<div class="container">
<h1 class="title">Save Travels</h1>
<div class="control">
<div class="box">

<table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    </thead>
<c:forEach items="${allExpenses}" var ="i">
<tbody>
<tr>
<td><a href="/expenses/${i.id }">${i.expenseName}</a></td>
<td>${i.vendor}</td>
<td>$${i.amount}</td>
<td>
<a href="/expenses/edit/${i.id}">Edit</a>
<form action="/delete/${i.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</td>
</tr>
</tbody>
</c:forEach>
</table>
</div>
</div>
<br />
<div class="control">
<div class="box is-dark">
<h2 class="subtitle">Create New Expense</h2>

<form:form action="/expenses/new" method="post" modelAttribute="expense">

    <p class="field">
        <form:label path="expenseName">Expense Name</form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName"/>
    </p>
    <p class="field">
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p class="field">
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount"/>
    </p> 
    <p class="field">
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>    
</div>
</div>
</div>
</section>
</body>
</html>