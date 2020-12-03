# Cal-engine-Project
A project using Java to perform simple mathematical calculations with also date time calculations

The Project has 10 categories each showing my development and increasing complexity of the code as I got to grips with Java's extensive functionality.
To view them in action, you'll need to test run the code on a local machine, using one of Javas IDEs and they are well documented.

This readme provides only an overview of what can be done with them

Some Vocabulary:
LeftVal: Is the Value at the left hand side
RightVal: Is the Value at the right hand side
Opcode: Indicates the operation to be done (a for addition, s for subtraction, m for multiplication and d for division)

The First Mode is the Main.java file.
  This is the most basic of the calcEngines as it only employs the simple
  functionality of addition, subtraction, multiplication and division, with the
  if and else if statements of Java.
  -> It takes in two values and an opcode and performs the operation, the values are specified in the code.


The Second Mode is the SwitchMode.java file.
  This mode uses the functionality of switches to perform the mathematical operation, making the usage of if/else if statements redundant
  -> It takes in two values and an opcode. The values are specified in the code.


The Third Mode is the withArrays.java file.
  In this mode, the functionality of arrays is employed to store a range of values upon which the calculations will be done, for loops and for-each loops are also employed to parse through the values, the functionality of switches are still utilized in this mode.


The Fourth Mode is the withMethods.java file.
  In this mode, the code is broken into two, and the switch operation is turned to a separate method on it's own, and it is then called in the main method after passing through the arrays.
  The mainstays here are the arrays, the for loops and the switches.
  This mode cleans up the code a bit, making it look a bit more professional.



The Fifth mode is the withClArguments.java file.
  This mode employs the functionality of being able to take values as command line arguments from users while retaining it's ability to run if there is no input from the users i.e. it uses the values in the arrays that was specified in code.
  The instructions to use this command line argument functionality is specified in the code.


The Sixth Mode is the withStringMods.java file.
  This mode adds the functionality of being able to input strings (one,two,three) as command line arguments for the calcEngine. In the earlier modes only numbers are allowed. So Now strings (please note it only supports numbers from range zero to nine)
  More instructions to be able to run the calcEngine in this mode is embedded in the code.


The Seventh Mode is the withStringBuilder.java file.
  In this mode the calcEngine rather than just producing the result as output, it generates the output in the form of a statement to match what was entered by the user.
      so user types multiply seven and five
        the calc engine outputs 7 * 5 = 35
        this is done with the functionality of a string builder

  For Implementation check the code for more detailed documentation.



The Eight Mode is the withFormatStrings.java file.
  In this mode the functionality of a string builder is replaced with string formats, not more difference asides this between the seventh mode and eight mode
  so user types multiply seven and five
    the calc engine outputs 7 * 5 = 35
    this is done with the functionality of a string builder

  For Implementation check the code for more detailed documentation.


The Ninth Mode is the withDateMath.java file.
  This is current mode whereby while the code is ran in the interactive mode, the user is asked for the type of calculation wanted, i.e. dataMath or BasicOps
  (to run code in interactive mode, check the code for details on how to do it)
  This mode employs Java's Date math functionality

  BasicOp functionality stays the same
  For the datemath the format of input required is

  "year-month-day plus/minus number days/weeks/months/year"
                      or
  "yyyy-mm-dd plus/minus number days/weeks/months/year"

   For example "2020-05-22 plus seven months"
   expected output from calc engine is "2020-05-22 plus 7 months is 2020-12-22"
