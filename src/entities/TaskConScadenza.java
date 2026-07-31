package entities;

import exception.ScadenzaPassataException;

import java.time.LocalDate;

public class TaskConScadenza extends Task {
    private LocalDate dataScadenza;

    public TaskConScadenza(String codice, String titolo, Priorita priorita, int durataMinuti, LocalDate dataScadenza) {
        super(codice, titolo, priorita, durataMinuti);
        if (dataScadenza.isBefore(LocalDate.now())) {

            throw new ScadenzaPassataException("La data di scadenza è già passata: " + dataScadenza);
        }
        this.dataScadenza = dataScadenza;
    }

    @Override
    public void completa() {
        setCompletato(true);
    }

    //getter

    public boolean isScaduto() {
        return LocalDate.now().isAfter(dataScadenza);
    }
    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public String toString() {
        return "TaskConScadenza{" +
                "dataScadenza=" + dataScadenza +
                '}';
    }
}
