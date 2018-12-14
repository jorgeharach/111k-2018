/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.model;

/**
 *
 * @author George
 */
public class Lote {
    
    private Integer id;
    private Integer numero;
    private Double  superficie;
    private TipoSuelo tipoSuelo;

    public Lote() {
    }

    public Lote(Integer numero, Double superficie, TipoSuelo tipoSuelo) {
        this.numero = numero;
        this.superficie = superficie;
        this.tipoSuelo = tipoSuelo;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public TipoSuelo getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(TipoSuelo tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }
    
}
