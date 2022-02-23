public class CardapioVegetariano extends Cardapio{

    private Integer quantTempero;
    private final Double SOBRETAXA = 0.01;

    public CardapioVegetariano(Double precoBase, String produto, Integer quantTempero) {
        super(precoBase, produto);
        this.quantTempero = quantTempero;
    }

    @Override
    public void montar() {
        System.out.println("O produto " + getProduto() + " está pronto. Foram adicionados "+ this.quantTempero+ " temperos. O valor adicional a ser pago é  R$ " + (quantTempero * SOBRETAXA)+ ". Valor total R$ " + calcPrecoVenda());
    }
    @Override
    public Double calcPrecoVenda(){
        return getPrecoBase() + (quantTempero * SOBRETAXA);
    }
}
