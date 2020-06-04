import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {
        try {
            File folder = new File("C:\\Users\\Student");
            if (!folder.exists())
                folder.mkdir();
            File f1 = new File("C:\\Users\\Student\\file123.txt");
            if (f1.exists()) f1.delete();
                f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1,"rw"); // чтение и запись
            long fSize = rf.length(); // размер файла
            Scanner sc = new Scanner(System.in, "cp1251");
            System.out.print("Введите количество людей для записи в файл\n");
            int kol = sc.nextInt();
            sc.nextLine(); // очистка буфера после ввода числа

            String fam, name, god;
            int mes;
//----ЗАПИСЬ ИНФОРМАЦИИ О СОТРУДНИКАХ В ФАЙЛ----
            for (int i = 0; i < kol; i++) {
                System.out.print("Введите фамилию " + (i + 1) + " человека => ");
                fam = sc.next();
                rf.seek(rf.length()); // поиск конца файла
                rf.writeUTF(fam); // запись фамилии
                for (int j = 0; j < 20 - fam.length(); j++)
                    rf.writeByte(1); // добавление байтов до 20-ти любой цифрой (=1)
                System.out.print("Введите имя => ");
                name = sc.next();
                rf.writeUTF(name); // запись должности
                for (int j = 0; j < 20 - name.length(); j++)
                    rf.writeByte(1); // добавление байтов до кол=20 любым числом
                System.out.print("Введите год рождения => ");
                god = sc.next();
                rf.writeUTF(god); // запись должности
                for (int j = 0; j < 20 - pol.length(); j++)
                    rf.writeByte(1); // добавление байтов до кол=20 любым числом
                System.out.print("Введите его месяц рождения в цифрах => ");
                mes = sc.nextInt();
                sc.nextLine(); // очистка буфера
                rf.writeInt(mes); // запись оклада

            }


            File f2 = new File("C:\\Users\\Student\\file222.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();
            RandomAccessFile rf2 = new RandomAccessFile(f2,"rw"); // чтение и запись

            for (int i = 0; i < kol; i++) {
                rf.seek(66 + 70*i);
                int mes = rf.readInt();
                if(mes==01){

                    long fSize2 = rf2.length(); // размер файла
                    rf2.writeInt(rost);
                   rf.seek(0+70*i);
                   String sn = rf.readUTF();
                   rf2.writeUTF(sn);

                   rf.seek(22+70*i);
                   String fn = rf.readUTF();
                    rf2.writeUTF(fn);

                   rf.seek(44+70*i);
                   String p = rf.readUTF();
                    rf2.writeUTF(p);

                    System.out.print("рожденные в январе\n");
                    System.out.println("фамилия: " + sn + " " + "имя: "+ fn + " "+ " год рождения: " + p + " " + "месяц рождения: "+ rost);
                    //rf.writeUTF(sn + " " + fn + " " + p + " " + mes);
                }
            }

            rf.close();
        } catch (IOException e) {
            System.out.println("End of file " + e);
        } }}
