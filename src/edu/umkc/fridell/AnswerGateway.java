package edu.umkc.fridell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AnswerGateway {

  public ArrayList<Answer> fetch(Question question) {
    return fetch(question.id);
  }

  public ArrayList<Answer> fetch(int questionId) {
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

  public static void push(Answer Answer) {
    Connection conn = SqliteConnection.connect();
    try {
      assert conn != null;
      Statement statement = SqliteConnection.createStatement();
      statement.executeUpdate("INSERT INTO Answers (question_id_fk, answer) Values(\"" + Answer.questionId + ", " + Answer.answer + "\")");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
