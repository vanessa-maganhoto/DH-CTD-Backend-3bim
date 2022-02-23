public class CardapioInfantil extends Cardapio{

    private String presenteSurpresa;
    private Double custoAdicional;

    public CardapioInfantil(Double precoBase, String produto, String presenteSurpresa, Double custoAdicional) {
        super(precoBase, produto);
        this.presenteSurpresa = presenteSurpresa;
        this.custoAdicional = custoAdicional;
    }


    @Override
    public void montar() {
        System.out.println("O produto " + getProduto() + " está pronto. Você ganhou um presente do Mc Lanche Feliz com o custo adicional de R$ " + this.custoAdicional + ". O total pago será de R$ " + calcPrecoVenda());
    }

    @Override
    public Double calcPrecoVenda() {
        return getPrecoBase() + this.custoAdicional;
    }

}
