package alura.oo.aula4.desafio;

import java.util.Calendar;
import java.util.List;

public class FiltroDataMesCorrente extends Filtro{

   private static final int NOVEMBRO = 10;

   public FiltroDataMesCorrente(){ super(); }

   public FiltroDataMesCorrente(Filtro filtro){ super(filtro); }

   @Override
   public List<Conta> filtra(List<Conta> contas){

      for(Conta conta : contas){

         if(conta.getDataDeAbertura().get(Calendar.MONTH) == NOVEMBRO){ suspeitas.add(conta); }
      }

      suspeitas = aplicaOutroFiltro(contas);

      return suspeitas;
   }

}
