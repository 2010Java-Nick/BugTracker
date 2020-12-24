# BugTracker

## Project Description

The BugTracker app is a system for developers to post issues about their code, the ticket describing the bug is automatically assigned to another developer to resolve, any user can post under the ticket. When the ticket is fixed by the assigned developer the status is changed and the assigned developer gains experience points based on the difficulty level of the bug. A leaderboard view keeps track of the most skilled developers

## Technologies Used

* Java - version 8
* Angular - version 11
* Spring - version 4
* Hibernate -version 5

## Features

List of features ready and TODOs for future development
* JWT used with login.
* Users can create and update posts.
* Leaderboard element that gamifies bug resolution

To-do list:
* Implement attractive UI
* Allow deletion of posts and tickets
*

## Getting Started
   
git clone https://github.com/2010Java-Nick/BugTracker.git
git checkout staging
git pull
Open Spring Tool Suite and import as existing gradle proeject the directory you cloned the repo in
In SessionFactoryUtil in BugTrackerUtil replace the connection.url, connection.username, and password with your own specific credentials
Run the server driver as Java application in BugTracker package to create the tables
In your database run the included SQL script in the repo 
Restart the server driver
Navigate to http://localhost:9090/auth
Supply an employee with valid credentials




## Contributors

> Vincent Guerrero, Acacia Holliday, Hannah Novack, Ksenia Milstein

## License

No Licenses used for this project

