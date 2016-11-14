package edu.umkc.fridell.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umkc.fridell.model.QuestionModel;

@WebServlet("/api/questions")
public class GetQuestions extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public GetQuestions() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");
    // Get the printwriter object from response to write the required json object to the output stream
    PrintWriter out = response.getWriter();
    //new Gson().toJson(QuestionModel.questions, out);
    prettyPrint(out);

  }

  private void prettyPrint(PrintWriter out) {
    Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    gson.toJson(QuestionModel.questions, out);
    out.flush();
  }
}
