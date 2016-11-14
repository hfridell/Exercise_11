package edu.umkc.fridell.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.umkc.fridell.database.SqliteConnection;


public class QuestionModel {
  public static ArrayList<Question> mock;
	static {
		mock = new ArrayList<Question>();
		mock.add(new Question(1,"What experiences have you had with functional programming?"));
		mock.add(new Question(2,"Are you reasonably confident you can complete the assignment now?"));
		mock.add(new Question(3,"What other Java topics would you like to discuss this semester?"));
	}

  public static ArrayList<Question> questions;
  static {
    questions = new ArrayList<>();
    try {
      Statement statement = SqliteConnection.createStatement();
      ResultSet rs = statement.executeQuery("select * from Questions ORDER BY question_id ASC ;");

      int numbering = 1;
      while (rs.next()) {
        questions.add(new Question(rs.getInt("question_id"), rs.getString("question")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void newQuestion(Question question) {
    Connection conn = SqliteConnection.connect();
    try {
      assert conn != null;
      Statement statement = SqliteConnection.createStatement();
      statement.executeUpdate("INSERT INTO Questions (question) Values(\"" + question.question + "\")");

    } catch (SQLException e) {
      e.printStackTrace();
    }
    questions.add(question);
  }
}
