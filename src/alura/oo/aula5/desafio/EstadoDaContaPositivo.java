package alura.oo.aula5.desafio;

public class EstadoDaContaPositivo implements EstadoDaConta{

   @Override
   public void saca(Conta conta, double valor){
      conta.setSaldo(conta.getSaldo() - valor);

      if(conta.getSaldo() < 0){ conta.setEstadoAtual(new EstadoDaContaNegativo()); }

   }

   @Override
   public void deposita(Conta conta, double valor){
      conta.setSaldo(conta.getSaldo() + valor * 0.98);
   }

}
