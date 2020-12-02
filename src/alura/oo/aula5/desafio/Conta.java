package alura.oo.aula5.desafio;

public class Conta{

   private double saldo = 0.0;
   private EstadoDaConta estadoAtual;

   public Conta(double saldo){
      this.saldo = saldo;
      this.estadoAtual = new EstadoDaContaPositivo();
   }

   public void saca(double valor){
      this.estadoAtual.saca(this, valor);
   }

   public void deposita(double valor){
      this.estadoAtual.deposita(this, valor);
   }

   public double getSaldo(){ return saldo; }

   public void setSaldo(double saldo){ this.saldo = saldo; }

   public EstadoDaConta getEstadoAtual(){ return estadoAtual; }

   public void setEstadoAtual(EstadoDaConta estadoAtual){ this.estadoAtual = estadoAtual; }

}
