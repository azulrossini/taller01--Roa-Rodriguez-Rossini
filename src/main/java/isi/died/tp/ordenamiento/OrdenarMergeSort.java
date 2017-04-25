/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

/**
 *
 * @author mdominguez
 */
public class OrdenarMergeSort extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arreglo) { //---------->> RUTINA GUIA
       
        arregloOrdenado = arreglo.clonar(); // TRABAJAMOS CON UNA COPIA COMO LO PIDE LA CONSIGNA
        arregloOrdenado.inicializarContadores(); // SE INICIAN CONTADORES 
        this.merge(arregloOrdenado, 0, (arregloOrdenado.tamanio())-1);
        return arregloOrdenado;
    }
    
    private void merge (ArregloDied arreglo, Integer primero, Integer ultimo){
        
        Integer central;
        
        if (primero < ultimo){            
            central = (primero + ultimo)/2;
            this.merge(arreglo, primero, central);
            this.merge(arreglo, central+1 , ultimo);
            this.mezcla(arreglo, primero, central, ultimo);            
        }
        
        
    }

    private void mezcla(ArregloDied arreglo, Integer primero, Integer central, Integer ultimo) {
        
        ArregloDied tmp = new ArregloDied(arreglo.tamanio());        
        Integer i = primero, k, z = primero;
        k = central +1;
        
        while (i <= central && k <= ultimo){
            
            if (arreglo.mayorIgual(k, i)){
                tmp.agregarEnPosicion(z++, arreglo.get(i++));
            }
            else{
                tmp.agregarEnPosicion(z++, arreglo.get(k++));
            }
        }
        
        while(i <= central){
            tmp.agregarEnPosicion(z++, arreglo.get(i++));
        }
        while(k <= ultimo){
            tmp.agregarEnPosicion(z++, arreglo.get(k++));
        }
        
        for(Integer j = primero; j <= ultimo; j++){
            arreglo.agregarEnPosicion(j, tmp.get(j));
        }
        
        
   }
    
    
}
