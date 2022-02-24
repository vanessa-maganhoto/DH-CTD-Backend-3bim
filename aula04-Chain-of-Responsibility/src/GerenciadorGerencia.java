public class GerenciadorGerencia extends Gerenciador {

    @Override
    public void verficar(Mail email) {
        if((email.getDestino().equalsIgnoreCase("gerência@colmeia.com")) || (email.getAssunto().equalsIgnoreCase("Gerência"))){
            System.out.println("Enviado ao departamento da Gerência");
        } else {
            if(this.getSeguinte() != null){
                this.getSeguinte().verficar(email);
            }
        }
    }
}
