package entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import entity.Participant;
import entity.Raffle;

class RaffleTest {
  
  Raffle r = new Raffle(8);
  
  @Test
  void testRaffleAddWithMoreThanMinScore() {
    Participant p1 = new Participant("o@mail.com", "otavio", 10);
    r.addParticipant(p1);
    assertTrue(r.getParticipants().contains(p1));
  }
  
  @Test
  void testRaffleDontAddWithLessThanMinScore() {
    Participant p1 = new Participant("j@mail.com", "julio", 7);
    r.addParticipant(p1);
    assertFalse(r.getParticipants().contains(p1));
  }
  
  @Test
  void testDrawParticipant() {
    Participant p1 = new Participant("o@mail.com", "otavio", 10);
    Participant p2 = new Participant("j@mail.com", "julio", 7);
    Participant p3 = new Participant("m@mail.com", "marco", 8);
    List<Participant> lp = new ArrayList<Participant>();
    lp.add(p1);
    lp.add(p2);
    lp.add(p3);
    r.addParticipants(lp);
    Participant p = r.drawParticipant();
    assertThat(p, anyOf(equalTo(p1), equalTo(p3)));
    assertFalse(r.getParticipants().contains(p));
  }

}
