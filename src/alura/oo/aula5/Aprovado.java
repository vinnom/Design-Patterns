package alura.oo.aula5;

public class Aprovado implements EstadoDoOrcamento{

   @Override
   public void aplicaDescontoExtra(Orcamento orcamento){
      orcamento.setValor(orcamento.getValor() * 0.98);
      orcamento.setEstadoAtual(new DescontoAprovadoAplicado());
   }

   @Override
   public void aprova(Orcamento orcamento){
      throw new RuntimeException("Orçamento já se encontra aprovado");
   }

   @Override
   public void reprova(Orcamento orcamento){
      throw new RuntimeException("Orçamento aprovado não pode ser reprovado");
   }

   @Override
   public void finaliza(Orcamento orcamento){
      orcamento.setEstadoAtual(new Finalizado());
   }

}
