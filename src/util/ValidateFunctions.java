package util;

import model.Task;

import java.util.List;

public class ValidateFunctions {
    public static boolean isValidInputForAddTask(List<Task> tasks, String name, int priority, int day, int hour, int minute) {
        if (!name.isEmpty() && (priority > 0 && priority <= 10)) {
            if ((day >= 0 && day <= 31) && (hour >= 0 && hour <= 24) && (minute >= 0 && minute < 60)) {
                if (day == 0 && hour == 0 && minute == 0) {
                    return false;
                } else {
                    if (tasks.stream().filter(el -> el.getName().equalsIgnoreCase(name)).count() != 0) {
                        return false;
                    }

                    return true;
                }
            }
        }

        return false;
    }
}
