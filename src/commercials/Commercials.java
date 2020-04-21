package commercials;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Commercials {
    public static void main(String[] args) {
        int result = findBiggestExpectedProfit(readInputData());

        System.out.println(result);
    }

    private static List<Integer> readInputData() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        List<Integer> breaks = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            breaks.add(scanner.nextInt() - p);
        }

        return breaks;
    }
    private static int findBiggestExpectedProfit(List<Integer> commercialBreaks) {
        int currentMax = commercialBreaks.get(0);
        int globalMax = currentMax;

        for(int cb : commercialBreaks) {
            currentMax = Integer.max(cb, currentMax + cb);

            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }
}
