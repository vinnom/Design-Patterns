package alura.oo.aula5;

public interface EstadoDoOrcamento{

   void aplicaDescontoExtra(Orcamento orcamento);

   void aprova(Orcamento orcamento);
   void reprova(Orcamento orcamento);
   void finaliza(Orcamento orcamento);

}
