package alura.oo.aula5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import alura.oo.aula2.Item;

public class Orcamento{

   private Double valor;
   private final List<Item> itens;
   private EstadoDoOrcamento estadoAtual;

   public Orcamento(double valor){
      this.valor = valor;
      this.itens = new ArrayList<>();
      this.estadoAtual = new EmAprovacao();
   }

   public void adiciona(Item item){
      itens.add(item);
   }

   public Double getValor(){ return valor; }

   public void setValor(Double valor){ this.valor = valor; }

   public List<Item> getItens(){ return Collections.unmodifiableList(this.itens); }

   public EstadoDoOrcamento getEstadoAtual(){ return estadoAtual; }

   public void setEstadoAtual(EstadoDoOrcamento estadoAtual){ this.estadoAtual = estadoAtual; }

   public void aplicaDescontoExtra(){
      estadoAtual.aplicaDescontoExtra(this);
   }

}
