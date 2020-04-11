package usecase;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import entity.Raffle;

class CreateRaffleTest {

  @Test
  void createRaffleWithMinScore8() {
    CreateRaffle cr = new CreateRaffle();
    Raffle r = cr.createRaffle(8);
    assertThat(r.getMinScore(), is(8));
  }

}
