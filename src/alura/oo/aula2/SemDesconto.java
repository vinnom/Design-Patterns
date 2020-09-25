package alura.oo.aula2;

import alura.oo.aula1.Orcamento;


public class SemDesconto implements Desconto{

   @Override
   public double desconto(Orcamento orcamento){ 
      return 0;
   }

   @Override
   public void setProximo(Desconto proximo){
   }

}
