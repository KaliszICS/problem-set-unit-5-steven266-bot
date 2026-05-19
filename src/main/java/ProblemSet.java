import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
public class ProblemSet {

	public static void main(String args[]) {


        Scanner scanner = new Scanner(System.in);

      System.out.println("Welcome to the Text Analyzer.\n");
  		// Welcome message
        
        System.out.print("Please enter a sentence or paragraph:\n\n");
		// Ask user for input
        String text = scanner.nextLine();

        int totalCharacters = text.length();
		// Total characters

        int totalSpaces = 0;
		// Total spaces

        int totalVowels = 0;{
		// Total vowels

        for (int i = 0; i < text.length(); i++) {
			// Count spaces and vowels
            char ch = Character.toLowerCase(text.charAt(i));

            if (ch == ' ') {
                totalSpaces++;
            }

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                totalVowels++;
            }
        }

        int sentenceCount = 0;
		// Count sentences
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == '.' || ch == '!' || ch == '?') {
                sentenceCount++;
            }
        }

        String cleanedText = text.toLowerCase()
		// Convert to lowercase and remove punctuation
                .replaceAll("[^a-zA-Z0-9\\s]", "");

        String[] words = cleanedText.trim().split("\\s+");
		// Convert to lowercase and remove punctuation

        int totalWords = words.length;

        Set<String> ignoredWords = new HashSet<>();
        ignoredWords.add("the");
        ignoredWords.add("a");
        ignoredWords.add("an");
        ignoredWords.add("and");
        ignoredWords.add("is");
		// Common words to ignore

        Map<String, Integer> wordFrequency = new LinkedHashMap<>();
		 // Store word frequencies

        int totalWordLength = 0;
		// Store word frequencies

        int longestLength = 0;
        int shortestLength = Integer.MAX_VALUE;

        Set<String> longestWords = new LinkedHashSet<>();
        Set<String> shortestWords = new LinkedHashSet<>();

        for (String word : words) {

            if (word.isEmpty()) {
                continue;
            }

            totalWordLength += word.length();
			//count word length

            if (word.length() > longestLength) {
				// Longest word check
                longestLength = word.length();

                longestWords.clear();
                longestWords.add(word);

            } else if (word.length() == longestLength) {
                longestWords.add(word);
            }

            if (word.length() < shortestLength) {
                shortestLength = word.length();

                shortestWords.clear();
                shortestWords.add(word);
				// Shortest word check

            } else if (word.length() == shortestLength) {
                shortestWords.add(word);
            }

            if (ignoredWords.contains(word)) {
				// Ignore common words for frequency count
                continue;
            }

            if (wordFrequency.containsKey(word)) {
				// Count word frequency
                wordFrequency.put(word,
                        wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        } 
        double averageWordLength =
		 // Calculate average word length
                (double) totalWordLength / totalWords;

        System.out.println("\nTotal Characters: " + totalCharacters);
        System.out.println("Total Words: " + totalWords);
        System.out.println("Total Vowels: " + totalVowels);
        System.out.println("Total Spaces: " + totalSpaces);

        
        System.out.println("\nWord Frequency:\n");
		// Word frequency output
        for (Map.Entry<String, Integer> entry :
                wordFrequency.entrySet()) {

            System.out.println(entry.getKey()
                    + " - " + entry.getValue());
        }

        System.out.println("\nLongest Word: "
                + String.join(", ", longestWords));

        System.out.println("Shortest Word: "
                + String.join(", ", shortestWords));

        System.out.printf("Average Word Length: %.2f\n",
                averageWordLength);

        System.out.println("Number of Sentences: "
                + sentenceCount);

        System.out.println("Unique Words: "
                + wordFrequency.size());
			// Advanced statistics

       
    }
}
}
