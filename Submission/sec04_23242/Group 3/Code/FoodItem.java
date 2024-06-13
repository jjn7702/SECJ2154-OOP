import java.util.ArrayList;

class FoodItem {
    //Attribute
    private String name;
    private double calories;

    //Construstor
    public FoodItem(){}
    public FoodItem(String name, double calories){
        this.name = name;
        this.calories = calories;
    }
    
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }

    //Getter
    public String getName(){return name;}
    public double getCalories(){return calories;}

    public void displayFood(){
        System.out.printf("%-25s%-2s%-4.2f%-5s\n", name, ":", calories, " kcal");
    }

}

class Meal{
    //Attribute
    private ArrayList <FoodItem> foodList;
    //Construtor
    public Meal(){
        foodList = new ArrayList<FoodItem>();
    }

    //add new food into meal
    public void addFoodItem(FoodItem fi){
        foodList.add(fi);
    }

    //remove fooditem from the list based on name inserted
    public void removeFoodItem(String food){
        for(FoodItem f : foodList){
            if(f.getName().equals(food)){
                foodList.remove(f);
            }
        }
    }

    //polymorphism display function
    public void displayMeal(){
        int counter = 1;
        for(FoodItem f : foodList){
            System.out.print(counter + ")");
            f.displayFood();
            counter ++;
        }
    }

    //calculate total calories
    public double totalCal(){
        double totalC = 0.0;
        for(FoodItem f : foodList){
            totalC += f.getCalories();
        }
        return totalC;
    }
}

interface suggestedCal{
    int maxBreakfastCal = 500;
    int maxLunchDinnerCal = 600;
}

class Breakfast extends Meal implements suggestedCal{
    public Breakfast(){
        super();
    }

    public void displayMeal(){
        System.out.println("----------Breakfast----------");
        System.out.println("Maximun suggested calories intake: " + maxBreakfastCal + "kcal");
        System.out.println("Food intake:");
        super.displayMeal();
        System.out.println("Total calories intake for Breakfast: " + super.totalCal() + "kcal");
    }
}

class Lunch extends Meal implements suggestedCal{
    public Lunch(){
        super();
    }

    public void displayMeal(){
        System.out.println("----------Lunch----------");
        System.out.println("Maximun suggested calories intake: " + maxLunchDinnerCal + "kcal");
        System.out.println("Food intake:");
        super.displayMeal();
        System.out.println("Total calories intake for Lunch: " + super.totalCal() + "kcal");
    }
}

class Dinner extends Meal implements suggestedCal{
    public Dinner(){
        super();
    }

    public void displayMeal(){
        System.out.println("----------Dinner----------");
        System.out.println("Maximun suggested calories intake: " + maxLunchDinnerCal + "kcal");
        System.out.println("Food intake:");
        super.displayMeal();
        System.out.println("Total calories intake for Dinner: " + super.totalCal() + "kcal");
    }
}