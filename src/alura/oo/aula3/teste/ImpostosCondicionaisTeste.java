package alura.oo.aula3.teste;

import static alura.oo.ConstantesTestes.DELTA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.jupiter.api.Test;

import alura.oo.aula1.Orcamento;
import alura.oo.aula2.Item;
import alura.oo.aula3.ICPP;
import alura.oo.aula3.IHIT;
import alura.oo.aula3.IKCV;

public class ImpostosCondicionaisTeste{
   
   @Test
   public void deve_Retornar5Porcento_QuandoCalculadoICPP_OrcamentoQuinhentosOuMenos(){
      Orcamento orcamento = new Orcamento(500.0);
      double icpp = new ICPP().calcula(orcamento);

      assertThat(icpp, is(closeTo(25.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar7Porcento_QuandoCalculadoICPP_OrcamentoMaiorQueQuinhentos(){
      Orcamento orcamento = new Orcamento(600.0);
      double icpp = new ICPP().calcula(orcamento);

      assertThat(icpp, is(closeTo(42.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar6Porcento_QuandoCalculadoIKCV_OrcamentoQuinhentosOuMenosComItemDeValorAcimaDeCem(){
      Orcamento orcamento = new Orcamento(500.0);
      orcamento.adiciona(new Item("a", 110.0));
      double ikcv = new IKCV().calcula(orcamento);

      assertThat(ikcv, is(closeTo(30.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar6Porcento_QuandoCalculadoIKCV_OrcamentoMaiorQueQuinhentosComItemDeValorAbaixoDeCem(){
      Orcamento orcamento = new Orcamento(600.0);
      orcamento.adiciona(new Item("a", 90.0));
      double ikcv = new IKCV().calcula(orcamento);

      assertThat(ikcv, is(closeTo(36.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar10Porcento_QuandoCalculadoIKCV_OrcamentoMaiorQueQuinhentosComItemDeValorAcimaDeCem(){
      Orcamento orcamento = new Orcamento(600.0);
      orcamento.adiciona(new Item("a", 110.0));
      double ikcv = new IKCV().calcula(orcamento);

      assertThat(ikcv, is(closeTo(60.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar1PorcentoVezesAQuantidadeDeItens_QuandoCalculadoIHIT_OrcamentoNaoPossuiItensDeMesmoNome(){
      Orcamento orcamento = new Orcamento(1000.0);
      orcamento.adiciona(new Item("a", 110.0));
      orcamento.adiciona(new Item("b", 110.0));
      orcamento.adiciona(new Item("c", 110.0));
      double ihit = new IHIT().calcula(orcamento);

      assertThat(ihit, is(closeTo(30.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar13PorcentoMais100_QuandoCalculadoIHIT_OrcamentoComItensDeMesmoNome(){
      Orcamento orcamento = new Orcamento(1000.0);
      orcamento.adiciona(new Item("a", 110.0));
      orcamento.adiciona(new Item("a", 110.0));
      double ihit = new IHIT().calcula(orcamento);

      assertThat(ihit, is(closeTo(230.0, DELTA)));
   }

}
