import java.util.*;
import java.util.stream.Collectors;

public class App {

    /**
     * Prompts the user to enter the prizes and returns them as an array of strings.
     */
    public static String[] getPrizes(Scanner sc) {
        System.out.print("Enter the prizes (comma-separated values): ");
        return sc.nextLine().split(",");
    }

    /**
     * Prompts the user to enter the winners and returns them as an array of
     * strings.
     */
    public static String[] getWinners(Scanner sc) {
        System.out.print("Enter the winners (comma-separated names): ");
        return sc.nextLine().split(",");
    }

    /**
     * Converts an array of prize values in string format to a list of integers.
     */
    public static List<Integer> convertToIntegerList(String[] prizeValues) {
        List<Integer> prizes = new ArrayList<>();
        for (String prize : prizeValues) {
            prizes.add(Integer.parseInt(prize.trim()));
        }
        return prizes;
    }

    /**
     * Distributes the prizes among the winners as fairly as possible and returns a
     * map of winner names to list of prize amounts.
     */
    public static Map<String, List<Integer>> distributePrizes(List<Integer> prizes, String[] winners) {
        int numWinners = winners.length;
        int totalPrize = prizes.stream().mapToInt(Integer::intValue).sum();
        int fairShare = totalPrize / numWinners;
        Map<String, List<Integer>> prizeDistribution = new HashMap<>();

        // Give each winner a fair share of the total prize
        for (String winner : winners) {
            List<Integer> fairShareList = new ArrayList<>();
            fairShareList.add(fairShare);
            prizeDistribution.put(winner, fairShareList);
        }

        // Distribute any remaining prizes one at a time, starting from the first winner
        int remainingPrizes = totalPrize - (fairShare * numWinners);
        int i = 0;
        while (remainingPrizes > 0) {
            String winner = winners[i];
            prizeDistribution.get(winner).add(1);
            remainingPrizes--;
            i = (i + 1) % numWinners;
        }

        return prizeDistribution;
    }

    public static void printPrizeDistribution(Map<String, List<Integer>> prizeDistribution) {
        System.out.println("\nPrize Distribution:");
        for (Map.Entry<String, List<Integer>> entry : prizeDistribution.entrySet()) {
            String winner = entry.getKey();
            List<Integer> prizes = entry.getValue();
    
            // Format the prize amounts as a comma-separated string
            String prizeString = prizes.stream().map(p -> String.format("%,d", p)).collect(Collectors.joining(","));

            // Print the winner and their prize amounts
            System.out.println(winner + ":" + prizeString);
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] prizeValues = getPrizes(sc);
        String[] winners = getWinners(sc);
        List<Integer> prizes = convertToIntegerList(prizeValues);
        Map<String, List<Integer>> prizeDistribution = distributePrizes(prizes, winners);
        printPrizeDistribution(prizeDistribution);
        sc.close();
    }

}
