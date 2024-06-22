# 🍏🥦🥑 Nutrition Tracker System 🍏🥦🥑

Ⓦⓔⓛⓒⓞⓜⓔ ⓣⓞ ⓝⓤⓣⓡⓘⓣⓘⓞⓝ ⓣⓡⓐⓒⓚⓔⓡ ⓢⓨⓢⓣⓔⓜ !!


> This system helps you keep track of your daily food intake, monitor your nutritional goals, and maintain a balanced diet. 🫐

<img align= "center"  width=80% src= "https://i.giphy.com/j6SbdhHBWfz8SttRAJ.webp">



##  🥗 𝐅𝐞𝐚𝐭𝐮𝐫𝐞𝐬 🥗
<img align="right" width=30% src="https://img.freepik.com/premium-vector/eat-healthy-food-cartoon-hand-drawn-doodle-self-care-awareness-drawing-clip-art-icon-illustration_66976-559.jpg">

📊 **Daily Tracking**: Log your daily meals and snacks.

⚖️ **BMI Calculation**: Calculate your Body Mass Index (BMI) to monitor your health and fitness progress.

📝 **Meal Recording**: Users can log their meals, including meal type, date, and food items.

✏️ **Meal Editing**: Easily edit your logged meals to ensure accurate tracking.

📈 **Meal Reports**: View your meals over date with visual reports.

👥 **User Management**: Admins can view food items, manage users, and delete user accounts.

🔒 **Secure Login**: Both admin and regular users can securely log in to access their personalized features.

🍏🥦🥑

## 🥗 𝐒𝐲𝐬𝐭𝐞𝐦 𝐏𝐫𝐞𝐯𝐢𝐞𝐰 🥗
### ------**Main Page**------
~~~
Welcome to Nutrition Tracker System !

+----------------------+----------+
|        M A I N   P A G E        |
+----------------------+----------+

1. Admin Login
2. Regular User Login
3. Register
4. Exit
Choose an option:
~~~
### ------**Admin Login & Menu**------
~~~
+----------------------+----------+
|      A D M I N   L O G I N      |
+----------------------+----------+

Enter username: Chan
Enter password: 0040

------Admin login successful!------
~~~
~~~
       A D M I N   M E N U
+----------------------+----------+

1. View Food Items
2. View User List
3. Delete Regular User
4. Logout
Choose an option:
~~~
### ------**User Login & Menu**------
~~~
+----------------------+----------+
|      U S E R     L O G I N      |
+----------------------+----------+

Enter username: Sini
Enter password: 0810

------User login successful!------
~~~
~~~
         U S E R   M E N U
+----------------------+----------+

1. Enter Meal
2. View Meals
3. Edit Meal
4. Logout
Choose an option:
~~~
### ------**BMI calculation &  Meal Analysis**------
~~~
+-------------------+
| User Info         |
+-------------------+
| Name: Sini        |
| Age : 22          |
| BMI : 19.10       |
+-------------------+

+------------+------------+----------------------+----------+
| Date       | Meal Type  | Food Item            | Calories |
+------------+------------+----------------------+----------+
| 2024-06-11 | Breakfast  | Apple                | 52       |
|            |            | Toast                | 75       |
|            | Lunch      | Sandwich             | 250      |
|            |            | Soup                 | 150      |
|            | Dinner     | Pizza                | 285      |
|            |            | GrilledChicken       | 335      |
|            | Snack      | GranolaBar           | 150      |
+------------+------------+----------------------+----------+
| 2024-06-11 | Total      |                      | 1297     |
| 2024-06-11 | Recommend  |                      | 1613     |
| 2024-06-11 | Status     |                      | Under    |
+------------+------------+----------------------+----------+
| 2024-06-12 | Breakfast  | NasiLemak            | 280      |
|            |            | Yogurt               | 100      |
|            | Lunch      | Sushi                | 200      |
|            |            | Salad                | 150      |
|            | Dinner     | Pasta                | 300      |
|            |            | Steak                | 679      |
|            | Snack      | ChocolateBar         | 210      |
+------------+------------+----------------------+----------+
| 2024-06-12 | Total      |                      | 1919     |
| 2024-06-12 | Recommend  |                      | 1613     |
| 2024-06-12 | Status     |                      | Exceeded |
+------------+------------+----------------------+----------+
~~~

🍏🥦🥑

## 🥗 𝐎𝐎𝐏 𝐂𝐨𝐧𝐜𝐞𝐩𝐭 🥗

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

🥦🥦🥦

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

🥦🥦🥦

## 🥗 𝐅𝐥𝐨𝐰𝐂𝐡𝐚𝐫𝐭 🥗
<img src="image/flow_pg1.jpg"/>
<img src="image/OOP%20Project-Page-3_page-0001.jpg"/>
<img src="image/OOP%20Project-Page-4_page-0001.jpg"/>

🍏🥦🥑

## 🥗 𝐂𝐥𝐚𝐬𝐬 𝐃𝐢𝐚𝐠𝐫𝐚𝐦 🥗
<img src="image/OOP Class diagram.jpg"/>
 :bookmark_tabs: PDF File: https://drive.google.com/file/d/1p6gn3fgb4KgbxAUSTbbQZom97mcHeHEQ/view?usp=drive_link



