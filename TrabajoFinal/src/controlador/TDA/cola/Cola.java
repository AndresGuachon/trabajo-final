/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.TDA.cola;

import controlador.TDA.list.ListaEnlazada;
import controlador.TDA.exception.EstructuraDataVaciaExpetion;
import controlador.TDA.exception.PosicionException;
import controlador.TDA.exception.TopeException;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class Cola <E> extends ListaEnlazada<E> {
    private Integer tope;

    public Cola(Integer tope) {
        this.tope = tope;
    }
    
    public Boolean estaLleno() {
        if(tope == 0)
            return false;
        else if(tope == getSize().intValue())
            return true;
        else
            return false;
    }
    
    public void queue(E dato) throws TopeException, PosicionException {
        if(!estaLleno()) {
            insertar(dato, getSize()-1);
        } else 
            throw new TopeException("La pila esta llena");
    }
    
    public E dequeue(Integer pos) throws EstructuraDataVaciaExpetion, PosicionException {
        E auxdato =  null;
        if(!estaVacia()) {
            if (pos >= 0 && pos < getSize()) {
                for(int i = 0; i <= pos; i++) {
                    auxdato = eliminarDato(0);
                }
                return auxdato;

            } else {
                throw new PosicionException("Error al realizar la operacion DEQUEUE No existe la posicion dada");
            }
        } else
            throw new EstructuraDataVaciaExpetion("La cola esta vacia");
    }

    public Integer getTope() {
        return tope;
    }
    
    
    
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>(5);
int a=Integer.parseInt(JOptionPane.showInputDialog("Ingrese comando"));
int b=Integer.parseInt(JOptionPane.showInputDialog("Ingrese comando"));
        try {
            cola.queue(a);
            cola.queue(b);
            cola.queue(Integer.valueOf(JOptionPane.showInputDialog("Ingrese comando")));
            cola.queue(Integer.parseInt(JOptionPane.showInputDialog("Ingrese comando")));
            cola.queue(Integer.parseInt(JOptionPane.showInputDialog("Ingrese comando")));
            cola.imprimir();

            System.out.println("Desencole " + cola.dequeue(0));
            cola.print();
            cola.queue(Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo comando")));
         //System.out.println("Agrega " + cola.dequeue(4)); linea no imprime el valor del comando agregado

            cola.printN();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        
    }
    
}
