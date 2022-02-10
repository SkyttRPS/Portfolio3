DROP TABLE IF EXISTS Students;
CREATE TABLE IF NOT EXISTS Students (
    StudentID integer PRIMARY KEY,
    StudentName TEXT NOT NULL,
    StudentAddress TEXT NOT NULL
);

DROP TABLE IF EXISTS Teachers;
CREATE TABLE IF NOT EXISTS Teachers (
    TeacherID integer PRIMARY KEY,
    TeacherName TEXT NOT NULL,
    TeacherAddress TEXT NOT NULL
);

DROP TABLE IF EXISTS Coursse;
CREATE TABLE IF NOT EXISTS Courses (
    CourseID integer PRIMARY KEY,
    CourseName TEXT NOT NULL,
    CourseYear integer NOT NULL,
    CourseSemester TEXT NOT NULL,
    CourseTeacherID integer,
    FOREIGN KEY(CourseTeacherID) REFERENCES Teachers
);

DROP TABLE IF EXISTS Grades;
CREATE TABLE IF NOT EXISTS Grades(
    Grade FLOAT,
    CourseID TEXT NOT NULL,
    StudentID TEXT NOT NULL,
    FOREIGN KEY (CourseID)
        REFERENCES Courses (CourseName)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (StudentID)
        REFERENCES Students (StudentName) ON DELETE RESTRICT ON UPDATE CASCADE, PRIMARY KEY (CourseID, StudentID)
    );

INSERT INTO Students VALUES (1, 'Aisha Lincoln', '4800, Nykøbing F, Denmark'),
                           (2, 'Anya Nielsen', '4800, Nykøbing F, Denmark'),
                           (3, 'Alfred Jensen', 'Karlskrona, Sweden'),
                           (4, 'Berta Bertelsen', '7190, Billund, Denmark'),
                           (5, 'Albert Antonsen', '4180, Sorø, Denmark'),
                           (6, 'Eske Eriksen', '4863, Eskildstrup, Denmark'),
                           (7, 'Olaf Olesen', '5000, Odense, Denmark'),
                           (8, 'Salma Simonsen', 'Stockholm, Sweden'),
                           (9, 'Theis Thomasen', '4340, Tølløse, Denmark'),
                           (10, 'Janet Jensen', '4040, Jyllinge, Dennmark'),
                           (11, 'Egon Damdrup', '4000, Roskilde, Denmark');

INSERT INTO Teachers VALUES (1, 'Line Reinhardt', '4800, Nykøbing F, Denmark'),
                           (2,'Bo Holst','4000 Roskilde Denmark');

INSERT INTO Courses VALUES (1, 'SD', 2020, 'autumn', 1),
                          (2, 'SD', 2021, 'autumn', 1),
                          (3, 'ES1', 2019, 'autumn', 2);

INSERT INTO Grades VALUES (12, 1, 1),
                         (10, 3, 1),

                         (null, 2, 2),
                         (12, 3, 2),

                         (7, 1, 3),
                         (10, 3, 3),

                         (null, 2, 4),
                         (2, 3, 4),

                         (10, 1, 5),
                         (7, 3, 5),

                         (null, 2, 6),
                         (10, 3, 6),

                         (4, 1, 7),
                         (12, 3, 7),

                         (null, 2, 8),
                         (12, 3, 8),

                         (12, 1, 9),
                         (12, 3, 9),

                         (null, 2, 10),
                         (7, 3, 10),

                         (null, 2, 11),
                         (2, 3, 11);

-- Selecting average grades from each student manually
SELECT AVG(Grade) FROM Grades where StudentID = 1;
SELECT AVG(Grade) FROM Grades where StudentID = 2;
SELECT AVG(Grade) FROM Grades where StudentID = 3;
SELECT AVG(Grade) FROM Grades where StudentID = 4;
SELECT AVG(Grade) FROM Grades where StudentID = 5;
SELECT AVG(Grade) FROM Grades where StudentID = 6;
SELECT AVG(Grade) FROM Grades where StudentID = 7;
SELECT AVG(Grade) FROM Grades where StudentID = 8;
SELECT AVG(Grade) FROM Grades where StudentID = 9;
SELECT AVG(Grade) FROM Grades where StudentID = 10;
SELECT AVG(Grade) FROM Grades where StudentID = 11;

-- Selecting average grades from each course
SELECT AVG(Grade) From Grades Where CourseID = 1;
SELECT AVG(Grade) From Grades Where CourseID = 2;
SELECT AVG(Grade) From Grades Where CourseID = 3;
