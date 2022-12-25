import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество человек, между которыми нужно разделить счёт: ");
        int persons;
        String input = scanner.next();

        // защита от присваивания некорректных значений
        while (!isValidInt(input)) {
            System.out.print("\nНекорректное число! Количество человек должно быть целым, положительным числом! Попробуйте ещё раз: ");
            input = scanner.next();
        }
        persons = Integer.parseInt(input);

        Bill bill = new Bill();
        String completion = "";
        while (completion.compareToIgnoreCase("Завершить") != 0) {
            System.out.print("\nВведите название товара: ");
            bill.addToList(scanner.next());
            System.out.print("Введите стоимость товара: ");
            input = scanner.next();
            while (!isValidDouble(input)) {
                System.out.print("\nНекорректное число! Стоимость должна быть выражена положительным числом (разделитель целой и дробной части - точка)! Попробуйте ещё раз: ");
                input = scanner.next();
            }
            bill.addToTotal(Double.parseDouble(input));
            System.out.print("Товар успешно добавлен в список! Хотите добавить ещё что-нибудь? (Для рассчёта равных долей введите \"Завершить\"): ");
            completion = scanner.next();
        }
        System.out.println("-----------------------------------------------------");
        bill.displayTotalList();
        System.out.println("----------");
        bill.displayTotalCost();
        System.out.println(" " + messageEndingHandler(bill.total));
        System.out.println("-----------------------------------------------------");
        Calculator payment = new Calculator(persons,bill);
        System.out.println(" " + messageEndingHandler(payment.billPerPerson));
    }

    // проработка окончания слова "рубль" в зависимости от суммы
    public static String messageEndingHandler(double number) {
        String ending;
        String message = "рубл";
        int preLastDigit = (int) number % 100 / 10;
        if (preLastDigit == 1)
        {
            ending = "ей";
        }
        switch ((int) number % 10)
        {
            case 1:
                ending = "ь";
                break;
            case 2:
            case 3:
            case 4:
                ending = "я";
                break;
            default:
                ending = "ей";
                break;
        }
        return message += ending;
    }

    // проверка значения на целочисленность и положительность
    public static boolean isValidInt(String str){
        if (str != null && str.matches("[0-9]+") ) {
            if (Integer.parseInt(str) <= 0 ) {
                return false;
            } else
                return true;
        } else
            return false;
    }

    // проверка значения на вещественность и положительность
    public static boolean isValidDouble(String str){
        if (str != null && str.matches("[0-9.]+") ) {
            if (Double.parseDouble(str) <= 0 ) {
                return false;
            } else
                return true;
        } else
            return false;
    }
}


