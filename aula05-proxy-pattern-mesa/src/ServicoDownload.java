public class ServicoDownload implements Download{



    @Override
    public void baixarMusica(String id, String tipoUsuario) {
        System.out.println("O usuário de identificação " + id + " tem permissão para realizar o download");
    }
}
