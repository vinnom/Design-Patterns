package alura.oo.aula1.desafio;

public class CalculoRendimento{

   public double calcula(Investimento investimento, Perfil perfil){
      return perfil.rendimento(investimento.getValor()) * 0.75;
   }

}
