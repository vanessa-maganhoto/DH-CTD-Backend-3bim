import model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();

        Contato c1 = new Contato("Teresa", "teresa@gmail.com", "5555555");
        Contato c2 = new Contato("Cristina", "cristina@gmail.com", "222222");
        Contato c3 = new Contato("Antonio", "antonio@gmail.com", "333333");
        Contato c4 = new Contato("Matias", "matias@gmail.com", "999999");
        Contato c5 = new Contato("Nina", "nina@gmail.com", "4444444");
        Contato c6 = new Contato("Ana", "ana@gmail.com", "88888888");

        contatos.add(c1);
        contatos.add(c2);
        contatos.add(c3);
        contatos.add(c4);
        contatos.add(c5);
        contatos.add(c6);

        //Salva a lista em um arquivo
        FileOutputStream arq1 = null;

        try{
            arq1 = new FileOutputStream("lista1.txt");
            ObjectOutputStream a1 = new ObjectOutputStream(arq1);
            a1.writeObject(contatos);
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //Imprime a lista salva
        List<Contato> retornaListaContatos = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("lista1.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            retornaListaContatos = (ArrayList)ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for(Contato c: retornaListaContatos){
            System.out.println(
                    c.getNome()
                    + " | " + c.getEmail()
                    + " | " + c.getTelefone()
            );
        }

    }
}
