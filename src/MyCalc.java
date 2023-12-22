import java.util.Scanner;

public class MyCalc {
    static int num;
    static int num1;
    static int itog;
    boolean isRoman = true;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение в одном формате:");
        String input = sc.nextLine(); // Выводим текст на консоль
        String calc = calc(input);
        System.out.println("Ответ: " + calc);


    }

    public static String calc(String input) throws Exception {
        String[] exp = {"+", "-", "*", "/"};
        String[] expr = input.split("[+,\\-,*,/]");
        String[] rezult = input.split(" ");
        int a = 0;
        String str = "";
        String out;
        RomNombr[] values = RomNombr.values();
        RomNombr.fromArad(str,a);
        if (3 != rezult.length) {
            throw new Exception("Не тот формат выражения");
        }
        if (expr.length != 2) {
            throw new Exception("Не тот формат выражения");
        }
        int exspindex = -1;
        for (int i = 0; i < exp.length; i++) {
            if (input.contains(exp[i])) exspindex = i;
        }
        boolean isRoman;
        try {
            num = Integer.parseInt(rezult[0]); //"Переводим стинг в инт"
            num1 = Integer.parseInt(rezult[2]);
            isRoman = false;// Если не римские то парс не работает
        } catch (NumberFormatException e) {
            try {
                num = RomNombr.valueOf(rezult[0]).getA();
                num1 = RomNombr.valueOf(rezult[2]).getA();
                isRoman = true;

            } catch (IllegalArgumentException ex) {// исключение недопустимые или неподходящие аргументы.

                throw new Exception("Ошибка числа должны быть в одном фомате", ex);
            }
        }
        if (num < 1 || num > 10) {
            throw new Exception("Не корректное иыражение,числа должны быть от 1 до 10:");
        }
        if (num1 < 1 || num1 > 10) {
            throw new Exception("Не корректное иыражение,числа должны быть от 1 до 10");
        }

        switch (exp[exspindex]) { // Производим арифмитические действия
            case "+" -> itog = num + num1;
            case "-" -> itog = num - num1;
            case "*" -> itog = num * num1;
            case "/" -> itog = num / num1;
            default -> {
            }
        }
        if(isRoman){
            for (int i =0;i< values.length;i++){
                if(values[i].getA()==itog){
                   out = values[i].getStr();
                   return out;
                }
                if(itog < 0) {
                    throw new Exception("В римском формате нет отрицательных чисел");
                }
            }
        }
        return Integer.toString(itog);


    }
}