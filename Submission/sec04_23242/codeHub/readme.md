![Project Status](https://img.shields.io/badge/status-completed-brightgreen)
[![Visitors](https://api.visitorbadge.io/api/visitors?path=https%3A%2F%2Fgithub.com%2FSECJ2154-OOP%2FSubmission%2Fsec04_23242%2FcodeHub&labelColor=%23697689&countColor=%23555555&style=plastic)](https://visitorbadge.io/status?path=https%3A%2F%2Fgithub.com%2FSECJ2154-OOP%2FSubmission%2Fsec04_23242%2FcodeHub)
![](https://hit.yhype.me/github/profile?user_id=81284918&path=https%3A%2F%2Fgithub.com%2FSECJ2154-OOP%2FSubmission%2Fsec04_23242%2FcodeHub)

<h1 align="center">
💸 Personal Finance Manager 💸
</h1>

<p align="center">
  <img src="https://github.com/jjn7702/SECJ2154-OOP/blob/main/images/CodeHubLogo.png" alt="Code Hub Logo"/>
</p>

# Appendix :red_circle:
- [Overview of The Project](#description)
- [Analysis and Design](#analysis)
- [OO Concept](#concept)
- [User Manual/Guide](#usermanual)
- [Similarity Report](#similarity)
- [Findings](#findings)

# Project Description <a name="description"></a> :hash:
### Synopsis :book:
Our project, the Finance Manager Project, aimed to assist users in efficiently managing their personal accounts. The system has features for tracking transactions, savings, bank accounts, budgeting, and report generation. Multiple accounts can be created and managed, spending can be tracked, budget limitations can be set, and savings targets can be kept an eye on. The method facilitates the division of transactions into distinct categories, such as groceries and shopping, which enables thorough financial analysis. The system's design makes it easy for users to navigate between its various functionalities, making it user-friendly.

### Objective 📝
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
<img width="7648" alt="Section 1" src="https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/images/classUML.png">

# OO Concept <a name="concept"></a> :heavy_exclamation_mark:
#### Encapsulation:
- The Account class encapsulates account details like name, id and balance and provides public methods like getBalance(), deposit() and withdraw().
#### Inheritance:
- The ShoppingCategory and FoodCategory class is derived from the Category class.
#### Association:
- The Account class has zero-to-many relationship with the class Budget.
#### Aggregation:
- The Bank class has an aggregation relationship with class Account, as there is an Account object inside the Bank class.
#### Composition
- The Account class has a composition relationship with class Transaction, as there is a Transaction method inside the Account class.
#### Polymorphism
- The ShoppingCategory, FoodCategory, Deposit and OtherCategory class override the method getCategoryType() from the Category class to behave differently in respective classes.

# User Manual <a name="usermanual"></a> :scroll:
### View Full User Manual Book Here 🔻
Click the link here to view the full version:
[User Manual](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/files/CodeHub%20-%20user%20Manual.pdf)

<img src="https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/images/CodeHub%20-%20user%20Manual-1-1.png">

# Similarity Report <a name="similarity"></a> :white_check_mark:
### View the PDF 🔻
Click the link here to view the full version:
[Similarity Report](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/files/CodeHub%20-%20Similarity%20Report_compressed.pdf)

<img src="https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/images/similarity_AI_report-1.png">

## Findings <a name="findings"></a>📊
- [Source Code](https://github.com/jjn7702/SECJ2154-OOP/tree/main/Submission/sec04_23242/codeHub/source-code)
- [Project Report](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/files/CodeHub_-_Project_Report_.pdf)
- [Presentation Slide](https://github.com/jjn7702/SECJ2154-OOP/blob/main/Submission/sec04_23242/codeHub/files/OOP%20Slide%20Presentation.pdf)
