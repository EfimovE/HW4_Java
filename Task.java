// Написать приложение для ввода ФИО, возраст и пол пользователей. Данные хранить в разных списках. 
// Сортировать пользователей по возрасту. Не вывести в порядке возрастания возрастов а именно сортировать!)


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Task {
    public static void main(String[] args) {

        ArrayList<String> list_fname = new ArrayList<>();
        ArrayList<String> list_lname = new ArrayList<>();
        ArrayList<String> list_tname = new ArrayList<>();
        ArrayList<Integer> list_age = new ArrayList<>();
        ArrayList<Boolean> list_gender = new ArrayList<>();
        List<Integer> linkedlist = new LinkedList<>();

        boolean flag = true;
        while (flag) {
            Scanner iScanner = new Scanner(System.in);;
            Scanner scanner = new Scanner(System.in);
            Scanner scanner_age = new Scanner(System.in);
            Scanner gender = new Scanner(System.in);
            System.out.printf("Введите фамилию: ");
            String lname = scanner.nextLine();
            list_lname.add(lname);
            System.out.println();

            System.out.printf("Введите имя: ");
            String fName = scanner.nextLine();
            list_fname.add(fName);
            System.out.println();

            System.out.printf("Введите отчество: ");
            String tname = scanner.nextLine();
            list_tname.add(tname);
            System.out.println();

            // System.out.println("Введите ФИО: ");
            // String fio = scanner.nextLine();
            System.out.println("Введите возраст: ");
            Integer age = scanner_age.nextInt();
            list_age.add(age);
            // String[] fio1 = fio.split(" ");
            // if (fio1.length == 3) {
            //     list_fname.add(fio1[1]);
            //     list_lname.add(fio1[0]);
            //     list_tname.add(fio1[2]);
            // } else if (fio1.length == 2) {
            //     list_lname.add(fio1[0]);
            //     list_fname.add(fio1[1]);
            //     list_tname.add("");
            // } else {
            //     list_lname.add(fio1[0]);
            //     list_fname.add("");
            //     list_tname.add("");
            // }

            System.out.println("Введите пол: M/F");

            String gender1 = scanner.nextLine();
            switch(gender1.toLowerCase()) {
                case "m":
                    list_gender.add(true);
                    break;
                case "f":
                    list_gender.add(false);
                    break;
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
            // if (gender.contains("M")) {
            //     list_gender.add("true");
            // }
            // else  {
            //     list_gender.add("false");
            // }
            linkedlist.add(list_age.size() - 1); 
            System.out.println("Добавить еще одну запись? Y/N");
            Scanner scanner1 = new Scanner(System.in);
            String yn = scanner1.nextLine();
            if(yn.toUpperCase().equals("N")) {
                flag = false;
            }
        }

        int cnt = list_age.size()-1;
        while (cnt > -1) {
            int max_age = list_age.get(linkedlist.get(cnt));
            int index = cnt;
            for (int i = 0; i < cnt; i++){
                if (max_age < list_age.get(linkedlist.get(i))){
                    max_age = list_age.get(linkedlist.get(i));
                    index = i;
                }
            }
            int tmp = linkedlist.get(cnt);
            linkedlist.set(cnt, linkedlist.get(index));
            linkedlist.set(index, tmp);

            cnt--;
        }
        System.out.println("Сортировка пользователей по возрасту.");
        linkedlist.forEach(i ->
        System.out.println(list_fname.get(i) + list_lname.get(i) + list_tname.get(i) + ", " + list_age.get(i) + ", " + list_gender.get(i)));

    }
} 
    

