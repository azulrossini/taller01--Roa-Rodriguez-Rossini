/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

import java.util.ArrayList;


/**
 *
 * @author mdominguez
 */ 

public class OrdenarRadix extends OrdenadorService{
        
    @Override
    public ArregloDied ordenar(ArregloDied arreglo) {
        arregloOrdenado = arreglo.clonar();
        ArrayList<ColaDied> urna = new ArrayList<ColaDied>(10);
        
        //Se agregan los elementos a las urnas
        for(int i=0; i<10; i++){
            ColaDied nueva_pos = new ColaDied(arregloOrdenado.tamanio());
            urna.add(i, nueva_pos);
        }
        
        //Para encontrar el mayor digito
        long mayor = arregloOrdenado.datos[0].valorOrdenamiento();
        for(int j=0; j<arregloOrdenado.tamanio(); j++){
            if(mayor < arregloOrdenado.datos[j].valorOrdenamiento()){
                mayor = arregloOrdenado.datos[j].valorOrdenamiento();
            }
        }
            
        long divd = 1l;
        do{
            Integer x=0;
            for(int i=0; i<arregloOrdenado.tamanio(); i++){
                Long a;
                a=((arregloOrdenado.datos[i].valorOrdenamiento()/divd))%10;
                urna.get(a.intValue()).enqueue(arregloOrdenado.datos[i]);
                ArregloDied.comparaciones++;
            }
            
            for(int j=0; j<10; j++){
                while(!(urna.get(j).isEmpty())){
                    arregloOrdenado.agregarEnPosicion(x, urna.get(j).dequeue());
                    x++;
                }
            }
            
            divd*=10;
        }while(mayor/divd>0);
        
      return arregloOrdenado;
    }
}

