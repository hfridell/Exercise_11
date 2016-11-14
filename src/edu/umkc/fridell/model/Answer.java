package edu.umkc.fridell.model;

public class Answer {
  public final String answer;
  public final int id;
  public final int questionId;
  public Answer(int id, int questionId, String answer) {
    this.answer = answer;
    this.questionId = questionId;
    this.id = id;
  }
}
