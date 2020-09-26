package alura.oo.aula2.desafio;

public interface Impressora{

   String imprime(Requisicao requisicao, Conta conta);
   void setProxima(Impressora proxima);

}
