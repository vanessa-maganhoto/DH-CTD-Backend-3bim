public class GerenciadorTecnica extends Gerenciador {

    @Override
    public void verficar(Mail email) {
        if((email.getDestino().equalsIgnoreCase("tecnica@colmeia.com")) || (email.getAssunto().equalsIgnoreCase("Técnica"))){
            System.out.println("Enviado ao departamento da Técnica");
        } else {
            if(this.getSeguinte() != null){
                this.getSeguinte().verficar(email);
            }
        }
    }
}
