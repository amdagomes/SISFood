/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fernandasj.modelo;

/**
 *
 * @author Amanda
 */
public enum StatusAmizade {
    AMIGO("amigo"), SOLICITADO("solicitado");
    
    private final String status;
    
    StatusAmizade(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return this.status;
    }
}
