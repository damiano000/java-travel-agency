import java.time.LocalDate;
import java.time.Period;

public class Vacanza {

    // ATTRIBUTI
    private String destinazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;


    // COSTRUTTORI
    public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine) throws RuntimeException {
        // Validazione dei parametri
        if (destinazione == null || destinazione.isEmpty()){

            throw new RuntimeException("Destinazione non può essere nullo!");
        }

        if ( dataInizio==null || dataInizio.isBefore(LocalDate.now())) {
            throw new RuntimeException("La data di inizio è già passata!");
        }

        if (dataFine==null || dataFine.isBefore(dataInizio)) {
            throw new RuntimeException("La data di fine non può essere prima della data di inizio!");
        }

        this.destinazione = destinazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    // GET AND SET
    public String getDestinazione() {
        return destinazione;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    // METODI
  public int duration(){
      Period giorniVacanza = Period.between(dataInizio , dataFine);
      return giorniVacanza.getDays();
  }
}
