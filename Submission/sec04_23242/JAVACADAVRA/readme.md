# Sports Team Manager - Project

## Overview of The Project <a name="overview"></a> :heavy_check_mark:
## Objective <a name="objective"></a> 🧠
  The main objective for developing the Sports Team management system is

## Synopsis <a name="synopsis"></a> ✨


## Problem Analysis <a name="problemanalysis"></a> 🕵🏻‍♀️🕵🏻‍♂️
 
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
- 

## Design <a name="design"></a> 🎨
#### Flowchart
![1]()
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


