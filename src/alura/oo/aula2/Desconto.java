package alura.oo.aula2;

import alura.oo.aula1.Orcamento;

public interface Desconto{

   double desconto(Orcamento orcamento);
   void setProximo(Desconto proximo);

}
