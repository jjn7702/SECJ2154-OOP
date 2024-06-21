# 🍏🥦🥑 Nutrition Tracker System 🍏🥦🥑

Ⓦⓔⓛⓒⓞⓜⓔ ⓣⓞ ⓝⓤⓣⓡⓘⓣⓘⓞⓝ ⓣⓡⓐⓒⓚⓔⓡ ⓢⓨⓢⓣⓔⓜ !!


> This system helps you keep track of your daily food intake, monitor your nutritional goals, and maintain a balanced diet. 🫐

<img align= "center"  width=80% src= "https://i.giphy.com/j6SbdhHBWfz8SttRAJ.webp">

🥦🥦🥦..
##  🥗 𝐅𝐞𝐚𝐭𝐮𝐫𝐞𝐬 🥗
<img align="right" width=30% src="https://img.freepik.com/premium-vector/eat-healthy-food-cartoon-hand-drawn-doodle-self-care-awareness-drawing-clip-art-icon-illustration_66976-559.jpg">

📊 **Daily Tracking**: Log your daily meals and snacks.

⚖️ **BMI Calculation**: Calculate your Body Mass Index (BMI) to monitor your health and fitness progress.

📝 **Meal Recording**: Users can log their meals, including meal type, date, and food items.

✏️ **Meal Editing**: Easily edit your logged meals to ensure accurate tracking.

📈 **Meal Reports**: View your meals over date with visual reports.

👥 **User Management**: Admins can view food items, manage users, and delete user accounts.

🔒 **Secure Login**: Both admin and regular users can securely log in to access their personalized features.

🥦🥦🥦..

## 🥗 𝐎𝐎𝐏 𝐂𝐨𝐧𝐜𝐞𝐩𝐭𝐬 🥗
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
🥦🥦🥦..
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
The above code show the unidirectional association between the Meal class and NutritionTracker class. This can be proven by the instance variables of Meal datatype objects as well as methods to add Meal objects in NutritionTracker. However, in the Meal class, there is none of the instance variables or methods about the NutritionTracker class. Also, the NutritionTracker class is an enclosing class whereas the Meal class is an enclosed class. The enclosing class exclusively owns enclosed classes. That means the existence of objects are independent where when a NutritionTracker object is destroyed, the Meal objects owned by this NutritionTracker object will not be destroyed together.
🥦🥦🥦..
### 📦Composition
~~~
public class DatabaseManager {
    private ArrayList<Admin> admins;
    private ArrayList<RegularUser> regularUsers;
    private static final String ADMIN_FILE = "C:\\Users\\kaixu\\Desktop\\source_code\\admins.txt";
    private static final String REGULAR_USER_FILE = "C:\\Users\\kaixu\\Desktop\\source_code\\regular_users.txt";
    private static final String MEAL_FILE = "C:\\Users\\kaixu\\Desktop\\source_code\\meals.txt";

    public DatabaseManager() throws IOException {
        this.admins = new ArrayList<>();
        this.regularUsers = new ArrayList<>();
        loadAdmins();
        loadRegularUsers();
        loadMeals();
    }
~~~
The above code shows the composition between the DatabaseManager class with Admin class and the RegularUser class. In this case, the DatabaseManager class is an enclosing class whereas the Admin class and RegularUser class are enclosed classes. The enclosed classes are the parts of the enclosed class. That means the existence of objects is dependent where when a DatabaseManager object is destroyed, the Admin objects and RegularUsers objects owned by this DatabaseManager object will be destroyed too. 
🥦🥦🥦..
### 🗂️Inheritance
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
~~~
The above code shows the inheritance relationship between RegularUser and User where RegularUser is a child class, User is a parent class. A child class will own all the attributes and methods declared in the parent class and add on their specific attribute and methods. The username and password attributes shown above are the attributes inherited from the parent class, User. To initialize them, we need to invoke the parent class constructor by super() method. The instance variables and methods are declared in the RegularUser class making it a specialized form of the User class.
🥦🥦🥦..
### 🫧Abstract class and polymorphism
~~~
public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract void displayOptions();
}
~~~
The above code shows the abstract class in our system. As you see, there is one abstract method in this class, so this class will automatically become abstract and must be extended by the child class. Yet, the abstract method must be overridden by the subclass so that the subclass will not transform to an abstract class too.
~~~
 public void displayOptions() {
        System.out.println("1. Add Meal");
        System.out.println("2. View Meals");
        System.out.println("3. Edit Meal");
    }
~~~
the overridden method in the RegularUser class where it is the child class of the User class. To override the method, we should have exactly the same function name, parameter lists and return datatype. If a User datatype variable reference to a RegularUser, the polymorphism is implemented as the implementation of displayOptions() will be used either in User class or RegularUser class will be determined during run time.

🥦🥦🥦..
### 📥Exception handling
~~~
private static void adminLogin(DatabaseManager dbManager, Scanner scanner) {
        clearConsole();
            System.out.println("+----------------------+----------+");
            System.out.println("|      A D M I N   L O G I N      |");
            System.out.println("+----------------------+----------+\n");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Admin admin : dbManager.getAdmins()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("\n------Admin login successful!------\n");
                pauseForUserInput();
                adminOptions(admin, dbManager, scanner);
                return;
            }
        }
        System.out.println("\nCAUTION : !!! Invalid admin credentials !!!\n");
        pauseForUserInput();
    }
~~~
One of the exception handling we had in our developed system. The exception we try to handle is the user entering an invalid input of username and password. If the user entered the username and password which is not matched with the database, an error message “Invalid admin credentials” will be displayed to the user to indicates their invalid inputs.

🥦🥦🥦..
## 🥗 𝐅𝐥𝐨𝐰𝐂𝐡𝐚𝐫𝐭 🥗
abcd
🥦🥦🥦..
## 🥗 𝐂𝐥𝐚𝐬𝐬 𝐃𝐢𝐚𝐠𝐫𝐚𝐦 🥗
abcd



