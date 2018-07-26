package by.oksana.lesson8;
//Создать и заполнить файл случайными целыми числами.
//Отсортировать содержимое файла по возрастанию

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Task5 {
    public static void main (String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество элементов массива");
        int k = in.nextInt();
        int [] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = (int)(Math.random()*100);
        }

        int sort = 0;
        writeFile(arr, sort); // в файл
        printArr(arr); // на экран

        System.out.println("\nВведите 1 - сортировка по возрастанию, 2 - по убыванию");
        sort = in.nextInt();
        switch (sort) {
            case 1:
                // по возрастанию
                for (int j = 1; j < arr.length - 1; j++) {
                    for (int i = 0; i < arr.length - 1; i++) {
                        if (arr[i] > arr[i + 1]) {
                            int temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;
                        }
                    }
                }
                System.out.println("по возрастанию");
                printArr(arr);
            break;
            case 2:
                // по убыванию
                for (int j = 1; j < arr.length - 1; j++) {
                    for (int i = 0; i < arr.length - 1; i++) {
                        if (arr[i] < arr[i + 1]) {
                            int temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;
                        }
                    }
                }
                System.out.println("по убыванию");
                printArr(arr);
            break;
        }
        writeFile(arr, sort);
    }

    public static void printArr(int arr[]) {
        for (int elem: arr) {
            System.out.printf("%3d", elem);
        }
    }

    public static void writeFile(int arr[], int sort) {
        FileWriter fr = null;
        File file = new File("FileOut5lesson8.txt");

        String str = "";
        if (sort == 1) {
            str = "по возрастанию: ";
        } else if (sort == 2){
            str = "по убыванию: ";
        } else {
            str = "до сортировки: ";
        }

        try {
            fr = new FileWriter(file, true);
            fr.write("\n"+str);
            for (int i = 0; i < arr.length; i++) {
                String s = Integer.toString(arr[i]);
                fr.write(s+"; ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
