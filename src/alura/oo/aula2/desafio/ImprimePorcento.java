package alura.oo.aula2.desafio;

public class ImprimePorcento implements Impressora{

   private Impressora proxima;

   public ImprimePorcento(){ this.proxima = new ImprimeSemFormato(); }

   @Override
   public String imprime(Requisicao requisicao, Conta conta){
      if(requisicao.getFormato() == Formato.PORCENTO){
         StringBuilder sb = new StringBuilder();
         sb.append("%");
         sb.append(conta.getTitular());
         sb.append("%\n");
         sb.append("%");
         sb.append(conta.getSaldo());
         sb.append("%\n");
         return sb.toString();
      }

      return proxima.imprime(requisicao, conta);
   }

   @Override
   public void setProxima(Impressora proxima){ this.proxima = proxima; }

}
