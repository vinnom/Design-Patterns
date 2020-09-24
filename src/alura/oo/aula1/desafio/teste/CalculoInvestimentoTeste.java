package alura.oo.aula1.desafio.teste;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.jupiter.api.Test;

import alura.oo.aula1.desafio.Arrojado;
import alura.oo.aula1.desafio.CalculoRendimento;
import alura.oo.aula1.desafio.Conservador;
import alura.oo.aula1.desafio.Investimento;
import alura.oo.aula1.desafio.Moderado;

public class CalculoInvestimentoTeste{

   private static final double DELTA = 0.0001;
   private final CalculoRendimento calculadora = new CalculoRendimento();
   private final Investimento investimento = new Investimento(1000.0);

   @Test
   public void deve_RetornarRendimentoConservador(){
      double calculado = calculadora.calcula(investimento, new Conservador());

      assertThat(calculado, is(closeTo(6.0, DELTA)));
   }
   
   @Test
   public void deve_RetornarRendimentoModerado(){
      double calculado = calculadora.calcula(investimento, new Moderado());

      assertThat(calculado, is(anyOf(closeTo(5.25, DELTA), closeTo(18.75, DELTA))));
   }
   
   @Test
   public void deve_RetornarRendimentoArrojado(){
      double calculado = calculadora.calcula(investimento, new Arrojado());

      assertThat(calculado, is(anyOf(closeTo(4.5, DELTA), closeTo(22.5, DELTA), closeTo(37.5, DELTA))));
   }
   

}
