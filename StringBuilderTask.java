package by.oksana.lesson8;

public class StringBuilderTask {

	private final static String string = "The Java Tutorials are practical guides for programmers who want to use the Java programming language to create applications.";
	private static int k = 3;
	private static char letter = '+';

	public static void main(String[] args) {
		String[] wordArray = string.split(" ");
		System.out.println("String before replacement: " + string);
		System.out.println("String length: " + wordArray.length);
		StringBuilder stringBuilder = new StringBuilder();

		for(int i = 0; i < wordArray.length; i++) {
			char[] charArray = wordArray[i].toCharArray();

			if(charArray.length > k - 1) {
				charArray[k - 1] = letter;
			}
			stringBuilder.append(String.valueOf(charArray) + " ");
		}

		System.out.println("String after replacement: " + stringBuilder.toString().trim());
	}
}
