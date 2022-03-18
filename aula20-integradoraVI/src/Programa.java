import model.Empresa;
import model.Funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    public static void main(String[] args) throws IOException {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        Funcionario f1 = new Funcionario("Mario", "Brandão", "xxxx", 3.200);
        Funcionario f2 = new Funcionario("Marcelo", "Boda", "aaa", 1.500);
        Funcionario f3 = new Funcionario("Matheus", "Alves", "yyyy", 6.540);
        Funcionario f4 = new Funcionario("Miguel", "Santos", "fff", 5.980);

        listaFuncionarios.add(f1);
        listaFuncionarios.add(f2);
        listaFuncionarios.add(f3);
        listaFuncionarios.add(f4);

        //System.out.println(listaFuncionarios);

        Empresa e1 = new Empresa("65656565", "AAAAA", listaFuncionarios);

        //metodo1(e1);
        metodo2(e1);



    }

    private static void metodo2(Empresa e1) throws IOException {
        String caminho = "empregados.txt";

        try(BufferedWriter arqLista = new BufferedWriter(new FileWriter(caminho))){
            for( Funcionario f : e1.getFuncionarios()){
                String s = String.format("%s;%s;%s;%s", f.getNome(), f.getSobrenome(), f.getDocumentoIdentificacao(), f.getSalario());
                arqLista.write(s);
                arqLista.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho));
        String linha = null;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        while((linha=bufferedReader.readLine()) != null){
            String[] split = linha.split(";");
            Funcionario funcionario = new Funcionario(split[0], split[1], split[2], Double.valueOf(split[3]));
            funcionarios.add(funcionario);
        }
        System.out.println(funcionarios);
    }

    private static void metodo1(Empresa e1) throws IOException {
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("listaFuncionarios.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(e1);
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream("listaFuncionarios.txt");
            objectinputstream = new ObjectInputStream(streamIn);
            Empresa readCase = (Empresa) objectinputstream.readObject();
            System.out.println("Objeto lido do arquivo");
            System.out.println(readCase);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(objectinputstream != null){
                objectinputstream.close();
            }
        }
    }

}
