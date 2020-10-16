private class Currency {
    
    private double quantity;
    
    public Currency(double quantity){
        this.quantity = quantity;
    }
    
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


    public static void main(String []args){
        Currency curr = new Currency(2000.0);
        System.out.println(curr.toString());
    }

    
}
