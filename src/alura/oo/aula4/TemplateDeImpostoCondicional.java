package alura.oo.aula4;

import alura.oo.aula1.Orcamento;

public abstract class TemplateDeImpostoCondicional extends Imposto{

   public TemplateDeImpostoCondicional(){ super(); }

   public TemplateDeImpostoCondicional(Imposto novoImposto){ super(novoImposto); }

   @Override
   public double calcula(Orcamento orcamento){
      if(obedeceRegra(orcamento)){ return calculoDaRegraParticular(orcamento) + calculaNovoImposto(orcamento); }
      return calculoDaRegraGeral(orcamento) + calculaNovoImposto(orcamento);
   }

   protected abstract boolean obedeceRegra(Orcamento orcamento);

   protected abstract double calculoDaRegraGeral(Orcamento orcamento);

   protected abstract double calculoDaRegraParticular(Orcamento orcamento);

}
