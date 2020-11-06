package alura.oo.aula4;

import alura.oo.aula1.Orcamento;

public class ICC extends Imposto{

   public ICC(){ super(); }

   public ICC(Imposto novoImposto){ super(novoImposto); }

   @Override
   public double calcula(Orcamento orcamento){
      if(orcamento.getValor() < 1000){
         return orcamento.getValor() * 0.05 + calculaNovoImposto(orcamento);
      } else if(orcamento.getValor() >= 1000 && orcamento.getValor() <= 3000){
         return orcamento.getValor() * 0.07 + calculaNovoImposto(orcamento);
      }
      return orcamento.getValor() * 0.08 + 30 + calculaNovoImposto(orcamento);
   }

}
