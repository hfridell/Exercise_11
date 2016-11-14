<%--
  Created by IntelliJ IDEA.
  User: hffri
  Date: 11/13/2016
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.umkc.fridell.model.Question" %>

<html>
<head>
    <title>Questions</title>
</head>
<body>
    <form action="/questions" method="post">
        <h1>Questions</h1>
        <%
            ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
            for (Question q : questions){
                out.print("<li>");
                    out.print("<a href='/answers?id=" + q.id + "'>");
                        out.print(q.question);
                    out.print("</a>");
                out.println("</li>");
            }
        %>
        <input type="text" name='newQuestion'>
        <button type="submit">Add Question</button>
    </form>
</body>
</html>
