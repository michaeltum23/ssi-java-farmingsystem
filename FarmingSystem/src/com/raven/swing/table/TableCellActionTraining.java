package com.raven.swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellActionTraining extends DefaultCellEditor {

    private ModelActionTraining data;
   

    public TableCellActionTraining() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionTraining) o;
        ActionTraining cell = new ActionTraining(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }
    
    

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
