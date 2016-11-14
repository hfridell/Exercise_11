package edu.umkc.fridell.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.umkc.fridell.database.SqliteConnection;


public class AnswerModel {

  public ArrayList<Answer> getAnswers(Question question) {
    return getAnswers(question.id);
  }

  public ArrayList<Answer> getAnswers(int questionId) {
    ArrayList<Answer> answers = new ArrayList<>();
    try {
      Statement statement = SqliteConnection.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM Answers WHERE question_id_fk=" + questionId);

      int numbering = 1;
      while (rs.next()) {
        answers.add(new Answer(rs.getInt("answer_id"), rs.getInt("question_id_fk"), rs.getString("answer")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  return answers;
  }

  public static void addAnswer(int questionId, String answer) {
    Connection conn = SqliteConnection.connect();
    try {
      assert conn != null;
      Statement statement = SqliteConnection.createStatement();
      statement.executeUpdate("INSERT INTO Answers (question_id_fk, answer) Values(" + questionId + ", \"" + answer + "\")");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
