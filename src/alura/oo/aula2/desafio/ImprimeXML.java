package alura.oo.aula2.desafio;

public class ImprimeXML implements Impressora{

   private Impressora proxima;

   public ImprimeXML(){
      this.proxima = new ImprimeSemFormato();
   }

   @Override
   public String imprime(Requisicao requisicao, Conta conta){
      if(requisicao.getFormato() == Formato.XML){
         StringBuilder sb = new StringBuilder();
         sb.append("<titular>");
         sb.append(conta.getTitular());
         sb.append("</titular>\n");
         sb.append("<saldo>");
         sb.append(conta.getSaldo());
         sb.append("</saldo>\n");
         return sb.toString();
      }

      return proxima.imprime(requisicao, conta);
   }

   @Override
   public void setProxima(Impressora proxima){ this.proxima = proxima; }

}
