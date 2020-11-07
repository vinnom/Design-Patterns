package alura.oo.aula5;


public class DescontoAprovadoAplicado implements EstadoDoOrcamento{

   @Override
   public void aplicaDescontoExtra(Orcamento orcamento){
      throw new RuntimeException("Desconto extra já aplicado neste orçamento");
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
