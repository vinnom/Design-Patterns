package alura.oo.aula5;

public class Reprovado implements EstadoDoOrcamento{

   @Override
   public void aplicaDescontoExtra(Orcamento orcamento){
      throw new RuntimeException("Orçamento reprovado não recebe desconto");
   }

   @Override
   public void aprova(Orcamento orcamento){
      throw new RuntimeException("Orçamento reprovado não pode ser aprovado");
   }

   @Override
   public void reprova(Orcamento orcamento){
      throw new RuntimeException("Orçamento já se encontra reprovado");
   }

   @Override
   public void finaliza(Orcamento orcamento){
      orcamento.setEstadoAtual(new Finalizado());
   }

}
