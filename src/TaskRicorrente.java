public class TaskRicorrente extends Task {
    private int frequenzaGiorni;
    private int volteCompletato;

    public TaskRicorrente(String codice, String titolo, Priorita priorita, int durataMinuti, int frequenzaGiorni) {
        super(codice, titolo, priorita, durataMinuti);
        if (frequenzaGiorni <= 0) {
            throw new FrequenzaNonValidaException("La frequenza deve essere maggiore di zero: " + frequenzaGiorni);
        }
        this.frequenzaGiorni = frequenzaGiorni;
        this.volteCompletato = 0;
    }

    @Override
    public void completa() {
        volteCompletato++;
    }

    // getter e setter
    public int getFrequenzaGiorni() {
        return frequenzaGiorni;
    }

    public int getVolteCompletato() {
        return volteCompletato;
    }
}
