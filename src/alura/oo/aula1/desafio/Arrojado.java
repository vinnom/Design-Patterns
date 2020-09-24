package alura.oo.aula1.desafio;

import java.util.Random;

public class Arrojado implements Perfil{
   
   private final double risco = new Random().nextDouble();
   private final boolean alto = (risco <= 0.2);
   private final boolean medio = (risco > 0.2) && (risco <= 0.5);
  
   @Override
   public double rendimento(double valor){
      if(alto){
         return valor * 0.05;
      } else if(medio){
         return valor * 0.03;
      }
      return valor * 0.006;
   }
}
