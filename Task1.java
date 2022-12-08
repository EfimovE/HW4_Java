// Написать приложение для ввода ФИО, возраст и пол пользователей. 
// Данные хранить в разных списках. Сортировать пользователей по возрасту. Н
// е вывести в порядке возрастания возрастов а именно сортировать!)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> patronymics = new ArrayList<>();
        ArrayList<Boolean> genders = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();

        String answer = "y";
//        names.add("Math");
//        names.add("Way");
//        names.add("Sort");
//        names.add("Ing");
//        lastNames.add("Bool");
//        lastNames.add("Dog");
//        lastNames.add("Hot");
//        lastNames.add("Sossis");
//        patronymics.add("Serg");
//        patronymics.add("Ant");
//        patronymics.add("Olg");
//        patronymics.add("Elen");
//        genders.add(true);
//        genders.add(true);
//        genders.add(false);
//        genders.add(false);
//        ages.add(55);
//        ages.add(46);
//        ages.add(12);
//        ages.add(34);

        while (answer.equals("y") ) {
            Scanner iScanner = new Scanner(System.in);

            System.out.printf("name: ");
            String name = iScanner.nextLine();
            names.add(name);
            System.out.println();

            System.out.printf("last name: ");
            String lastName = iScanner.nextLine();
            lastNames.add(lastName);
            System.out.println();

            System.out.printf("patronymic: ");
            String patronymic = iScanner.nextLine();
            patronymics.add(patronymic);
            System.out.println();

            System.out.printf("gender M/F: ");
            String gender = iScanner.nextLine();
            switch(gender.toLowerCase()) {
                case "m":
                    genders.add(false);
                    break;
                case "f":
                    genders.add(true);
                    break;
                default:
                    System.out.println("unknown command");
                    break;
            }
            System.out.println();

            System.out.printf("age: ");
            int age = iScanner.nextInt();
            ages.add(age);
            System.out.println();

            Scanner lScanner = new Scanner(System.in);

            System.out.printf("append user? Y/N ");
            answer = lScanner.nextLine().toLowerCase(Locale.ROOT);
        }

        System.out.println(names);
        System.out.println(lastNames);
        System.out.println(patronymics);
        System.out.println(genders);
        System.out.println(ages);

        Scanner sc = new Scanner(System.in);
        int choise = 0;
        LinkedList <Integer> sortList = new LinkedList<>();
        for (int i = 0; i < ages.size(); i++){
            sortList.add(i);
        }
        System.out.println("choise sort:");
        System.out.println("1 - name");
        System.out.println("2 - last name");
        System.out.println("3 - patronymic");
        System.out.println("4 - gender");
        System.out.println("5 - age");
        choise = sc.nextInt();

        switch (choise){
            case 1:
                int cnt1 = names.size()-1;
                while (cnt1 > -1) {
                    String maxName = names.get(sortList.get(cnt1));
                    int index = cnt1;
                    for (int i = 0; i < cnt1; i++){
                        String word = names.get(sortList.get(i));
                        if (maxName.charAt(0)  < word.charAt(0)){
                            maxName = word;
                            index = i;
                        }
                    }
                    int tmp = sortList.get(cnt1);
                    sortList.set(cnt1, sortList.get(index));
                    sortList.set(index, tmp);
                    cnt1--;
                }
                break;
            case 2:
                int cnt2 = lastNames.size()-1;
                while (cnt2 > -1) {
                    String maxLastName =lastNames.get(sortList.get(cnt2));
                    int index = cnt2;
                    for (int i = 0; i < cnt2; i++){
                        String word = lastNames.get(sortList.get(i));
                        if (maxLastName.charAt(0)  < word.charAt(0)){
                            maxLastName = word;
                            index = i;
                        }
                    }
                    int tmp = sortList.get(cnt2);
                    sortList.set(cnt2, sortList.get(index));
                    sortList.set(index, tmp);
                    cnt2--;
                }
                break;
            case 3:
                int cnt3 = patronymics.size()-1;
                while (cnt3 > -1) {
                    String maxPatronymic =patronymics.get(sortList.get(cnt3));
                    int index = cnt3;
                    for (int i = 0; i < cnt3; i++){
                        String word = patronymics.get(sortList.get(i));
                        if (maxPatronymic.charAt(0)  < word.charAt(0)){
                            maxPatronymic = word;
                            index = i;
                        }
                    }
                    int tmp = sortList.get(cnt3);
                    sortList.set(cnt3, sortList.get(index));
                    sortList.set(index, tmp);
                    cnt3--;
                }
                break;
            case 4:
                int cnt4 = genders.size()-1;
                while (cnt4 > -1){
                    int index = cnt4;
                    for (int i = 0; i < cnt4; i++) {
                        if(genders.get(sortList.get(cnt4))){
                            index = i;
                        }
                    }
                    int tmp = sortList.get(cnt4);
                    sortList.set(cnt4, sortList.get(index));
                    sortList.set(index, tmp);
                    cnt4--;
                }
                break;
            case 5:
                int cnt = ages.size()-1; // индекс последнего
                while (cnt > -1) {
                    int max_age = ages.get(sortList.get(cnt));
                    int index = cnt;
                    for (int i = 0; i < cnt; i++){
                        if (max_age < ages.get(sortList.get(i))){
                            max_age = ages.get(sortList.get(i));
                            index = i;
                        }
                    }
                    int tmp = sortList.get(cnt);
                    sortList.set(cnt, sortList.get(index));
                    sortList.set(index, tmp);
                    cnt--;
                }
                break;
            default:
                System.out.println("error");
                break;
        }
        for (int i = 0; i < sortList.size(); i++) {
            System.out.printf(names.get(sortList.get(i)) + " ");
            System.out.printf(lastNames.get(sortList.get(i)) + " ");
            System.out.printf(patronymics.get(sortList.get(i)) + " ");
            System.out.printf(genders.get(sortList.get(i)) + " ");
            System.out.printf(ages.get(sortList.get(i)) + " ");
            System.out.println();
        }
    }
}