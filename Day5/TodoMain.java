import java.text.SimpleDateFormat;
import java.util.Date;
final class TodoMain {

    private TodoMain() {

    }
    private static void setDetails(final String name, final String description,
                                         final String status, final Task task) {
        task.setName(name);
        task.setDescription(description);
        task.setStatus(status);
    }
    public static void main(final String[] args) {
        TodoList todoList = new TodoList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        Task task4 = new Task();
        Task task5 = new Task();
        Task task6 = new Task();
        try {
            Date date1 = sdf.parse("15/10/1997");
            Date date2 = sdf.parse("15/10/2015");
            Date date3 = sdf.parse("15/10/2016");
            Date date4 = sdf.parse("15/10/2017");
            Date date5 = sdf.parse("15/10/2018");
            Date date6 = sdf.parse("15/10/2019");

            task1.setDueDate(date1);
            task2.setDueDate(date2);
            task3.setDueDate(date3);
            task4.setDueDate(date4);
            task5.setDueDate(date5);
            task6.setDueDate(date6);
        } catch (Exception e) {
            }
        setDetails("task-1", "description-1", "incomplete", task1);
        setDetails("task-2", "description-2", "in process", task2);
        setDetails("task-3", "description-3", "complete", task3);
        setDetails("task-4", "description-4", "incomplete", task4);
        setDetails("task-5", "description-5", "complete", task5);
        setDetails("task-6", "description-6", "in process", task6);
        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);
        todoList.addTask(task4);
        todoList.addTask(task5);
        todoList.addTask(task6);
        Task[] overDueTasks = todoList.getAllOverDueTasks();
        if (overDueTasks.length != 0) {
            for (int i = 0; i < overDueTasks.length; i++) {
                System.out.println(overDueTasks[i].getName() + "   "
                + overDueTasks[i].getDescription() + "   "
                + overDueTasks[i].getDueDate() + "   "
                + overDueTasks[i].getStatus());
            }
        }
    }
}