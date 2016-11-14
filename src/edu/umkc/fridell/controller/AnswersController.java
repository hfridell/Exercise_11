package edu.umkc.fridell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umkc.fridell.model.Answer;
import edu.umkc.fridell.model.AnswerModel;
import edu.umkc.fridell.model.Question;
import edu.umkc.fridell.model.QuestionModel;

@WebServlet("/answers")
public class AnswersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AnswersController() {
        super();
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer questionId = Integer.parseInt(request.getParameter("id"));
		AnswerModel model = new AnswerModel();
    ArrayList<Answer> answers = model.getAnswers(questionId);
    Question question = QuestionModel.questions.get(questionId-1);

    request.setAttribute("answers", answers);
    request.setAttribute("question", question.question);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Answers.jsp");
    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newAnswer = request.getParameter("newAnswer");
		Integer questionId = Integer.parseInt(request.getParameter("questionId"));

		AnswerModel.addAnswer(questionId, newAnswer);

		response.sendRedirect("/answers?id=" + questionId);
	}
}
