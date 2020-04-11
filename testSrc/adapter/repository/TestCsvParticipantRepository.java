package adapter.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import java.util.List;

import entity.Participant;
import usecase.port.ParticipantDS;

class TestCsvParticipantRepository {

  @Test
  void testCsvPR() throws IOException {
    String participantsCsv = "email,score,Nome\r\notaviolemos@gmail.com, 10 / 10, otavio\r\njuliolemos@gmail.com, 7 / 10, julio";
    Writer out = new FileWriter("test.csv");
    out.append(participantsCsv);
    out.close();
    CsvParticipantRepository cpr = new CsvParticipantRepository("test.csv");
    List<ParticipantDS> lp = cpr.findAllParticipantsData();
    ParticipantDS p1 = lp.get(0);
    ParticipantDS p2 = lp.get(1);
    assertThat(p1.email, equalTo("otaviolemos@gmail.com"));
    assertThat(p1.name, equalTo("otavio"));
    assertThat(p1.score, is(10));
    assertThat(p2.email, equalTo("juliolemos@gmail.com"));
    assertThat(p2.name, equalTo("julio"));
    assertThat(p2.score, is(7));
    File f = new File("test.csv");
    f.delete();
  }

}
