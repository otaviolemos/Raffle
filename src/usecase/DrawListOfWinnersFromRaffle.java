package usecase;

import java.util.ArrayList;
import java.util.List;

import entity.Participant;
import entity.Raffle;

public class DrawListOfWinnersFromRaffle {
  
  private final Raffle raffle;

  public DrawListOfWinnersFromRaffle(Raffle r) {
    raffle = r;
  }

  public List<Participant> drawListOfWinnersFromRaffle(int num) {
    List<Participant> winners = new ArrayList<Participant>();
    for(int i = 0; i < num; i++)
      winners.add(raffle.drawParticipant());
    return winners;
  }

}
