/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author FPALES
 */
public class Complain {
    
    private int id;
    private String ticketNo;
    private int orderId;
    private String message;
    private String status;
    private String dateCreated;
    private String dateResolved;
    private int response_id;
    private String response;
    private int user_id;

   
    
    
    public Complain(){
        
    }
    public Complain(String ticketNo, int orderId, String message, String status, String dateCreated, String dateResolved, int response_id, String response, int user_id) {
        this.ticketNo = ticketNo;
        this.orderId = orderId;
        this.message = message;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateResolved = dateResolved;
        this.response_id = response_id;
        this.response = response;
        
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateResolved() {
        return dateResolved;
    }

    public void setDateResolved(String dateResolved) {
        this.dateResolved = dateResolved;
    }
    public int getResponse_id() {
        return response_id;
    }

    public void setResponse_id(int response_id) {
        this.response_id = response_id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
     public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
