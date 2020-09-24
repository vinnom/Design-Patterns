package alura.oo.aula1;

public class ISS implements Imposto{

   @Override
   public double calcula(double valor){ return valor * 0.06; }

}
