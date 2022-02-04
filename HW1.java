import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*
 * CSCI 221, Spring 2021, Programming HW 1
 * <Haley Pappano>
 *
 * This program analyzes movie review data to determine if words have a
 * negative or positive meaning. If a word is used more often in positive
 * reviews, it is assumed that the word is positive, and vice versa.
 *  it reads review data line by line - each line is a single review in the form:
 * <integer rating of movie> <Written review - text supporting the rating> <newline>
 * it will also read a user input file consisting of words and turn it into a array to
 * be analyzed to see if the string of words will be either postive or negative
 *
 * This work is entirely my own.
 */
public class HW1
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// Create file instance for input
		File reviewFile = new File("movieReviews.txt");
		// This scanner instance will read from the aforementioned file, which
		// must be in your BlueJ project directory for it to find it.
		Scanner reviewScanner = new Scanner(reviewFile);
		// This scanner instance reads from the keyboard
		Scanner keyboard = new Scanner(System.in);

		double wordAverage = 0.0;
		double wordCount = 0.0;
		double reviewSum = 0.0;
		int reviewScore;
		String reviewText;
		String word;
		String userFile;
		double userFileWordsAve = 0.0;
		int totalWordCount = 0;
		String userWords;
		String finalUserWords = "";
		double userFileWordsSum = 0.0;
		int userNumber = 0;
		double min = 1.0;
		double max = 1.0;
		String maxWord = "";
		String minWord = "";

while(true){
	//This while loop creates the 1-5 user choice menu, allows the user to go through
	//each option and closes the loop once 5 is entered.
		System.out.println("What would you like to do?");
		System.out.println("1: Get the Score of a Word");
		System.out.println("2: Get the Average of words in a file");
		System.out.println("3: Find the Highest and Lowest scoring words in a file.");
		System.out.println("4: Sort words from a file into positivie.txt and negative.txt");
		System.out.println("5: Exit the program.");
		userNumber = keyboard.nextInt();

		if(userNumber == 1) {
			//

			System.out.println("Enter a word of your choice here to see it's average: ");

      word = keyboard.next();

			while(reviewScanner.hasNext())
			{
				// Read the numeric movie rating
				reviewScore = reviewScanner.nextInt();
				// Read the text of the verbal review
				reviewText = reviewScanner.nextLine();
				// If the review contains the word the user entered, print the
				// rating and the review and continue; if it does not, process the
				// next review. Your program will do more than this, of course!!
				if(reviewText.contains(word))
				{
										wordCount++;
										// Accumulates the amount of times the user's word choice was found in the text file
										reviewSum += reviewScore;
										// Adds up all the review scores that had the user's word choice in it
											 //System.out.println("Score: "+reviewScore);
										 //System.out.println("Text: "+reviewText);
				}
		}
					wordAverage = reviewSum / wordCount;
				System.out.println("The average score for reviews containing the word "+word+ " is: "+wordAverage);
				System.out.println(word+" was used: "+wordCount+" times in the movie reviews text file");

}
		else if(userNumber == 2) {
			System.out.println("Enter the name of your text file here (do not include .txt): "); //Asks user for the File name
			userFile = keyboard.next() + ".txt"; //Adds .txt to the end of user's file name so that the code can read and find the
			//text File
			File userWordFile = new File(userFile); // Creates a new scanner to read the user file
			Scanner userWordScanner = new Scanner(userWordFile);
			while(userWordScanner.hasNext())
			//Scans the user File and accumulates the words into a string.
			{
				totalWordCount++; //Acculates the the number of words are in the text file
				userWords = userWordScanner.nextLine();
				finalUserWords += userWords; //Acculates the words into a string
			}
			userWordScanner.close(); //closes random scanner so that review scanner will work
			String finalUserWordsArray[] = finalUserWords.split("\\W+");  //splits the final sentence into an array of words
			int length = finalUserWordsArray.length; // gets the length of the array.
			for (int i = 0; i < length; i++)
			 // while i is less than the length of the array the for loop will allow the code to iterate
			 // Through every word in the array
			{
			word = finalUserWordsArray[i]; // assigns i to word in position[i] in array
		  userFileWordsSum += wordAverage; // accumulates the wordAverage with each iteration
			while(reviewScanner.hasNext())
			{
				reviewScore = reviewScanner.nextInt();
				reviewText = reviewScanner.nextLine();
				if(reviewText.contains(word))
				{
										wordCount++;

										reviewSum += reviewScore;

					}
					wordAverage = reviewSum / wordCount;
				}

			}
			userFileWordsAve = userFileWordsSum / totalWordCount; // takes the userFileWordsSum accumulator and
			// divides it by the total amount of words that was used in the user txt file oringinally
			// the if, else if statements are to figure out whether or not the sentence is positive, negative, or neutral
			// depending on the average
			System.out.println("The average score of words in " +userFile+ " is: " +userFileWordsAve);
			  if (userFileWordsAve >= 2.01) {
					System.out.println("The overall sentiment for " +userFile+ " is positive");
				}
				else if (userFileWordsAve <= 1.99){
					System.out.println("The overall sentiment for " +userFile+ " is negative");
				}
				else if (userFileWordsAve == 2.00){
					System.out.println("the overall sentiment for " +userFile+ " is neutral");
				}

	}


	  else if(userNumber == 3){
			System.out.println("Enter the name of your text file here (do not include .txt): ");
			userFile = keyboard.next() + ".txt";
			File userWordFile = new File(userFile);
			Scanner userWordScanner = new Scanner(userWordFile);
			while(userWordScanner.hasNext())
			{
				totalWordCount++;
				userWords = userWordScanner.nextLine();
				finalUserWords += userWords;
			}
			userWordScanner.close(); //closes random scanner so that review scanner will work
			String finalUserWordsArray[] = finalUserWords.split("\\W+");  //splits the final sentence into an array of words
			int length = finalUserWordsArray.length;
			for (int i = 0; i < length; i++)
			 // while i is less than the length of the array the for loop will allow the code to iterate
			 // Through every word in the array
			{
			word = finalUserWordsArray[i]; // assigns i to word
			userFileWordsSum += wordAverage; // accumulates the wordAverage with each iteration
			while(reviewScanner.hasNext())
			{
				reviewScore = reviewScanner.nextInt();

				reviewText = reviewScanner.nextLine();

				if(reviewText.contains(word))
				{
										wordCount++;

										reviewSum += reviewScore;

										 wordAverage = reviewSum / wordCount;
					}
				}
     //Should test and see if each word average is either higher or lower than the set min or max
		 //if it is either higher or lower then the word and the average for that word will take the
		 // position of being either the minimum or the maximum and be the test case for other words
		 //until there is no more words left.
					double testMin = wordAverage;
					double testMax = wordAverage;
					if (testMin < min){
							min = testMin;
							minWord = word;
						}
					else if(testMax > max){
						max = testMax;
						maxWord = word;
					}
}
System.out.println("the most positive word, with a score of " +max+ " is " +maxWord);
System.out.println("the most negative word, with a score of " +min+ " is " +minWord);
}

		else if(userNumber == 4) {
			// if the userNumber is == 4 then the program will output a message
			// telling the user that the code has not been created for this portion of the program.
			System.out.println("The number you have selected does not run");
		}
		else if(userNumber == 5) {
			System.out.println("end of code");
			break; //breaks the while loop and allows the user to exit the program
		}
	}
}


}
