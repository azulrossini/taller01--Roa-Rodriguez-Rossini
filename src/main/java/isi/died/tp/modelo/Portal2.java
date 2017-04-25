/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.ArrayList;
import isi.died.tp.modelo.MaterialCapacitacion;
/**
 *
 * @author azuli
 */
public class Portal2 extends Portal {
    private ArrayList <MaterialCapacitacion> lista;
    
    public ArrayList<MaterialCapacitacion> listar(){
        return lista;
    }
    
    
    public Portal2(){
        this.lista = new ArrayList();
    }
    
    public void agregar(MaterialCapacitacion m){
       lista.add(m);
       super.agregarMaterial((lista.size())-1, m);
    }
    
    
}
