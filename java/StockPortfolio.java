import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*; 
import java.util.Comparator;

public class StockPortfolio {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
        StockPortfolio.matchBenchmark(line);
    }
  }
  
  public static void matchBenchmark(String input) {
    // Access your code here. Feel free to create other classes as required
    String portfolio = input.split(":")[0];
    String benchmark = input.split(":")[1];


    String[] portfolioAssets = portfolio.split("\\|");
    String[] benchmarkAssets = benchmark.split("\\|");

    Set<Asset> portAssets =  new HashSet<Asset>();
    Set<Asset> benchAssets = new HashSet<Asset>();


    for(int i=0; i<portfolioAssets.length;i++){
        String[] arr = portfolioAssets[i].split(",");
        portAssets.add(new Asset(arr[0],arr[1],Integer.parseInt(arr[2])));
        
    }

    for(int i=0; i<benchmarkAssets.length;i++){
        String[] arr = benchmarkAssets[i].split(",");
        benchAssets.add(new Asset(arr[0],arr[1],Integer.parseInt(arr[2])));
    }

    //check if any asset from the benchmark is not in portfolio assets,and if not,add it with quantity equal to 0,so it will apper in the ending result as a BUY recommendation.
    for(Asset a : benchAssets) {
        if(!contains(a,portAssets)){
            portAssets.add(new Asset(a.name,a.kind,0));
        }
    }


    Set<action> ts1 = new HashSet<action>(); 

    String st = "";
    for(Asset a : portAssets){
        for(Asset b : benchAssets){
            if(a.sameName(b) && a.sameKind(b)){
                 ts1.add(a.equalizeAssets(b));
            }   
        }
    }
    for(action ac:ts1){
        System.out.println(ac);
    }
    
    
    

  }

  public static Boolean contains(Asset as, Set<Asset> set){
      Boolean flag = false;
      for(Asset a : set) {
          if(a.sameName(as) && a.sameKind(as)){
              flag = true;
          }
         
      }
      return flag;
  }

}


class Asset {

    public String name;
    public String kind;
    public int quantity;

    public Asset(String name,String kind,int quantity){
        this.name=name;
        this.kind=kind;
        this.quantity=quantity;


    }

    public  Boolean compareAssets (Asset a1){
        Boolean flag = false;
        if(this.name.equals(a1.name) && this.kind.equals(a1.kind) && this.quantity == a1.quantity){
            flag = true;
        }
        else{
            flag = false;
        }
        return flag;
    }

    public  Boolean sameName(Asset a1){
        Boolean flag = false;
        if(this.name.equals(a1.name)){
            flag = true;
        }
        else{
            flag = false;
        }
        return flag;
    }

    public  Boolean sameKind(Asset a1){
        Boolean flag = false;
        if(this.kind.equals(a1.kind)){
            flag = true;
        }
        else{
            flag = false;
        }
        return flag;
    }

    public action equalizeAssets(Asset bench){
            action s =null;
            if(this.quantity<bench.quantity){
                 s = new action("BUY",this.name,this.kind,bench.quantity-this.quantity);
            }
            else if (this.quantity>bench.quantity){
                 s =  new action("SELL",this.name,this.kind,this.quantity-bench.quantity);
            }

            else{
                 s =  new action("","","",0);
            }
          
            return s;
    }

    public String toString() {
        String str = this.name + "," + this.kind + "," + this.quantity;
        return str;
    }

     


}

 class action {

    public String act;
    public String name;
    public String kind;
    public int quantity;

    public action(String act,String name,String kind,int quantity){
       
        this.act=act;
        this.name=name;
        this.kind=kind;
        this.quantity=quantity;


    }

    public String toString() {
        String str = "";
        if(!this.name.equals("")){
        str+=this.act+","+ this.name + "," + this.kind + "," + this.quantity; 
        }
        else{
            str+="";
        }
        return str;
    }

 }