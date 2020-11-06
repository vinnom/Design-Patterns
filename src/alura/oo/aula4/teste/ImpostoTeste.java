package alura.oo.aula4.teste;

import static alura.oo.ConstantesTestes.DELTA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.jupiter.api.Test;

import alura.oo.aula1.Orcamento;
import alura.oo.aula4.ICC;
import alura.oo.aula4.ICMS;
import alura.oo.aula4.IMA;
import alura.oo.aula4.ISS;

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

   @Test
   public void deve_Retornar5PorcentoMais50Mais6Porcento_QuandoCalculadoOICMScomISS(){
      Orcamento orcamento = new Orcamento(1000.0);
      double icmsComIss = new ICMS(new ISS()).calcula(orcamento);

      assertThat(icmsComIss, is(closeTo(160.0, DELTA)));
   }

   @Test
   public void deve_Retornar6PorcentoMais5PorcentoMais50_QuandoCalculadoOISSComICMS(){
      Orcamento orcamento = new Orcamento(1000.0);
      double issComIcms = new ISS(new ICMS()).calcula(orcamento);

      assertThat(issComIcms, is(closeTo(160.0, DELTA)));
   }

   @Test
   public void deve_Retornar5PorcentoMais5PorcentoMais50Mais6Porcento_QuandoCalculadoOICCDeOrcamentoMenorQue1000(){
      Orcamento orcamento = new Orcamento(800.0);
      double iccComIcmsComIss = new ICC(new ICMS(new ISS())).calcula(orcamento);

      assertThat(iccComIcmsComIss, is(closeTo(178.0, DELTA)));
   }

   @Test
   public void deve_Retornar7PorcentoMais5PorcentoMais50Mais6Porcento_QuandoCalculadoOICCDeOrcamentoDe1000ComICMSComISS(){
      Orcamento orcamento = new Orcamento(1000.0);
      double iccComIcmsComIss = new ICC(new ICMS(new ISS())).calcula(orcamento);

      assertThat(iccComIcmsComIss, is(closeTo(230.0, DELTA)));
   }

   @Test
   public void deve_Retornar7PorcentoMais5PorcentoMais50Mais6Porcento_QuandoCalculadoOICCDeOrcamentoEntre1000e3000ComICMSComISS(){
      Orcamento orcamento = new Orcamento(2000.0);
      double iccComIcmsComIss = new ICC(new ICMS(new ISS())).calcula(orcamento);

      assertThat(iccComIcmsComIss, is(closeTo(410.0, DELTA)));
   }

   @Test
   public void deve_Retornar7PorcentoMais5PorcentoMais50Mais6Porcento_QuandoCalculadoOICCDeOrcamentoDe3000ComICMSComISS(){
      Orcamento orcamento = new Orcamento(3000.0);
      double iccComIcmsComIss = new ICC(new ICMS(new ISS())).calcula(orcamento);

      assertThat(iccComIcmsComIss, is(closeTo(590.0, DELTA)));
   }

   @Test
   public void deve_Retornar8PorcentoMais30Mais5PorcentoMais50Mais6Porcento_QuandoCalculadoOICCDeOrcamentoMaiorQue3000ComICMSComISS(){
      Orcamento orcamento = new Orcamento(5000.0);
      double iccComIcmsComIss = new ICC(new ICMS(new ISS())).calcula(orcamento);

      assertThat(iccComIcmsComIss, is(closeTo(1030.0, DELTA)));
   }

   @Test
   public void deve_Retornar20Porcento_QuandoCalculadoOIMA(){
      Orcamento orcamento = new Orcamento(1000.0);
      double ima = new IMA().calcula(orcamento);

      assertThat(ima, is(closeTo(200.0, DELTA)));
   }

   @Test
   public void deve_Retornar20PorcentoMais5PorcentoMais50_QuandoCalculadoOIMAComICMS(){
      Orcamento orcamento = new Orcamento(1000.0);
      double imaComIcms = new IMA(new ICMS()).calcula(orcamento);

      assertThat(imaComIcms, is(closeTo(300.0, DELTA)));
   }

}
