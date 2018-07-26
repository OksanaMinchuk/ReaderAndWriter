package by.oksana.lesson8;
//В каждой строке найти и удалить заданную подстроку

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main (String[] arg) {

        Scanner in = new Scanner(System.in);

//        String str = null;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите строку");
//        try {
//            str = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("---"+str);

        /*FileInputStream fis = null;
        InputStreamReader ist = null;

        int a = 0;
        int count = 0;

        try {
            fis = new FileInputStream("/media/oksana/6388-4168/FilesForJava/FileForTask1.txt");
            ist = new InputStreamReader(fis, "UTF-8");
            while ((a = ist.read()) != -1) {
                System.out.print((char) a);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ist.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        System.out.println("Введите исходную строку");
        String str = in.nextLine();
        System.out.println("Введите подстроку, которую необходимо удалить");
        String strDelete = in.nextLine();
        String result = "";
        int i = 0;

        do {
            i=str.indexOf(strDelete);
            if (i != -1) {
                str = str.substring(0,i)+str.substring(i+strDelete.length());
            }
        } while (i != -1);

        writeFile(str);
   }

    public static void writeFile(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("FileOut1lesson8.txt");
            fileOutputStream.write(str.getBytes()); //Метод принимает массив байтов
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

