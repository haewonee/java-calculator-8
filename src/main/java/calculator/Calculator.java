package calculator;

public class Calculator {
    public int add(String input){
        if (input == null || input.isEmpty()){
            return 0;
        }


        if(input.startsWith("//")){
            String[] parts = input.split("\n");
            String separator = parts[0].substring(2);
            String numbers = parts[1];

            String[] tokens = numbers.split(separator);
            int sum = 0;
            for(String token : tokens){
                sum += Integer.parseInt(token);
            }
            return sum;
        }

        String[] numbers = input.split("[,:]");
        int sum = 0;
        for (String number : numbers){
            sum += Integer.parseInt(number);
        }


        return sum;
    }
}
