import java.util.Date;
import java.text.SimpleDateFormat;
class DoList {
    /**
     * ten = 10.
     */
    private final int ten = 10;
    /**
     * tasks to be done of todolist type.
     */
    private ToDoList[] tasks = new ToDoList[ten];
    /**
     * taskcount represents number of task to be done.
     */
    private int taskCount = 0;
    public void addTask(final ToDoList task) {
        tasks[taskCount] = task;
        taskCount++;
    }
    public boolean removeTask(final String task) {
        int temp = 0;
        boolean value = false;
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equals(task)) {
                temp = i;
                value = true;
            }
        }
        if (!value) {
            return false;
        }
        for (int j = temp; j < taskCount - 1; j++) {
            tasks[j] = tasks[j + 1];
        }
        taskCount--;
        return true;
    }
    public void updateTask(final String taskName, final String status) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equals(taskName)) {

                tasks[i].setStatus(status);
            }
        }
    }
    public void dispPendingTasks() {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getStatus().equals("incomplete")
                || tasks[i].getStatus().equals("in process")) {
                System.out.println(tasks[i].toString());

            }
        }
    }
    public void dispTaskAccToDate(final String date) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getDate().equals(date)) {
                System.out.println(tasks[i].toString());

            }
        }
    }
    public void findTask(final String name) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equals(name)) {
                System.out.println(tasks[i].toString());
            }
        }
    }
    public void display() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(tasks[i].toString());
        }
    }
    public void overDueTasks() throws Exception {
        Date date = new Date();
        for (int i = 0; i < taskCount; i++) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date target = formatter.parse(tasks[i].getDate());
            boolean b = target.before(date);
            if (b && tasks[i].getStatus() != "complete") {
                System.out.println(tasks[i].toString());
            }
        }
    }
}
