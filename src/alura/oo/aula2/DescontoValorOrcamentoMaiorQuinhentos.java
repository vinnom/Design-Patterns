package alura.oo.aula2;

import alura.oo.aula1.Orcamento;


public class DescontoValorOrcamentoMaiorQuinhentos implements Desconto{

   private Desconto proximo;

   public DescontoValorOrcamentoMaiorQuinhentos(){
      this.proximo = new SemDesconto();
   }

   @Override
   public double desconto(Orcamento orcamento){ 
      if(orcamento.getValor() > 500.0){
         return orcamento.getValor() * 0.07;
      }
            
      return proximo.desconto(orcamento);
   }

   @Override
   public void setProximo(Desconto proximo){
      this.proximo = proximo; 
   }

}
