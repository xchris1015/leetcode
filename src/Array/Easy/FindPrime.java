package Array.Easy;

public class FindPrime {

    public static boolean findPrimie(int number) {

        if (number <= 1) {
            return false;
        }

        boolean result = true;

        for (int i = 2 ; i < number / 2 ; i++ ) {

            if (number % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(FindPrime.findPrimie(38));
    }



}
