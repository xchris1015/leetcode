package Array.Medium;

public class Shuffling {

    private static int[] shuffle(int[] deck) {

        int n = deck.length;
        int[] newDeck = new int[n];

        for (int i = 0 ; i < n / 2 ; i++ ) {

            // this is for the interleaves card starting with the top
            newDeck[2 * i] = deck[n / 2 + i];
            newDeck[2 * i + 1] = deck[i];

//            this is for the interleaves card starting with the bottom
//            newDeck[2 * i] = deck[n / 2 + i];
//            newDeck[2 * i + 1] = deck[i];
        }
        return newDeck;
    }

    private static void swap(int[] deck, int i, int j) {
        int temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;

    }

    private static int firstQuestion(int[] deck) {

        for (int i = 0 ; i < deck.length ; i++ ) {
            if (deck[i] == 1) {
                return i;
            }
        }

        return -1;
    }

    private static boolean thirdQuestion(int[] deck) {

        for (int i = 0 ; i < deck.length - 1 ; i++ ) {
            if ((deck[i] == 52 && deck[i + 1] == 1) || (deck[i] == 1 && deck[i + 1] == 52)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // deck with 52 cards
        int[] deck = new int[52];

        // initial with card position
        for (int i = 0 ; i < deck.length ; i++ ) {
            deck[i] = i + 1;
        }

        boolean firstPlace = false;
        boolean topToBottom = false;
        boolean firstTouchLast = false;

        int shuffles = 0;

        while (!(firstPlace && topToBottom && firstTouchLast)) {
            deck = shuffle(deck);
            shuffles++;

            // Question 1: What is the position of the first card after the 7th shuffle?
            if (shuffles == 7) {
                int position = firstQuestion(deck);
                firstPlace = true;
                System.out.println("Position of the first card after the 7th shuffle : " + position);
            }

            // Question 2 : How many times must one perform the shuffle so that the top card becomes the bottom card?
            if (deck[deck.length - 1] == 1) {
                topToBottom = true;
                System.out.println("Top card becomes the bottom card at " + shuffles + " shuffles.");
            }

            // Question 3 : When do the first and last cards in the deck touch?
            if (thirdQuestion(deck)) {
                firstTouchLast = true;
                System.out.println("First card touch the last card at " + shuffles + " shuffles.");
            }

        }

    }
}
