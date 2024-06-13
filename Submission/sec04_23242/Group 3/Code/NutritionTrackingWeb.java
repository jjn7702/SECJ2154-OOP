import java.util.*;
import java.io.File;
import java.io.IOException;

public class NutritionTrackingWeb {
    public static void main(String[] args) throws IOException {
        Scanner foodList = new Scanner(new File("foodItemList.txt"));
        ArrayList <FoodItem> foodItemList = new ArrayList<FoodItem>();
        String foodName;
        double foodCalories;

        while(foodList.hasNext()){
            
            foodCalories = foodList.nextDouble();
            foodName = foodList.nextLine();

            FoodItem ft = new FoodItem(foodName, foodCalories);
            foodItemList.add(ft);
        }

        // for(FoodItem f: foodItemList){
        //     f.displayFood();
        // }

        foodList.close();


    }
}
