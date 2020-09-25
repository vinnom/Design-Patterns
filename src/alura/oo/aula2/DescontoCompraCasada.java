package alura.oo.aula2;

import java.util.List;

import alura.oo.aula1.Orcamento;

public class DescontoCompraCasada implements Desconto{

   private Desconto proximo;

   public DescontoCompraCasada(){
      this.proximo = new SemDesconto();
   }

   @Override
   public double desconto(Orcamento orcamento){
      List<Item> itens = orcamento.getItens();
      int contador = 0;

      for(Item item : itens){
         if(item.getNome().equals("LAPIS") || item.getNome().equals("CANETA")){ contador++; }
      }

      if(contador == 2){ return orcamento.getValor() * 0.05; }

      return proximo.desconto(orcamento);
   }

   @Override
   public void setProximo(Desconto proximo){ this.proximo = proximo; }

}
