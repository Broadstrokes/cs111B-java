public class StringProcessor {
	final private char[] vowelsArray = new char[] {'a', 'e', 'i', 'o', 'u'};
	final private String digitWords = new String(
		"zero one two three four five six seven eight nine"
	);
	final private String[] digits = new String[] {"0", "1", "2", "3", "4", "6", "7", "8", "9"};
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
			if(Character.isUpperCase(str.charAt(i))) {
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

	public int digitWordCount() { 
		int count = 0;
		String currentWord;
		String currentWordWithoutSpecialCharacters;
		String[] tokens = this.str.split(" ");

		for(int i = 0; i < tokens.length; i++) {
			currentWord = new String(tokens[i]);
			currentWordWithoutSpecialCharacters = currentWord.replaceAll("[^\\w\\s]","");

			if (digitWords.indexOf(currentWordWithoutSpecialCharacters.toLowerCase()) > 1) {
				count++;
			}			
		}

		return count;
	}

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

	public String getNoDigitWordString() {
		String[] digitWordsArray = this.digitWords.split(" ");
		String[] tokens = this.str.split(" "); // convert the string into array
		int startingIndexOfWordDigitIfFoundInString;
		String currentDigit;

		// Loop over the tokenized user input string
		for (int i = 0; i < tokens.length; i++) {
			// Loop over the word digits array called digitWordsArray {"zero", "one", ... "nine"}
			for (int j = 0; j < digitWordsArray.length; j++) {
				currentDigit = digitWordsArray[j];
				startingIndexOfWordDigitIfFoundInString = tokens[i].toLowerCase().indexOf(digitWordsArray[j]);

				// This check ensures that a word such as money doesn't turn into m1y
				if (startingIndexOfWordDigitIfFoundInString == 0) {
					// Using a StringBuilder replace the substring with correct digit eg: one get converted to "1"
					StringBuilder temp = new StringBuilder(tokens[i]);
					temp.replace(0, digitWordsArray[j].length(), digits[j]);
					// Place the item in the tokens array
					tokens[i] = temp.toString();
				}
			}
		}

		return String.join(" ", tokens);
	}
}
