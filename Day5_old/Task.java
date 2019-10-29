import java.util.Date;
class Task {
    private String name;
    private String description;
    private Date dueDate;
    private String status;
    public String getName() {
        return name;
    }
    public void setName(final String name1) {
        this.name = name1;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(final String description1) {
        this.description = description1;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(final Date dueDate1) {
        this.dueDate = dueDate1;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(final String status1) {
        this.status = status1;
    }
    Task() {
        
    }
    Task(final String name1, final String description1, final Date dueDate1, final String status1) {
        this.name = name1;
        this.description = description1;
        this.dueDate = dueDate1;
        this.status = status;
    }
}