import java.util.*;
import java.io.*;
public class romanNumbers {
    public static void main(String [] args) throws IOException {
        //Reading input file and adding lines to an array
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        String[] arr = new String[6600];
        int index = 0;

        while((line = br.readLine()) != null){
            arr[index] = line;
            index++;
        }
        fr.close();

        //Creating Hashmap for each roman digit

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        //Going through the array and adding the numbers
        char a = ' ';
        char b = ' ';
        int addx = 0;
        for(String str : arr){
            int len = str.length();
            for(int i=0;i<len;i++){
                a = str.charAt(i);
                int value = map.get(a);
                int nextNum = 0;
                if(i<len-1){
                    b = str.charAt(i+1);
                    nextNum = map.get(b);
                }
                if(value<nextNum){
                    value *= -1;
                }
                addx+=value;
            }
        }
        System.out.println(addx);
    }
}