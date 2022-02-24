public class Programa {
    public static void main(String[] args) {

        CheckMail verificaMail = new CheckMail();
        verificaMail.verificar(new Mail("email@email.com", "tecnica@colmeia.com", "Reclamação"));

        verificaMail.verificar(new Mail("email@email.com", "sdsa@colmeia.com", "Gerência"));
        verificaMail.verificar(new Mail("email@email.com", "quaqua@dh.com", "Comecial"));

    }
}
