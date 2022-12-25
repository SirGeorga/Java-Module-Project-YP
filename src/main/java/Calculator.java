public class Calculator {
    double billPerPerson;
    Calculator(int persons, Bill bill) {
        billPerPerson = bill.total;
        if (persons > 1) {
            billPerPerson = bill.total / persons;
            System.out.printf("Каждый из %d присутствующих должен заплатить: %.2f", persons, billPerPerson);
        }else
            System.out.printf("Вы оплачиваете полную стоимость: %.2f", billPerPerson);
    }

    Calculator() {
        System.out.println("Для рассчёта передайте в качестве аргументов количество человек и объект класса Bill");
    }
}

