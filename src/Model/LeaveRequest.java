package model;


public class LeaveRequest 
{
    private String name;
    private String summary;
    private String body;

    public LeaveRequest(String name, String summary) {
        this.name = name;
        this.summary = summary;
    }
    
    public LeaveRequest(String name, String summary, String body) {
        this.name = name;
        this.summary = summary;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" + "name=" + name + ", summary=" + summary + ", body=" + body + '}';
    }
}
