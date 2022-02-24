public class CheckMail {

    Gerenciador inicial;

    public CheckMail(){
        this.inicial = new GerenciadorGerencia();
        Gerenciador tecnica = new GerenciadorTecnica();
        Gerenciador comercial = new GerenciadorComercial();
        Gerenciador spam = new GerenciadorSpam();

        inicial.setSeguinte(comercial);
        comercial.setSeguinte(tecnica);
        tecnica.setSeguinte(spam);
    }

    public void verificar(Mail email){
        inicial.verficar(email);
    }

}
