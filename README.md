# Lab 01 - Java I
## Getting Started
For the first part of this lab, you will install some software that we will use throughout this course.

### Open JDK
First, we need to install the Java OpenJDK.  This package includes the compiler, the interpreter/JVM, and the libraries used by Java.

Windows, Linux, and OS-X Users:
You can download and install the OpenJDK package from the following locations: 
•	https://jdk.java.net/14/ 

Note:  Oracle has recently determined that University use of the official Oracle Java JDK is considered commercial use, and requires a large subscription fee (per student).  This would be wasteful of University resources, when a similar (and in some ways, better) implementation of Java is available in the OpenJDK.  Students are asked not to use Oracle's commercially-licensed JDK package, but rather Oracle’s open-source licensed Open JDK.

### Text Editor
You should also install a text editor.  This is very personal, and you are welcome to use any text editor that you wish, but it is advisable to choose a text editor that has syntax highlighting for Java.  Some popular text editors include:
•	Atom:  		http://atom.io 
•	Brackets:	http://brackets.io 
•	VS Code:	https://code.visualstudio.com/download  
•	Sublime:	https://www.sublimetext.com/ (not free)

You can also install an integrated development environment, if you prefer to compile in the same application.  Some popular Java IDEs include:
•	IntelliJ IDEA:	https://www.jetbrains.com/idea/download/ 
•	Eclipse:		https://eclipse.org/downloads/ 
•	NetBeans:	https://netbeans.org/ 

_**Note:**  You are required to know how to compile and run a Java application from the command line in this course, even if you regularly use an IDE._

## Part 1
Now that we have the software that we need, let's write a simple program in Java.

We'll create a Java class, called `Battle`.  `Battle` will have a `main` method, which will be provided, below.  Your job will be to simulate a simple battle between two RPG game “pocket monsters”: Chikapu and Zarichard by creating an instance of `Battle` and repeatedly invoking the `simulateRound` function until the either the function `isMonster1Fainted` returns `true` or the function `isMonster2Fainted` returns `true`.  The `simulateRound` function will simulate Chikapu attacking Zarichard, and then Zarichard attacking Chikapu.  The damage dealt by each attack is determined by the following formula:

`damage = attacker's attack – defender's defense`

The `isMonster1Fainted` and `isMonster2Fainted` simply return true if the corresponding monster has HP <= 0.  Each of the instance variables should also have corresponding get methods (e.g. `getMonster1HP` and `getMonster2Attack`).

Some code to initialize the two characters is given below:

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

To compile your class, use the following command:

`javac Battle.java`

To run your program, use the following command:

`java Battle`

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
For this part, we’re going to write a simple Taylor series calculator within the `main` method of a new class, `TaylorSeries` which will find an approximate value for <img src="https://render.githubusercontent.com/render/math?math=e^x">.  Use a variable `numIterations` to adjust the number of iterations (the number of terms summed).  Use the following series for your approximation:

<img src="https://render.githubusercontent.com/render/math?math=e^x=\sum_{n=0}^\infty \frac{x^n}{n!}=\frac{x^0}{0!}+\frac{x^1}{1!}+\frac{x^2}{2!}+\frac{x^3}{3!}+\frac{x^4}{4!}+...">

Determine an appropriate number of iterations to get a reasonable approximation (e.g. to 5 accurate decimal places) for <img src="https://render.githubusercontent.com/render/math?math=e^1">.

_**Hint:**  Our function for calculating the factorial of a number currently cannot handle 0!.  0! should be 1.  Either change this function so that it works properly, or else change the way you calculate your Taylor series accordingly._