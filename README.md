# AlgorithmsAndDataStructures
Implementation of certain data structures and algorithms in Java

## Why
I want to learn how data structures work under the hood.
Also I want to somewhere save algorithms, so that I can find them fast, if I need.


## Documentation

### Array

````java
Array<String> myArray = new Array<>(5); // Create a new array with datatpye String and size 5
myArray.set(0, "Hello"); // Set the String "Hello" at index 0
String val = myArray.get(0); // Get the value at index ß
int size = myArray.getSize(); // Get the size of the array
````

### List

````java
List<String> myList = new List<>(); // Create a new list with datatype String
myList.pushEnd("World"); // Adds the "World" at the end of the list
myList.pushStart("Hello"); // Adds the "Hello" at the start of the list
myList.removeAtIndex(0); // Removes the element at index 0
myList.remove("World"); // Removes the first element that matches with the String "World"
myList.clear(); // Clears the whole list
myList.set(5, "Hello World"); // Sets the String at a certain index
String val = myList.get(5); // Get the value at an certain index
int i = myList.indexOf("Hello World"); // Get the index of the first match
boolean c = myList.contains("Hans Peter"); // Checks if the list contains a certain element
List<String> subList = myList.subList(2, 5); // Creates a sublist
int size = myList.getSize(); // Get the size of the list
````

### LinkedList

### Queue

### Stack

### HashMap