package alura.oo.aula1;

public class ICMS implements Imposto{

   @Override
   public double calcula(double valor){ return valor * 0.05 + 50; }

}
