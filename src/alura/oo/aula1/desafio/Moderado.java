package alura.oo.aula1.desafio;

import java.util.Random;

public class Moderado implements Perfil{

   private final boolean alto = new Random().nextDouble() <= 0.5;

   @Override
   public double rendimento(double valor){
      if(alto){ return valor * 0.025; }
      return valor * 0.007;
   }

}
