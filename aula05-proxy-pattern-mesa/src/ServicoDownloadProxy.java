public class ServicoDownloadProxy implements Download{


    @Override
    public void baixarMusica(String id, String tipoUsuario) {
        if(tipoUsuario.equalsIgnoreCase("premium")){
            ServicoDownload servicoDownload = new ServicoDownload();
            servicoDownload.baixarMusica(id,tipoUsuario);
            System.out.println("Tem permissão para baixar música");
        } else {
            System.out.println("Usuário sem permissão para baixar música.");
        }
    }
}
