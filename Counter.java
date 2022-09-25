import java.math.BigInteger;
import java.util.*;

public class Counter {
    static String result = "";
    static int iteration = 1; // This one is for increment during counting
    static String tmpIteration="";
    static int base=0;
    static int position=0;
    
    
    public static void main(String[] args) {        

        // Nice switch loop to give to each number of args, the necessary treatment.
        switch (args.length) {
            case 2:
                setValues(args[0], args[1]);
                break;
            case 3:
                tmpIteration=args[2]; // But if user puts third invalid number, we inform him but it's not blocking
                setValues(args[0], args[1]);
                break;
            case 4:
                findParameters(args);
                break;
            case 6:
                findParameters(args);
                break;
            default:
                System.out.println("Looking for the good values...");
        }
        
        counting();
    } 

    // Converter
    public static void counting(){
        int step = 0;
        
        // The condition who decide witch formular to use depending on the base
        if(base>=16 && base<=64) {
            do {
                result= convertToHigherBase(Integer.toString(step),base);
                if(result.length() <= position)
                    System.out.println(formatNumber(position, result));
                step+=iteration;
            }while ((result.length() <= position));
        }else if (base>=2 && base<16){
            do {
                result = convertToBase(Integer.toString(step), 10, base);
                if(result.length() <= position)
                    System.out.println(formatNumber(position, result));
                step+=iteration;
            }while ((result.length() <= position));
        }
    }

    // And this one manage the parameters to find out exact base or position mean by the user
    public static void findParameters(String arguments[]){
        String tmpBase="";
        String tmpPosition="";

        if (arguments.length==2){
            for (int i=0; i<arguments.length; i+=2){
                /* Increment to 2, because we want to make sure there is no confusion between options and values
                Then if user chooses to use command line options, he use it till the end or not at all */
                if (arguments[i].equals("-b")){
                    tmpBase=arguments[i+1];
                }else if (arguments[i].equals("-p")){
                    tmpPosition=arguments[i+1];
                }
            }
        }else if (arguments.length==4){
            for (int i=0; i<arguments.length; i+=2){
                if (arguments[i].equals("-b")){
                    tmpBase=arguments[i+1];
                }else if (arguments[i].equals("-p")){
                    tmpPosition=arguments[i+1];
                }
            }
        }else if (arguments.length==6){
            for (int i=0; i<arguments.length; i+=2){
                if (arguments[i].equals("-b")){
                    tmpBase=arguments[i+1];
                }else if (arguments[i].equals("-p")){
                    tmpPosition=arguments[i+1];
                }else if (arguments[i].equals("-i")){
                    tmpIteration=arguments[i+1];
                }else{
                    // Then something's wrong and we cannot accept that
                    tmpIteration="0";
                    tmpBase="0";
                    tmpPosition="0";
                }
            }
        }
        
        setValues(tmpBase, tmpPosition);
    }

    // It ensure the arguments values are valid before starting convertion
    public static void setValues(String b, String p){
        try {
            base = Integer.parseInt(b);
            position = Integer.parseInt(p);
            if (tmpIteration != "")
                iteration = Integer.parseInt(tmpIteration);
            if (base<2 || base>64)
                throw new Exception();
        }catch (Exception e) {
            System.out.println("Please enter a valid parameters. For base, it has to be bigger  than or equal to 2, and less than 65 ");
        }
    }
    
    // Convert from base 10 to the given base till base 16
    public static String convertToBase(String num, int decimal, int givenBase) {
        try {
            BigInteger b = new BigInteger(num,decimal);
            return b.toString(givenBase);
        } catch (Exception e) {
            System.out.println("Invalid argument : " + e.getLocalizedMessage());
        }
        return null;
    }

    /**
    * Convertion for 16+ bases
    * The converted value is given by repeatedly dividing number by target base and taking remainder
    * Case by case we construct a HashMap to keep and respect the defaults chars and digits to use
    */
    public static String convertToHigherBase(String number, int targetBase){

        Map<Integer, Character> decimalMapping=new HashMap<>();
        int j = 0;
        int temp = Integer.parseInt(number);
        StringBuilder str1 = new StringBuilder(); // To build the result in destination base

        for (int i = 0; i < 64; i++) {
            if (i<26)
                decimalMapping.put(10 + i, (char)('a' + i));
            if (i>=26 && i<62)
                decimalMapping.put(10 + i, (char)('A' + j++));
            if (i==62)
                decimalMapping.put(62, (char)('@'));
            if (i==63)
                decimalMapping.put(63, (char)('/'));
        }

        while (temp != 0) {
            int tempValue = temp % targetBase;
            if (targetBase >= 16 && decimalMapping.containsKey(tempValue)) {
                str1.insert(0, decimalMapping.get(tempValue));
            }
            else {
                str1.insert(0, tempValue);
            }
            temp /= targetBase;
        }
        return str1.toString();
    }

    // Replace left spaces by 0 to respect position format
    public static String formatNumber(int position, String str){
        int diff = position - str.length();
        return new String(new char[diff]).replace("\0", "0") + str;
    }

}