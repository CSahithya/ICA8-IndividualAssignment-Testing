package ICA8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Urinals {
    private File datFile = new File("src\\main\\resources\\urinals.dat");
    private String urinalArray[];
    private int Count;
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
    public int countUrinals(){

        return 0;
    }
    public boolean goodString(String str){
        //length check
        if(str.length()>20 || str.length()<1){
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
