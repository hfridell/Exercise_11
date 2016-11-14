<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.umkc.fridell.model.Answer" %><%--
  Created by IntelliJ IDEA.
  User: hffri
  Date: 11/13/2016
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answers</title>
</head>
<body>
    <form method="post" action="/answers">
        <h1>Answers</h1>
        <h2>
            <%= request.getAttribute("question")%>
        </h2>
        <%
            Integer questionId = Integer.parseInt(request.getParameter("id"));
            ArrayList<Answer> answers = (ArrayList<Answer>)request.getAttribute("answers");
            for(Answer a : answers) {
                out.print("<li>");
                out.print(a.answer);
                out.print("</li>");
            }
        %>
        <input type='text' name='newAnswer'><button type='submit'>Add Answer</button>
        <input type="hidden" name="questionId" value="<%=questionId %>">
    </form>
</body>
</html>
