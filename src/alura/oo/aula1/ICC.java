package alura.oo.aula1;

public class ICC implements Imposto{

   @Override
   public double calcula(double valor){
      if(valor < 1000){
         return valor * 0.05;
      } else if(valor >= 1000 || valor <= 3000){ return valor * 0.07; }
      return valor * 0.08 + 30;
   }

}
