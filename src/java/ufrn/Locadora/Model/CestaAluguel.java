/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.Locadora.Model;

/**
 *
 * @author Hudson
 */
public class CestaAluguel {
       
    Filme filme;
    int quantidade;
    Double preco = 2.0;

    public CestaAluguel() {
    }

    public CestaAluguel(Filme filme, int quantidade, Double preco) {
        this.filme = filme;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    // Mêtodos abaixos são utilizados para manipular quantidade e valor de Filmes na Cesta
    
    public void IncrementaQtdCesta(){
        this.quantidade++;
    }
    
    public void DecrementaQtdCesta(){
        this.quantidade--;
    }
    
    public void IncrementarValor(){
        this.preco += 2;
    }
    
     public void DecrementarValor(){
        this.preco -= 2;
    }
}
