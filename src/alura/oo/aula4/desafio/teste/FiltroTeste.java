package alura.oo.aula4.desafio.teste;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import alura.oo.aula4.desafio.Conta;
import alura.oo.aula4.desafio.FiltroDataMesCorrente;
import alura.oo.aula4.desafio.FiltroSaldoMaiorQue500k;
import alura.oo.aula4.desafio.FiltroSaldoMenorQue100;

public class FiltroTeste{

   @Test
   public void deve_ConterUmaConta_QuandoFiltrarContaComSaldoMenorQue100(){
      Conta c1 = new Conta();
      Conta c2 = new Conta();
      FiltroSaldoMenorQue100 filtroSaldoMenorQue100 = new FiltroSaldoMenorQue100();
      List<Conta> contas = new ArrayList<>(Arrays.asList(c1, c2));

      c1.deposita(50.0);
      c2.deposita(150.0);

      List<Conta> filtradas = filtroSaldoMenorQue100.filtra(contas);

      assertThat(filtradas, Matchers.hasSize(1));
      assertThat(filtradas, Matchers.hasItem(c1));

   }

   @Test
   public void deve_ConterUmaConta_QuandoFiltrarContaComSaldoMaiorQue500k(){
      Conta c1 = new Conta();
      Conta c2 = new Conta();
      FiltroSaldoMaiorQue500k filtroSaldoMaiorQue500k = new FiltroSaldoMaiorQue500k();
      List<Conta> contas = new ArrayList<>(Arrays.asList(c1, c2));

      c1.deposita(600000.0);
      c2.deposita(150000.0);

      List<Conta> filtradas = filtroSaldoMaiorQue500k.filtra(contas);

      assertThat(filtradas, Matchers.hasSize(1));
      assertThat(filtradas, Matchers.hasItem(c1));

   }

   @Test
   public void deve_ConterDuasContas_QuandoFiltrarComSaldoMenorQue100EContaComSaldoMaiorQue500k(){
      Conta c1 = new Conta();
      Conta c2 = new Conta();
      Conta c3 = new Conta();
      FiltroSaldoMaiorQue500k filtroSaldoMaiorQue500k = new FiltroSaldoMaiorQue500k(new FiltroSaldoMenorQue100());
      List<Conta> contas = new ArrayList<>(Arrays.asList(c1, c2, c3));

      c1.deposita(600000.0);
      c2.deposita(150000.0);
      c3.deposita(50.0);

      List<Conta> filtradas = filtroSaldoMaiorQue500k.filtra(contas);

      assertThat(filtradas, Matchers.hasSize(2));
      assertThat(filtradas, Matchers.hasItems(c1, c3));

   }

   @Test
   public void deve_ConterTresContas_QuandoFiltrarComSaldoMenorQue100EContaComSaldoMaiorQue500kEContaMesCorrente(){
      Conta c1 = new Conta();
      Conta c2 = new Conta();
      Conta c3 = new Conta();
      Conta c4 = new Conta();
      FiltroSaldoMaiorQue500k filtroSaldoMaiorQue500k = 
            new FiltroSaldoMaiorQue500k(
                  new FiltroSaldoMenorQue100(
                        new FiltroDataMesCorrente()));
      List<Conta> contas = new ArrayList<>(Arrays.asList(c1, c2, c3,c4));

      c1.deposita(600000.0);
      c2.deposita(150000.0);
      c3.deposita(50.0);
      c4.deposita(5000.0);
      
      Calendar novaData = Calendar.getInstance();
      novaData.set(2020, 8, 23);
      c2.setDataDeAbertura(novaData);
      

      List<Conta> filtradas = filtroSaldoMaiorQue500k.filtra(contas);

      assertThat(filtradas, Matchers.hasSize(3));
      assertThat(filtradas, Matchers.hasItems(c1, c3, c4));

   }

}
