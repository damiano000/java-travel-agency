import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continua = true;
        while (continua) {
            try {
                System.out.print("Vuoi inserire una nuova vacanza? (Y/n): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("n")) {
                    continua = false;
                } else if (input.equalsIgnoreCase("y")) {
                    System.out.print("Inserisci la destinazione: ");
                    String destinazione = scanner.nextLine();

                    System.out.println("inserire la data di inzio della vacanza :(ES:yyyy-MM-gg) ");
                    LocalDate dataInizio = LocalDate.parse(scanner.nextLine());

                    System.out.println("inserire la data della fine della vacanza :(ES:yyyy-MM-gg)");
                    LocalDate dataFine = LocalDate.parse(scanner.nextLine());

                    Vacanza vacanza = new Vacanza(destinazione, dataInizio, dataFine);
                    System.out.println("Hai prenotato una vacanza di " + vacanza.duration() + " giorni a " +
                            vacanza.getDestinazione() + " dal " + vacanza.getDataInizio() + " al " + vacanza.getDataFine());
                } else {
                    System.out.println("Comando non valido. Riprova.");
                }
            } catch (RuntimeException e) {
                System.out.println("Errore durante la prenotazione: " + e.getMessage());
            }
        }

        scanner.close();
    }
}