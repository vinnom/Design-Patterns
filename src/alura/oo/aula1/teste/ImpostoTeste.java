package alura.oo.aula1.teste;

import static alura.oo.ConstantesTestes.DELTA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.jupiter.api.Test;

import alura.oo.aula1.ICC;
import alura.oo.aula1.ICMS;
import alura.oo.aula1.ISS;
import alura.oo.aula1.Orcamento;


public class ImpostoTeste{

   @Test
   public void deve_Retornar5PorcentoMais50_QuandoCalculadoOICMS(){
      Orcamento orcamento = new Orcamento(1000.0);
      double icms = new ICMS().calcula(orcamento);

      assertThat(icms, is(closeTo(100.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar6Porcento_QuandoCalculadoOISS(){
      Orcamento orcamento = new Orcamento(1000.0);
      double iss = new ISS().calcula(orcamento);

      assertThat(iss, is(closeTo(60.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar5Porcento_QuandoCalculadoOICCDeOrcamentoMenorQue1000(){
      Orcamento orcamento = new Orcamento(800.0);
      double icc = new ICC().calcula(orcamento);

      assertThat(icc, is(closeTo(40.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar7Porcento_QuandoCalculadoOICCDeOrcamentoDe1000(){
      Orcamento orcamento = new Orcamento(1000.0);
      double icc = new ICC().calcula(orcamento);

      assertThat(icc, is(closeTo(70.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar7Porcento_QuandoCalculadoOICCDeOrcamentoEntre1000e3000(){
      Orcamento orcamento = new Orcamento(2000.0);
      double icc = new ICC().calcula(orcamento);

      assertThat(icc, is(closeTo(140.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar7Porcento_QuandoCalculadoOICCDeOrcamentoDe3000(){
      Orcamento orcamento = new Orcamento(3000.0);
      double icc = new ICC().calcula(orcamento);

      assertThat(icc, is(closeTo(210.0, DELTA)));
   }
   
   @Test
   public void deve_Retornar8PorcentoMais30_QuandoCalculadoOICCDeOrcamentoMaiorQue3000(){
      Orcamento orcamento = new Orcamento(5000.0);
      double icc = new ICC().calcula(orcamento);

      assertThat(icc, is(closeTo(430.0, DELTA)));
   }

}
