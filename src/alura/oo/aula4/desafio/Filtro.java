package alura.oo.aula4.desafio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Filtro{

   protected final Filtro filtro;
   protected List<Conta> suspeitas;

   public Filtro(){
      this.filtro = null;
      this.suspeitas = new ArrayList<>();
   }

   public Filtro(Filtro filtro){
      this.filtro = filtro;
      this.suspeitas = new ArrayList<>();
   }

   public abstract List<Conta> filtra(List<Conta> contas);

   protected List<Conta> aplicaOutroFiltro(List<Conta> contas){

      if(filtro != null){
         List<Conta> novasSuspeitas = filtro.filtra(contas);
         suspeitas.addAll(novasSuspeitas);

         return suspeitasSemDuplicadas(suspeitas);
      }

      return suspeitas;
   }

   private List<Conta> suspeitasSemDuplicadas(List<Conta> suspeitas){
      return new ArrayList<>(new HashSet<>(suspeitas));
   }

}
