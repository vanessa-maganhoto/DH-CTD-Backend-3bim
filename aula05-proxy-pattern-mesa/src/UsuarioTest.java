import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    public void fazerDownloadPremium(){
        Usuario us1 = new Usuario("2525", "Premium");
        Download download = new ServicoDownloadProxy();
        download.baixarMusica(us1.getId(), us1.getTipoUsuario());
        System.out.println(us1.toString());
    }

    @Test
    public void fazerDownloadFree(){
        Usuario us2 = new Usuario("3030", "free");
        Download download = new ServicoDownloadProxy();
        download.baixarMusica(us2.getId(), us2.getTipoUsuario());
        System.out.println(us2.toString());
    }



}