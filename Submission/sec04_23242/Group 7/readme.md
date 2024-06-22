<h1 align="center"># Volunteer Opportunity System</h1>

## Project Overview

The Volunteer Opportunity System is designed to link volunteers with various volunteering opportunities offered by organizers. The system allows organizers to post both short-term and long-term positions, while volunteers can search for, apply to, and receive responses regarding the positions they applied for.

## Team Members

- Omar Mohammed Rezk Ebid Elashry (A22EC0026)
- Hasan Hatem Hasan (A22EC0013)
- Ahmed Amir Moustafa (A22EC0007)
- Hamdan Saleh Omar Almohamadi (A22EC4027)

## Course Information

- **Course**: Object Oriented Programming (SECJ2154)
- **Semester**: 2, 2023/2024
- **Section**: 04
- **Lecturer**: Madam Lizawati Mi Yusuf
- **Date**: 20 June 2024

## Project Description

### Synopsis

The Volunteer Opportunity System aims to connect volunteers with suitable opportunities based on their skills and availability. It enables organizers to post opportunities and manage applications effectively.

### How to Use the System

#### Signup/Login

- **Organizer**: Sign up with personal information (name, email, password, organization name). Log in using these credentials.
- **Volunteer**: Sign up with personal information (name, email, password, skills, availability). Log in using these credentials.

#### Functionalities for Organizers

- **Add Short Term Opportunity**: Create and add short-term opportunities.
- **Add Long Term Opportunity**: Create and add long-term opportunities.
- **Review Applications**: Evaluate volunteer applications and provide feedback.
- **View All Available Long Term Opportunities**: See all available long-term opportunities.
- **View All Available Short Term Opportunities**: See all available short-term opportunities.
- **Logout**: Log out of the account.

#### Functionalities for Volunteers

- **Join Long Term Opportunity**: Apply for available long-term opportunities.
- **Join Short Term Opportunity**: Apply for available short-term opportunities.
- **View Long Term Opportunities**: View the list of available long-term opportunities.
- **View Short Term Opportunities**: Browse through the list of available short-term opportunities.
- **Show Review**: Access feedback provided by organizers.
- **Logout**: Log out of the account.

### Objective and Scope

#### Objective

The primary objective is to match volunteers with suitable opportunities based on their skills and availability and to enable organizers to manage and review volunteer applications effectively.

#### Scope

- **Volunteers**: Sign up, log in, view, and apply for both long-term and short-term opportunities.
- **Organizers**: Create, view, and manage volunteer opportunities, and provide feedback on volunteer applications.
- **System**: Handle user authentication, opportunity creation, application management, and feedback.

## Workflow
![flowchart simpler](https://github.com/jjn7702/SECJ2154-OOP/assets/148300714/063a96b5-257c-44ad-b8f1-fd643b3d0d1b)

## Object-Oriented Concepts

1. **Classes and Objects**: Uses classes like `Application`, `LongTermOpportunity`, `Opportunity`, `Organizer`, `Review`, `ShortTermOpportunity`, `User`, and `Volunteer`.
2. **Inheritance**: 
   - `Volunteer` and `Organizer` inherit from `User`.
   - `LongTermOpportunity` and `ShortTermOpportunity` inherit from `Opportunity`.
3. **Encapsulation**: Private attributes with public methods to access and modify them.
4. **Polymorphism**: Overrides `toString` methods for unified object representation.
5. **Abstraction**: `User` and `Opportunity` are extended by derived classes.
6. **Association**: Relationships between classes [`Opportunity` and `LongTermOpportunity` and `ShortTermOpportunity`], [`User` and `volunteer` and `organizer`], [`volunteer` and `application`]
7. **Aggregation**: `Volunteer` and `Application`.
8. **Composition**: [`Opportunity` and `application`],[`application` and `volunteer`], [`Opportunity` and `organizer`].
9. **Exception Handling**: Manages errors gracefully to ensure smooth application execution.

## Class Diagrams
![WhatsApp Image 2024-06-20 at 11 44 13_f21557cf](https://github.com/jjn7702/SECJ2154-OOP/assets/148300714/a4092013-69bb-489c-b68d-dd0162fd50f3)


### [Source Code and User Manual](https://drive.google.com/drive/folders/1mBoSv1dsRvoJQsM1m0arfva0B41kn3he?usp=sharing)
