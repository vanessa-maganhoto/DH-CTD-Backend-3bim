public abstract class Cardapio {
    private Double precoBase;
    private String produto;

    public Cardapio(Double precoBase, String produto) {
        this.precoBase = precoBase;
        this.produto = produto;
    }

    public String getProduto() {
        return produto;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public Double preparacao(){
        montar();
        return calcPrecoVenda();
    }

    public abstract void montar();
    public Double calcPrecoVenda(){
        return precoBase;
    }

}

/*
* Mesa 2:
*
* */
