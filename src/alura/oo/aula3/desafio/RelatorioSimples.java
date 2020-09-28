package alura.oo.aula3.desafio;

import java.util.List;

public class RelatorioSimples extends RelatorioTemplate{

   @Override
   protected String imprimeRodape(){ return new StringBuilder("(99)98765-4321\n").toString(); }

   @Override
   protected String imprimeCorpo(List<Conta> contas){
      StringBuilder sb = new StringBuilder();
      for(Conta conta : contas){
         sb.append(conta.getTitular());
         sb.append("\n");
         sb.append(conta.getSaldo());
         sb.append("\n");
      }
      sb.append("\n");
      return sb.toString();
   }

   @Override
   protected String imprimeCabecalho(){ return new StringBuilder("Banco\n\n").toString(); }

}
