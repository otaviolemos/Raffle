package main;

import java.io.IOException;

import java.util.List;

import adapter.repository.CsvParticipantRepository;
import entity.Participant;
import entity.Raffle;
import usecase.AddParticipantsToRaffle;
import usecase.CreateRaffle;
import usecase.DrawListOfWinnersFromRaffle;

public class Main {

  public static void main(String[] args) throws IOException {
    CsvParticipantRepository repo = new CsvParticipantRepository("sorteio.csv");
    Raffle raffle = new CreateRaffle().createRaffle(8);
    AddParticipantsToRaffle apr = new AddParticipantsToRaffle(raffle, repo);
    apr.addParticipantsToRaffle();
    DrawListOfWinnersFromRaffle draw = new DrawListOfWinnersFromRaffle(raffle);
    List<Participant> winners = draw.drawListOfWinnersFromRaffle(10);
    int i = 1;
    for(Participant p : winners) {
      System.out.println(i++);
      System.out.println("Nome: " + p.getName());
      System.out.println("Email: " + p.getEmail());
      System.out.println("Score: " + p.getScore());
      System.out.println("=======================");
    }
  }
  
}
