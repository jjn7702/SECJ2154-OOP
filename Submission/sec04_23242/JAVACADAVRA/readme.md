# Sports Team Manager - Project

## Overview of The Project <a name="overview"></a> :heavy_check_mark:

## Synopsis <a name="synopsis"></a> ✨
The Sports Team Manager allows users to store data about sports management including the athletes, coach, manager, training session, sports, and events in a more organized way. For instance, we can view, add and remove the athlete’s details, teams, team’s member and the events of the sport and also their training. First of all, the system will prompt the user to insert the number that is provided in the system (1-3) which will manage the athlete, manage the team, and exit the system. The system will prompt the user to either want to use the existing athlete/team data or want to add a new athlete/team. Next the user will be given 8 options to manage the athlete and team which are to recruit an athlete into the team, remove an athlete from the team, add a training session, remove a training session, add a sports event, cancel a sports event, display team details and exit the athlete/team management menu. All of the options have two options inside them which are either want to use the existing data or add new data except for canceling a sports event, remove an athlete from the team, remove a training session and exit option. 


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
![1](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/JAVACADAVRA/Untitled%20Diagram-Page-2.jpg)
- The figure above illustrates the overview flow of the flowchart which incorporates multiple layers of data handling, loop, conditional statements and others.

![2](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/JAVACADAVRA/Screenshot%202024-06-22%20at%2022.43.26.png)
- Figure above illustrates the flow of athlete management option flow, after each option is executed the program will return to the athlete menu display via loop. The options offered for athlete management menu are recruitment and removal of the athlete from a team, joining and canceling a training session, joining and canceling a sport event and displaying athletes details.

![3](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/JAVACADAVRA/838D59E7-0BB1-4E88-9C25-64554A12219E_1_201_a.jpeg)
- Figure above illustrates the flow of team management option flow, after each option is executed the program will return to the team menu display via loop. Similar to athlete management flow, the options offered for team management menu are recruitment and removal of the athlete from a team, joining and canceling a training session, joining and canceling a sport event and displaying team details. The program also offers an option to exit the program.
#### Class Diagram
![1](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/JAVACADAVRA/Untitled%20Diagram-Page-1.drawio.png)
- Lastly, the figure above illustrates the class diagram of the sports team management program. It consists of multiple classes such as Person, Coach, Manager, Athlete, Team, TrainingSession, Sport, Event and SportsTeamManagement. This program employs multiple relationships such as association, aggregation and composition. Each class also employs various private attributes and public methods and constructors.

## User Manual/Guide <a name="usermanual"></a> 📝

### Main Menu (3 Options)
#### 1. Manage Athlete(s)
  
  	-----Main Menu-----
   	Welcome to Our Sports Team Management System
	[1] Manage Athlete(s)
	[2] Manage Team(s)   
	[3] Exit

	Your Choice:  1

#### 2. Manage Team(s)
	Welcome to Our Sports Team Management System
  
  	-----Main Menu-----  
	[1] Manage Athlete(s)
	[2] Manage Team(s)   
	[3] Exit

	Your Choice:  2


#### 3. Exit
	Welcome to Our Sports Team Management System
	
	-----Main Menu-----  
	[1] Manage Athlete(s)
	[2] Manage Team(s)   
	[3] Exit
	Your Choice:  3

### Athlete Management 
### Main Prompt (2 Options)
#### 1. Manage an Existing Athlete
	Do you wish to manage an existing athlete or add a new athlete?:
	[1] Manage an Existing Athlete
	[2] Add a New Athlete
	
	Your Choice: 1
	Choose an Athlete to Manage: 1

#### 2. Add a New Athlete
	Do you wish to manage an existing athlete or add a new athlete?:
	[1] Manage an Existing Athlete
	[2] Add a New Athlete
	
	Your Choice: 2
	
	Output: It will ask user to input for athlete’s details
 
### Athlete Options
#### 1. Recruit Athlete into a Team
	Do you wish to add an existing team or add a new Team?
	[1] Add an Existing Team
	[2] Add a New Team
	
	1.  Add an Existing Team
		- Insert index of team from existing team list to be assigned to the athlete
		
	2. Add a New Team
		- Insert new team’s details in user prompts

#### 2. Remove Athlete from an Assigned Team
	- Remove the selected athlete from assigned team

#### 3. Add a Training Session
	Do you wish to add an existing training session or add a new training session?
	[1] Add an Existing Training Session
	[2] Add a New Training Session
	
	1,  Add an Existing Training Session
		- Insert index of training session from existing training session list to be assigned to the athlete
   
	2. Add a New Training Session
		- Insert new training session’s details in user prompts

#### 4. Remove a Training Session
	- Remove the selected training session from the athlete

#### 5. Add a  Sports Event
	Do you wish to add an existing Event or add a new Event?
	[1] Add an Existing Event
	[2] Add a New Event
	
	1. Add an Existing Event
		- Insert index of event from existing event list to be assigned to the athlete
		
	2. Add a New Event
		- Insert new event’s details in user prompts

#### 6. Cancel a Sports Event
	- Remove the selected event from the athlete

#### 7. Display Athlete Details
	- Display all details of the athlete

#### 8. Return to Main Menu
   
### Team Management
### Main Prompt (2 Options)
#### 1. Manage an Existing Team
	Do you wish to manage an existing team or add a new team?:
	[1] Manage an Existing Team
	[2] Add a New Team
	
	Your Choice: 1
	Choose a Team to Manage: 1

#### 2. Add a New Team
	Do you wish to manage an existing team or add a new team?:
	[1] Manage an Existing Team
	[2] Add a New Team
	
	Your Choice: 2
	
	Output: It will ask user to input for athlete’s details
 
### Team Options
#### 1. Recruit an Athlete into the Team
	Do you wish to add an existing Athelete or add a new Athlete?
	[1] Add an Existing Athlete
	[2] Add a New Athlete

	1.  Add an Existing Athlete
    		- Insert index of athlete from existing team list to be assigned to the team
	
	2. Add a New Athlete
		- Insert new athlete’s details in user prompts

#### 2. Remove Athlete from an the Team
	- Remove the selected athlete from assigned team

#### 3. Add a Training Session
	Do you wish to add an existing training session or add a new training session?
	[1] Add an Existing Training Session
	[2] Add a New Training Session
	
	1.  Add an Existing Training Session
		- Insert index of training session from existing training session list to be assigned to the team
		
	2. Add a New Training Session
		- Insert new training session’s details in user prompts

#### 4. Remove a Training Session
	- Remove the selected training session from the team

#### 5. Add a  Sports Event
	Do you wish to add an existing Event or add a new Event?
	[1] Add an Existing Event
	[2] Add a New Event
	
	1.  Add an Existing Event
		- Insert index of event from existing event list to be assigned to the team
		
	2. Add a New Event
		- Insert new event’s details in user prompts
#### 6. Cancel a Sports Event
	- Remove the selected event from the team

#### 7. Display Team Details
	- Display all details of the team

#### 8. Return to Main Menu


## Similarity Report <a name="report"></a> 🔔
Submission date: 

Submission ID: 

File name:

Word count:

Character count: 

![1]()

## Findings <a name="findings"></a>📊

- [Source Code](https://github.com/jjn7702/SECJ2154-OOP/tree/main/Submission/sec04_23242/JAVACADAVRA/source_code)
- [Project Report]()
- [Similarity Report]()
- [Presentation Slide]()


