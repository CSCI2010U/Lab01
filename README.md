# Lab 01 - Java I
## Getting Started
For the first part of this lab, you will install some software that we will use throughout this course.

### Open JDK
First, we need to install the Java OpenJDK.  This package includes the compiler, the interpreter/JVM, and the libraries used by Java.

Windows, Linux, and OS-X Users:
You can download and install the OpenJDK package from the following locations: 
•	https://jdk.java.net/14/ 

Note:  Oracle has recently determined that University use of the official Oracle Java JDK is considered commercial use, and requires a large subscription fee (per student).  This would be wasteful of University resources, when a similar (and in some ways, better) implementation of Java is available in the OpenJDK.  Students are asked not to use Oracle's commercially-licensed JDK package, but rather Oracle’s open-source licensed Open JDK.

### Gradle
The GitHub Classroom environment uses the Gradle build tool for its Java projects.  This means that the project directory needs to have a specific structure, as you'll see if you examine the contents of this repository.  The code for all of your labs will be found in `src/main/java`.  Instructions on how to run your program are given later in this document.

In order to use the `gradle` commands given, you will need to install Gradle.  You can complete your labs without it, but once installed, it does make the process significantly easier.  As a bonus, I've created unit tests for every lab that will verify that your code is correct, so you can be certain that your lab assignment will be given full marks if it passes all of these tests.

Instructions for installing Gradle can be found here:  https://gradle.org/install/

### Text Editor
You should also install a text editor.  This is very personal, and you are welcome to use any text editor that you wish, but it is advisable to choose a text editor that has syntax highlighting for Java.  Some popular text editors include:
- Atom:  	http://atom.io 
- Brackets:	http://brackets.io 
- VS Code:	https://code.visualstudio.com/download  
- Sublime:	https://www.sublimetext.com/ (not free)

You can also install an integrated development environment, if you prefer to compile in the same application.  Some popular Java IDEs include:
- IntelliJ IDEA:	https://www.jetbrains.com/idea/download/ 
- Eclipse:		    https://eclipse.org/downloads/ 
- NetBeans:	        https://netbeans.org/ 

_**Note:**  You are required to know how to compile and run a Java application from the command line in this course, even if you regularly use an IDE._

## Part 1
Now that we have the software that we need, let's write a simple program in Java.

_**Note:** Do not modify any files in this repository, except for the following:_
- `src/main/java/Lab01.java`
- `src/main/java/Battle.java`
- `src/main/java/TaylorSeries.java`

We'll create a Java class, called `Battle`.  The `Battle` class can already be found in this repository (in `src/main/java`).  `Battle` will have a `main` method, which will be provided, below.  Your job will be to simulate a simple battle between two RPG game “pocket monsters”: Chikapu and Zarichard by creating an instance of `Battle` and repeatedly invoking the `simulateRound` function until the either the function `isMonster1Fainted` returns `true` or the function `isMonster2Fainted` returns `true`.  The `simulateRound` function will simulate Chikapu attacking Zarichard, and then Zarichard attacking Chikapu.  The damage dealt by each attack is determined by the following formula:

`damage = attacker's attack – defender's defense`

The `isMonster1Fainted` and `isMonster2Fainted` simply return true if the corresponding monster has HP <= 0.  Each of the instance variables should also have corresponding get methods (e.g. `getMonster1HP` and `getMonster2Attack`).

Some code, which is included in the `Lab01.java` file's `main` function in the respository, to initialize the two characters is given below:

```
String chikapuName = "Chikapu";
float chikapuAttack = 38.5f;
float chikapuDefense = 20.0f;
float chikapuHP = 200f;

String zarichardName = "Zarichard";
float zarichardAttack = 25f;
float zarichardDefense = 12.5f;
float zarichardHP = 200f;
```
These values will be passed to the `Battle` class' constructor, which will be stored as instance variables.  There will also be an instance variable (`round_num`), which will store the round number.

Sample output, using the values given above, is shown below:

```
Round 1
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  195
Zarichard:  174

Round 2
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  190
Zarichard:  148

Round 3
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  185
Zarichard:  122

Round 4
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  180
Zarichard:  96

Round 5
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  175
Zarichard:  70

Round 6
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  170
Zarichard:  44

Round 7
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  165
Zarichard:  18

Round 8
Chikapu does 26 points of damage to Zarichard
Zarichard does 5 points of damage to Chikapu
Chikapu:  160
Zarichard:  -8

Zarichard has fainted!
```

The `main` method code used to produce the above output is shown below:

```
public static void main(String[] args) {
    String chikapuName = "Chikapu";
    float chikapuAttack = 38.5f;
    float chikapuDefense = 20.0f;
    float chikapuHP = 200f;

    String zarichardName = "Zarichard";
    float zarichardAttack = 25f;
    float zarichardDefense = 12.5f;
    float zarichardHP = 200f;

    Battle battle = new Battle(chikapuName, chikapuAttack, chikapuDefense, chikapuHP, 
                               zarichardName, zarichardAttack, zarichardDefense, zarichardHP);

    while (!battle.isMonster1Dead() && !battle.isMonster2Dead()) {
        battle.simulateRound();
    }

    if (battle.isMonster1Dead()) {
        System.out.printf("\n%s has fainted!\n", chikapuName);
    } else {
        System.out.printf("\n%s has fainted!\n", zarichardName);
    }
}
```
However, it is important to note that your code should work for other values for attack, damage, HP, and names, and should behave accordingly.

