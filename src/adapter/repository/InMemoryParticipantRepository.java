package adapter.repository;

import java.util.ArrayList;
import java.util.List;

import usecase.port.ParticipantRepository;
import usecase.port.ParticipantDS;

public class InMemoryParticipantRepository implements ParticipantRepository {

  List<ParticipantDS> participants = new ArrayList<ParticipantDS>();
  
  public InMemoryParticipantRepository(List<ParticipantDS> lp) {
    participants.addAll(lp);
  }
  
  @Override
  public List<ParticipantDS> findAllParticipantsData() {
    return participants;
  }

}
