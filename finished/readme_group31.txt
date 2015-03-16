----------README----------
Group Name: Tempest
Group Number: 31
Group Members: Anil Banarsee, Magdi Ayad (130084262), Hamzah Hayat (130772901), Sam Chadd

Pre-requisites:
1) The program must be run on Windows in the ITL machines, as they use Java 8.

How to run the project from the JAR:

1) Extract the contents of the ZIP file into a folder. 
2) Run the JAR file. This should open two Java windows.
3) To switch between the pages of the program, we have developed a control panel to simulate the swiping actions on a phone. Move the Weather App window to reveal the control panel behind it.
4) Use the control panel to interact with the app, including switching from portrait to landscape and vice versa.

How to compile and run the project from scratch:

1) Extract the 'src' folder
2) Direct the command line to the contents of the 'src' folder
3) Run the commands "javac gui/handler/*.java", "javac gui/*.java", "javac gui2/*.java", "javac travelData/*.java" and "javac weatherdata/*.java". This compiles all the java files into their respective class files.
4) Then run "jar cvfm program.jar manifest.txt gui/*.class gui2/*.class travelData/*.class weatherData/*.class gui/handler/*.class assets lib". This creates a jar file called "program.jar", that can then be run.
5) Alternatively, there is a batch file in that directory that can also run the above commands.