# 💼 Employee Bonus System

A simple **Java Swing GUI application** developed to calculate employee bonuses based on their **salary, performance rating, and years of service**.

The application provides a user-friendly interface where employee details can be entered, and a complete bonus report is generated automatically.

---

## 📌 Project Overview

The **Employee Bonus System** is a desktop-based Java application built using **Java Swing**.

The system accepts employee information such as:

* Employee ID
* Employee Name
* Salary
* Years of Service
* Performance Rating

Based on the employee's performance rating and years of service, the application determines whether the employee is eligible for a bonus and calculates the final salary.

---

## 🎯 Objectives

The main objectives of this project are:

* To create a simple GUI-based Java application.
* To collect employee information through form fields.
* To calculate bonus percentage based on performance rating.
* To check employee bonus eligibility.
* To calculate the bonus amount.
* To calculate the final salary after adding the bonus.
* To generate a formatted bonus report.
* To provide a reset option for entering new employee details.
* To demonstrate Java concepts such as **methods, switch statements, if-else conditions, exception handling, and Swing components**.

---

## 🛠️ Technologies Used

| Technology  | Purpose                                   |
| ----------- | ----------------------------------------- |
| Java        | Main programming language                 |
| Java Swing  | GUI development                           |
| AWT         | Layouts, fonts, colors and GUI components |
| JFrame      | Main application window                   |
| JTextField  | Employee data input                       |
| JComboBox   | Performance rating selection              |
| JTextArea   | Bonus report display                      |
| JButton     | User actions                              |
| JOptionPane | Error and validation messages             |

---

## ✨ Features

### 👤 Employee Details

The application allows the user to enter:

* Employee ID
* Employee Name
* Salary
* Years of Service

### ⭐ Performance Rating

The user can select a performance rating from:

```text
1
2
3
4
5
```

The default rating is **5**.

### 💰 Automatic Bonus Calculation

The bonus percentage is automatically selected according to the performance rating.

| Rating | Bonus Percentage |
| -----: | ---------------: |
|      5 |              20% |
|      4 |              15% |
|      3 |              10% |
|      2 |               5% |
|      1 |               0% |

### ✅ Eligibility Checking

An employee is eligible for a bonus when:

```text
Years of Service >= 2
AND
Performance Rating >= 3
```

Otherwise, the employee is considered **Not Eligible**.

### 📊 Bonus Report

After clicking **Calculate Bonus Report**, the application displays:

* Employee ID
* Employee Name
* Salary
* Years of Service
* Performance Rating
* Bonus Percentage
* Bonus Amount
* Final Salary
* Eligibility Status

### 🔄 Reset Function

The **Reset Fields** button clears all entered employee information and the generated report.

### ⚠️ Input Validation

The application handles invalid numerical input using `try-catch` and displays an error message if the user enters invalid values.

---

## 🧮 Bonus Calculation

The bonus amount is calculated using:

```text
Bonus = Salary × Bonus Percentage / 100
```

The final salary is calculated using:

```text
Final Salary = Salary + Bonus
```

### Example

Suppose:

```text
Salary = Rs. 50,000
Rating = 5
Years of Service = 3
```

Rating 5 provides a **20% bonus**.

Therefore:

```text
Bonus = 50,000 × 20 / 100
      = Rs. 10,000
```

Final salary:

```text
Final Salary = 50,000 + 10,000
             = Rs. 60,000
```

The employee is **Eligible** because:

```text
Years of Service >= 2
Rating >= 3
```

---

## 🖥️ User Interface

The application contains three main sections:

### 1. Header

Displays:

```text
EMPLOYEE BONUS SYSTEM
```

### 2. Employee Details Form

The form contains fields for employee information and performance rating.

It also contains two buttons:

```text
Calculate Bonus Report
Reset Fields
```

### 3. Bonus Report Output

The generated report is displayed in a non-editable text area.

Example:

```text
========== BONUS REPORT ==========
Employee ID        : 101
Employee Name      : Rahul
Salary             : Rs. 50000.00
Years of Service   : 3
Performance Rating : 5
Bonus Percentage   : 20.0%
Bonus Amount       : Rs. 10000.00
Final Salary       : Rs. 60000.00
Eligibility        : Eligible
==================================
```

---

## 📂 Project Structure

```text
Employee-Bonus-System/
│
├── MajorProject.java
└── README.md
```

---

## 🔑 Important Methods

### `getBonusPercentage()`

This method determines the bonus percentage according to the employee's performance rating.

```java
static double getBonusPercentage(int rating)
```

It uses a **switch statement**.

---

### `calculateBonus()`

This method calculates the actual bonus amount.

```java
static double calculateBonus(double salary, double percentage)
```

Formula:

```text
Salary × Percentage / 100
```

---

### `checkEligibility()`

This method checks whether an employee is eligible for the bonus.

```java
static boolean checkEligibility(int years, int rating)
```

The employee must satisfy:

```text
Years >= 2
Rating >= 3
```

---

### `calculateReport()`

This method:

1. Reads employee information.
2. Converts input values into numbers.
3. Checks the employee name.
4. Gets the bonus percentage.
5. Checks eligibility.
6. Calculates the bonus.
7. Calculates the final salary.
8. Displays the complete report.

---

### `resetFields()`

This method clears all input fields and the report area.

---

## 🧠 Java Concepts Demonstrated

This project demonstrates several important Java programming concepts.

### Classes and Objects

The application uses a class:

```java
public class MajorProject extends JFrame
```

### Inheritance

`MajorProject` inherits from `JFrame`.

```java
extends JFrame
```

### Methods

Separate methods are created for:

* Bonus calculation
* Eligibility checking
* Report generation
* Resetting fields

### Switch Statement

The `switch` statement determines the bonus percentage.

```java
switch (rating) {
    case 5: return 20;
    case 4: return 15;
    case 3: return 10;
    case 2: return 5;
    case 1: return 0;
}
```

### If-Else

The program uses conditions to determine eligibility and validate the employee name.

### Exception Handling

The application uses:

```java
try {
    ...
} catch (NumberFormatException e) {
    ...
}
```

This prevents the program from crashing when invalid numerical input is entered.

### GUI Programming

Java Swing components are used to create the graphical user interface.

### Event Handling

Button actions are handled using:

```java
addActionListener()
```

---

## ▶️ How to Run the Project

### Step 1: Install Java

Make sure Java JDK is installed on your computer.

Check the installation using:

```bash
java -version
```

---

### Step 2: Download or Clone the Repository

Clone the repository:

```bash
git clone <YOUR-GITHUB-REPOSITORY-URL>
```

Move into the project folder:

```bash
cd Employee-Bonus-System
```

---

### Step 3: Compile the Program

Run:

```bash
javac MajorProject.java
```

---

### Step 4: Run the Program

Run:

```bash
java MajorProject
```

The Employee Bonus System GUI will open.

---

## 🧪 Sample Test Cases

| Salary | Years | Rating | Eli
