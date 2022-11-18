
package farmingsystem.model;

public class Respond {
    private int id;
    private int user_id;
    private String response_body;
    private String response_date;
    
    private int complaint_id;
    private String complaint_message;
    private int complaint_user_id;

    public Respond() {
        }

    public Respond(int id, int user_id, String response_body, String response_date, int complaint_id, String complaint_message, int complaint_user_id) {
        this.id = id;
        this.user_id = user_id;
        this.response_body = response_body;
        this.response_date = response_date;
        this.complaint_id = complaint_id;
        this.complaint_message = complaint_message;
        this.complaint_user_id = complaint_user_id;
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

    public String getResponse_body() {
        return response_body;
    }

    public void setResponse_body(String response_body) {
        this.response_body = response_body;
    }

    public String getResponse_date() {
        return response_date;
    }

    public void setResponse_date(String response_date) {
        this.response_date = response_date;
    }

    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getComplaint_message() {
        return complaint_message;
    }

    public void setComplaint_message(String complaint_message) {
        this.complaint_message = complaint_message;
    }

    public int getComplaint_user_id() {
        return complaint_user_id;
    }

    public void setComplaint_user_id(int complaint_user_id) {
        this.complaint_user_id = complaint_user_id;
    }

    
    
}
