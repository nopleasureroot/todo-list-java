import java.time.LocalDateTime;import java.util.ArrayList;import java.util.List;import java.util.Scanner;public class Main {    static List<Task> tasks = new ArrayList<>();    static Scanner scanner = new Scanner(System.in);    /**     * Task - {     *     name - String,     *     priority - Integer,     *     createdAt - LocalDateTime,     *     deadline - LocalDateTime,     *     status - DONE, IN_PROGRESS, READY_FOR_WORK, CANCELED     * }     * ToDo list     * 1) Добавлять новое дело +     * 2) Удалять дело по какому-то параметру +     * 3) Получать все дела +     * 4) Получать дела по названию +     * 5) Блок меню +     * 6) Переводить задачу по статусной модели +     * 7) Сохранение задач в файл +     * 8) Вычитывание из файла при запуске программы +     */    public static void main(String[] args) {        menu();    }    static void menu() {        FileUtil.readFromFile(tasks);        int choice;        while(true) {            UtilFunctions.printMenu();            choice = scanner.nextInt();            switch (choice) {                case 1: {                    addTask();                    UtilFunctions.pressToStart(scanner);                } break;                case 2: {                    tasks.forEach(UtilFunctions::printTask);                    UtilFunctions.pressToStart(scanner);                } break;                case 3: {                    findTaskByName();                    UtilFunctions.pressToStart(scanner);                }                case 4: {                    changeTaskStatus();                    UtilFunctions.pressToStart(scanner);                }                case 5: {                    deleteTask();                    UtilFunctions.pressToStart(scanner);                }                default:                    System.out.println(Constants.NOT_EXIST_MENU);            }        }    }    /**     * This method can find task by name     */    static void findTaskByName() {        System.out.println("Пожалуйста, введите название задачи: ");        scanner.nextLine();        String name = scanner.nextLine();        tasks.stream().filter((el) -> el.getName().equalsIgnoreCase(name))                .forEach(UtilFunctions::printTask);    }    /**     * This method can change task status by name     */    static void changeTaskStatus() {        System.out.println("Пожалуйста, введите название задачи, для которой нужно изменить статус: ");        scanner.nextLine();        String name = scanner.nextLine();        for (Task task : tasks) {            if (task.getName().equalsIgnoreCase(name)) {                System.out.println("Пожалуйста введите статус из представленных: DONE, READY_FOR_WORK, CANCELED, IN_PROGRESS");                String stringStatus = scanner.nextLine();                TaskStatus newStatus = TaskStatus.valueOf(stringStatus);                task.setStatus(newStatus);                System.out.printf("Статус успешно изменен на %s \n", newStatus);            }        }    }    /**     * This method can delete task by name     */    static void deleteTask() {        System.out.println("Enter name task: ");        scanner.nextLine();        String name = scanner.nextLine();        Task potentialForDeleteTask = null;        if (tasks.stream().anyMatch(el -> el.getName().equalsIgnoreCase(name))) {            for (Task task : tasks) {                if (task.getName().equalsIgnoreCase(name)) {                    potentialForDeleteTask = task;                }            }            tasks.remove(potentialForDeleteTask);            System.out.println("Задача успешно удалена");            return;        }        System.out.println("Задача не была найдена");    }    /**     * This method can add task     */    static void addTask() {        System.out.println("Enter name task: ");        scanner.nextLine();        String name = scanner.nextLine();        System.out.println("Enter priority task: ");        int priority = scanner.nextInt();        System.out.println("Enter day deadline: ");        int day = scanner.nextInt();        System.out.println("Enter hour deadline: ");        int hour = scanner.nextInt();        System.out.println("Enter minute deadline: ");        int minute = scanner.nextInt();        if (!ValidateFunctions.isValidInputForAddTask(tasks, name, priority, day, hour, minute)) {            System.out.println("Вы ввели некорректные данные, попробуйте еще раз");            return;        }        LocalDateTime createdAt = LocalDateTime.now();        LocalDateTime deadline = createdAt.plusDays(day).plusHours(hour).plusMinutes(minute);        Task task = new Task(name, priority, createdAt, deadline, TaskStatus.READY_FOR_WORK);        tasks.add(task);        FileUtil.writeToFile(task);    }}