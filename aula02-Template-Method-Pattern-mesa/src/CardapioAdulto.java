public class CardapioAdulto extends Cardapio{

    public CardapioAdulto(Double precoBase, String produto) {
        super(precoBase, produto);
    }

    @Override
    public void montar() {
        System.out.println("O produto " + getProduto() + " está pronto. O total pago será de R$ " + calcPrecoVenda());
    }

    @Override
    public Double calcPrecoVenda() {
        return getPrecoBase();
    }


}
