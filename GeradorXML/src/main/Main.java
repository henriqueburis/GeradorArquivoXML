/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.InformacaoClient;

/**
 *
 * @author luiz.buris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Cliente> cliente = setCliente();

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Cliente", Cliente.class);

        String xml = xstream.toXML(cliente);

//        System.out.println(xml);
        gerarArquivoXML(xml);
        lerArquivoXML();

    }

    // método responsável por gera o arquivo
    public static void gerarArquivoXML(String xml) {

        PrintWriter print = null;
        try {

            File file = new File("C:\\Users\\Luiz Henrique Buris\\Documents\\NetBeansProjects\\arquivogerado.xml");
            print = new PrintWriter(file);
            print.write(xml);

            print.flush();
            print.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            print.close();
        }

    }

    // Método responsável por ler arquivo xml
    public static void lerArquivoXML() {
        try {

            FileReader ler = new FileReader("C:\\Users\\Luiz Henrique Buris\\Documents\\NetBeansProjects\\arquivogerado.xml");
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("Cliente", Cliente.class);
            List<Cliente> client = (List<Cliente>) xstream.fromXML(ler);

            for (Cliente cl : client) {
                System.out.println(cl.getNome());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Simular dados inserido no objeto
    private static List<Cliente> setCliente() {

        List<Cliente> lista = new ArrayList<>();
        Cliente c1 = new Cliente();
        InformacaoClient inf1 = new InformacaoClient();

        c1.setNome("Luiz Henrique Buris");
        c1.setEndereco("Rua Victal Alves de Feitas");
        inf1.setEmail("henrique@bol.com");
        inf1.setTelefone("1231533662");
        c1.setInfoClient(inf1);
        lista.add(c1);

        Cliente c2 = new Cliente();
        InformacaoClient inf2 = new InformacaoClient();
        c2.setNome("Simone Silva");
        c2.setEndereco("Nico Rosa");
        inf2.setEmail("simone@bol.com");
        inf2.setTelefone("1231533662");
        c2.setInfoClient(inf2);
        lista.add(c2);
 

        return lista;
    }

}
