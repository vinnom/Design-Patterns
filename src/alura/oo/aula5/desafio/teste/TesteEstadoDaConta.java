package alura.oo.aula5.desafio.teste;

import static alura.oo.ConstantesTestes.DELTA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import alura.oo.aula5.desafio.Conta;
import alura.oo.aula5.desafio.EstadoDaContaNegativo;
import alura.oo.aula5.desafio.EstadoDaContaPositivo;

public class TesteEstadoDaConta{

   private final Conta CONTA = new Conta(1000.0);

   @Test
   public void deve_EstarNoEstadoPositivo_QuandoContaEhCriada(){
      assertThat(CONTA.getEstadoAtual().getClass(), is(EstadoDaContaPositivo.class));
   }

   @Test
   public void deve_EstarNoEstadoPositivo_QuandoSacaMenosQueMil(){
      CONTA.saca(500.0);

      assertThat(CONTA.getSaldo(), is(closeTo(500.0, DELTA)));
      assertThat(CONTA.getEstadoAtual().getClass(), is(EstadoDaContaPositivo.class));
   }

   @Test
   public void deve_DepositarNoventaEOitoPorcentoDoValor_QuandoEstadoPositivo(){
      CONTA.deposita(100.0);

      assertThat(CONTA.getSaldo(), is(closeTo(1098.0, DELTA)));
   }

   @Test
   public void deve_EstarNoEstadoNegativo_QuandoSacaMaisQueMil(){
      CONTA.saca(1500.0);

      assertThat(CONTA.getSaldo(), is(closeTo(-500.0, DELTA)));
      assertThat(CONTA.getEstadoAtual().getClass(), is(EstadoDaContaNegativo.class));
   }

   @Test
   public void deve_LancarExceptionEstadoNegativo_QuandoSacaNoEstadoNegativo(){
      CONTA.saca(1500.0);

      assertThrows(RuntimeException.class, () -> { CONTA.saca(100.0); }, "Conta com saldo negativo não permite saque!");
   }

   @Test
   public void deve_DepositarNoventaECincoPorcentoDoValor_QuandoEstadoNegativo_PermaneceNegativo(){
      CONTA.saca(1500.0);
      CONTA.deposita(100.0);

      assertThat(CONTA.getSaldo(), is(closeTo(-405.0, DELTA)));
      assertThat(CONTA.getEstadoAtual().getClass(), is(EstadoDaContaNegativo.class));
   }

   @Test
   public void deve_DepositarNoventaECincoPorcentoDoValor_QuandoEstadoNegativo_FicaPositivo(){
      CONTA.saca(1500.0);
      CONTA.deposita(1000.0);

      assertThat(CONTA.getSaldo(), is(closeTo(450.0, DELTA)));
      assertThat(CONTA.getEstadoAtual().getClass(), is(EstadoDaContaPositivo.class));
   }

}
