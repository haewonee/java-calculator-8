package calculator;

public class Calculator {
    public int add(String input){
        if (input == null || input.isEmpty()){
            return 0;
        }


        if (input.startsWith("//")){
            String[] parts = input.split("\n");
            String separator = parts[0].substring(2);
            String numbers = parts[1];

            String[] tokens = numbers.split(separator);
            int sum = 0;
            for(String token : tokens){
                int number = parseNumber(token);
                if (number < 0){
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                }
                sum += number;
            }
            return sum;
        }

        String[] numbers = input.split("[,:]");
        int sum = 0;
        for (String number : numbers){
            int value = parseNumber(number);
            if (value < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: "+value);
            }
            sum += value;
        }

        return sum;
    }

    private int parseNumber(String s){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + s);
        }
    }
}
