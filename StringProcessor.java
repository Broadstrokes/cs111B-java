public class StringProcessor {
	private String str;
	private char[]  vowelsArray = new char[] {'a', 'e', 'i', 'o', 'u'};
	private String digitWords = new String(
		"zero one two three four five six seven eight nine"
	);

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
		return this.str.length();
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
		String cleanCurrentWord;
		String[] tokens = this.str.split(" ");

		for(int i =0; i < tokens.length; i++) {
			currentWord = new String(tokens[i]);
			cleanCurrentWord = currentWord.replaceAll("[^\\w\\s]","");
			// System.out.println(currentWord);

			if(digitWords.indexOf(cleanCurrentWord.toLowerCase()) > 1) {
				System.out.println(tokens[i]);
				count++;
			}			
		}

		return count;
	}


	// public String getNoSpaceString() { 

	// }

	// public String getNoVowelString() { 

	// }

	// public String getNoDigitWordString() { 

	// }
}
