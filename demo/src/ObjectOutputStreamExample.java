import java.io.*;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/save.txt"));
        Student student = new Student(1, "Dung", "113");
        oos.writeObject(student);
        oos.writeUTF("Ha Noi");
        oos.writeInt(123);
        oos.writeInt(456);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/save.txt"));
        Student std = (Student) ois.readObject();
        String address = ois.readUTF();
        Integer number1 = ois.readInt();
        Integer number2 = ois.readInt();
        System.out.println(std + ", " + address + ", " + number2);
        ois.close();
    }
}
