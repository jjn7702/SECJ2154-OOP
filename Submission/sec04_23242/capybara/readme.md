# 🏕️ Camping Trip Planner!

> The most efficient way to prepare your memorable days on a camping trip together with your family, friends, or even your partners!

![alt text](/images/campingGif.gif "Logo Title Text 1")

## Table of Contents  
[What it does?](#-what-it-does)  
[Work Distribution](#-work-distribution)                      
[Technical Implementation](#%EF%B8%8F-technical-implementation)

## 🚀 What it does?
1. Collect all <span style="color: yellow;">important information</span> regarding your upcoming camping trip.
2. Automatically <span style="color: yellow;">calculate</span> all your budgets.
3. Make sure to <span style="color: yellow;">archive</span> all your previous trips.

## 👨🏻‍💻 Work Distribution

| Group Members | Classes       | Implementation  |
| :-------------: |:-------------:| :-----:|
| Megat      | Init & CampingTrips | UI & Exception Handling |
| Arif      |   Transportation & Budget   |   Aggregation & Inheritance |
| Danial | DateAndTime & Activities      |   Aggregation & Inheritance & Exception Handling|
| Kugan | Item & Food      |  Aggregation & Inheritance |
| Ainn | Location & Campground      |    Polymorphism (Abstract) & Composition|



## 🛠️ Technical Implementation

### 🗃️ Encapsulation and Data Hiding
~~~
public class Budget {
    private double sumBudget;
    private double sumUsed;

    public Budget() {
        this.sumBudget = 0;
        this.sumUsed = 0;
    }

    public void setBudget(double sumBudget) {
        this.sumBudget = sumBudget;
    }

    public double getBudget() {
        return sumBudget;
    }

       public double getUsed() {
        return sumUsed;
    }
    cont...
}
~~~

Encapsulation and Data hiding concepts exist in nearly all of the classes in your project but to make it simple, we will use the class BUDGET. For some context, Encapsulation in java means to integrate data and code into a single unit and Data Hiding refers to encapsulating data within a class and restricting some attributes and methods using access modifiers.

For our case, in class Budget we can see the keyword “Private” where it hides the attribute sumBudget and sumUsed from the method in the class, this is due to the fact that we want to protect the attribute so that we will not abuse it by directly calling it with a “Public” type. This method is called encapsulation as we are encapsulating the attributes into one container and not letting outsiders disturb it.

For Data Hiding, we can refer to the “public double getBudget” and “public double getUsed” as  setters or mutators that makes us able to access the private attribute by returning the value that is associated with the type of return statement. This concept is important for a large code just like this project as we want to protect the attributes from unauthorised data change and it also makes the code more rigid and secure .

### 🔗 Association: Composition and Aggregation

~~~
class CampingTrips {
    private String name;
    private DateAndTime dateTime;
    private Vector<Budget> budget = new Vector<Budget>();
    private Vector<Item> item = new Vector<Item>();
    private Location campground = new Campground();

    public CampingTrips(String name, DateAndTime dateTime, Vector<Budget> tripBudgets,
            Vector<Item> item, String campName, String campDescription, int campSites) {
        this.name = name;
        this.dateTime = dateTime;
        this.budget = tripBudgets;
        this.item = item;
        this.campground = new Campground(campName, campDescription, campSites);
    };

    cont...
~~~

- **Composition**: Composition on the other hand does not exist in the parameter of the Constructor but it will create an object inside the method just like “this.campground = new Campground(campName, campDescription, campSites)”. This is because composition will create an object for every iteration of input that exists. 

- **Aggregation**: Aggregation can be seen in the Constructor name “private CampingTrips” and the attributes inside the bracket are what separates aggregation and composition as aggregation will need us to have the value of the class object in its parameter because we need its value and we can see it with “DateAndTime dateTime” with the method “this.dateTime = dateTime”.

### 🧬 Inheritance and Polymorphism

- **Inheritance**
~~~
class Item {
    private String name;
    private int quantity;
    private double price;
    private String description;// description about the Item

    public Item() {
    }

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

   cont...
}
~~~

~~~
public class Food extends Item {
    private String expirationDate; // expirationDate for Packet Food // Fruit, Lunch meal, Breakfast, Dinner, //
                                   // Packet food
    private boolean isVegetarian;

    public Food(String n, int q, double p, String e, Boolean t) {
        super(n, q, p);
        expirationDate = e;
        isVegetarian = t;
    }

    cont...
}

~~~
We can see this mechanism in our code by referring to class “Item” and “Food” where Item is the Parent class and Food is the Child class. The child class, if you can see, has a keyword “extends” to show that it is inheriting all the attributes and methods in its parent class Item. This keyword is used to show to the compiler that the class is a specialised class and its attributes and methods are bigger than what is stated in the class code.

Inheritance mechanism uses the keyword “super” to invoke the method in its parent class such as “super(n, q, p)” that will call the method in the parent class and add it to the child class. The keyword “super” is rather sensitive as it needs to be as the first statement of the method and it must not be together with “this” as they will break the code.

- **Polymorphism**

~~~
abstract class Location {
    private String name;
    private String description;

    cont...

    public abstract String displayLocationInfo();
}
~~~

~~~
class Campground extends Location {
    private int sitesAvailable;

    // Constructor
    public Campground(String name, String description, int sitesAvailable) {
        super(name, description);
        this.sitesAvailable = sitesAvailable;
    }
    
    cont...

    @Override
    public String displayLocationInfo() {
        String str = String.format("Campground Name: %s\nDescription: %s\nSites Available: %d", getName(),
                getDescription(), sitesAvailable);

        return str;
    }
}
~~~

As an example we can see the class “abstract class Location” where the keyword “abstract” is used to invoke polymorphism in one of its methods. This can be seen with the method “public abstract String displayLocationInfo():” where it will end with a semicolon and not a curly-bracket. We can also see that class Location does not provide any description to the method as we will put it in the other classes.

To prove this, we can see in class Campground where we can refer to the method “public String displayLocationInfo()”. This method is undoubtedly from class Location as we are calling the functions of “getName()” and “getDescription()” in its statement. By doing this method, we are making a method signature without implementations.

### 🔍 Exception Handling

~~~
   public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    // Method untuk check time format
    public static boolean isValidTime(String time) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false);
        try {
            timeFormat.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
~~~

~~~
       if (DateAndTime.isValidDate(date) && DateAndTime.isValidTime(time)) {
            cont...
        } else {
            JOptionPane.showMessageDialog(null, "Invalid date or time format. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
~~~

As we can see in our class DateAndTime in the method of “public static boolean isValidDate” and “public static boolean isValidTime” both have the keyword “try” and “catch” in its statements. These statements are the statements that will handle such errors if they do encounter it. 

For an example is method “public static boolean isValidDate” will return a value of “FALSE” if it encounters a value that does not follow the date format of “yyyy-MM-dd” this will give an error notification to the user that they made a mistake in the Date and Time section in our code.
