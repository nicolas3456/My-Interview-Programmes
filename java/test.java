
public class test {
    public static void main(String[] args)  {
        char[] patt = new char[2];
        patt[0] = 'b';patt[1] = 'c';
        String string = "bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32";
        String[] parts = string.split("\\|");
        int count = 0;
        int c=0;

        for(int z=0;z<parts[0].length();z++){
            count = 0;
            for(int i =0;i<patt.length;i++){
                if(patt[i] == parts[0].charAt(z)){
                    count++;
                }
                else{
                    count+=0;
                }

            }
            if(count == patt.length){
                c++;
            }
        }

        System.out.println(c);
        System.out.println(patt[0]);
        System.out.println(parts[0].charAt(0));



        
    }

}