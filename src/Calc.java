//
import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        
        int a, c, result = 0;
        boolean isRimA = false, isRimC = false;
        String str_a, str_c;
        
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine();
        
        String[] arr = str.split(" ");
        
        try{
            if (arr.length != 3){
                throw new Exception("Incorrect number of operands or operators");
            }

            str_a = arr[0];
            if (str_a.contains("I") | 
                    str_a.contains("V") |
                    str_a.contains("X") |
                    str_a.contains("L") |
                    str_a.contains("C")
                    ){
                a = RimToArab(str_a);
                isRimA = true;
            } else {
                a = Integer.parseInt(str_a);
            }
            
            str_c = arr[2];
            if (str_c.contains("I") | 
                    str_c.contains("V") |
                    str_c.contains("X") |
                    str_c.contains("L") |
                    str_c.contains("C")
                    ){
                c = RimToArab(str_c);
                isRimC = true;
            } else {
                c = Integer.parseInt(str_c);
            }
            
            System.out.println(a);
            System.out.println("......");
            System.out.println(c);
            System.out.println("......");            
            
            if (isRimA ^ isRimC) throw new Exception("Both numbers must be Rim or Arabic!");
       
            boolean isRim = isRimA & isRimC;
            
            if ((a<1)||(a>10)||(c<1)||(c>10)){
                throw new Exception("Numbers must be between 0 and 11");
            }
            switch(arr[1]) {
               case "+" :
                   result = a + c;
                   break;
               case "-" :
                   result = a - c;
                   break;
               case "/" :
                   result = a / c;
                   break;
              case "*" :
                  result = a * c;
                  break;
              default:
                  throw new Exception("The operand isn't correct!");
            }
            
            String str_result;
            
            if (isRim) {
                if (result < 1){
                    str_result = "";
                } else {
                    str_result = ArabToRim(result);
                }
            } else {
                str_result = Integer.toString(result);
            }

            System.out.println(str_result);
            
        } 
        
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    static int RimToArab(String num){
        int res = 0;
            switch (num){
                case "I":
                    res = 1;
                    break;
                case "II":
                    res = 2;
                    break;
                case "III":
                    res = 3;
                    break;
                case "IV":
                    res = 4;
                    break;
                case "V":
                    res = 5;
                    break;
                case "VI":
                    res = 6;
                    break;
                case "VII":
                    res = 7;
                    break;
                case "VIII":
                    res = 8;
                    break;
                case "IX":
                    res = 9;
                    break;
                case "X":
                    res = 10;
                    break;
                default:
                    res = 0;
                    break;
            }  
            System.out.println(num);
           
            return res;
    }
    
    static String ArabToRim(int num){
        String strRim = "";
        String res1 = "";
        String res2 = "";
        char digit;
        String strArab = Integer.toString(num);
        
        if (strArab.length() == 3){
            strRim = "C";
        } else {
            if (strArab.length() == 2){
                switch (strArab.charAt(0)){
                    case '1' : 
                        res1 = "X";
                        break;
                    case '2' :
                        res1 = "XX";
                        break;
                    case '3' :
                        res1 = "XXX";
                        break;
                    case '4' : 
                        res1 = "XL";
                        break;
                    case '5' :
                        res1 = "L";
                        break;
                    case '6' :
                        res1 = "LX";
                        break;
                    case '7' : 
                        res1 = "LXX";
                        break;
                    case '8' : 
                        res1 = "LXXX";
                        break;
                    case '9' : 
                        res1 = "XC";
                        break;
                    default : 
                        break;        
                }
                digit = strArab.charAt(1);
            } else {
                digit = strArab.charAt(0);
            }
            
            switch (digit){
                case '0' :
                    res2 = "";
                    break;
                case '1' :
                    res2 = "I";
                    break;
                case '2' :
                    res2 = "II";
                    break;
                case '3' :
                    res2 = "III";
                    break;
                case '4' :
                    res2 = "IV";
                    break;
                case '5' :
                    res2 = "V";
                    break;
                case 6 :
                    res2 = "VI";
                    break;
                case 7 :
                    res2 = "VII";
                    break;
                case 8 :
                    res2 = "VIII";
                    break;
                case 9 : 
                    res2 = "IX";
                    break;
                default :
                    break;
            }  
            strRim = res1.concat(res2);  
        }    
        
        return strRim;
    }
}

    


