package alura.oo.aula3;

import alura.oo.aula1.Imposto;
import alura.oo.aula1.Orcamento;

public abstract class TemplateDeImpostoCondicional implements Imposto{

   @Override
   public double calcula(Orcamento orcamento){
      if(obedeceRegra(orcamento)){ return calculoDaRegraParticular(orcamento); }
      return calculoDaRegraGeral(orcamento);
   }

   protected abstract boolean obedeceRegra(Orcamento orcamento);

   protected abstract double calculoDaRegraGeral(Orcamento orcamento);

   protected abstract double calculoDaRegraParticular(Orcamento orcamento);

}
