public class SerieNaoHabilitadaException extends RuntimeException{

    public SerieNaoHabilitadaException() {
        super("Excede o número de reproduções permitidas");
    }


}
