
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class HelloWorld {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        String S="31/12/1998";
        System.out.println(S.substring(0, S.length()-1));
    }
}
