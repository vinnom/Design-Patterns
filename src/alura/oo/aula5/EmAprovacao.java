package alura.oo.aula5;

public class EmAprovacao implements EstadoDoOrcamento{

   @Override
   public void aplicaDescontoExtra(Orcamento orcamento){
      orcamento.setValor(orcamento.getValor() * 0.95);
      orcamento.setEstadoAtual(new DescontoEmAprovacaoAplicado());
   }

   @Override
   public void aprova(Orcamento orcamento){
      orcamento.setEstadoAtual(new Aprovado());
   }

   @Override
   public void reprova(Orcamento orcamento){
      orcamento.setEstadoAtual(new Reprovado());
   }

   @Override
   public void finaliza(Orcamento orcamento){
      throw new RuntimeException("Orçamento precisa ser aprovado ou reprovado antes de ser finalizado");
   }
}
