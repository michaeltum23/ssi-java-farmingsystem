/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import com.raven.swing.table.EventActionUser1;
import com.raven.swing.table.ModelActionUser1;
import javax.swing.JTextArea;

/**
 *
 * @author RPAGUIO
 */
public class FarmingTips {

    private int id;
    private String title;
    private String content;
    private JTextArea ta;

    public FarmingTips() {

    }

    public FarmingTips(int id, String title, JTextArea ta) {
        this.id = id;
        this.title = title;
        this.ta = ta;
    }

    
    public Object[] toRowTable(EventActionUser1 event) {
        return new Object[]{id, title, ta, new ModelActionUser1(this, event)};
    }

    public FarmingTips(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
