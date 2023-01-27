import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    /**
     * Task - {
     *     name - String,
     *     priority - Integer,
     *     createdAt - LocalDateTime,
     *     deadline - LocalDateTime,
     *     status - DONE, IN_PROGRESS, READY_FOR_WORK, CANCELED
     * }
     * ToDo list
     * 1) Добавлять новое дело
     * 2) Удалять дело по какому-то параметру
     * 3) Получать все дела
     * 4) Получать дело по названию
     * 5) Блок меню
     * 6) Переводить задачу по статусной модели
     * 7) Сохранение задач в файл
     */

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int choice;
        while(true) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    addTask();
                    scanner.nextLine();
                } break;
                case 2: {
                    tasks.forEach(Main::printTask);
                    scanner.nextLine();
                } break;
                default:
                    System.out.println("Такого пункта меню не существует");
            }

        }
    }

    static void printMenu() {
        System.out.println("\t\t\tПожалуйста, выберите нужный пункт для начала работы");
        System.out.println("\t\t\t1) Добавить новую задачу");
        System.out.println("\t\t\t2) Вывести все задачи");
    }

    static void printTask(Task task) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("\t\t\tНазвание: %s \n", task.getName());
        System.out.printf("\t\t\tПриоритет: %s \n", task.getPriority());
        System.out.printf("\t\t\tДата создания: %s \n", task.getCreatedAt());
        System.out.printf("\t\t\tДедлайн: %s \n", task.getDeadline());
        System.out.printf("\t\t\tСтатус задачи: %s \n", task.getStatus());
    }

    static void addTask() {
        System.out.println("Enter name task: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("Enter priority task: ");
        int priority = scanner.nextInt();

        System.out.println("Enter day deadline: ");
        int day = scanner.nextInt();

        System.out.println("Enter hour deadline: ");
        int hour = scanner.nextInt();

        System.out.println("Enter minute deadline: ");
        int minute = scanner.nextInt();

        if (!isValidInputForAddTask(name, priority, day, hour, minute)) {
            System.out.println("Вы ввели некорректные данные, попробуйте еще раз");

            return;
        }

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime deadline = createdAt.plusDays(day).plusHours(hour).plusMinutes(minute);

        Task task = new Task(name, priority, createdAt, deadline, TaskStatus.READY_FOR_WORK);
        tasks.add(task);
    }

    static boolean isValidInputForAddTask(String name, int priority, int day, int hour, int minute) {
        if (!name.isEmpty() && (priority > 0 && priority <= 10)) {
            if ((day >= 0 && day <= 31) && (hour >= 0 && hour <= 24) && (minute >= 0 && minute < 60)) {
                if (day == 0 && hour == 0 && minute == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}


