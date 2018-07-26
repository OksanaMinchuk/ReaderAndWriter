package by.oksana.lesson8;

import java.io.*;
import java.util.Scanner;

public class ReadAndWriteInFile {
    public static void main (String[] arg)  {

    }

    public static void readFile(){
        FileInputStream fis = null;
        InputStreamReader ist = null;
        int COUNT = 0;
        int a = 0;
        try {
            fis = new FileInputStream("FileForTask1.txt");
            ist = new InputStreamReader(fis, "UTF-8");
            while ((a = ist.read()) != -1) {
                System.out.print((char) a);
                COUNT++;
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
        }

    }



    public static void writeFile() {
        FileOutputStream fileOutputStream = null;
        String str = "qwerty!!";

        try {
            fileOutputStream = new FileOutputStream("FileOut1.txt");
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
