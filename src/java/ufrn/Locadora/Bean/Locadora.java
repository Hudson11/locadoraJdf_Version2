/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.Locadora.Bean;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import ufrn.Locadora.Model.Filme;

/**
 *
 * @author Hudson
 */
@ManagedBean
@ApplicationScoped
public class Locadora {

    ArrayList <Filme> listafilmes;
    Filme filme;
    

    public Locadora() {
        
        Date data1 = new GregorianCalendar(2018,Calendar.JUNE,11).getTime();
        Date data2 = new GregorianCalendar(2015,Calendar.JUNE,05).getTime();
        Date data3 = new GregorianCalendar(2015,Calendar.FEBRUARY,17).getTime();
        
        Filme f1 = new Filme("Os vingadores",data1, 5,"Herois da Marvel",3);
        Filme f2 = new Filme("A morte",data2, 4,"Terror",2);
        Filme f3 = new Filme("Deadpool",data3, 3,"Comedia Marvel",6);
        
        listafilmes = new ArrayList<>();
        filme = new Filme();
        
        
        listafilmes.add(f1);
        listafilmes.add(f2);
        listafilmes.add(f3);
    }
    
    public void Cadastrar() throws IOException{
        this.listafilmes.add(filme);
        filme = new Filme();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    
    public void RemoverFilme(Filme f){
        if(f.getQuantidade() > 1){
            f.DecrementarQtd();
        }else{
            this.listafilmes.remove(f);
        }
    }
    
    public ArrayList<Filme> getListafilmes() {
        return listafilmes;
    }

    public void setListafilmes(ArrayList<Filme> listafilmes) {
        this.listafilmes = listafilmes;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
