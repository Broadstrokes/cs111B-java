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
			if(Character.isDigit(str.charAt(i))) {
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
		return String.join("", this.str.split(" "));
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

	// public String getNoDigitWordString() { 

	// }
}
