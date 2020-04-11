package usecase;

import entity.Raffle;

public class CreateRaffle {

  public Raffle createRaffle(int minScore) {
    return new Raffle(minScore);
  }

}
