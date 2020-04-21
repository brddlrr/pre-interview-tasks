package pizzahawaii;

import java.util.*;

public class PizzaHawaii {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            List<Pizza> pizzas = new ArrayList<>();
            Set<String> ingredients = new TreeSet<>();

            for (int j = 0; j < n; j++) {
                String name = scanner.next();

                int engCount = scanner.nextInt();
                Set<String> italian = new TreeSet<>();
                for (int x = 0; x < engCount; x++) {
                    italian.add(scanner.next());
                }

                int itCount = scanner.nextInt();
                Set<String> english = new TreeSet<>();
                for (int x = 0; x < itCount; x++) {
                    english.add(scanner.next());
                }

                ingredients.addAll(italian);
                pizzas.add(new Pizza(name, english, italian));
            }

            for (String ingredient : ingredients) {
                Set<String> translated = new TreeSet<>();

                for (Pizza pizza : pizzas) {
                    if (pizza.italian.contains(ingredient)) {
                        if(translated.isEmpty()) {
                            translated.addAll(pizza.english);
                        } else {
                            translated.retainAll(pizza.english);
                        }
                    }
                }

                if (translated.isEmpty()) {
                    continue;
                }

                for (Pizza pizza : pizzas) {
                    if (!pizza.italian.contains(ingredient)) {
                        translated.removeAll(pizza.english);
                    }
                }

                for (String translation : translated) {
                    System.out.println("(" + ingredient + ", " + translation + ")");
                }
            }

            System.out.println();
        }
    }

    public static class Pizza {
        String name;
        Set<String> english;
        Set<String> italian;

        public Pizza(String name, Set<String> english, Set<String> italian) {
            this.name = name;
            this.english = english;
            this.italian = italian;
        }
    }
}
