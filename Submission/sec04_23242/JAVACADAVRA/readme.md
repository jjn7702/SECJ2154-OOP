# Sports Team Manager - Project

## Overview of The Project <a name="overview"></a> :heavy_check_mark:

## Synopsis <a name="synopsis"></a> ✨


## Objective and Scope <a name="objective"></a> 🧠
The aim is to apply for a sports team manager based on what we learned in the Object-Oriented Programming which are encapsulation, association, aggregation, composition, inheritance, polymorphism and exception handling. The program provides a menu- driven interface for performing some operations similar as adding, deleting, and viewing  athletes, training, events, members of the team to the system, for a based on provided options, and displaying the updated data. In this coding we use the arraylist for our program as it should be able to handle increments of data volume efficiently. First of foremost, we definitely implemented encapsulation and hiding concepts in our system of each class as it was the basic concept in Object Oriented. Aggregation and composition also have been implemented in our coding for the management of the team class(aggregation), athlete class(aggregation)  and event class(composition). While inheritance was implemented at coach class, athlete class and manager class that inherit the data from the person class. For the association we use unidirectional and bidirectional concepts so that the object’s class can call the methods in other objects. For the polymorphism, we also implemented in the Person class, Coach class and Manager class that have the same method but different behaviour or action. Furthermore, our system has exception handling to prevent the program crashing, as if we don’t have this process, exceptions will disrupt our process in the system. The system also has a user-friendly interface with a menu- driven system that determines users through the whole process until they choose to exit the system.

## Workflow <a name="workflow"></a> 

 
## OO Concepts <a name="ooconcepts"></a> ✍🏼
#### 1. Classes and Object

Class
  -  Blueprint that describes the structure and behavior shared by all objects of a specific  kind.
  -  For this management system, we already decided to use 9 classes which consist of class Person,Coach,Manager,Athletes,Team,TrainingSession,Event,Sport and also SportsTeamManagement (main method).
  -  Each class consists of their own attribute and method.
	
Object
- Instances of classes created during runtime.
- Each object has its own attributes and can perform methods defined in its class.

#### 2. Constructor
- Special kind of methods for creating instance of the class
- Each class that we created have one constructor
- Constructor are called when keyword ‘new’ is used to create object.

#### 3. Encapsulation and Data Hiding
- For data hiding using encapsulation, we declared each attribute in each class  as  private.
- This will prevent direct access to the attribute hence ensuring the data integrity.
- To access this attribute we need to use an accessor or also known as getter (ex: getName() in ‘Person’ class).

#### 4. Association
- Represent general binary relationships that describe an activity between two classes.
- We implement both unidirectional(one-way) and bidirectional navigability.
- By using association, it allows objects to call methods in other objects. As an example, addTrainingSession(TrainingSession) method can be called in ‘Coach’.
- It enables one class to gain information about another and interact with its objects.

#### 5. Composition
- Composition is a strong form of aggregation.
- The parts (object of another class) belong to one whole class and does not change during the execution. [Strong Ownership].
- As an example, ‘Athlete’ class needs at least one ‘Sport’ object. An ‘Athlete’ cannot exist without being associated with a ‘Sport’.

#### 6. Aggregation
- Aggregation is a special form of association, “has-a” relationship.
- Relationship where one whole class contains parts (objects of another class). [Weak Ownership]
- As an example, ‘Athlete’ class does not necessarily need to have a ‘Manager’ object. It still can execute even if the ‘Athlete’ does not have a ‘Manager’.
- Allows part objects to exist independently of the whole object.

#### 7. Inheritance 
- Inheritance implements the “is-a” relationship that consists of superclass(general class) and subclass(specialized class).
- Process which a new class is created from anothe class.
- Allow subclass to inherits the attributes and methods of the superclass.
- As an example, ‘Person’ is a superclass that allow other classes such as ‘Coach’, ‘Manager’ and ‘Athlete’ to inherit all the attributes and methods.

#### 8. Polymorphism 
- Polymorphism  is when the same method call can lead to different behaviors.
- Allows methods to be overridden.
- Polymorphism also uses dynamic binding that determines the method to be invoked during runtime based on the object type not the reference type.
- ‘getInfo()’ method can lead to different behaviors depending on which it is invoked. As an example, if it is called by object ‘Coach’, it will return name, gender, age, experience and expertise. Meanwhile, if it is called by object ‘Manager’, it will return name, gender, age and office.

#### 9. Exception Handling
- For exception handling, we decided to use a do…while loop.
- The user will be ask to enter choice 1-3 (Manage Athlete(s), Manage Team(s) and Exit) only, if the user enter any other number, the system will keep looping until the correct input is entered.


## Design <a name="design"></a> 🎨
#### Flowchart
![1]([https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/JAVACADAVRA/838D59E7-0BB1-4E88-9C25-64554A12219E_1_201_a.jpeg](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/JAVACADAVRA/Untitled%20Diagram-Page-2.jpg))
- The figure above illustrates the overview flow of the flowchart which incorporates multiple layers of data handling, loop, conditional statements and others.
#### Class Diagram
![1]()



## User Manual/Guide <a name="usermanual"></a> 📝

## Similarity Report <a name="report"></a> 🔔
Submission date: 

Submission ID: 

File name:

Word count:

Character count: 

![1]()

## Findings <a name="findings"></a>📊

- [Source Code]()
- [Project Report]()
- [Similarity Report]()
- [Presentation Slide]()


