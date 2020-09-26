package alura.oo.aula2.desafio;

public class Conta{

   private final String titular;
   private double saldo;

   public Conta(String titular, double saldo){
      this.titular = titular;
      this.saldo = saldo;
   }

   public String getTitular(){ return titular; }

   public double getSaldo(){ return saldo; }

}
