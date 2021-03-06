/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.TDA.cola;

import controlador.TDA.exception.EstructuraDataVaciaExpetion;
import controlador.TDA.exception.PosicionException;
import controlador.TDA.exception.TopeException;

/**
 *
 * @author sebastian
 */
public class ColaServices <E> {
    private Cola<E> cola;

    public ColaServices(Integer tope) {
       cola = new Cola<>(tope);
    }
    public boolean push(E dato) {
        try {
            cola.queue(dato);
            return true;
        } catch (TopeException | PosicionException e) {
            System.out.println("Error "+e);
        }
        return false;
    }
    
    public E pop(Integer pos) {
        try {
            return cola.dequeue(pos);
            
        } catch (EstructuraDataVaciaExpetion | PosicionException e) {
            System.out.println("Error "+e);
        }
        return null;
    }
    
    public Integer getSize() {
        return cola.getSize();
    }
    
    public Integer getTope() {
        return cola.getTope();
    }
    
}
