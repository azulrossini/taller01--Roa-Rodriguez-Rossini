/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

/**
 *
 * @author mdominguez
 */
public final class Suscriptor {
    private String nombre;

    // a. crear una constante CAPACIDAD_DOCUMENTOS q permite determinar la cantidad MAXIMA 
    // de documentos que puede tener una biblioteca
    private final Integer CAPACIDAD_DOCUMENTOS = 5;

    // definir un arreglo que permita almacenar documentos
    private MaterialCapacitacion[] material;    
    
    // definir una variable que determine cual es el presupuesto de la biblioteca
    private Double credito;
    
    // definir una variable de control para saber cuantos documentos tiene la biblioteca
    private Integer cantidadDocumentos;
    
    public Suscriptor(){
        this.material = new MaterialCapacitacion[CAPACIDAD_DOCUMENTOS];
        cantidadDocumentos=0;
        credito=0.0;
    }    
    
    public Suscriptor(String nombre){
        this();
        this.nombre=nombre;
    }       

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }
    
    public void listarSuscripciones(){
         System.out.println("SUSCRIPCIONES DEL USUARIO");       
         for(MaterialCapacitacion unMaterial: this.material){
             if(unMaterial!=null){
                 System.out.println("     >"+unMaterial.getTitulo());
             }
         }
    }
    
    public void agregar(MaterialCapacitacion d){
       if(d.precio() < this.disponible()){
           Integer i=0;
           while(i<material.length){
               if(material[i] != null){
                   i++;
               }
               else{
                   material[i]=d;
                   i=material.length+1;
               }
           }
           if(i==material.length){
               System.out.println ("No se pudo agregar el material");
           }
           else{
                System.out.println ("El material se ha agregado");   
           }
           d.suscribir();
           
           
       }
    }

    public void quitar(MaterialCapacitacion d){
         Integer i=0;
           while(i < material.length){
               if(material[i] != d){
                   i++;
                   
               }
               else{
                   material[i]=null;
                   i=material.length+1;
               }
           }
           if(i==material.length){
               System.out.println ("No se pudo quitar el material");
           }
           else{
                System.out.println ("El material se ha quitado");   
           }
        
    }   
    
    private Double costo(){
        Double totalizador = 0.0;
        for(MaterialCapacitacion d:this.material){
            if(d!=null)totalizador +=d.precio();
        }
        return totalizador;
    }

    public Double disponible(){
        return this.credito-costo();
    }

    @Override
    public String toString() {
        return "Suscriptor{" + "nombre=" + nombre + ", credito=" + credito + '}';
    }

    

}
