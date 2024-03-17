-- Students Table
CREATE TABLE Students (
    StudentID SERIAL PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    EmailAddress VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Address VARCHAR(255)
);

-- Teachers Table
CREATE TABLE Teachers (
    TeacherID SERIAL PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    EmailAddress VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Specialization VARCHAR(100)
);

-- Courses Table
CREATE TABLE Courses (
    CourseID SERIAL PRIMARY KEY,
    CourseName VARCHAR(100),
    Description TEXT,
    Level VARCHAR(20)
);

-- Classes Table
CREATE TABLE Classes (
    ClassID SERIAL PRIMARY KEY,
    CourseID INT,
    TeacherID INT,
    StartTime TIME,
    EndTime TIME,
    Days VARCHAR(20),
    ClassFinalDate DATE,
    ClassMidtermDate DATE,
    ClassRoom VARCHAR(100),
    ClassBranch VARCHAR(100),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
    FOREIGN KEY (TeacherID) REFERENCES Teachers(TeacherID)
);

-- Enrollment Table
CREATE TABLE Enrollment (
    EnrollmentID SERIAL PRIMARY KEY,
    StudentID INT,
    ClassID INT,
    EnrollmentDate DATE,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (ClassID) REFERENCES Classes(ClassID)
);

-- Attendance Table
CREATE TABLE Attendance (
    AttendanceID SERIAL PRIMARY KEY,
    StudentID INT,
    ClassID INT,
    Date DATE,
    Status VARCHAR(10),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (ClassID) REFERENCES Classes(ClassID)
);

-- Payments Table
CREATE TABLE Payments (
    PaymentID SERIAL PRIMARY KEY,
    StudentID INT,
    Amount DECIMAL(10, 2),
    PaymentDate DATE,
    PaymentMethod VARCHAR(20),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
);

-- TestResults Table
CREATE TABLE TestResults (
    TestResultID SERIAL PRIMARY KEY,
    StudentID INT,
    CourseID INT,
    TestName VARCHAR(100),
    Score DECIMAL(5, 2),
    Feedback TEXT,
    TestDate DATE,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);
