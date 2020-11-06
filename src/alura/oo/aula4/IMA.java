package alura.oo.aula4;

import alura.oo.aula1.Orcamento;

public class IMA extends Imposto{

   public IMA(){ super(); }

   public IMA(Imposto novoImposto){ super(novoImposto); }

   @Override
   public double calcula(Orcamento orcamento){ return orcamento.getValor() * 0.2 + calculaNovoImposto(orcamento); }

}
