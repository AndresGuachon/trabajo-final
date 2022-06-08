/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.table.AbstractTableModel;
import controlador.TDA.ListaEnlazadaServices;
import javax.swing.table.AbstractTableModel;
import modelo.pelicula;
import modelo.Caracteristicas;
/**
 *
 * @author LENOVO
 */

public class peliculaV extends AbstractTableModel {
    private ListaEnlazadaServices<pelicula> lista;

    public ListaEnlazadaServices<pelicula> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazadaServices<pelicula> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Nro";
            case 1: return "Title";
            case 2: return "Year";
            case 3: return "Rated";
            case 4:
                return "Released";
            case 5:
                return "Runtime";
            case 6:
                return "Genre";
            case 7:
                return " Director";
            case 8:
                return " Writer";
            case 9:
                return " Actor";
            case 10:
                return " Language";
            case 11:
                return " Country";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        pelicula pelicula = new pelicula();
        switch (arg1) {
            case 0:
                return (arg0 + 1);
            case 1:
                return new peliculaServicio().getListaArchivo().obtenerDato(pelicula.getPelicula() - 1);
            case 2:
                return pelicula.getTitle();
            case 3:
                return pelicula.getYear();
            case 4:
                return pelicula.getRated();
            case 5:
                return pelicula.getReleased();
            case 6:
                return pelicula.getRuntime();
            case 7:
                return pelicula.getGenre();
            case 8:
                return pelicula.getDirector();
            case 9:
                return pelicula.getWriter();
            case 10:
                return pelicula.getLanguage();
            case 11:
                return pelicula.getAwards();

            default:
                return null;
        }
    }
    
    
    
    
}