import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class TodoList {
    Task[] tasks;
    private int count = 0;
    TodoList() {
        tasks = new Task[10];
    }
    private static Task[] getTaskContents(final Task[] task1) {
        int p = 0;
        for (int i = 0; i < task1.length; i++) {
            if (task1[i] != null) {
                p = p + 1;
            }
        }
        Task[] newTask = new Task[p];
        p = 0;
        for (int i = 0; i < task1.length; i++) {
            if (task1[i] != null) {
                newTask[p] = task1[i];
                p = p + 1;
            }
        }
        return newTask;
    }
    private static Task[] reSize(final Task[] task) {
        Task[] newTask = new Task[task.length * 2];
        System.arraycopy(task, 0, newTask, 0, task.length);
        return newTask;
    }
    public void addTask(final Task task) {

        if (count == tasks.length) {
            tasks = reSize(tasks);
        }
        tasks[count] = task;
        count++;
    }
    public void removeTask() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" removeTask : enter taskName ");
        String taskName = scan.next();
        tasks = getTaskContents(tasks);

        while (true) {
            int index = -1;
            for (int i = 0; i < count; i++) {
                if (tasks[i].getName().equals(taskName)) {
                    index = i;
                }
            }
            if (index == -1) {
                break;
            }
            count--;
            for (int i = index; i < tasks.length - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[count] = null;
        }
    }
    public void updateStatusOfTask() {

        Scanner scan = new Scanner(System.in);
        System.out.println(" updateTask : enter taskName ");
        String taskName = scan.next();
        System.out.println(" updateTask : enter status ");
        String status = scan.next();

        tasks = getTaskContents(tasks);

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().equals(taskName)) {
                tasks[i].setStatus(status);
                break;
            }
        }
    }
    public void displayPendingTasks() {

        tasks = getTaskContents(tasks);

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getStatus().equals("incomplete")
                || tasks[i].getStatus().equals("in process")) {
                System.out.println("Name : " + tasks[i].getName());
                System.out.println("Descrption : " + tasks[i].getDescription());
                System.out.println("Due Date : " + tasks[i].getDueDate());
                System.out.println("Status : " + tasks[i].getStatus());
            }
        }
    }
    public void displayTasksBasedOnDate(final String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = sdf.parse(date);
            for (int i = 0; i < count; i++) {
                if (tasks[i].getDueDate().equals(date1)) {
                    System.out.println(tasks[i].getName() + "   "
                    + tasks[i].getDescription() + "   "
                    + tasks[i].getDueDate() + "   "
                    + tasks[i].getStatus()
                    );
                }
            }
        } catch (Exception e) {
            }
    }
    public Task findTask(final String taskName) {

        // Scanner scan = new Scanner(System.in);
        // System.out.println(" removeTask : enter taskName ");

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().equals(taskName)) {
                return tasks[i];
            }
        }
        return null;

    }
    public Task[] getAllOverDueTasks() {
        Date date = new Date();
        int num = 0;
        Task[] temp = new Task[0];
        for (int i = 0; i < count; i++) {
            if (tasks[i].getDueDate().after(date)) {
                num = num + 1;
            }
        }
        if (num != 0) {
            Task[] overDue = new Task[num];
            num = 0;
            for (int i = 0; i < count; i++) {
                if (tasks[i].getDueDate().after(date)) {
                    overDue[num] = tasks[i];
                    num = num + 1;
                }
            }
            return overDue;
        }
        return temp;
    }
    public void displayAllTasks() {
        tasks = getTaskContents(tasks);
        for (int i = 0; i < tasks.length; i++) {
            System.out.println("Name : " + tasks[i].getName());
            System.out.println("Description : " + tasks[i].getDescription());
            System.out.println("Due Date : " + tasks[i].getDueDate());
            System.out.println("Status : " + tasks[i].getStatus());
        }
    }
}