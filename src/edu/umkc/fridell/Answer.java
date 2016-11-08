package edu.umkc.fridell;

public class Answer {
  public String answer;
  public int id;
  public int questionId;
  public Answer(int id, int questionId, String answer) {
    this.answer = answer;
    this.questionId = questionId;
    this.id = id;
  }
}
