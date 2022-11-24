package com.raven.swing.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAction1 extends DefaultCellEditor {

    private ModelActionUser1 data;
   

    public TableCellAction1() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionUser1) o;
        Action1 cell = new Action1(data);
        cell.setBackground(new Color(255,255,255));
        return cell;
    }
    
    

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
