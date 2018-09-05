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
public class Cliente {
    
    String login;
    String senha;
    static int sequence = 1;
    int id;

    public Cliente(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.id = sequence++;
    }

    public Cliente() {
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
    
}
