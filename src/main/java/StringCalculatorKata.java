import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class StringCalculatorKata {



    public int add(String InputString) throws Exception{
        if(InputString.isEmpty())
        {
            return 0;
        }

        if(!Character.isDigit(InputString.charAt(InputString.length()-1)))
        {
            throw new Exception("ERROR: Invalid Input");
        }

        if(InputString.startsWith(" "))
        {
           throw new Exception("ERROR: Invalid Input");
        }

        if(!Character.isDigit(InputString.charAt(0)) || InputString.contains("//"))
        {
            if(!Character.isDigit(InputString.charAt(1))) {

                if(!InputString.startsWith("//")) {
                    throw new Exception("ERROR: Invalid Input");
                }
            }
        }



        String[] InputStrings = getNumbersFromString(InputString);

        return CalculateTotal(InputStrings);
    }

    private String[] getNumbersFromString(String InputString) throws Exception
    {
        String delimiter = ",";


        if(!InputString.contains("\n"))
        {
            return InputString.split(",");
        }

        String[] extract = InputString.split("\n");

        if(InputString.contains("["))
        {
            Pattern pattern = Pattern.compile("(?<=\\[).+?(?=\\])");
            Matcher matcher = pattern.matcher(extract[0]);
            while(matcher.find()){
                extract[1] = extract[1].replace(matcher.group(),",");
            }

            return extract[1].split(",");
        }

        if(InputString.startsWith("//"))
        {

            delimiter = extract[0].substring(2,extract[0].length());
            extract[1].replace(delimiter,",");
            return extract[1].replace(delimiter,",").split(",");

        }
        return InputString.replace("\n",delimiter).split(",");

    }


    public int CalculateTotal (String[] numbers) throws Exception
    {
        int i = 0;
        String negNumbers = "";

        ArrayList<String> negatives = new ArrayList<>();

            for (String number : numbers) {
                if (Integer.parseInt(number) > 0 && Integer.parseInt(number) < 1000) {
                    i += Integer.parseInt(number);
                }
                else
                    negatives.add(number);
            }

            for(String negative: negatives)
            {
                if(Integer.parseInt(negative) < 1000)
                    negNumbers += negative + ",";
            }

            if(!negNumbers.isEmpty())
            {
                throw new Exception("ERROR: negatives not allowed " + negNumbers.substring(0,negNumbers.length()-1));
            }


            return i;

    }
}
