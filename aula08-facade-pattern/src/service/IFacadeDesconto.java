package service;

import model.Cartao;
import model.Produto;

public interface IFacadeDesconto {

    public int desconto(Cartao cartao, Produto produto, int quantidade);

}
