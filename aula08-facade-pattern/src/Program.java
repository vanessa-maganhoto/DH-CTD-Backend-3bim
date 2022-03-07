import model.Cartao;
import model.Produto;
import service.impl.FacadeDesconto;

public class Program {

    public static void main(String[] args) {
        FacadeDesconto facade = new FacadeDesconto();
        Cartao cartao = new Cartao("332255", "Star Bank");
        Produto produto = new Produto("Lasanha", "Lata");
        System.out.println("Desconto concedido: " + facade.desconto(cartao, produto, 15));
    }

}
