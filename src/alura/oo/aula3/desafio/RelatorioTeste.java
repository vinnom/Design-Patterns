package alura.oo.aula3.desafio;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RelatorioTeste{

   @Test
   public void deve_RetornarRelatorioSimples(){
      Conta c1 = new Conta("titular1", "0001", "123456");
      Conta c2 = new Conta("titular2", "0001", "456789");

      c1.deposita(100.0);
      c2.deposita(200.0);

      ArrayList<Conta> contas = new ArrayList<>(asList(c1, c2));

      String relatorioReal = new RelatorioSimples().imprime(contas);

      StringBuilder sb = new StringBuilder();
      sb.append("Banco\n\n"); // cabecalho
      for(Conta conta : contas){ // corpo
         sb.append(conta.getTitular());
         sb.append("\n");
         sb.append(conta.getSaldo());
         sb.append("\n");
      }
      sb.append("\n").append("(99)98765-4321\n"); // rodape
      String relatorioEsperado = sb.toString();

      assertThat(relatorioEsperado, is(equalTo(relatorioReal)));
   }

   @Test
   public void deve_RetornarRelatorioComplexo(){
      Conta c1 = new Conta("titular1", "0001", "123456");
      Conta c2 = new Conta("titular2", "0001", "456789");

      c1.deposita(100.0);
      c2.deposita(200.0);

      ArrayList<Conta> contas = new ArrayList<>(asList(c1, c2));

      RelatorioComplexo relatorioComplexo = new RelatorioComplexo();
      String relatorioReal = relatorioComplexo.imprime(contas);

      StringBuilder sb = new StringBuilder();
      sb.append("Banco\n").append("Rua rua numero 99\n").append("(99)98765-4321\n\n"); // cabecalho
      for(Conta conta : contas){
         sb.append(conta.getTitular());
         sb.append("\n");
         sb.append(conta.getAgencia());
         sb.append("\n");
         sb.append(conta.getNumero());
         sb.append("\n");
         sb.append(conta.getSaldo());
         sb.append("\n");
      }
      sb.append("\n").append("email@email.com.br").append("\n").append(relatorioComplexo.getData()); // rodape
      String relatorioEsperado = sb.toString();

      assertThat(relatorioEsperado, is(equalTo(relatorioReal)));
   }

}
