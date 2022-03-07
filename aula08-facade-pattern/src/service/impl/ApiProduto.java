package service.impl;

import model.Cartao;
import model.Produto;

public class ApiProduto {

    public int desconto(Produto produto){
        if(produto.getTipo().compareTo("Lata") == 0 ){
            return 20;

        } else{
            return 0;
        }
    }
}
