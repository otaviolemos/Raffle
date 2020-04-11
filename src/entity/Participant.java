package entity;

public class Participant {
  
  private String email;
  private String name;
  private int score;
  
  public Participant(String em, String nom, int s) {
    email = em;
    name = nom;
    score = s;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

}
