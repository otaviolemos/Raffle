package usecase.port;

public class ParticipantDS {
  
  public String email = "";
  public String name = "";
  public int score;

  public ParticipantDS(String e, String n, int sc) {
    email = e;
    name = n;
    score = sc;
  }
  
}
