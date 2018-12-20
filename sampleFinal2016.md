# Sample Final 2016


## 1  
In your own words explain whether or not subclasses inherit constructors from their super classes.

No superclass constructors are not inherited by the subclass because the purpose of the constructor is to create objects that respective class. Subclasses have their own constructors that create objects of the subclass type.


## 2
Write a static method that accepts an array of integers as a parameter, and sets the first and last elements to 0. If there are no elements to set your method should throw an IllegalArgumentException.

public static void setElementsToZero(int[] myArray) {
	if (!myArray.length) {
		throw new IllegalArgumentException("Array is empty. Nothing to replace!");
	} else {
		myArray[0] = 0;
		myArray[myArray.length - 1] = 0;
	}
}

## 3
Imagine that you have access to a class named MyCircle that has  void setRadius(double r) and double getRadius() methods. Write a static method that accepts a MyCircle array. The method should accomplish two goals: it should return the average of the radius’s for all MyCircles that have a positive radius, and for any MyCircles that have a negative radius it should set the radius to 0.

public static double(MyCircle[] circlesArray) {
	double sumPositiveRadii = 0.0;
	int numCirclesWithPositiveRadii = 0;
	
	for(int i = 0; i < circlesArray.length; i++) {
		double currentCircleRadius = circlesArray[i].getRadius();
		
		if(currentCircleRadius > 0) {
			sumPositiveRadii += currentCircleRadius;
			numCirclesWithPositiveRadii++;
		} else if (currentCircleRadius < 0) {
			circlesArray[i].setRadius(0.0);
		}
	}

	return (sumPositiveRadii / numCirclesWithPositiveRadii); 
}

## 4
Imagine that ClassB and ClassC are subclasses of ClassA.  For each of the references below, list the types of objects that the reference can refer to (some combination of ClassA, ClassB, and/or ClassC)

A <-- B
A <-- C

ClassA  aReference;
ClassB  bReference;
ClassC  cReference;

ClassA = new ClassA();
ClassA = new ClassB();
ClassA = new ClassC();

ClassB = new ClassB();
ClassC = new ClassC();


## 5

In your own words, describe the difference between a static method, and a plain old method. (1 or 2 sentences)

Static means that the method belongs to a class & not a specific object. Static methods do not need an object to be initialized for it to be called.
Instance methods do not have the modifier static in the header and belong to instances of an object.

## 6

Write a class named DiceHolder. The class should be able to store five integer values. You can assume that the values will always be 1 - 6. Your class does not need to verify that.

The class should have the following Constructors and methods.

DiceHolder(int value1, int value2, int, value3, int value 4, int value 5)


int getValue(int index)

void setValue(int index, int value)


int getTotal()  // Returns the total of the five values


  public static class DiceHolder {
    int[] diceValue = new int[5];
    // Constructor
    DiceHolder(int value1, int value2, int value3, int value4, int value5) {
      diceValue[0] = value1;
      diceValue[1] = value2;
      diceValue[2] = value3;
      diceValue[3] = value4;
      diceValue[4] = value5;
    }
    
    public void setValue(int index, int value) {
      diceValue[index] = value;
    }
    public int getValue(int index) {
      return diceValue[index];
    }

    // Returns the total of the five values
    public int getTotal() {
      int sum = 0;
      for(int i = 0; i < diceValue.length; i++) {
        sum += diceValue[i];
      }
      return sum;
    }
  }

## 7 
Write a subclass of DiceHolder that adds one constructor, and one method. Users of AdvancedDiceHolder should have access to all methods and constructors in DiceHolder


  public static class AdvancedDiceHolder extends DiceHolder {

    public AdvancedDiceHolder(int[] values) {
      super(values[0], values[1], values[2], values[3], values[4]);
    }

    public int[] getMostOccuringValueArray() {

      int maxOccurancesSoFar = 0;
      int valueEncounteredMost = 0;

      
      for (int i = 0; i < 5; i++) {
        int currentValue = getValue(i);
        int countCurrentVal = 0;
        for (int j = 0; j < 5; j++) {
          if (currentValue == getValue(j)) { countCurrentVal += 1; }

        }

        if (countCurrentVal > maxOccurancesSoFar) { 
          maxOccurancesSoFar = countCurrentVal;
          valueEncounteredMost = currentValue;
        }
      }

      int[] arrayToReturn = new int [maxOccurancesSoFar];
      for(int k = 0; k < maxOccurancesSoFar; k++) {
        arrayToReturn[k] = valueEncounteredMost;
      }

      return arrayToReturn;
    }
  }


## 8 


Create a subclass of AdvancedDiceHolder that hides all constructors except the default constructor, and adds the following methods

bool isStraight()  // returns true if the values form a straight, in no particular order.
bool hasPair()  // returns true if the there are any duplicate values.  
Bool isNotAll1s() // Returns true if there are any values greater than one.

  public static class SuperAdvancedDiceHolder extends AdvancedDiceHolder {
    SuperAdvancedDiceHolder(int[] values) {
      super(values);
    }

    public boolean isStraight() {

      for (int i = 0; i < 4; i++) {
        if (getValue(i) + 1 != getValue(i + 1)) { return false; }
      }

      return true;
    }
    public boolean hasPair() {
      int[] duplicatesArray = getMostOccuringValueArray();
      if (duplicatesArray.length > 1) return true;
      return false;
    }
    
    public boolean isNotAll1s() {
      for (int i = 0; i < 4; i++) {
          if (getValue(i) > 1) { return true; }
      }

      return false;
    }

  }




