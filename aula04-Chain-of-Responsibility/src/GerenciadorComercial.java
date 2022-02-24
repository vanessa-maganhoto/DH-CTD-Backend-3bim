public class GerenciadorComercial extends Gerenciador {

    @Override
    public void verficar(Mail email) {
        if((email.getDestino().equalsIgnoreCase("comercial@colmeia.com")) || (email.getAssunto().equalsIgnoreCase("Comercial"))){
            System.out.println("Enviado ao departamento comercial");
        } else {
            if(this.getSeguinte() != null){
                this.getSeguinte().verficar(email);
            }
        }
    }
}
