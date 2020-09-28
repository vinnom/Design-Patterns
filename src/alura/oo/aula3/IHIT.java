package alura.oo.aula3;

import static java.util.stream.Collectors.toList;

import java.util.List;

import alura.oo.aula1.Orcamento;
import alura.oo.aula2.Item;

public class IHIT extends TemplateDeImpostoCondicional{

   @Override
   protected boolean obedeceRegra(Orcamento orcamento){ return temItensComMesmoNome(orcamento); }

   private boolean temItensComMesmoNome(Orcamento orcamento){
      List<String> nomes = orcamento.getItens().stream().map(Item::getNome).collect(toList());
      for(int i = 0; i < nomes.size(); i++){
         List<String> subList = nomes.subList(i + 1, nomes.size());
         if(subList.contains(nomes.get(i))){ return true; }
      }
      return false;
   }

   @Override
   protected double calculoDaRegraGeral(Orcamento orcamento){
      return orcamento.getValor() * (0.01 * orcamento.getItens().size());
   }

   @Override
   protected double calculoDaRegraParticular(Orcamento orcamento){ return orcamento.getValor() * 0.13 + 100; }

}
