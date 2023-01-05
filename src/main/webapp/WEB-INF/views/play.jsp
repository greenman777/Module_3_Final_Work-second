<%--
  Created by IntelliJ IDEA.
  User: Ал9
  Date: 26.11.2022
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Вопросы и ответы</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body style="background-image: url('https://99px.ru/sstorage/53/2011/04/tmb_13208_7707.jpg')" >

<p class="p-1 mb-2 bg-primary text-white" align="center">Привет: <%= session.getAttribute("name")%></p>


<p class="p-3 mb-2 bg-info text-dark d-inline-block p-2 text-bg-primary"><%= request.getAttribute("stateString")%></p>
<br>
<form action = "play" method="post">
  <p class="p-3 mb-2 bg-warning d-inline-block -white">Выбери один из двух ответов.</p>

  <br>
  <p class="p-2 mb-2 bg-primary d-inline-block -white"><input type="radio" name="choice" value="true" /> <%= request.getAttribute("answerYes")%></p>
  <br>
  <p class="p-2 mb-2 bg-primary d-inline-block -white"><input type="radio" name="choice" value="false" /> <%= request.getAttribute("answerNo")%></p>
  <br>
  <input type="submit" class="btn btn-primary btn btn-info p-3 mb-2 bg-success text-white" name="submit" value="submit" /></p>

</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>
