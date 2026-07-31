import entities.*;
import exception.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // TaskSemplice
        TaskSemplice ts = new TaskSemplice("T001", "Fare la spesa", Task.Priorita.BASSA, 30);
        //TaskConScadenza
        TaskConScadenza tcs = new TaskConScadenza("T002", "Consegnare relazione", Task.Priorita.ALTA, 60, LocalDate.now().plusDays(5));
        // TaskRicorrente
        TaskRicorrente tr = new TaskRicorrente("T003", "Allenarsi", Task.Priorita.MEDIA, 45, 2);
        System.out.println("array da qui");
        //ARRAY
        List<Task> tasks = new ArrayList<>(Arrays.asList(ts, tcs, tr));


        for (Task t : tasks) {
            System.out.println(t.toString());
        }
        System.out.println("eccezioni da qui");
        //Test eccezioni
        try {
            new TaskSemplice("T004", "Task invalida", Task.Priorita.BASSA, -10);
        } catch (DurataNonValidaException e) {
            System.out.println("DurataNonValida: " + e.getMessage());
        }

        try {
            new TaskRicorrente("T005", "Task invalida", Task.Priorita.MEDIA, 30, 0);
        } catch (FrequenzaNonValidaException e) {
            System.out.println("FrequenzaNonValida: " + e.getMessage());
        }

        try {
            new TaskConScadenza("T006", "Task scaduta", Task.Priorita.ALTA, 20, LocalDate.now().minusDays(1));
        } catch (ScadenzaPassataException e) {
            System.out.println("ScadenzaPassata: " + e.getMessage());
        }




        // Controlli del TaskManager
        TaskManager tm = new TaskManager();
        tm.aggiungiTask(ts);
        tm.aggiungiTask(tcs);
        tm.aggiungiTask(tr);


        // cerca per codice
        System.out.println(tm.cercaPerCodice("T001"));


        // cerca per priorità
        tm.cercaPerPriorita(Task.Priorita.ALTA).forEach(System.out::println);


        // completa e rimuovi
        tm.completaTask("T001");
        tm.rimuoviTask("T002");


        // statistiche
        tm.stampaStatistiche();


        // codice duplicato
        try {
            tm.aggiungiTask(ts);
        } catch (NonDuplicareException e) {
            System.out.println("Duplicato: " + e.getMessage());
        }


        // task non trovata
        try {
            tm.cercaPerCodice("T999");
        } catch (TaskNonTrovataException e) {
            System.out.println("Non trovata: " + e.getMessage());
        }
    }
}
