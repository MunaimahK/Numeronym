import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Numeronym {
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public Numeronym(String input) {
        this.input = input;

    }

    public String printNumeronym(String input)
    {
        this.input = input;
        char[] ch = input.toCharArray();
        int num = ch.length - 2;
        int length = ch.length;

        if(input.contains(".") || input.contains("!") || input.contains("?"))
        {
            return "Invalid input.";
        }
        
        if(length < 3)
        {
            return input;
        }
       
      return input +" -> " + ch[0] + num + ch[length-1];
    }
}
