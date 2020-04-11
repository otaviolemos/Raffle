package usecase.port;

import java.util.List;


public interface ParticipantRepository {
  
  public List<ParticipantDS> findAllParticipantsData();

}
