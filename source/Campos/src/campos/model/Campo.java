/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Optional;

/**
 *
 * @author George
 */
public class Campo extends Observable {

    private Integer id;
    private String nombre;
    private List<Lote> lotes;
    private EstadoCampo estado;

    public Campo() {
        this.lotes = new ArrayList<>();
    }
    
    public Campo(EstadoCampo estado){
        this();
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        this.setChanged();
        this.notifyObservers();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.setChanged();
        this.notifyObservers();
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
        this.setChanged();
        this.notifyObservers();
    }

    public EstadoCampo getEstado() {
        return estado;
    }

    public void setEstado(EstadoCampo estado) {
        this.estado = estado;
    }
    
    

    public void agregarLote(Lote l) {
        this.lotes.add(l);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void quitarLote(Lote l){
        this.lotes.remove(l);
        this.setChanged();
        this.notifyObservers();
    }

    public Optional<Lote> obtenerLote(Integer nroLote) {
        for (Lote l : this.lotes) {
            if (l.getNumero().equals(nroLote)) {
                return Optional.of(l);
            }
        }
        return Optional.empty();
    }

    public Double getSuperficie() {
        Double superficieTotal = 0.0;
        for (Lote l : this.lotes) {
            superficieTotal += l.getSuperficie();
        }
        return superficieTotal;
    }

    public Integer getProximoNroLote() {
        if(this.lotes.isEmpty()){
            return 1;
        }
        Lote max = Collections.max(lotes, new Comparator<Lote>() {
            @Override
            public int compare(Lote o1, Lote o2) {
                return o1.getNumero().compareTo(o2.getNumero());
            }
        });
        return max.getNumero() + 1;
    }

}
