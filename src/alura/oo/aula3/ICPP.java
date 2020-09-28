package alura.oo.aula3;

import alura.oo.aula1.Orcamento;

public class ICPP extends TemplateDeImpostoCondicional{

   @Override
   protected boolean obedeceRegra(Orcamento orcamento){
      if(orcamento.getValor() > 500){ return true; }

      return false;
   }

   @Override
   protected double calculoDaRegraParticular(Orcamento orcamento){ return orcamento.getValor() * 0.07; }

   @Override
   protected double calculoDaRegraGeral(Orcamento orcamento){ return orcamento.getValor() * 0.05; }

}
