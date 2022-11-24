package com.raven.swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellActionCrops extends DefaultCellEditor {

    private ModelActionCrops data;
   

    public TableCellActionCrops() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionCrops) o;
        ActionCrops cell = new ActionCrops(data);
        cell.setBackground(new Color(255, 255, 255));
        return cell;
    }
    
    

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
