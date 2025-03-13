package ru.practicum.dinner;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();
            String commandTrimmed = command.trim();
            switch (commandTrimmed) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Спасибо за использование программы! До свидания!");
                    return;
                default:
                    System.out.println("Ошибка: такой команды не существует. Попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
        System.out.println("Блюдо успешно добавлено:)");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        ArrayList<String> dishTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                dishTypes.add(nextItem);
            } else {
                System.out.println("В настоящее время у нас нет блюда такого типа, пожалуйста, введите другой тип");
            }
            nextItem = scanner.nextLine();
        }

        dc.generateCombinations(dishTypes, numberOfCombos);
    }
}
