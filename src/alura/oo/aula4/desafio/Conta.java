package alura.oo.aula4.desafio;

import java.util.Calendar;

public class Conta{

   private double saldo;
   private Calendar dataDeAbertura;

   public Conta(){
      this.saldo = 0.0;
      this.dataDeAbertura = Calendar.getInstance();
      this.dataDeAbertura.set(2020, 10, 6);
   }

   public double getSaldo(){ return saldo; }

   public Calendar getDataDeAbertura(){ return dataDeAbertura; }

   public void deposita(double valor){ if(valor > 0){ this.saldo += valor; } }

   public void setDataDeAbertura(Calendar dataDeAbertura){ this.dataDeAbertura = dataDeAbertura; }

}
