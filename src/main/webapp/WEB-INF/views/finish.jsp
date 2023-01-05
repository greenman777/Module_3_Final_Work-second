<%--
  Created by IntelliJ IDEA.
  User: Ал9
  Date: 27.11.2022
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Конец игры</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body style="background-image: url('https://cdn.smartfacts.ru/183363/pol-sekretnyy-materialchik_10.jpg')">
<p class="p-1 mb-2 bg-primary text-white" align="center"><%= session.getAttribute("name")%></p>

<p class="p-3 mb-2 bg-info text-dark d-inline-block p-2 text-bg-primary"><%= request.getAttribute("stateString")%></p>
<br>
<div class="p-3 mb-2 bg-warning text-dark d-inline-block">
  <form action="index.html" >
    <button type="submit" class="btn bg-success btn-success">Вернуться в начало</button>
  </form>
  <br>
  <p class="p-3 mb-2 bg-white text-dark">Количество сыгранных игр: <%= session.getAttribute("gameCount")%></p>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>