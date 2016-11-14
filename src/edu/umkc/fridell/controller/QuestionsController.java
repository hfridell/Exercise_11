package edu.umkc.fridell.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umkc.fridell.model.Question;
import edu.umkc.fridell.model.QuestionModel;

@WebServlet("/questions")
public class QuestionsController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public QuestionsController() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("questions", QuestionModel.questions);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Questions.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String theQuestion = request.getParameter("newQuestion");
    QuestionModel.newQuestion(new Question(QuestionModel.questions.size() + 1, theQuestion));
    response.sendRedirect("/questions");
  }

}
