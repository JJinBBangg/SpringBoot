<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<h1>${customer.id }번 고객 수정</h1>
	<form action="/sub17/link5"> 
		수정할 고객번호 조회
		<input type="text" name="id" placeholder="번호를 입력하세요.">
		<input type="submit" value="조회">
	</form><br />
	<form action="/sub17/link6" method="post">
		<input type="hidden" name="id" value="${customer.id }" />
		<!-- (input[name][value]+br)*7+input:s -->
		<pre>
id          :  <input type="text" name="customerName" value="${customer.customerName }" />
contactName :  <input type="text" name="contactName" value="${customer.contactName }" />
address     :  <input type="text" name="address" value="${customer.address }" />
city        :  <input type="text" name="city" value="${customer.city }" />
postalCode  :  <input type="text" name="postalCode" value="${customer.postalCode }" />
country     :  <input type="text" name="country" value="${customer.country }" />
<input type="submit" value="수정" />
		</pre>
	</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>










