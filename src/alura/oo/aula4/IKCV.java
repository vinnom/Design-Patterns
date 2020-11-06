package alura.oo.aula4;

import alura.oo.aula1.Orcamento;
import alura.oo.aula2.Item;

public class IKCV extends TemplateDeImpostoCondicional{

   public IKCV(){ super(); }

   public IKCV(Imposto novoImposto){ super(novoImposto); }

   @Override
   protected boolean obedeceRegra(Orcamento orcamento){
      if(orcamento.getValor() > 500 && temItemAcimaDe100(orcamento)){ return true; }

      return false;
   }

   private boolean temItemAcimaDe100(Orcamento orcamento){
      boolean itemValor = false;
      for(Item item : orcamento.getItens()){
         if(item.getValor() >= 100){ itemValor = true; }
      }
      return itemValor;
   }

   @Override
   protected double calculoDaRegraGeral(Orcamento orcamento){ return orcamento.getValor() * 0.06; }

   @Override
   protected double calculoDaRegraParticular(Orcamento orcamento){ return orcamento.getValor() * 0.1; }

}
