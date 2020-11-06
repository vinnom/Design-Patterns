package alura.oo.aula4.desafio;

import java.util.List;

public class FiltroSaldoMenorQue100 extends Filtro{

   private static final double CEM = 100.0;

   public FiltroSaldoMenorQue100(){ super(); }

   public FiltroSaldoMenorQue100(Filtro outroFiltro){ super(outroFiltro); }

   @Override
   public List<Conta> filtra(List<Conta> contas){

      for(Conta conta : contas){

         if(conta.getSaldo() < CEM){ suspeitas.add(conta); }
      }

      suspeitas = aplicaOutroFiltro(contas);

      return suspeitas;
   }

}
