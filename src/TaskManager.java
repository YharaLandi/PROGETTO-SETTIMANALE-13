import entities.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import exception.*;
//CRUD
public class TaskManager {
    private List<Task> taskRepo = new ArrayList<>();

    //Aggiungi
    public void aggiungiTask(Task task) {
        boolean esiste = taskRepo.stream().anyMatch(t -> t.getCodice().equals(task.getCodice()));
        if (esiste) {
            throw new NonDuplicareException("Task con codice già esistente: " + task.getCodice());
        }
        taskRepo.add(task);
    }

    //CERCARE COD
    public Task cercaPerCodice(String codice) {
        return taskRepo.stream()
                .filter(t -> t.getCodice().equals(codice))
                .findFirst()
                .orElseThrow(() -> new TaskNonTrovataException("Task non trovata: " + codice));
    }

    //CERCA PRIORIT
    public List<Task> cercaPerPriorita(Task.Priorita priorita) {
        return taskRepo.stream()
                .filter(t -> t.getPriorita().equals(priorita))
                .collect(Collectors.toList());
    }

    //RIMUOVI
    public void rimuoviTask(String codice) {
        Task task = cercaPerCodice(codice);
        taskRepo.remove(task);
    }

    //Ceck completa
    public void completaTask(String codice) {
        cercaPerCodice(codice).completa();
    }

    //Stampa
    public void stampaStatistiche() {
        long completati = taskRepo.stream().filter(Task::isCompletato).count();
        long daFare = taskRepo.size() - completati;
        System.out.println("Completati: " + completati + " | Da fare: " + daFare);
    }
}