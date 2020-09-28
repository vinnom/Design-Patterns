package alura.oo.aula3.desafio;

import java.util.List;

public abstract class RelatorioTemplate implements Relatorio{

   protected String cabecalho;
   protected String corpo;
   protected String rodape;

   @Override
   public String imprime(List<Conta> contas){
      cabecalho = imprimeCabecalho();
      if(!contas.isEmpty()){
      corpo = imprimeCorpo(contas);
      } else{
         corpo = "Não há contas\n\n";
      }
      rodape = imprimeRodape();
      
      StringBuilder sb = new StringBuilder();
      sb.append(cabecalho).append(corpo).append(rodape);
      return sb.toString();
   }

   protected abstract String imprimeRodape();

   protected abstract String imprimeCorpo(List<Conta> contas);

   protected abstract String imprimeCabecalho();

}
