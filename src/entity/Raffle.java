package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Raffle {
  
  private List<Participant> participants = new ArrayList<Participant>();
  private int minScore;
  
  public Raffle(int minS) {
    minScore = minS;
  }
  
  public List<Participant> getParticipants() {
    return new ArrayList<Participant>(participants);
  }

  public void addParticipant(Participant p) {
    if(p.getScore() >= minScore)
      participants.add(p);
  }
 
  public Participant drawParticipant() {
    Random random = new Random();
    Participant p = participants.get(random.nextInt(participants.size()));
    participants.remove(p);
    return p;
  }

  public void setMinScore(int s) {
    minScore = s;
  }

  public void addParticipants(List<Participant> lp) {
    for(Participant p : lp)
      addParticipant(p);
  }

  public int getMinScore() {
    return minScore;
  }
}
