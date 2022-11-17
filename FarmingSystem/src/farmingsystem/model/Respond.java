
package farmingsystem.model;


public class Respond {
    private int id;
    private int user_id;
    private String userid;
    private int complaint_id;   
    private String response_date;
    private String response_body;
    
     public Respond(){
         
     }

    public Respond(int id, int user_id, String userid, int complaint_id, String response_date, String response_body) {
        this.id = id;
        this.user_id = user_id;
        this.userid = userid;
        this.complaint_id = complaint_id;
        this.response_date = response_date;
        this.response_body = response_body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getResponse_date() {
        return response_date;
    }

    public void setResponse_date(String response_date) {
        this.response_date = response_date;
    }

    public String getResponse_body() {
        return response_body;
    }

    public void setResponse_body(String response_body) {
        this.response_body = response_body;
    } 
}
