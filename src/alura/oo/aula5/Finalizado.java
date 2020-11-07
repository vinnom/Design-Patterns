package alura.oo.aula5;


public class Finalizado implements EstadoDoOrcamento{

   @Override
   public void aplicaDescontoExtra(Orcamento orcamento){
      throw new RuntimeException("Orçamento finalizado não recebe desconto");
   }

   @Override
   public void aprova(Orcamento orcamento){
      throw new RuntimeException("Orçamento finalizado não pode ser aprovado");
   }

   @Override
   public void reprova(Orcamento orcamento){
      throw new RuntimeException("Orçamento finalizado não pode ser reprovado");
   }

   @Override
   public void finaliza(Orcamento orcamento){
      throw new RuntimeException("Orçamento já se encontra finalizado");
   }

}
