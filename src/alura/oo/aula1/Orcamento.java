package alura.oo.aula1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import alura.oo.aula2.Item;

public class Orcamento{

   private final double valor;
   private final List<Item> itens;

   public Orcamento(double valor){
      this.valor = valor;
      this.itens = new ArrayList<>();
   }

   public void adiciona(Item item){ itens.add(item); }

   public double getValor(){ return valor; }

   public List<Item> getItens(){ return Collections.unmodifiableList(this.itens); }

}
