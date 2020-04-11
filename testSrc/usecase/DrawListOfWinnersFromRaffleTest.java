package usecase;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import adapter.repository.InMemoryParticipantRepository;

import entity.Participant;
import entity.Raffle;
import usecase.port.ParticipantDS;
import usecase.port.ParticipantRepository;

class DrawListOfWinnersFromRaffleTest {

  @Test
  void testDrawListOfWinnersFromRaffle() {
    Raffle r = new CreateRaffle().createRaffle(8);
    ParticipantDS p1 = new ParticipantDS("o@mail.com", "otavio", 10);
    ParticipantDS p2 = new ParticipantDS("j@mail.com", "julio", 7);
    ParticipantDS p3 = new ParticipantDS("m@mail.com", "marco", 8);
    List<ParticipantDS> lp = new ArrayList<ParticipantDS>();
    lp.add(p1);
    lp.add(p2);
    lp.add(p3);
    ParticipantRepository pr = new InMemoryParticipantRepository(lp);
    AddParticipantsToRaffle aptr = new AddParticipantsToRaffle(r,pr);
    aptr.addParticipantsToRaffle();
    DrawListOfWinnersFromRaffle dlowfr = 
        new DrawListOfWinnersFromRaffle(r);
    List<Participant> winners = dlowfr.drawListOfWinnersFromRaffle(1);
    assertTrue(winners.get(0).getName().equals(p1.name) || 
        winners.get(0).getName().equals(p3.name));
  }

}
