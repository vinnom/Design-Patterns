package alura.oo.aula2.desafio.teste;

import alura.oo.aula2.desafio.Conta;
import alura.oo.aula2.desafio.Formato;
import alura.oo.aula2.desafio.Impressora;
import alura.oo.aula2.desafio.ImprimeCSV;
import alura.oo.aula2.desafio.ImprimePorcento;
import alura.oo.aula2.desafio.ImprimeXML;
import alura.oo.aula2.desafio.Requisicao;

public class ProConsoleTeste{

   public static void main(String[] args){
      final ImprimeXML xml = new ImprimeXML();
      final ImprimeCSV csv = new ImprimeCSV();
      final ImprimePorcento porcento = new ImprimePorcento();
      final Conta conta = new Conta("teste", 100.0);
      
      xml.setProxima(csv);
      csv.setProxima(porcento);
      
      imprimeEm(xml, new Requisicao(Formato.XML), conta);
      System.out.println();
      
      imprimeEm(xml, new Requisicao(Formato.CSV), conta);
      System.out.println();
      
      imprimeEm(xml, new Requisicao(Formato.PORCENTO), conta);
      System.out.println();
      
   }

   private static void imprimeEm(Impressora impressora, Requisicao requisicao, Conta conta){ 
      System.out.println(impressora.imprime(requisicao, conta));
    }

}
