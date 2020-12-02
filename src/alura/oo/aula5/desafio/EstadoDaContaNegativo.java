package alura.oo.aula5.desafio;

public class EstadoDaContaNegativo implements EstadoDaConta{

   @Override
   public void saca(Conta conta, double valor){
      throw new RuntimeException("Conta com saldo negativo não permite saque!");
   }

   @Override
   public void deposita(Conta conta, double valor){
      conta.setSaldo(conta.getSaldo() + valor * 0.95);

      if(conta.getSaldo() >= 0){ conta.setEstadoAtual(new EstadoDaContaPositivo()); }
   }

}
