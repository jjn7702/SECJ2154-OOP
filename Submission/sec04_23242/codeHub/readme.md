<h1 align="center">
💸 Personal Finance Manager 💸
</h1>

## Appendix :red_circle:

- [Overview of The Project](#description)
- [Analysis and Design](#analysis)
- [OO Concept](#concept)
- [User Manual/Guide](#usermanual)
- [Similarity report](#report)
- [Findings](#findings)

# Project Description <a name="description"></a> :hash:
## Synopsis :book:
Our project, the Finance Manager Project, aimed to assist users in efficiently managing their personal accounts. The system has features for tracking transactions, savings, bank accounts, budgeting, and report generation. Multiple accounts can be created and managed, spending can be tracked, budget limitations can be set, and savings targets can be kept an eye on. The method facilitates the division of transactions into distinct categories, such as groceries and shopping, which enables thorough financial analysis. The system's design makes it easy for users to navigate between its various functionalities, making it user-friendly.

## Objective 📝
* Manage multiple bank accounts simultaneously
* Track and categorize transactions
* Setting and monitoring budget
* Create savings goals
* Analyze financial data based on generated reports
* Protected user accounts data

# Analysis and Design <a name="analysis"></a> :clipboard:
### Work Flow 🔂 
<img src="https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/images/Work%20Flow.png">

### UML Diagram 📚
<img width="7648" alt="Section 1" src="https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/images/class_diagram.png">

# OO Concept <a name="concept"></a> :heavy_exclamation_mark:
### Encapsulation:
- The Account class encapsulates account details like name, id and balance and provides public methods like getBalance(), deposit() and withdraw().
### Inheritance:
- The ShoppingCategory and FoodCategory class is derived from the Category class.
### Association:
- The Account class has zero-to-many relationship with the class Budget.
### Aggregation:
- The Bank class has an aggregation relationship with class Account, as there is an Account object inside the Bank class.
### Composition
- The Account class has a composition relationship with class Transaction, as there is a Transaction method inside the Account class.
### Polymorphism
- The ShoppingCategory, FoodCategory, Deposit and OtherCategory class override the method getCategoryType() from the Category class to behave differently in respective classes.



## Findings <a name="findings"></a>📊

- [Source Code](https://github.com/jjn7702/SECJ2154-OOP/tree/main/Submission/sec04_23242/codeHub/source-code)
- [Project Report]()
- [Similarity Report]()
- [Presentation Slide]()



[![Visitors](https://api.visitorbadge.io/api/visitors?path=https%3A%2F%2Fgithub.com%2FSECJ2154-OOP%2FSubmission%2Fsec04_23242%2FcodeHub&labelColor=%23697689&countColor=%23555555&style=plastic)](https://visitorbadge.io/status?path=https%3A%2F%2Fgithub.com%2FSECJ2154-OOP%2FSubmission%2Fsec04_23242%2FcodeHub)
![](https://hit.yhype.me/github/profile?user_id=81284918&path=https%3A%2F%2Fgithub.com%2FSECJ2154-OOP%2FSubmission%2Fsec04_23242%2FcodeHub)
