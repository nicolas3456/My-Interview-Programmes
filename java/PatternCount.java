import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PatternCounter {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] splittedInput = line.split(";");
      String pattern = splittedInput[0];
      String blobs = splittedInput[1];
      PatternCounter.doSomething(pattern, blobs);
    }
  }
  
  public static void doSomething(String pattern, String blobs) {
        
    String[] blobArray = blobs.split("\\|");
    int totalOccurences = 0;

    if(pattern.equals("")){
        for(int i= 0;i<blobArray.length;i++){
            System.out.print(0+"|");
        }
        System.out.println(0);
    }
    else{

    for(int i =0;i<blobArray.length;i++){
        int count = 0;
        //checking equality between all possible n-length substrings(where n is the length of the pattern) and the pattern.
        //The substrings are formed with the loop: starting with the substring from indexes 0-1 then 1-2 then 2-3 and so on.
        for(int j = 0;j < blobArray[i].length() - 1;j++) { 
            if(blobArray[i].substring(j,j+pattern.length()).equals(pattern))
                 count++;
                 
        } 

        System.out.print(count+ "|");
        totalOccurences+=count;
        
    }
    System.out.print(totalOccurences);

        }


  }
}