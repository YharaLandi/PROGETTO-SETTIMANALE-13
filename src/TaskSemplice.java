public class TaskSemplice extends Task {

    public TaskSemplice(String codice, String titolo, Priorita priorita, int durataMinuti) {
        super(codice, titolo, priorita, durataMinuti);
    }


    ///prova
    @Override
    public void completa() {
        setCompletato(true);
    }


}
