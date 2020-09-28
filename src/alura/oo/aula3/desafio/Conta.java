package alura.oo.aula3.desafio;

public class Conta{

   private String titular;
   private final String agencia;
   private final String numero;
   private Double saldo = 0.0;

   public Conta(String titular, String agencia, String numero){
      this.titular = titular;
      this.agencia = agencia;
      this.numero = numero;
   }

   public String getTitular(){ return titular; }

   public String getAgencia(){ return agencia; }

   public String getNumero(){ return numero; }

   public Double getSaldo(){ return saldo; }

   public void deposita(Double saldo){
      if(saldo > 0){ this.saldo = saldo; }
   }

}
