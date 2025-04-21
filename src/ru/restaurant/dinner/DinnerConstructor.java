package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    private static Random random = new Random();
    HashMap<String, ArrayList<String>> dishTypeNames;

    DinnerConstructor() {
        dishTypeNames = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {
        dishTypeNames.putIfAbsent(dishType, new ArrayList<>());
        dishTypeNames.get(dishType).add(dishName);
    }

    boolean checkType(String nextItem) {
        return dishTypeNames.containsKey(nextItem);
    }

    void generateCombinations(ArrayList<String> dishTypes, int numberOfCombos) {
        for (int i = 1; i <= numberOfCombos; i++) {
            System.out.println("Комбо " + i);
            ArrayList<String> combination = new ArrayList<>();
            for (String type : dishTypes) {
                ArrayList<String> dishes = dishTypeNames.get(type);
                String randomDish = dishes.get(random.nextInt(dishes.size()));
                combination.add(randomDish);
            }
            System.out.println(combination);
        }
    }

}
