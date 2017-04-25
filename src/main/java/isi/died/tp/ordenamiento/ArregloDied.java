/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

import java.util.Arrays;

/**
 * Representa un Arreglo de objetos que pueden ser ordenados
 * @author mdominguez
 */
public class ArregloDied {
    protected Ordenable[] datos;
    protected OrdenadorService ordenador;
    public static Integer comparaciones;
    public static Integer intercambios;
    
    /**
     * La única forma de crear un arreglo es indicandole en el constructor la capacidad
     * @param capacidad 
     */    
    public ArregloDied(Integer capacidad){
        this.datos = new Ordenable[capacidad];
        this.ordenador=new OrdenarBurbuja();   
        inicializarContadores();
    }
    /**
     * Agrega un elemento recibido como parámetro en la posición indicada. 
     * Si lo agrego retorna true, en otro caso, si el indice era incorrecto
     * retorna false
     * @param i
     * @param elemento
     * @return 
     */
    public Boolean agregarEnPosicion(Integer i,Ordenable elemento){
        if(i>=0 && i<datos.length) {
            datos[i]=elemento;
            return true;
        }
        return false;
    }

   
    /**
     * retorna true si elementoA es mayor que elementoB
     * @param elementoA
     * @param elementoB
     * @return 
     */
    public Boolean mayor(Integer elementoA,Integer elementoB){     
        this.comparaciones++;
        return this.datos[elementoA].valorOrdenamiento()>this.datos[elementoB].valorOrdenamiento();
    }

    /**
     * retorna true si elementoA es mayor o igual que elementoB
     * @param elementoA
     * @param elementoB
     * @return 
     */
    public Boolean mayorIgual(Integer elementoA,Integer elementoB){
        this.comparaciones++;
        return this.datos[elementoA].valorOrdenamiento()>=this.datos[elementoB].valorOrdenamiento();
    }    

    public void intercambiar(Integer i,Integer j){
        this.intercambios++;
        Ordenable aux = this.datos[i];
        this.datos[i]=this.datos[j];
        this.datos[j]=aux;
    }   
    
    public Ordenable get(Integer indice){
        if(indice>=0 && indice<this.datos.length)        return this.datos[indice];
        return null;
    }

    public Integer tamanio(){
        return this.datos.length;
    }

    public ArregloDied ordenar(){
        return this.ordenador.ordenar(this);
    }
    
    /**
     * Retorna una nueva instancia de ArregloDied con una copia de otro arreglo
     * similar al de la instancia origen. 
     * Se duplican los elementos en memoria
     * @return una nueva instancias de ArregloDied con sus datos duplicados.
     */
    public ArregloDied clonar(){
        ArregloDied copia = new ArregloDied(this.datos.length);
        System.arraycopy(this.datos, 0, copia.datos, 0, this.datos.length);        
        return copia;
    }

    @Override
    public String toString() {
        return Arrays.toString(datos);
    }
    
    public void inicializarContadores(){
        this.comparaciones=0;
        this.intercambios=0;
    }

    public Integer getComparaciones() {
        return comparaciones;
    }

    public Integer getIntercambios() {
        return intercambios;
    }
 
    public OrdenadorService getOrdenador() {
        return ordenador;
    }

    public void setOrdenador(OrdenadorService ordenador) {
        this.ordenador = ordenador;
    }
    
    
    
}
