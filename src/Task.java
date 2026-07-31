public abstract class Task {
    private String codice;
    private String titolo;
    private Priorita priorita;
    private int durataMinuti;
    private boolean completato;

    // Costruttore comune: anche se Task è astratta e non si può istanziare direttamente,
    // questo costruttore viene richiamato da ogni sottoclasse tramite super(...)
    // per inizializzare i campi condivisi e validare la durata una sola volta per tutte
    public Task(String codice, String titolo, Priorita priorita, int durataMinuti) {
        if (durataMinuti <= 0) {
            throw new DurataNonValidaException("La durata deve essere maggiore di zero: " + durataMinuti);
        }
        this.codice = codice;
        this.titolo = titolo;
        this.priorita = priorita;
        this.durataMinuti = durataMinuti;
        this.completato = false;
    }

    public abstract void completa();

    //enum, per evitare l'introduzione di valori diversi
    public enum Priorita {
        BASSA, MEDIA, ALTA
    }

    // getter e setter
    public boolean isCompletato() {
        return completato;
    }

    public void setCompletato(boolean completato) {
        this.completato = completato;
    }

    public String getCodice() {
        return codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public Priorita getPriorita() {
        return priorita;
    }

    public int getDurataMinuti() {
        return durataMinuti;
    }
}