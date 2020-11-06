package alura.oo.aula4.desafio;

import java.util.List;

public class FiltroSaldoMaiorQue500k extends Filtro{

   private static final double QUINHENTOS_MIL = 500000.0;

   public FiltroSaldoMaiorQue500k(){ super(); }

   public FiltroSaldoMaiorQue500k(Filtro filtro){ super(filtro); }

   @Override
   public List<Conta> filtra(List<Conta> contas){

      for(Conta conta : contas){

         if(conta.getSaldo() > QUINHENTOS_MIL){ suspeitas.add(conta); }
      }

      suspeitas = aplicaOutroFiltro(contas);

      return suspeitas;
   }

}
