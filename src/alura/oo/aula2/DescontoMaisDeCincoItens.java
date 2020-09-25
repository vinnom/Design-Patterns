package alura.oo.aula2;

import alura.oo.aula1.Orcamento;

public class DescontoMaisDeCincoItens implements Desconto{

   private Desconto proximo;

   public DescontoMaisDeCincoItens(){ this.proximo = new SemDesconto(); }

   @Override
   public double desconto(Orcamento orcamento){
      if(orcamento.getItens().size() > 5){ return orcamento.getValor() * 0.1; }

      return proximo.desconto(orcamento);

   }

   @Override
   public void setProximo(Desconto proximo){ this.proximo = proximo; }

}
