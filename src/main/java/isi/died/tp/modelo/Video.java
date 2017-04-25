
package isi.died.tp.modelo;


public class Video extends MaterialCapacitacion{
    
    public Integer duracion;
    public Double costo;

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Video() {
    }

    public Video(Integer duracion, Double costo, String titulo) {
        super(titulo);
        this.duracion = duracion;
        this.costo = costo;
        this.estado = EstadoPromocion.REGULAR;
    }
    
    @Override
     public Double precio(){   
        double costoregular = this.duracion*this.costo;
        
        switch(this.estado){
            case REGULAR:  return costoregular;
            case OFERTA: return this.costo*0.5;
        } 
    return 0.0;
    }
     
    @Override
    public void liquidar() {
        this.estado = EstadoPromocion.OFERTA;
    }
    
    @Override
    public boolean equals(Object m){
        return ((m instanceof Video) && super.equals(m));
    }
    
    @Override
     public void publicar (String s){
        super.publicar(s);
        this.estado = EstadoPromocion.REGULAR;
    }
}
