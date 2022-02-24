public abstract class Gerenciador {

    protected Gerenciador gerenciadorSeguinte;
    public Gerenciador getSeguinte(){
        return this.gerenciadorSeguinte;
    }

    public void setSeguinte(Gerenciador g){
        this.gerenciadorSeguinte = g;
    }

    public abstract void verficar(Mail mail);

}
