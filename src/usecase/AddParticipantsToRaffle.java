package usecase;

import entity.Participant;
import entity.Raffle;
import usecase.port.ParticipantDS;
import usecase.port.ParticipantRepository;

public class AddParticipantsToRaffle {

  private final Raffle raffle;
  private final ParticipantRepository repo;
  
  public AddParticipantsToRaffle(Raffle r, ParticipantRepository rep) {
    raffle = r;
    repo = rep;
  }

  public void addParticipantsToRaffle() {
    for(ParticipantDS pd : repo.findAllParticipantsData()) {
      Participant p = new Participant(pd.email, pd.name, pd.score);
      raffle.addParticipant(p);
    }
  }

}
