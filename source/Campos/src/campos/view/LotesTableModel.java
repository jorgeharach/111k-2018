/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.view;

import campos.model.Lote;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author George
 */
public class LotesTableModel 
        extends AbstractTableModel{

    private static final String[] COLUMN_NAMES = {"Nro", "Superficie", "Tipo de Suelo"};
    
    private List<Lote> data;

    public LotesTableModel() {
        this.data = new ArrayList<>();
    }
    
    
    public LotesTableModel(List<Lote> data){
        this.data = data;
    }
    
    public void setData(List<Lote> data){
        this.data = data;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lote solicitado = this.data.get(rowIndex);
        switch(columnIndex){
            case 0: return solicitado.getNumero();
            case 1: return solicitado.getSuperficie();
            case 2: return solicitado.getTipoSuelo();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
    public Optional<Lote> getLoteEn(int row){
        if(row < 0 || row >= this.data.size()){
            return Optional.empty();
        }
        return Optional.of(this.data.get(row));
    }
    
}
