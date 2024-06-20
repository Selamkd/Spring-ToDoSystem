
CREATE DATABASE `taskmanager` DEFAULT CHARACTER SET utf8mb4;

       USE `taskmanager`;


DROP TABLE IF EXISTS Users;

-- Create Users Table
CREATE TABLE Users (
                       UserID INT PRIMARY KEY,
                       UserName VARCHAR(100),
                       UserPassword VARCHAR(100)
);

DROP TABLE IF EXISTS Tasks;
-- Create Tasks Table
CREATE TABLE Tasks (
                       TaskID INT PRIMARY KEY,
                       Title VARCHAR(255),
                       CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       Status ENUM('Pending', 'In progress', 'Completed') NOT NULL DEFAULT 'Pending'
);

-- Create UserTasks Join Table
DROP TABLE IF EXISTS UserTasks;
CREATE TABLE UserTasks (
                           UserID INT,
                           TaskID INT,
                           PRIMARY KEY (UserID, TaskID),
                           FOREIGN KEY (UserID) REFERENCES Users(UserID),
                           FOREIGN KEY (TaskID) REFERENCES Tasks(TaskID)
);
