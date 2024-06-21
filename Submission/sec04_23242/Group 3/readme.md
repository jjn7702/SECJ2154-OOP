# 🍏Nutrition Tracker System

𝓦𝓮𝓵𝓬𝓸𝓶𝓮 𝓽𝓸 𝓷𝓾𝓽𝓻𝓲𝓽𝓲𝓸𝓷 𝓽𝓻𝓪𝓬𝓴𝓮𝓻 𝓼𝔂𝓼𝓽𝓮𝓶 ! 

> This system helps you keep track of your daily food intake, monitor your nutritional goals, and maintain a balanced diet.

<img align= "center"  width=80% src= "https://i.giphy.com/j6SbdhHBWfz8SttRAJ.webp">


## 🥗 Features

📊 Daily Tracking: Log your daily meals and snacks.

⚖️ BMI Calculation: Calculate your Body Mass Index (BMI) to monitor your health and fitness progress.

📝 Meal Recording: Users can log their meals, including meal type, date, and food items.

✏️ Meal Editing: Easily edit your logged meals to ensure accurate tracking.

📈 Meal Reports: View your meals over date with visual reports.

👥 User Management: Admins can view food items, manage users, and delete user accounts.

🔒 Secure Login: Both admin and regular users can securely log in to access their personalized features.


## 🥗 OOP concepts
### 🔐Encapsulation and data hiding 
~~~
public class RegularUser extends User {
    private int age;
    private String gender;
    private double weight;
    private double height;
    private NutritionTracker nutritionTracker;

    public RegularUser(String username, String password, int age, String gender, double weight, double height) {
        super(username, password);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.nutritionTracker = new NutritionTracker();
    }

    public int getAge() {
        return age;
    }
~~~
Above code shows the RegularUser class has implemented encapsulation by providing accessors such as getAge() for other objects to indirectly access data. 
### 🖇️Association
~~~
public class NutritionTracker {
    private ArrayList<Meal> meals;

    public NutritionTracker() {
        this.meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }
~~~
~~~
public class Meal {
    private String type;
    private String date;
    private ArrayList<FoodItem> foodItems;

    public Meal(String type, String date) {
        this.type = type;
        this.date = date;
        this.foodItems = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
    }
~~~
The above figures show the unidirectional association between the Meal class and NutritionTracker class. This can be proven by the instance variables of Meal datatype objects as well as methods to add Meal objects in NutritionTracker. However, in the Meal class, there is none of the instance variables or methods about the NutritionTracker class. Also, the NutritionTracker class is an enclosing class whereas the Meal class is an enclosed class. The enclosing class exclusively owns enclosed classes. That means the existence of objects are independent where when a NutritionTracker object is destroyed, the Meal objects owned by this NutritionTracker object will not be destroyed together.

### 📦Composition
### 🗂️Inheritance
### 🫧Abstract class and polymorphism
### 📥Exception handling


## 🥗 FlowChart

## 🥗 Class Diagram
