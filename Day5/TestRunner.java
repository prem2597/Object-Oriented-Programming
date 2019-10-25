public class TestRunner{
	public static void main(String[] args) throws Exception {
		DoList obj = new DoList();
		obj.addTask(new ToDoList("task1", "desc1", "24/09/2019", "incomplete"));
		obj.addTask(new ToDoList("task2", "desc2", "23/09/2019", "in process"));
		obj.addTask(new ToDoList("task3", "desc3", "23/09/2019", "in process"));
		obj.addTask(new ToDoList("task4", "desc4", "11/11/2019", "incomplete"));

		System.out.println("Finding a task by name");
		obj.findTask("task2");
		System.out.println("\n Updating a task: task3");
		obj.updateTask("task3", "complete");
		System.out.println("\n getting all pending tasks");
		obj.dispPendingTasks();
		System.out.println("\n Finding a task by due Date");
		obj.dispTaskAccToDate("23/09/2019");
		System.out.println("\n Removing a task");
		System.out.println(obj.removeTask("task4"));
		System.out.println("\n All tasks");
		obj.display();
		System.out.println("\n Overdue tasks");
		obj.overDueTasks();
	}
}
