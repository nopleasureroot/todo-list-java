package util;

import model.Task;

import java.util.Scanner;

public class UtilFunctions {
    public static void pressToStart(Scanner scanner) {
        System.out.println("Нажмите любую клавишу, чтобы показать меню");

        scanner.nextLine();
        scanner.nextLine();
    }

    public static void printMenu() {
        System.out.println("\t\t\tПожалуйста, выберите нужный пункт для начала работы");
        System.out.println("\t\t\t1) Добавить новую задачу");
        System.out.println("\t\t\t2) Вывести все задачи");
        System.out.println("\t\t\t3) Вывести все задачи по названию");
        System.out.println("\t\t\t4) Изменить статус задачи");
        System.out.println("\t\t\t5) Удалить задачу по имени");
    }

    public static void printTask(Task task) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("\t\t\tНазвание: %s \n", task.getName());
        System.out.printf("\t\t\tПриоритет: %s \n", task.getPriority());
        System.out.printf("\t\t\tДата создания: %s \n", task.getCreatedAt());
        System.out.printf("\t\t\tДедлайн: %s \n", task.getDeadline());
        System.out.printf("\t\t\tСтатус задачи: %s \n", task.getStatus());
    }
}
