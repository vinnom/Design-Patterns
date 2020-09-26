package alura.oo.aula2.desafio.teste;

import static alura.oo.aula2.desafio.Formato.CSV;
import static alura.oo.aula2.desafio.Formato.PORCENTO;
import static alura.oo.aula2.desafio.Formato.XML;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import alura.oo.aula2.desafio.Conta;
import alura.oo.aula2.desafio.ImprimeCSV;
import alura.oo.aula2.desafio.ImprimePorcento;
import alura.oo.aula2.desafio.ImprimeXML;
import alura.oo.aula2.desafio.Requisicao;

public class ImpressoraTeste{
   
   private final StringBuilder sb = new StringBuilder();
   private final ImprimeXML xml = new ImprimeXML();
   private final ImprimeCSV csv = new ImprimeCSV();
   private final ImprimePorcento porcento = new ImprimePorcento();
   private final Conta conta = new Conta("teste", 100.0);
   
   @Test
   public void deve_ImprimirContaNoFormatoXML() {
      xml.setProxima(csv);
      csv.setProxima(porcento);
      
      String impressa = xml.imprime(new Requisicao(XML), conta);
            
      sb.append("<titular>");
      sb.append(conta.getTitular());
      sb.append("</titular>\n");
      sb.append("<saldo>");
      sb.append(conta.getSaldo());
      sb.append("</saldo>\n");
      
      assertThat(impressa, is(equalTo(sb.toString())));
   }
   
   @Test
   public void deve_ImprimirContaNoFormatoCSV() {
      xml.setProxima(csv);
      csv.setProxima(porcento);
      
      String impressa = xml.imprime(new Requisicao(CSV), conta);
            
      sb.append("titular;saldo\n");
      sb.append(conta.getTitular());
      sb.append(";");
      sb.append(conta.getSaldo());
      sb.append("\n");
      
      assertThat(impressa, is(equalTo(sb.toString())));
   }
   
   @Test
   public void deve_ImprimirContaNoFormatoPorcento() {
      xml.setProxima(csv);
      csv.setProxima(porcento);
      
      String impressa = xml.imprime(new Requisicao(PORCENTO), conta);
            
      sb.append("%");
      sb.append(conta.getTitular());
      sb.append("%\n");
      sb.append("%");
      sb.append(conta.getSaldo());
      sb.append("%\n");
      
      assertThat(impressa, is(equalTo(sb.toString())));
   }
}
