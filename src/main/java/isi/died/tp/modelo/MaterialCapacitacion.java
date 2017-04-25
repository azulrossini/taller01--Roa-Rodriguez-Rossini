/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.Ordenable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable  {
    protected String titulo;
    protected EstadoPromocion estado;
    protected Date fechaPublicacion;
    protected Integer suscripciones; /* se cambia a protegido como indica el diagrama de clase*/

    public MaterialCapacitacion() {
        this.suscripciones=0;
    }       

    public MaterialCapacitacion(String titulo) {
        this();
        this.titulo = titulo;
    } 
       
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
    
    protected Integer suscripciones(){
        return this.suscripciones;
    }
   
    public void publicar(){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = new Date();
    }
    
    public void publicar (String s){
        
        try{
            SimpleDateFormat Formatdf = new SimpleDateFormat(s);
            Date fechaDeseada = Formatdf.parse(s);
            Date hoy = new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(hoy);
            Calendar cDeseado = new GregorianCalendar();
            cDeseado.setTime(fechaDeseada);
            c.add(Calendar.DAY_OF_YEAR, -45);
            if((cDeseado.compareTo(c) < 0) || (cDeseado.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) || (cDeseado.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)){
                System.out.println("No se puede publicar el libro");
            }
            else{
                this.estado = EstadoPromocion.LANZAMIENTO;
                this.fechaPublicacion = fechaDeseada;
            }
        } 
        catch(ParseException e1){
            System.out.println("Error de parseo de fechas");
        }
    }
    
    public abstract Double precio();

    public abstract void liquidar();
    
    public void suscribir (){
        this.suscripciones++;
    }
   
    final public void cancelarSuscripcion(){
        this.suscripciones--;
    }
    
    @Override
    public Long valorOrdenamiento() {
        return Long.valueOf(numerarString(this.titulo)+""+formatoPrecio(this.precio()));
    }
    private Long formatoPrecio(Double precio){
        Long precioEntero = Math.round(precio);
        Long x = precioEntero%10000 ;
        Long formato = 10000+ x;
        return formato;
    }
        
    private Long numerarString(String arg){
        String origen = arg.toUpperCase();
        String resultado = "";
        char unChar ;
        for(int i =0;i<4;i++){
        Integer aux;
        if(i>origen.length()-1) aux = 37;
        else {
        unChar = origen.charAt(i);
        if(unChar>='A' && unChar <='Z'){ aux = unChar-54;
        }else{ aux = 38; }
        }
        resultado +=aux;
        }
        return Long.valueOf(resultado);
     }
    
    
        @Override
    public boolean equals (Object m){
        return (this.titulo.equalsIgnoreCase(((MaterialCapacitacion)m).titulo));
    }
    
    public final String fechaPublicacion(){
        String format = "dd/MM/yyyy";
        DateFormat df= new SimpleDateFormat(format);
        return df.format(fechaPublicacion);
    }
}
    
   
