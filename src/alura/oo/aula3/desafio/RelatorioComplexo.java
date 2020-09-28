package alura.oo.aula3.desafio;

import java.util.Calendar;
import java.util.List;


public class RelatorioComplexo extends RelatorioTemplate{

   private long data = Calendar.getInstance().getTimeInMillis();

   @Override
   protected String imprimeRodape(){
      StringBuilder sb = new StringBuilder();
      sb.append("email@email.com.br");
      sb.append("\n");
      sb.append(data);
      
      return sb.toString();
   }

   @Override
   protected String imprimeCorpo(List<Conta> contas){
      StringBuilder sb = new StringBuilder();
      for(Conta conta : contas){
         sb.append(conta.getTitular());
         sb.append("\n");
         sb.append(conta.getAgencia());
         sb.append("\n");
         sb.append(conta.getNumero());
         sb.append("\n");
         sb.append(conta.getSaldo());
         sb.append("\n");
      }
      sb.append("\n");
      return sb.toString();
   }

   @Override
   protected String imprimeCabecalho(){
      StringBuilder sb = new StringBuilder();
      sb.append("Banco\n");
      sb.append("Rua rua numero 99\n");
      sb.append("(99)98765-4321\n\n");
      
      return sb.toString();
   }
   
   public long getData(){ return data; }

}
