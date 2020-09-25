package alura.oo.aula2.teste;

import static alura.oo.ConstantesTestes.DELTA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.jupiter.api.Test;

import alura.oo.aula1.Orcamento;
import alura.oo.aula2.DescontoCompraCasada;
import alura.oo.aula2.DescontoMaisDeCincoItens;
import alura.oo.aula2.DescontoValorOrcamentoMaiorQuinhentos;
import alura.oo.aula2.Item;
import alura.oo.aula2.SemDesconto;

public class DescontoChainOfResponsibilityTeste{
   
   @Test
   public void deve_RetornarDezPorcentoDeDesconto_QuandoOrcamentoTemMaisDeCincoItens_ComDescontoEncadeado() {
      Orcamento orcamento = new Orcamento(400.0);
      orcamento.adiciona(new Item("A", 1.0));
      orcamento.adiciona(new Item("B", 1.0));
      orcamento.adiciona(new Item("C", 1.0));
      orcamento.adiciona(new Item("D", 1.0));
      orcamento.adiciona(new Item("E", 1.0));
      orcamento.adiciona(new Item("F", 1.0));
      
      DescontoMaisDeCincoItens descontoMaisDeCincoItens = new DescontoMaisDeCincoItens();
      descontoMaisDeCincoItens.setProximo(new DescontoCompraCasada());

      double desconto = descontoMaisDeCincoItens.desconto(orcamento);

      assertThat(desconto, is(closeTo(40.0, DELTA)));
   }
   
   @Test
   public void deve_RetornarSetePorcentoDeDesconto_QuandoOrcamentoMaiorQueQuinhentos_ComDescontoEncadeado() {
      Orcamento orcamento = new Orcamento(600.0);
      
      DescontoValorOrcamentoMaiorQuinhentos descontoValorOrcamentoMaiorQuinhentos = new DescontoValorOrcamentoMaiorQuinhentos();
      descontoValorOrcamentoMaiorQuinhentos.setProximo(new DescontoMaisDeCincoItens());

      double desconto = descontoValorOrcamentoMaiorQuinhentos.desconto(orcamento);

      assertThat(desconto, is(closeTo(42.0, DELTA)));
   }
   
   @Test
   public void deve_RetornarCincoPorcentoDeDesconto_QuandoLapisECanetaEstiveremPresentes_ComDescontoEncadeado() {
      Orcamento orcamento = new Orcamento(1000.0);
      orcamento.adiciona(new Item("LAPIS", 1.0));
      orcamento.adiciona(new Item("CANETA", 1.0));
      
      DescontoCompraCasada descontoCompraCasada = new DescontoCompraCasada();
      descontoCompraCasada.setProximo(new DescontoMaisDeCincoItens());

      double desconto = descontoCompraCasada.desconto(orcamento);

      assertThat(desconto, is(closeTo(50.0, DELTA)));
   }
   
   @Test
   public void deve_RetornarZeroPorcentoDeDesconto_QuandoSemDesconto_ComDescontoEncadeado() {
      Orcamento orcamento = new Orcamento(50.0);
            
      SemDesconto semDesconto = new SemDesconto();
      semDesconto.setProximo(new DescontoValorOrcamentoMaiorQuinhentos());

      double desconto = semDesconto.desconto(orcamento);

      assertThat(desconto, is(closeTo(0.0, DELTA)));
   }
   
   @Test
   public void deve_EntrarNoPrimeiroDesconto_RetornandoDezPorcento() {
      Orcamento orcamento = new Orcamento(1000.0);
      orcamento.adiciona(new Item("LAPIS", 1.0));
      orcamento.adiciona(new Item("CANETA", 1.0));
      orcamento.adiciona(new Item("A", 1.0));
      orcamento.adiciona(new Item("B", 1.0));
      orcamento.adiciona(new Item("C", 1.0));
      orcamento.adiciona(new Item("D", 1.0));
      orcamento.adiciona(new Item("E", 1.0));
      orcamento.adiciona(new Item("F", 1.0));
      
      DescontoMaisDeCincoItens d1 = new DescontoMaisDeCincoItens();
      DescontoValorOrcamentoMaiorQuinhentos d2 = new DescontoValorOrcamentoMaiorQuinhentos();
      DescontoCompraCasada d3 = new DescontoCompraCasada();
      
      d1.setProximo(d2);
      d2.setProximo(d3);
      
      double desconto = d1.desconto(orcamento);
      
      assertThat(desconto, is(closeTo(100.0, DELTA)));
   }
   
   @Test
   public void deve_EntrarNoSegundoDesconto_RetornandoSetePorcento() {
      Orcamento orcamento = new Orcamento(1000.0);
      orcamento.adiciona(new Item("LAPIS", 1.0));
      orcamento.adiciona(new Item("CANETA", 1.0));
      orcamento.adiciona(new Item("A", 1.0));
      orcamento.adiciona(new Item("B", 1.0));
      orcamento.adiciona(new Item("C", 1.0));
      orcamento.adiciona(new Item("D", 1.0));
      orcamento.adiciona(new Item("E", 1.0));
      orcamento.adiciona(new Item("F", 1.0));
      
      DescontoMaisDeCincoItens d1 = new DescontoMaisDeCincoItens();
      DescontoValorOrcamentoMaiorQuinhentos d2 = new DescontoValorOrcamentoMaiorQuinhentos();
      DescontoCompraCasada d3 = new DescontoCompraCasada();
      
      d2.setProximo(d1);
      d1.setProximo(d3);
      
      double desconto = d2.desconto(orcamento);
      
      assertThat(desconto, is(closeTo(70.0, DELTA)));
   }
   
   @Test
   public void deve_EntrarNoTerceiroDesconto_RetornandoCincoPorcento() {
      Orcamento orcamento = new Orcamento(1000.0);
      orcamento.adiciona(new Item("LAPIS", 1.0));
      orcamento.adiciona(new Item("CANETA", 1.0));
      orcamento.adiciona(new Item("A", 1.0));
      orcamento.adiciona(new Item("B", 1.0));
      orcamento.adiciona(new Item("C", 1.0));
      orcamento.adiciona(new Item("D", 1.0));
      orcamento.adiciona(new Item("E", 1.0));
      orcamento.adiciona(new Item("F", 1.0));
      
      DescontoMaisDeCincoItens d1 = new DescontoMaisDeCincoItens();
      DescontoValorOrcamentoMaiorQuinhentos d2 = new DescontoValorOrcamentoMaiorQuinhentos();
      DescontoCompraCasada d3 = new DescontoCompraCasada();
      
      d3.setProximo(d1);
      d1.setProximo(d2);
      
      double desconto = d3.desconto(orcamento);
      
      assertThat(desconto, is(closeTo(50.0, DELTA)));
   }

}
