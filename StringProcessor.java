public class StringProcessor {
 final private String digitWords = new String(
  "zero one two three four five six seven eight nine"
 );
 final private String[] digits = new String[] { "0", "1", "2", "3", "4", "6", "7", "8", "9" };
 private String str;


 public StringProcessor() {
  str = "";
 }


 public StringProcessor(String s) {
  str = s;
 }


 public void setString(String s) {
  str = s;
 }


 public String getString() {
  return this.str;
 }


 public int wordCount() {
  return this.str.split(" ").length;
 }


 public int uppercaseCount() {
  int count = 0;
  for (int i = 0; i < this.str.length(); i++) {
   if (Character.isUpperCase(str.charAt(i))) {
    count++;
   }
  }
  return count;
 }

 public int digitCount() {
  int count = 0;
  for (int i = 0; i < this.str.length(); i++) {
   if (Character.isDigit(str.charAt(i))) {
    count++;
   }
  }
  
  return count;
 }


 /**
  * Returns the count of words that are digits
  */
 public int digitWordCount() {
  int count = 0;
  String currentWord;
  String currentWordWithoutSpecialCharacters;
	// break apart the user's input string into an array
  String[] userInputTokenized = this.str.split(" ");

  for (int i = 0; i < userInputTokenized.length; i++) {
		currentWord = new String(userInputTokenized[i]);
		// remove any special characters
		currentWordWithoutSpecialCharacters = currentWord.replaceAll("[^\\w\\s]", "");
		// checks if the current word from the user's input matches a word in the
		// digitsWords string, which holds all the digits ("zero one two three ... nine")
		if (digitWords.indexOf(currentWordWithoutSpecialCharacters.toLowerCase()) > 1) {
		count++;
		}
  }

  return count;
 }


 /**
  * Returns a new string with all whitespaces removed
  */
 public String getNoSpaceString() {
  char ch;
  StringBuilder myNewStr = new StringBuilder("");

  for (int i = 0; i < this.str.length(); i++) {
   ch = this.str.charAt(i);
   if (!Character.isWhitespace(ch)) {
    myNewStr.append(ch);
   }
  }

  return myNewStr.toString();
 }


 /**
  * Returns a new string with vowels replaced by hypens (-)
  */
 public String getNoVowelString() {
  char currentCharacterLowercased;
  StringBuilder myNewStr = new StringBuilder("");

  for (int i = 0; i < this.str.length(); i++) {
   currentCharacterLowercased = Character.toLowerCase(this.str.charAt(i));

   if (
    currentCharacterLowercased == 'a' ||
    currentCharacterLowercased == 'e' ||
    currentCharacterLowercased == 'i' ||
    currentCharacterLowercased == 'o' ||
    currentCharacterLowercased == 'u'
   ) {
    myNewStr.append('-');
   } else {
    myNewStr.append(this.str.charAt(i));

   }
  }

  return myNewStr.toString();
 }

 /**
  * Returns a new string with all word numbers converted to digits
  */
 public String getNoDigitWordString() {
  String[] digitWordsArray = this.digitWords.split(" ");
  String[] userInputTokenized = this.str.split(" "); // convert the string into array
  int startingIndexOfWordDigitIfFoundInString;
  String currentDigit;

  // Loop over the tokenized user input string
  for (int i = 0; i < userInputTokenized.length; i++) {
   // Loop over the word digits array called digitWordsArray {"zero", "one", ... "nine"}
   for (int j = 0; j < digitWordsArray.length; j++) {
    currentDigit = digitWordsArray[j];
    startingIndexOfWordDigitIfFoundInString = userInputTokenized[i].toLowerCase().indexOf(digitWordsArray[j]);

    // This check ensures that a word such as money doesn't turn into m1y
    if (startingIndexOfWordDigitIfFoundInString == 0) {
     // Using a StringBuilder replace the substring with correct digit eg: one get converted to "1"
     StringBuilder temp = new StringBuilder(userInputTokenized[i]);
     temp.replace(0, digitWordsArray[j].length(), digits[j]);
     // Place the item in the userInputTokenized array
     userInputTokenized[i] = temp.toString();
    }
   }
  }

  return String.join(" ", userInputTokenized);
 }
}