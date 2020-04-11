package adapter.repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import usecase.port.ParticipantRepository;
import usecase.port.ParticipantDS;

public class CsvParticipantRepository implements ParticipantRepository {

  private List<ParticipantDS> lp = new ArrayList<ParticipantDS>();
  
  public CsvParticipantRepository(String string) throws IOException {
    Reader in = new FileReader(string);
    Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader().withDelimiter(',').parse(in);
    for (CSVRecord record : records) {
        String email = record.get("email").trim();
        String name = record.get("Nome").trim();
        String scorestr = record.get("score");
        int score = Integer.parseInt(scorestr.substring(0, scorestr.indexOf("/")).trim());
        ParticipantDS pd = new ParticipantDS(email, name, score);
        lp.add(pd);
    }
  }

  @Override
  public List<ParticipantDS> findAllParticipantsData() {
    return lp;
  }

}
