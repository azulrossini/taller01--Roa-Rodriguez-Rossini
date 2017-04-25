/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion{
    private Double costo;
    private String isbn;
    private Integer paginas;

    public Libro(String titulo, Double costo, String isbn, Integer paginas ) {
        super(titulo);
        this.costo = costo;
        this.isbn = isbn;
        this.paginas = paginas;
        this.estado = EstadoPromocion.ACCESO_TEMPRANO;
    }
    
    
    public Libro() {
    }    

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }
   
    public void publicar(Date fechaEspecifica){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = fechaEspecifica;
    }
    
    public void publicar (String s){
        super.publicar(s);
        this.estado = EstadoPromocion.LANZAMIENTO;
    }
    
    @Override
    public Double precio(){   
        double costoregular = this.costo+((this.paginas/150)*(this.costo*0.03));
        
        switch(this.estado){
            case REGULAR:  return costoregular;
            case ACCESO_TEMPRANO: return costoregular*0.9;
            case LANZAMIENTO: return costoregular*1.2;
            case OFERTA: return this.costo*0.8;
        } 
    return 0.0;
    }
          
    @Override
    public void liquidar() {
        this.estado = EstadoPromocion.OFERTA;
    }
    
    @Override
    public void suscribir(){
        super.suscribir();
        if(2 < this.suscripciones){
            this.estado = EstadoPromocion.REGULAR;
        }
    }
    
    @Override
    public boolean equals(Object m){
        return ((m instanceof Libro) && super.equals(m));
    }


    
    
}