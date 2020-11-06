package alura.oo.aula4;

import alura.oo.aula1.Orcamento;

public class ISS extends Imposto{

   public ISS(){ super(); }

   public ISS(Imposto novoImposto){ super(novoImposto); }

   @Override
   public double calcula(Orcamento orcamento){ return orcamento.getValor() * 0.06 + calculaNovoImposto(orcamento); }

}
