package alura.oo.aula4;

import alura.oo.aula1.Orcamento;

public abstract class Imposto{

   protected Imposto novoImposto = null;

   public Imposto(){}

   public Imposto(Imposto novoImposto){ this.novoImposto = novoImposto; }

   public abstract double calcula(Orcamento orcamento);

   protected double calculaNovoImposto(Orcamento orcamento){
      if(this.novoImposto == null){ return 0.0; }
      return novoImposto.calcula(orcamento);
   }

}
