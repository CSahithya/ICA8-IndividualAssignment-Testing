# ICA8-IndividualAssignment-Testing

### Details
1. Test File has different unique test cases
2. Main has the countUrinal where hte count is calculated
3. Change the file name in the Urinals.java file to test for other input
4. Run main to get the keyboard or file input

### Your task: 
You need to write a function that returns the maximum of free urinals as an integer according to the unwritten rule. 

### Input 
A String containing 1s and 0s (Example:  10001 ) (1 <= Length <= 20). This string can come from the keyboard or a file 
called urinal.dat. The program will continue processing until a -1 or <eof> is reached. (This means you handle unusual 
input without crashing.) 

A one stands for a taken urinal and a zero for a free one. 

### Output 
If input is keyboard, print result to screen. If from a file, output to rule.txt. If the file rule.txt already exists, increment a 
counter to rule1.txt, rule2.txt, etc. 

_Examples_ 

10001  returns 1 (10101) 

1001  returns 0 (1001) 

00000  returns 3 (10101) 

0000  returns 2 (1001) 

01000  returns 1 (01010 or 01001) 

### Submit 
Submit a zip file with your java files and a text file with your name and GitHub repository for 
assignment. In the Canvas comments section also show the GitHub repository address. 

_*Note*_ 

When there is already a mistake in the input string (for example  011 ), then return  -1  

Have fun and don't pee into the wrong urinal!