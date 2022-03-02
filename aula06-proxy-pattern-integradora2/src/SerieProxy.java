public class SerieProxy implements ISerie{

    private Integer qtdViews =0;
    private Serie serie = new Serie();
    public static final int MAX_VIEWS =5;

    @Override
    public String getSerie(String nome) {
        if(qtdViews >=MAX_VIEWS){
            throw new SerieNaoHabilitadaException();
        }
        this.qtdViews++;
        return serie.getSerie(nome);
    }
}
