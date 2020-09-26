package alura.oo.aula2.desafio;

public class ImprimeCSV implements Impressora{

   private Impressora proxima;

   public ImprimeCSV(){ this.proxima = new ImprimeSemFormato(); }

   @Override
   public String imprime(Requisicao requisicao, Conta conta){
      if(requisicao.getFormato() == Formato.CSV){
         StringBuilder sb = new StringBuilder();
         sb.append("titular;saldo\n");
         sb.append(conta.getTitular());
         sb.append(";");
         sb.append(conta.getSaldo());
         sb.append("\n");
         return sb.toString();
      }

      return proxima.imprime(requisicao, conta);
   }

   @Override
   public void setProxima(Impressora proxima){ this.proxima = proxima; }

}
