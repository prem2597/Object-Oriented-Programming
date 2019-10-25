/**
 * todolist class which acts as a memorandam.
 * it contaoins taskname
 * it contains taskdescription.
 * it contains duedate.
 * it contains status.
 */
class ToDoList {
    /**.
     * taskname contains name of the task.
     */
    private String taskName;
    /**.
     * task description contains what to do.
     */
    private String taskDescription;
    /**.
     * duedate represents deadline.
     */
    private String dueDate;
    /**.
     * status about the task whether done or not.
     */
    private String status;
    /**
     * default constructor.
     */
    ToDoList() {
        this.taskName = "";
        this.taskDescription = "";
        this.dueDate = "";
        this.status = "";
    }
    /**
     * parametrised constructor.
     * represents constructor overloading here.
     * @param task taskto be done.
     * @param description task description.
     * @param date date to represent the deadline.
     * @param status1 postion of the task.
     */
    ToDoList(final String task, final String description,
        final String date, final String status1) {
        this.taskName = task;
        this.taskDescription = description;
        this.dueDate = date;
        this.status = status1;
    }
    public String getName() {
        return this.taskName;
    }
    public void setName(final String toset) {
        this.taskName = toset;
    }

    public String getTaskDes() {
        return this.taskDescription;
    }
    public void setTaskDes(final String toset) {
        this.taskDescription = toset;
    }

    public String getDate() {
        return this.dueDate;
    }
    public void setDate(final String toset) {
        this.dueDate = toset;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(final String toset) {
        this.status = toset;
    }
    public String toString() {
        return ("Task Name = " + this.taskName
            + "\nTask description = " + this.taskDescription
            + "\nDue Date = " + this.dueDate
            + "\nStatus = " + this.status);
    }
}
