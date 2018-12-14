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
public class TipoSuelo {

    private Integer numero;
    private String descripcion;
    

    public TipoSuelo() {
    }

    public TipoSuelo(Integer numero, String descripcion) {
        this.comprobarNumero(numero);
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.comprobarNumero(numero);
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private void comprobarNumero(Integer numero) {
        if (numero < 1 || numero > 5) {
            throw new IllegalArgumentException(
                    "El número de tipo de suelo se comprende entre 1 y 5"
            );
        }
    }

    @Override
    public String toString() {
        return this.getDescripcion();
    }

    
}
