package util;

import model.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileUtil {
    public static void writeToFile(Task task) {
        // input - ввод - чтение
        // output - вывод - запись
        try (FileOutputStream fos = new FileOutputStream("./tasks.dat", true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(task);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readFromFile(List<Task> tasks) {
        try (FileInputStream fileInputStream = new FileInputStream("./tasks.dat")) {
            while (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Task task = (Task) objectInputStream.readObject();
                if (task != null)
                    tasks.add(task);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
