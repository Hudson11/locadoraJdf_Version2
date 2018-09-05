/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.Locadora.Bean;


import java.io.IOException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import ufrn.Locadora.Model.CestaAluguel;
import ufrn.Locadora.Model.Cliente;
import ufrn.Locadora.Model.Filme;

/**
 *
 * @author Hudson
 */
@ManagedBean
@SessionScoped
public class ClienteCarrinho {
    
    String mensagem;
    Double soma = 0.0;
    ArrayList <CestaAluguel> listaaluguel;
    CestaAluguel aluguel;
    ArrayList <Cliente> listacliente;
    Cliente cli;

    public ClienteCarrinho() {
        
        Cliente c1 = new Cliente("hudson","hudson");
        Cliente c2 = new Cliente("taniro","taniro");
        Cliente c3 = new Cliente("alan","alan");
        
        listaaluguel = new ArrayList<>();
        aluguel = new CestaAluguel();
        listacliente = new ArrayList<>();
        cli = new Cliente();
        
        this.listacliente.add(c1);
        this.listacliente.add(c2);
        this.listacliente.add(c3);
    }
    //*****************************************************
    public void RemoverAluguel(CestaAluguel a){
        if(a.getQuantidade() > 1){
            a.DecrementaQtdCesta();
            a.getFilme().IncrementarQtd();
            a.DecrementarValor();
            soma -= 2;
        }else{
            a.DecrementarValor();
            a.getFilme().IncrementarQtd();
            soma -= 2;
            this.listaaluguel.remove(a);
        }
    }
    //*****************************************************
    public void AdcCestaAluguel(Filme f){
        CestaAluguel cesta;
        
        for(CestaAluguel a: listaaluguel){
            if(a.getFilme().getId() == f.getId()){
                a.IncrementaQtdCesta();
                a.IncrementarValor();
                a.getFilme().DecrementarQtd();
                return;
            }
        }
        f.DecrementarQtd();
        cesta = new CestaAluguel(f,1,2.0);
        this.listaaluguel.add(cesta);
    }
    //*****************************************************
    public void FinalizarAluguel(){
        this.listaaluguel.removeAll(listaaluguel);
        soma = 0.0;
    }
    
    //*****************************************************
    public Double CalculaTotal(){
        Double valor;
        soma = 0.0;
        for(CestaAluguel a: listaaluguel){
             valor = a.getPreco();
             soma += valor;
        }
        return soma;
    }
    //*****************************************************
    public String VerificaUsuario(String login, String senha) throws IOException{
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        for(Cliente c: listacliente){
            if(c.getSenha().equals(login) && c.getSenha().equals(senha)){
                ExternalContext ec = context.getExternalContext();
                HttpSession s = (HttpSession) ec.getSession(true);
                s.setAttribute("usuario-logado", c);
                return "/Restrita/index.xhtml?faces-redirect=true";
            }else{
                FacesMessage mensagem = new FacesMessage("Senha ou Login invalidos");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
		return null;
            }
        }
        return null;
    }
    //*****************************************************
    public String Desloga() throws IOException{
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        s.invalidate();
        return "/Login.xhtml?faces-redirect=true";
    }
    //*****************************************************
    public Double getSoma() {
        return soma;
    }

    public void setSoma(Double soma) {
        this.soma = soma;
    }

    public ArrayList<CestaAluguel> getListaaluguel() {
        return listaaluguel;
    }

    public void setListaaluguel(ArrayList<CestaAluguel> listaaluguel) {
        this.listaaluguel = listaaluguel;
    }

    public CestaAluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(CestaAluguel aluguel) {
        this.aluguel = aluguel;
    }

    public ArrayList<Cliente> getListacliente() {
        return listacliente;
    }

    public void setListacliente(ArrayList<Cliente> listacliente) {
        this.listacliente = listacliente;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
