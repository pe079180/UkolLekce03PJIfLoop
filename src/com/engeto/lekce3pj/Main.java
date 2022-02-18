package com.engeto.lekce3pj;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //region Demo

    /**
     * Ukázka použítí metody {@link Support#safeReadInt()}
     * <p>
     * Tato metoda použije metodu {@link Support#safeReadInt() k načtení
     * jednoho čísla od uživatele a vypsání tohoto čísla na výstup.
     * <p>
     * Podobně můžeš používat metodu {@link Support#safeReadInt()}
     * i v dalších metodách.
     */
    public static void readOneIntFromInputAndPrintIt() {
        int input = Support.safeReadInt();
        System.out.println("You entered: " + input);
    }
    //endregion

    //region Úlohy na cykly

    /**
     * Čte čísla, která zadává uživatel a vypisuje je na výstup.
     * Metoda pokračuje ve čtení opakovaně tak dlouho, dokud uživatel zadává kladná čísla či nulu.
     * <p>
     * Jakmile uživatel zadá záporné číslo, metoda skončí.
     */
    public static void readIntsFromInputAndPrintItUntilNegative() {
        int inputNumber;
        System.out.print("You entered: ");
        do {
            inputNumber = Support.safeReadInt();
            System.out.print(inputNumber + ", ");
        } while (inputNumber >= 0);

    }

    /**
     * Čte čísla ze vstupu tak dlouho, dokud uživatel nezadá záporné číslo.
     * Jako návratovou hodnotu vrátí součet zadaných čísel (záporné číslo by nemělo být zahrnuto).
     *
     * @return Součet všech zadaných čísel (záporné číslo ukončující vstup není zahrnuto).
     */
    public static int sumAllInputUntilNegative() {
        int inputNumber;
        int inputSumm = 0;

        do {
            inputNumber = Support.safeReadInt();
            if (inputNumber > 0) {
                inputSumm = inputSumm + inputNumber;
            }
        } while (inputNumber >= 0);
        return inputSumm;
    }

    /**
     * Čte čísla ze vstupu tak dlouho, dokud uživatel nezadá záporné číslo.
     * Všechna načtená čísla uloží do listu, který vrátí jako návratovou hodnotu.
     *
     * @return List načtených hodnot (záporná hodnota není zahrnuta v listu)
     */
    public static List storeAllInputInArrayListUntilNegative() {
        int inputNumber;
        List<Integer> inputNumbers = new ArrayList<>();

        do {
            inputNumber = Support.safeReadInt();
            inputNumbers.add(new Integer(inputNumber));
        } while (inputNumber >= 0);
        inputNumbers.remove(inputNumbers.size() - 1); // removes last negative number
        return inputNumbers;
    }

    /**
     * Dostane jako parametr list čísel. Vypíše čísla na obrazovku. Každé číslo vypiš na samostatný řádek.
     *
     * @param list List čísel, která se mají vypsat.
     */
    public static void printAllIntegersFromList(List<Integer> list) {
        for (Integer l : list
        ) {
            System.out.println(l);
        }
    }

    /**
     * Sečte hodnoty z listu a vrátí výsledek jako návratovou hodnotu.
     *
     * @param list List čísel, která chceme sečíst.
     * @return Součet všech čísel v listu.
     */
    public static Integer sumAllIntegersFromList(List<Integer> list) {
        int sumList = 0;
        for (Integer l : list
        ) {
            sumList = sumList + l;
        }
        return sumList;
    }
    //endregion

    //region Podmínky

    /**
     * Vypíše čísla ze seznamu, která jsou menší než zadaný limit.
     *
     * @param list  Seznam čísel, která máme zkontrolovat.
     * @param limit Limit - vypsána budou pouze čísla z listu, která jsou menší než limit
     */
    public static void printIntegersUnderLimit(List<Integer> list, int limit) {
        for (Integer l : list
        ) {
            if (l < limit) {
                System.out.println(l);
            }
        }
    }

    /**
     * Vypíše čísla ze zadaného listu.
     * Při výpisu ale nahradí:
     * - číslo 1 slovem "one",
     * - číslo 2 slovem "two",
     * - číslo 3 slovem "three"
     * Ostatní čísla vypíše jako číselnou hodnotu.
     * Například pokud dostane jako parametr seznam [5, 3, 1, 48, 2],
     * vypíše: 5, three, one, 48, two.
     *
     * @param list Seznam čísel, která se mají vypsat.
     */
    public static void printIntegersWithReplace(List<Integer> list) {
        String expression;
        for (Integer l : list
        ) {
            switch (l){
                case 1:
                    expression="one, ";
                    break;
                case 2:
                    expression="two, ";
                    break;
                case 3:
                    expression="three, ";
                    break;
                default:
                    expression=l+", ";


            }
            System.out.print(expression);
        }
    }
    //endregion

    public static void main(String[] args) {
        // Příklad:
        System.out.println("--- Example - read and print one integer ---");
        readOneIntFromInputAndPrintIt();
        // ---
        System.out.println("--- Task 1 - read and print integers until negative ---");
        readIntsFromInputAndPrintItUntilNegative();
        // ---
        System.out.println("--- Task 2 - sum all integers until negative ---");
        System.out.println("Total sum: " + sumAllInputUntilNegative());
        // ---
        System.out.println("--- Task 3 - read integers to list until negative ---");
        List<Integer> list = storeAllInputInArrayListUntilNegative();
        System.out.println(list);
        // ---
        System.out.println("--- Task 4 - print all integers from list ---");
        printAllIntegersFromList(list);
        // ---
        System.out.println("--- Task 5 - sum all integers in list ---");
        System.out.println("Total sum: " + sumAllIntegersFromList(list));
        // ---
        System.out.println("--- Task 6 - print integers under 5 from list ---");
        printIntegersUnderLimit(list, 5);
        // ---
        System.out.println("--- Task 7 - print integers - replace: 1 => \"one\", 2 => \"two\", 3 => \"three\" ---");
        printIntegersWithReplace(list);
    }
}