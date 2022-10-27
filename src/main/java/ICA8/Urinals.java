package ICA8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Urinals {
    private File datFile = new File("src\\main\\resources\\urinals.dat");
    private String urinalArray[];
    private int count;

    public static void main(String[] args) {

    }

    public void getString(){

    }

    public void openFile(File filename){
        StringBuilder sb = new StringBuilder();
        try {
            Scanner sc = new Scanner(filename);
            while(sc.hasNext()){
                sb.append(sc.nextLine()+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        urinalArray = sb.toString().split("\n ");
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
            previousVal = Character.valueOf(check.charAt(i));
        }
        if(count!=0) return count;
        return 0;
    }

    public boolean goodString(String str){
        //length check
        if(str.length()>20 || str.length()<1){
            return false;
        }
        //the given string shouldn't violate the unwritten rule
        if(str.contains("11")){
            return false;
        }
        //check string
        if(str.matches("[01]+")){
            return true;
        }
        //any other case
        return false;
    }
}
