import java.io.*;
import java.util.Scanner;

class Singer implements Serializable {
    String fam, name, pol;
    int roct;
}

public class p7 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner (System.in, "cp1251");
        File f = new File ("C:\\Users\\Student\\222ser.txt");
        f.createNewFile ( );
        FileOutputStream fos = new FileOutputStream (f);
        ObjectOutputStream oos = new ObjectOutputStream (fos);
        System.out.println ("Введите количество сотрудников для записи в файл:");
        int k = sc.nextInt ( );
        sc.nextLine ( );

        for (int i = 0; i < k; i++) {

            Singer sing = new Singer ( );
            System.out.print ("фамилия => ");
            sing.fam = sc.nextLine ( );
            System.out.print ("имя => ");
            sing.name = sc.nextLine ( );
            System.out.print ("пол => ");
            sing.pol = sc.nextLine ( );
            System.out.print ("рост => ");
            sing.roct = sc.nextInt ( );
            oos.writeObject (sing);
            sc.nextLine ( );

        }

        oos.flush ( );
        oos.close ( );
        fos.close ( );
        sc.close ( );

        FileInputStream fis = new FileInputStream (f);
        ObjectInputStream oin = new ObjectInputStream (fis);
        Singer singer;

        File f2 = new File ("C:\\Users\\Student\\222ser222.txt");
        if (f2.exists ( )) f2.delete ( );
        f2.createNewFile ( );

        FileOutputStream fos2 = new FileOutputStream (f2);
        ObjectOutputStream oos2 = new ObjectOutputStream (fos2);
        FileInputStream fis2 = new FileInputStream (f);
        ObjectInputStream oin2 = new ObjectInputStream (fis2);
        System.out.println ("выше ростом 170");
        for (int i = 0; i < k; i++) {
            singer = (Singer) oin2.readObject ( );
            if (singer.roct > 170) {
                oos2.writeObject (singer);
                System.out.println ("фамилия: "+singer.fam+" "+"имя: "+singer.name+" "+"пол: "+singer.pol+" "+"рост: " +singer.roct);

            }

        }

        oin2.close ( );
        fis2.close ();
        oos2.flush ();
        oos2.close ( );
        fos2.close ();


    }
}
