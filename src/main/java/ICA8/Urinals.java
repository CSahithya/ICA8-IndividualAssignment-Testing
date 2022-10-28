package ICA8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Urinals {
    private File datFile = new File("src\\main\\resources\\urinals.dat");
    private String urinalArray[];
    private String inputString;
    private File outputFile = new File("src\\main\\resources\\rule.txt");
    private String outputString;
    private int count;
    private int errorType;

    public static void main(String[] args) {
        Urinals u = new Urinals();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter:\n 1. Keyboard Input\n 2. File Input");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 1) {
            System.out.println("Enter a Urinal String to get the Count");
            String input = sc.nextLine();
            u.countUrinals(input);
            if (u.count == -1) {
                System.out.println("Check the input String. Result: " + -1);
            } else {
                System.out.println("Great! The number of free urinals are: " + u.count);
            }
        }
        else if(choice == 2){
            System.out.println("Working on the Urinals.dat file");
            u.openFile(u.datFile);
            System.out.println("Written to "+u.writeToOutputFile().getName());
            System.out.println("The output has been written to the latest rule.txt");
        }
            sc.close();
    }

    public File writeToOutputFile(){
        if(!outputFile.exists()){
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            for(int i=1;i<10;i++){
                String filepath = "src\\main\\resources\\rule"+i+".txt";
                outputFile = new File(filepath);
                if(!outputFile.exists()){
                    try {
                        outputFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            if(!outputFile.exists()){
                System.out.println("Too many rule files to create new!");
            }
        }
        outputString="";
        urinalArray = inputString.split("\n");
        for(int i=0;i<urinalArray.length;i++){
            outputString+= ""+this.countUrinals(urinalArray[i])+"\n";
        }
        try {
            FileWriter fw = new FileWriter(outputFile);
            fw.write(outputString);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFile;
    }

    public String getOutputString(){
        return outputString;
    }

    public String getInputString(){
        return this.inputString;
    }

    public int openFile(File filename){
        inputString="";
        try {
            Scanner sc = new Scanner(filename);
            while(sc.hasNext()){
                inputString+=sc.nextLine()+"\n";
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        if(inputString.equals("")){
            return 1;
        }
        return 0;
    }

    public int countUrinals(String check){
        if(!goodString(check)){
            return -1;
        }
        int flag=0, previousVal=0;
        count = 0;
        for(int i=0;i<check.length();i++){
            if(previousVal==0 && check.charAt(i)=='0'){
                if(flag==1){
                    count++;
                    previousVal = 1;
                    flag = 0;
                }
                else{
                    flag = 1;
                    previousVal = Integer.parseInt(check.charAt(i) + "");
                }
            }
            else {
                previousVal = Integer.parseInt(check.charAt(i) + "");
            }
        }
        if(previousVal == 0 && flag==1){
            count++;
        }
        if(!check.contains("1")){
            count++;
        }
        if(count!=0) return count;
        return 0;
    }

    public boolean goodString(String str){
        //length check
        if(str.length()>20 || str.length()<1){
            errorType = 2;
            return false;
        }
        //the given string shouldn't violate the unwritten rule
        if(str.contains("11")){
            errorType = 1;
            return false;
        }
        //check string
        if(str.matches("[01]+")){
            errorType = 0;
            return true;
        }
        //any other case
        errorType = 3;
        return false;
    }
}
