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

public class DescontoTeste{

   @Test
   public void deve_RetornarZeroPorcentoDeDesconto_QuandoUsadoOSemDesconto(){
      Orcamento orcamento = new Orcamento(400.0);
      orcamento.adiciona(new Item("LAPIS", 50.0));

      double desconto = new SemDesconto().desconto(orcamento);

      assertThat(desconto, is(closeTo(0.0, DELTA)));
   }

   @Test
   public void deve_RetornarDezPorcentoDeDesconto_QuandoTemMaisDeCincoItens(){
      Orcamento orcamento = new Orcamento(400.0);
      orcamento.adiciona(new Item("A", 1.0));
      orcamento.adiciona(new Item("B", 1.0));
      orcamento.adiciona(new Item("C", 1.0));
      orcamento.adiciona(new Item("D", 1.0));
      orcamento.adiciona(new Item("E", 1.0));
      orcamento.adiciona(new Item("F", 1.0));

      double desconto = new DescontoMaisDeCincoItens().desconto(orcamento);

      assertThat(desconto, is(closeTo(40.0, DELTA)));
   }

   @Test
   public void deve_RetornarZeroPorcentoDeDesconto_QuandoTemCincoItensOuMenos(){
      Orcamento orcamento = new Orcamento(400.0);
      orcamento.adiciona(new Item("A", 1.0));
      orcamento.adiciona(new Item("B", 1.0));
      orcamento.adiciona(new Item("C", 1.0));
      orcamento.adiciona(new Item("D", 1.0));
      orcamento.adiciona(new Item("E", 1.0));

      double desconto = new DescontoMaisDeCincoItens().desconto(orcamento);

      assertThat(desconto, is(closeTo(0.0, DELTA)));
   }

   @Test
   public void deve_RetornarSetePorcentoDeDesconto_QuandoOrcamentoMaiorQueQuinhentos(){
      Orcamento orcamento = new Orcamento(600.0);

      double desconto = new DescontoValorOrcamentoMaiorQuinhentos().desconto(orcamento);

      assertThat(desconto, is(closeTo(42.0, DELTA)));
   }

   @Test
   public void deve_RetornarZeroPorcentoDeDesconto_QuandoOrcamentoForQuinhentosOuMenos(){
      Orcamento orcamento = new Orcamento(500.0);

      double desconto = new DescontoMaisDeCincoItens().desconto(orcamento);

      assertThat(desconto, is(closeTo(0.0, DELTA)));
   }
   
   @Test
   public void deve_RetornarCincoPorcentoDeDesconto_QuandoLapisECanetaEstiveremPresentes(){
      Orcamento orcamento = new Orcamento(600.0);
      orcamento.adiciona(new Item("LAPIS", 1.0));
      orcamento.adiciona(new Item("CANETA", 1.0));
      

      double desconto = new DescontoCompraCasada().desconto(orcamento);

      assertThat(desconto, is(closeTo(30.0, DELTA)));
   }

   @Test
   public void deve_RetornarZeroPorcentoDeDesconto_QuandoLapisECanetaEstiveremAusentes(){
      Orcamento orcamento = new Orcamento(500.0);

      double desconto = new DescontoMaisDeCincoItens().desconto(orcamento);

      assertThat(desconto, is(closeTo(0.0, DELTA)));
   }
   
   @Test
   public void deve_RetornarZeroPorcentoDeDesconto_QuandoApenasCanetaEstiverPresente(){
      Orcamento orcamento = new Orcamento(500.0);
      orcamento.adiciona(new Item("CANETA", 1.0));

      double desconto = new DescontoMaisDeCincoItens().desconto(orcamento);

      assertThat(desconto, is(closeTo(0.0, DELTA)));
   }
   
   @Test
   public void deve_RetornarZeroPorcentoDeDesconto_QuandoApenasLapisEstiverPresente(){
      Orcamento orcamento = new Orcamento(500.0);
      orcamento.adiciona(new Item("LAPIS", 1.0));

      double desconto = new DescontoMaisDeCincoItens().desconto(orcamento);

      assertThat(desconto, is(closeTo(0.0, DELTA)));
   }

}
