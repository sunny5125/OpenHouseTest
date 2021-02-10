public class OpenHouseMain {
    public static void main (String[] args){
        System.out.println(stringToNumber("42")); // Output: 42
        System.out.println(stringToNumber("0")); // Output: 0
        System.out.println(stringToNumber("42a")); // Output: 42
        System.out.println(stringToNumber("42a35")); // Output: 42
        System.out.println(stringToNumber("abc42")); // Output: 0
        System.out.println(stringToNumber("-42")); // Output: -42
    }

    public static int stringToNumber(String num)
    {
        int signValue = 1, base = 0, i = 0;
        char[] number = num.toCharArray();
        while (number[i] == ' ') //Checking for white Space
        {
            i++;
        }
        if (number[i] == '-' || number[i] == '+') // Checking for negative value
        {
            signValue = 1 - 2 * (number[i++] == '-' ? 1 : 0);
        }
        while (i < number.length
                && number[i] >= '0'
                && number[i] <= '9') {

            if (base > Integer.MAX_VALUE / 10
                    || (base == Integer.MAX_VALUE / 10
                    && number[i] - '0' > 7))
            {
                if (signValue == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            base = 10 * base + (number[i++] - '0');
        }
        return base * signValue;
    }
}
