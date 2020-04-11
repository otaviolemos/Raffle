package usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import adapter.repository.InMemoryParticipantRepository;
import entity.Raffle;
import usecase.port.ParticipantDS;
import usecase.port.ParticipantRepository;

class AddParticipantsToRaffleTest {

  @Test
  void testAddParticipantsToRaffle() {
    ParticipantDS p1 = new ParticipantDS("o@mail.com", "otavio", 10);
    ParticipantDS p2 = new ParticipantDS("j@mail.com", "julio", 7);
    ParticipantDS p3 = new ParticipantDS("m@mail.com", "marco", 8);
    List<ParticipantDS> lp = new ArrayList<ParticipantDS>();
    lp.add(p1);
    lp.add(p2);
    lp.add(p3);
    Raffle r = new CreateRaffle().createRaffle(8);
    ParticipantRepository pr = new InMemoryParticipantRepository(lp);
    AddParticipantsToRaffle aptr = new AddParticipantsToRaffle(r,pr);
    aptr.addParticipantsToRaffle();
    assertThat(r.getParticipants().get(0).getName(), equalTo("otavio"));
    assertThat(r.getParticipants().get(1).getName(), equalTo("marco"));
  }

}
