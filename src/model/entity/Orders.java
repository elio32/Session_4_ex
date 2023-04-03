package model.entity;

public class Orders {

    private Integer id;
    private String status;
    private String comments;

    public Orders() {
    }

    public Orders(Integer id, String status, String comments) {
        this.id = id;
        this.status = status;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
