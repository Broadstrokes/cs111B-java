public class StringProcessor {
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
		return this.str.length();
	}

	public int uppercaseCount() { 

	}

	// public int digitCount() { 

	// }

	// public int digitWordCount() { 

	// }


	// public String getNoSpaceString() { 

	// }

	// public String getNoVowelString() { 

	// }

	// public String getNoDigitWordString() { 

	// }
}
