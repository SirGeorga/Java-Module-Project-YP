public class Bill {
    String list = "";
    double total = 0.0;
    void addToTotal (double itemCost){
        total += itemCost;
    }
    void addToList (String itemName){
        list += "\n- " + itemName;
    }
    void displayTotalCost (){
        System.out.printf("Общая стоимость внесённых позиций: %.2f",total);
    }
    void displayTotalList (){
        System.out.println("Список внесённых позиций:" + list);
    }
}
