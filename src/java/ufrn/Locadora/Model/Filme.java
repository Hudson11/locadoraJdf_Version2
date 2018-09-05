/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.Locadora.Model;

import java.util.Date;

/**
 *
 * @author Hudson
 */
public class Filme {
    String titulo;
    Date dtlancamento;
    Integer nota;
    String descricao;
    Integer quantidade;
    Integer id;
    static int sequence = 1;

    public Filme() {
        this.id = sequence++;
    }

    public Filme(String titulo, Date dtlancamento, Integer nota, String descricao, Integer quantidade) {
        this.titulo = titulo;
        this.dtlancamento = dtlancamento;
        this.nota = nota;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.id = sequence++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDtlancamento() {
        return dtlancamento;
    }

    public void setDtlancamento(Date dtlancamento) {
        this.dtlancamento = dtlancamento;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Filme.sequence = sequence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    //Mêtodos abaixos são utilizados para manipular a quantidade dod Filmes em estoque
    
    public void IncrementarQtd(){
        this.quantidade++;
    }
    
    public void DecrementarQtd(){
        this.quantidade--;
    }
}
