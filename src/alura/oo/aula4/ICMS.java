package alura.oo.aula4;

import alura.oo.aula1.Orcamento;

public class ICMS extends Imposto{

   public ICMS(){ super(); }

   public ICMS(Imposto novoImposto){ super(novoImposto); }

   @Override
   public double calcula(Orcamento orcamento){
      return orcamento.getValor() * 0.05 + 50 + calculaNovoImposto(orcamento);
   }

}
