# Return-Campus-Resident-Management-System

This project is a simple simulation of WKU’s return-campus management system. As a respond to the campus epidemic prevention and control requirements, this system enables administrators to easily process return-campus applications, arrange dormitory distribution, and manage information database which can be completed by simple button operations.

The return-campus management system consists of two main functions:
(1)  Record return-campus applications into database. Two separated portals are designed for students and faculties respectively.
(2) Modifying resident and room information, including record of arrival, changing rooms, put high-risk students into quarantine, and reject return-campus applications.

Java Swing & AWT are used to develop a graphical interface to display room and resident information. Data can be managed easily through different function buttons. 
Apache Derby is chosen to be our database tool. Derby database is accessed into our project via an embedded JDBC driver.

Function (1) is to record the information of each resident and update the status of the room (available or not). After filling in the information, the system will query the database to search certain rooms according to the type of room they want to stay (dormitory types such as single bed at Plum Hall, 2-Beds at Orchid Hall). If the room status is available, the administrator will arrange the applicant to the room according to the applicant’s gender. If there is no room, the check-in fails. 

Function (2) is designed for administrator to manage the two databases collaboratively: database 1(residents) and database 2(room). Under function (2), there are 3 sub-functions: mark as arrive, transfer room, and cancel. 
•	Mark as arrive means allow one’s room choice, the system will simply change the room status as “Checked In”. 
•	Transfer will enable administrator to search and retrieve a person’s information by one’s unique ID number. The room transfer operation will first check a certain room’s availability, and the transfer will be successful if the room status matches the “available” keyword. After the room transfer, the original room will be marked as “available”. The new room will be marked as “Checked In” at the same time. 
•	Cancel means reject one’s application if there is no available room of the required type or the student come from high-risk epidemic areas. This operation needs to be confirmed again.  
