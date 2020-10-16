import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;  
import java.lang.Math; 

public class Cashier {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(reader);

    try {
        double purchasePrice = Double.parseDouble(in.readLine());
        double cash = Double.parseDouble(in.readLine());
        Cashier.calculateChange(purchasePrice,cash);
    } catch (Exception e) {
        System.out.println(e);
    }
  }

  public static void calculateChange(double purchasePrice, double cash) {

        if (purchasePrice > cash){
            System.out.println("ERROR");
        }

        else {
    // Access your code here. Feel free to create other classes as required
        LinkedHashMap<Integer,Double> linkedHashMap = new LinkedHashMap<Integer,Double>();
        linkedHashMap.put(1,5000.0);
        linkedHashMap.put(2,2000.0);
        linkedHashMap.put(3,1000.0);
        linkedHashMap.put(4,500.0);
        linkedHashMap.put(5,200.0);
        linkedHashMap.put(6,100.0);
        linkedHashMap.put(7,50.0);
        linkedHashMap.put(8,20.0);
        linkedHashMap.put(9,10.0);
        linkedHashMap.put(10,5.0);
        linkedHashMap.put(11,2.0);
        linkedHashMap.put(12,1.0);

        String str = "";
        double cashToP = cash*100;
        double purchasePriceToP = purchasePrice * 100;
        
        double remainder = cashToP - purchasePriceToP;
     
        int i = 1;
        
        //the loop will be exterminatred as soon as the remainder is 0 so no more change left to give
        while (remainder > 0 && i<13) {
            
            //if the remainder/the current note or coin is 0(meaning the current note is greater than the remainder),which means there's no need of
            // giving such a note/coin as change,the remainder stays as it is,and we are
            //moving on to the next note/coin to see if it is a subset of our remaining change
            if((int)(remainder/linkedHashMap.get(i)) == 0 ){
                remainder-=0;
            }
            
            else {
                
                //if the current note/coin is smaller than our remaining.that means that we cane return such a note/coin and reduce the remaining change
                //the loop below determines how many current notes/coins can be given depending on how much is our remainder(i.e  if our remainder is 42 and the current 
                // note is 20 pounds,then 42/20 gives us 2 so we are printing Twenty Pounds 2 times.)
                for (int z=0; z<(int)(remainder/linkedHashMap.get(i));z++){
                    str+=new Currency(linkedHashMap.get(i)).toString();

                    //adding a coma after each printing)
                    if(z < (int)(remainder/linkedHashMap.get(i)) && remainder!=0){
                        str+=", ";
                    }
                }
                
                //setting the remainder to: (remainder) minus the product of how many times we gave a note/coin * the value of the note/coin
                remainder -= (int)(remainder/linkedHashMap.get(i)) * linkedHashMap.get(i);

               
                
            }
            
            i++;
        
        }
        System.out.println(str.substring(0, str.length() - 2));
  }
}

}

    //Notes-Coins class:: Has the quantity of pennies in it as an instance variables. 
       class Currency {
    
        private double quantity;
        
        public Currency(double quantity){
            this.quantity = quantity;
        }
        
        //returns what kind of note-coin the object is depending on the pennies equivalent
        public String toString() {
            String str = "";
            if(quantity == 5000.0){str = "Fifty Pounds";}
            if(quantity == 2000.0){str =  "Twenty Pounds";}
            if(quantity == 1000.0){str =  "Ten Pounds";}
            if(quantity == 500.0){str =  "Five Pounds";}
            if(quantity == 200.0){str =  "Two Pounds";}
            if(quantity == 100.0){str =  "One Pound";}
            if(quantity == 50.0){str =  "Fifty Pence";}
            if(quantity == 20.0){str =  "Twenty Pence";}
            if(quantity == 10.0){str =  "Ten Pounds";}
            if(quantity == 5.0){str =  "Five Pence";}
            if(quantity == 2.0){str =  "Two Pence";}
            if(quantity == 1.0){str =  "One penny";}
            
             return str; 
        }
    
    
        
    }