## Part 2
For this part, we’re going to write a simple Taylor series calculator within a static method `approximateExp` of a new class, `TaylorSeries` which will find an approximate value for <img src="https://render.githubusercontent.com/render/math?math=e^x">.  The `TaylorSeries` class can already be found in this repository (in `src/main/java`).  Use an argument `numIterations` to adjust the number of iterations (the number of terms summed).  Use the following series for your approximation:

<!-- e%5Ex%3D%5Csum_%7Bn%3D0%7D%5E%5Cinfty+%5Cfrac%7Bx%5En%7D%7Bn%21%7D%3D%5Cfrac%7Bx%5E0%7D%7B0%21%7D%2B%5Cfrac%7Bx%5E1%7D%7B1%21%7D%2B%5Cfrac%7Bx%5E2%7D%7B2%21%7D%2B%5Cfrac%7Bx%5E3%7D%7B3%21%7D%2B%5Cfrac%7Bx%5E4%7D%7B4%21%7D%2B... -->

<!-- e^x=\sum_{n=0}^\infty \frac{x^n}{n!}=\frac{x^0}{0!}%20+%20\frac{x^1}{1!}%20+\frac{x^2}{2!} + \frac{x^3}{3!} + \frac{x^4}{4!} + ... -->

<img src="https://render.githubusercontent.com/render/math?math=e%5Ex%3D%5Csum_%7Bn%3D0%7D%5E%5Cinfty+%5Cfrac%7Bx%5En%7D%7Bn%21%7D%3D%5Cfrac%7Bx%5E0%7D%7B0%21%7D%2B%5Cfrac%7Bx%5E1%7D%7B1%21%7D%2B%5Cfrac%7Bx%5E2%7D%7B2%21%7D%2B%5Cfrac%7Bx%5E3%7D%7B3%21%7D%2B%5Cfrac%7Bx%5E4%7D%7B4%21%7D%2B...">

You will implement the `approximateExp` function by calling another two functions, which you will also implement:
- `factorial(int n)` - calculates n!, using recursion
- `pow(int x, int n)` - calculates <img src="https://render.githubusercontent.com/render/math?math=x^n"> (x to the power of n) using recursion 

Determine an appropriate number of iterations to get a reasonable approximation (e.g. to 5 accurate decimal places) for <img src="https://render.githubusercontent.com/render/math?math=e^1">, and print out that approximation in your `main` method.

_**Hint:**  The recursive function developed in class for calculating the factorial of a number currently cannot handle 0!.  0! should be 1.  Either change this function so that it works properly, or else change the way you calculate your Taylor series accordingly._

## Compiling and Running Your Program
To compile and run your program, use the following command:
`gradle run`

If you want to see if your program passes the tests, i.e. is correct, use the following command:
`gradle test`

## Submission Instructions
Modify the `src/main/java/Battle.java` and `src/main/java/TaylorSeries.java` as described in this document, and commit and push your code to this repository.

Every lab assignment is due by the start of the following lab period, giving you an extra week to work on it.  Do not expect to continue to work on it during this next lab period, as the lab instructor will not permit that, since it would lead to you missing potential instructions/help for the next lab.

This repository will be marked by the lab instructor at their convenience, but any changes made to this repository after the due date (described above) will not be considered.  Labs not submitted on time, with the exception of documented absences/illnesses or SAS accommodations, will not be accepted.

## Getting Help
If you run into difficulty, you may wish to check out some of the following resources:
- https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html - A series of tutorials for the Java programming language, focusing almost entirely on the features of Java
- https://docs.oracle.com/en/java/javase/14/ - The standard documentation for Java classes, including methods that you can use, some of which will be discussed later in this course
- http://stackoverflow.com/ - A forum for asking questions about programming. Chances are, someone else has asked the same question as you have, and some knowledgeable person has already answered it.  This might be a good time to use the ‘site:’ feature in Google!

Of course, you can always ask the lab instructor for help! However, learning how to find the answers out for yourself is a skill that will pay off in the future, as solving your own problem is immediate (and satisfying)!

## Academic Integrity
Discussing strategies with your fellow students is acceptable, but once it is time to write the code you should do so on your own.  The instructor has learning goals planned for this course which are cumulative.  If you fail to learn some elements in this lab assignment, it most likely will affect your performance on higher-stakes assessments in the future.  You can also ask the lab instructor for help, but they won't directly solve your problems for you, but will rather point you in the right direction to find the solution yourself.

Lab assignments which have been plagiarized will receive a mark of zero, and both the student whose work was copied, and the student who copied the work will have an academic integrity report filed.

By submitting code to this repository, you are claiming that this work is your own.