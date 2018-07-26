package by.oksana.lesson8;

//В каждой строке найти и удалить заданную подстроку

import java.io.*;

public class TaskTextHandling {
	
	private static final String WHAT_TO_DELETE = "word5";

	public static void main(String[] arg) {
		File file = new File("textFile.txt");

		String originalStringFromFile = readFile(file);
		System.out.println("Original string: " + originalStringFromFile);

		System.out.println("--------------------------------------------------------------------------------");

		String stringWithDeletedWords = originalStringFromFile.replaceAll(WHAT_TO_DELETE, "");
		System.out.println("Edited string: " + stringWithDeletedWords);

		writeFile(file, stringWithDeletedWords);
	}

	// Write and read methods:

	public static String readFile(File file) {
		StringBuilder stringBuilder = new StringBuilder();

		try {
			// 1) Сначала считываем байты из файла в файловую систему с помощью FileInputStream (оно пока нечитабельно).
			// 2) Потом нечитабельное из FileInputStream преобразовываем в символы с помощью InputStreamReader
			// 3) Потом символьный набор из InputStreamReader кладём в BufferedReader
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader ist = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(ist);
			//
			String read;
			while ((read = br.readLine()) != null) { // Читаем построчно
				stringBuilder.append(read); // складываем стрингбилдер
				stringBuilder.append("\n"); // сохранить разбиение теста на строки
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	public static void writeFile(File file, String str) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(str.getBytes());
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
