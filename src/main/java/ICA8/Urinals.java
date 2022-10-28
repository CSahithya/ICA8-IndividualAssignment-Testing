package ICA8;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Urinals {
    private File datFile = new File("src\\main\\resources\\urinals.dat");
    private String urinalArray[];
    private String inputString;
    private String outputString;
    private int count;
    private int errorType;

    public static void main(String[] args) {
        Urinals u = new Urinals();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Urinal String to get the Count");
        String input = sc.nextLine();
        u.countUrinals(input);
        if(u.count==-1){
            System.out.println("Check the input String. Result: "+ -1);
        }
        else{
            System.out.println("Great! The number of free urinals are: "+u.count);
        }
        sc.close();
    }

    public void writeToOutputFile(){
        //File
    }

    public String getOutputString(){
        outputString="";
        urinalArray = inputString.split("\n");
        for(int i=0;i<urinalArray.length;i++){
            outputString+= ""+this.countUrinals(urinalArray[i])+"\n";
        }
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
                    flag = 0;
                }
                else{
                    flag = 1;
                }
            }
            previousVal = Integer.parseInt(check.charAt(i)+"");
        }
        if(previousVal == 0 && flag==1){
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
