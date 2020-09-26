package alura.oo.aula2.desafio;

public class ImprimeSemFormato implements Impressora{

   @Override
   public String imprime(Requisicao requisicao, Conta conta){
      StringBuilder sb = new StringBuilder();
      sb.append("titular: ");
      sb.append(conta.getTitular());
      sb.append("\n");
      sb.append("saldo: ");
      sb.append(conta.getSaldo());
      sb.append("\n");
      return sb.toString();
   }

   @Override
   public void setProxima(Impressora proxima){}

}
