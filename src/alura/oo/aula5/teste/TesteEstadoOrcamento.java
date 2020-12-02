package alura.oo.aula5.teste;

import static alura.oo.ConstantesTestes.DELTA;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import alura.oo.aula5.Aprovado;
import alura.oo.aula5.DescontoAprovadoAplicado;
import alura.oo.aula5.DescontoEmAprovacaoAplicado;
import alura.oo.aula5.EmAprovacao;
import alura.oo.aula5.Finalizado;
import alura.oo.aula5.Orcamento;
import alura.oo.aula5.Reprovado;

public class TesteEstadoOrcamento{

   private final Orcamento ORCAMENTO = new Orcamento(1000.0);

   @Test
   public void deve_EstarNoEstadoDeEmAprovacao_QuandoOrcamentoEhCriadoENaoEhAplicadoDescontoExtra(){
      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(EmAprovacao.class));
   }

   @Test
   public void deve_EstarNoEstadoDeAprovado_QuandoAprovaSaindoDeEmAprovacao(){
      ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO);
      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(Aprovado.class));
   }

   @Test
   public void deve_EstarNoEstadoDeDescontoEmAprovacaoAplicado_EValorSer95PorcentoDoInicial_QuandoEhAplicadoDescontoExtra(){
      ORCAMENTO.aplicaDescontoExtra();

      assertThat(ORCAMENTO.getValor(), is(closeTo(950.0, DELTA)));
      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(DescontoEmAprovacaoAplicado.class));
   }

   @Test
   public void deve_EstarNoEstadoDeAprovado_EValorSer98PorcentoDoInicial_QuandoEhAplicadoDescontoExtra(){
      ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO);
      ORCAMENTO.aplicaDescontoExtra();

      assertThat(ORCAMENTO.getValor(), is(closeTo(980.0, DELTA)));
      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(DescontoAprovadoAplicado.class));
   }

   @Test
   public void deve_LancarExceptionEstadoDeDescontoEmAprovacaoAplicado_QuandoTentaAplicarDescontoExtraDuasVezes(){
      ORCAMENTO.aplicaDescontoExtra();

      assertThrows(RuntimeException.class, () -> { ORCAMENTO.aplicaDescontoExtra(); },
            "Desconto extra já aplicado neste orçamento");
   }

   @Test
   public void deve_LancarExceptionEstadoDeDescontoAprovadooAplicado_QuandoTentaAplicarDescontoExtraDuasVezes(){
      ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO);
      ORCAMENTO.aplicaDescontoExtra();

      assertThrows(RuntimeException.class, () -> { ORCAMENTO.aplicaDescontoExtra(); },
            "Desconto extra já aplicado neste orçamento");
   }

   @Test
   public void deve_FinalizarOrcamento(){
      ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO);
      ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO);

      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(Finalizado.class));
   }

   @Test
   public void deve_LancarExceptionEstadoAprovado_QuandoTentaReprovar(){
      ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO);

      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO); },
            "Orçamento aprovado não pode ser reprovado");
   }

   @Test
   public void deve_LancarExceptionEstadoAprovado_QuandoTentaAprovar(){
      ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO);

      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO); },
            "Orçamento já se encontra aprovado");
   }

   @Test
   public void deve_ReprovarOrcamento_QuandoEstadoEmAprovacao(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);

      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(Reprovado.class));
   }

   @Test
   public void deve_ReprovarOrcamento_QuandoEstadoDescontoEmAprovacaoAplicado(){
      ORCAMENTO.aplicaDescontoExtra();
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);

      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(Reprovado.class));
   }

   @Test
   public void deve_FinalizarOrcamento_QuandoEstadoReprovado(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);
      ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO);

      assertThat(ORCAMENTO.getEstadoAtual().getClass(), is(Finalizado.class));
   }

   @Test
   public void deve_LancarExceptionEstadoReprovado_QuandoTentaAplicarDescontoExtra(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);
      
      assertThrows(RuntimeException.class, () -> { ORCAMENTO.aplicaDescontoExtra(); },
            "Orçamento reprovado não recebe desconto");
   }
   
   @Test
   public void deve_LancarExceptionEstadoReprovado_QuandoTentaAprovar(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);

      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO); },
            "Orçamento reprovado não pode ser aprovado");
   }

   @Test
   public void deve_LancarExceptionEstadoReprovado_QuandoTentaReprovar(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);

      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO); },
            "Orçamento já se encontra reprovado");
   }
   
   @Test
   public void deve_LancarExceptionEstadoEmAprovacao_QuandoTentaFinalizar(){
      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO); },
            "Orçamento precisa ser aprovado ou reprovado antes de ser finalizado");
   }
   
   @Test
   public void deve_LancarExceptionEstadoDescontoEmAprovacaoAplicado_QuandoTentaFinalizar(){
      ORCAMENTO.aplicaDescontoExtra();
      
      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO); },
            "Orçamento precisa ser aprovado ou reprovado antes de ser finalizado");
   }
   
   @Test
   public void deve_LancarExceptionEstadoFinalizado_QuandoTentaAplicarDescontoExtra(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);
      ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO);
      
      assertThrows(RuntimeException.class, () -> { ORCAMENTO.aplicaDescontoExtra(); },
            "Orçamento finalizado não recebe desconto");
   }
   
   @Test
   public void deve_LancarExceptionEstadoFinalizado_QuandoTentaAprovar(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);
      ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO);
      
      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().aprova(ORCAMENTO); },
            "Orçamento finalizado não pode ser aprovado");
   }
   
   @Test
   public void deve_LancarExceptionEstadoFinalizado_QuandoTentaReprovar(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);
      ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO);
      
      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO); },
            "Orçamento finalizado não pode ser reprovado");
   }
   
   @Test
   public void deve_LancarExceptionEstadoFinalizado_QuandoTentaFinalizar(){
      ORCAMENTO.getEstadoAtual().reprova(ORCAMENTO);
      ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO);
      
      assertThrows(RuntimeException.class, () -> { ORCAMENTO.getEstadoAtual().finaliza(ORCAMENTO); },
            "Orçamento já se encontra finalizado");
   }
   
   

}
