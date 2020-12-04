package Array.Easy;

public class FindSecondHighestNumber {

    public static int findSecondHighestNumber(int[] array) {

        if (array == null || array.length <= 1) {
            throw new IllegalArgumentException("Input Invalid");
        }

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i = 0 ; i < array.length ; i++ ) {
            if (array[i] > highest) {
                highest = array[i];
            }
        }

        for (int j = 0 ; j < array.length ; j++ ) {
            if (array[j] > secondHighest && array[j] < highest) {
                secondHighest = array[j];
            }
        }

        return secondHighest;

    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 14, 300, 1000, 5};
        System.out.println(FindSecondHighestNumber.findSecondHighestNumber(array));

    }




}
