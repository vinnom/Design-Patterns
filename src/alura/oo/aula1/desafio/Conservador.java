package alura.oo.aula1.desafio;

public class Conservador implements Perfil{

   @Override
   public double rendimento(double valor){ return valor * 0.008; }

}
