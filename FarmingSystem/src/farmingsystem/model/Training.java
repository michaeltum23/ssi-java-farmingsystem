/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author jtamayo
 */
public class Training {
    private int id;
    private String title;
    private String description;
    private String scheduleDate;
    private String schedulteTime;
    private InputStream trainingImage;
    private File file;
    private String status;
    
    public Training(){
        
    }

    public Training(int id, String title, String description, String scheduleDate, String schedulteTime, InputStream trainingImage, File file, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.scheduleDate = scheduleDate;
        this.schedulteTime = schedulteTime;
        this.trainingImage = trainingImage;
        this.file = file;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getSchedulteTime() {
        return schedulteTime;
    }

    public void setSchedulteTime(String schedulteTime) {
        this.schedulteTime = schedulteTime;
    }

    public InputStream getTrainingImage() {
        return trainingImage;
    }

    public void setTrainingImage(InputStream trainingImage) {
        this.trainingImage = trainingImage;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
