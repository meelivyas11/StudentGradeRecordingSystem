

CREATE DATABASE IF NOT EXISTS `sgrs` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sgrs`;

-- For Oracle --
/* Create a new User in Oracle SQL Developer */
--CREATE USER User_Name IDENTIFIED BY Selected_Password; (User_Name = SGRS and  Selected_Password = SGRS)
--GRANT CONNECT, RESOURCE TO User_Name;
/* Create a new Connection with name SGRS */

-- --------------------------------------------------------

--
-- Table structure for table `ASSIGNMENT`
--

CREATE TABLE IF NOT EXISTS `ASSIGNMENT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int(11) NOT NULL,
  `TOTAL_MARKS` double NOT NULL,
  `PERCENTAGE` double NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Dumping data for table `ASSIGNMENT`
--

INSERT INTO `ASSIGNMENT` (`ID`, `COURSE_ID`, `TOTAL_MARKS`, `PERCENTAGE`, `NAME`, `DESCRIPTION`) VALUES
(1, 2, 100, 20, 'Assignment-1', 'Write Abt you'),
(6, 2, 100, 25, 'Assignment-2', 'Assignment-2 Desc'),
(7, 2, 100, 25, 'Assignment-3', 'Assignment-3 Desc'),
(8, 2, 100, 25, 'Assignment-4', 'Assignment-4 Desc'),
(9, 5, 100, 20, 'Assignment #1', 'Paper #1'),
(10, 5, 100, 25, 'Assignment#2', 'This is test Assignment 2'),
(11, 4, 100, 25, 'Assignment#1', 'Assignment#1 Desc'),
(12, 4, 100, 25, 'Assignment#2', 'Assignment#2 Desc'),
(13, 4, 100, 25, 'Assignment#3', 'Assignment#3 Desc'),
(14, 2, 90, 5, 'Assignment #4', 'Paper #4'),
(15, 6, 100, 10, 'Assignment #1', 'Paper #1'),
(16, 6, 100, 40, 'Mid Term Test', 'Mid Term '),
(17, 6, 100, 50, 'Final Test', 'Final'),
(18, 8, 0, 10, 'Quiz #1', 'First Quiz'),
(19, 8, 100, 10, 'Quiz #2', 'Quiz'),
(20, 8, 100, 10, 'Quiz #3', 'Quiz'),
(21, 8, 100, 10, 'Quiz #4', 'Quiz'),
(22, 8, 100, 10, 'Mid Term Test', 'Test'),
(23, 8, 100, 10, 'Quiz #5', 'Quiz'),
(24, 8, 100, 10, 'Quiz #6', 'Quiz'),
(25, 8, 100, 10, 'Quiz #7', 'Quiz'),
(26, 8, 100, 10, 'Quiz #8', 'Quiz'),
(27, 8, 100, 10, 'Final Test', 'Test'),
(28, 7, 100, 20, 'Assign#1', 'temp '),
(29, 9, 100, 20, 'Homework#1', 'describing the hardware and software architecture required for a social networking site');

-- --------------------------------------------------------

--
-- Table structure for table `COURSE`
--

CREATE TABLE IF NOT EXISTS `COURSE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `CODE` varchar(10) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `STAFF_ID` int(11) NOT NULL,
  `TERM` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `COURSE`
--

INSERT INTO `COURSE` (`ID`, `NAME`, `CODE`, `DESCRIPTION`, `STAFF_ID`, `TERM`) VALUES
(2, 'Leadership & Team Building', 'MGT', 'aa', 5, 'S16'),
(4, 'Information System Development', '506', 'IT', 5, 'Spring 2016'),
(5, 'Test Course', 'TST-101', 'This is a Test Course', 5, 'Spring 2016'),
(6, 'Test Course 2', 'TST-202', 'This is Test Course 2', 5, 'Spring 2016'),
(7, 'A', 'A', 'A', 5, 'A'),
(8, 'Test Course 3', 'TST-303', 'This is Test Course 3', 5, 'Spring 2016'),
(9, 'Information System Development', 'CSC610', 'this Course Deals with ISD', 8, 'Spring 2016');

-- --------------------------------------------------------

--
-- Table structure for table `GRADE`
--

CREATE TABLE IF NOT EXISTS `GRADE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) NOT NULL,
  `ASSIGNMENT_ID` int(11) NOT NULL,
  `MARKS_OBTAINED` double NOT NULL,
  `COURSE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=42 ;

--
-- Dumping data for table `GRADE`
--

INSERT INTO `GRADE` (`ID`, `STUDENT_ID`, `ASSIGNMENT_ID`, `MARKS_OBTAINED`, `COURSE_ID`) VALUES
(9, 1, 6, 95, 2),
(10, 2, 6, 98, 2),
(11, 1, 1, 95, 2),
(12, 2, 1, 90, 2),
(13, 1, 7, 100, 2),
(14, 2, 7, 100, 2),
(15, 1, 10, 85, 5),
(16, 1, 11, 50, 4),
(17, 2, 11, 50, 4),
(18, 4, 11, 50, 4),
(19, 1, 12, 100, 4),
(20, 2, 12, 100, 4),
(21, 4, 12, 100, 4),
(22, 1, 13, 90, 4),
(23, 2, 13, 90, 4),
(24, 4, 13, 90, 4),
(25, 1, 8, 70, 2),
(26, 2, 8, 50, 2),
(27, 1, 14, 70, 2),
(28, 2, 14, 70, 2),
(29, 1, 9, 100, 5),
(30, 2, 9, 100, 5),
(31, 1, 15, 90, 6),
(32, 2, 15, 100, 6),
(33, 4, 15, 100, 6),
(34, 1, 16, 90, 6),
(35, 2, 16, 98, 6),
(36, 4, 16, 100, 6),
(37, 1, 17, 90, 6),
(38, 2, 17, 95, 6),
(39, 4, 17, 100, 6),
(40, 1, 18, 0, 8),
(41, 1, 19, 100, 8);

-- --------------------------------------------------------

--
-- Table structure for table `LOGIN`
--

CREATE TABLE IF NOT EXISTS `LOGIN` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `ROLE` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `LOGIN`
--

INSERT INTO `LOGIN` (`ID`, `USERNAME`, `PASSWORD`, `ROLE`) VALUES
(1, 'MarkW', 'Password1', 'Student'),
(2, 'MeeliY', 'Password1', 'Student'),
(3, 'HelloW', 'Password1', 'Student'),
(4, 'YongxingS', 'Password1', 'Student'),
(5, 'HS', 'HS', 'Professor'),
(6, 'PrasanthiY', 'Password1', 'Student'),
(7, 'CurtisS', 'Password1', 'Student'),
(8, 'JelenaV', 'Password1', 'Professor');

-- --------------------------------------------------------

--
-- Table structure for table `STAFF`
--

CREATE TABLE IF NOT EXISTS `STAFF` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(50) NOT NULL,
  `LASTNAME` varchar(50) NOT NULL,
  `DEGREE` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `STAFF`
--

INSERT INTO `STAFF` (`ID`, `FIRSTNAME`, `LASTNAME`, `DEGREE`) VALUES
(5, 'Harshal', 'Shah', 'ASDFGH'),
(8, 'Jelena', 'Vucetic', 'Ph.D.Electrical Engineering, Master''s C.S., and B.S. in Electrica');

-- --------------------------------------------------------

--
-- Table structure for table `STUDENT`
--

CREATE TABLE IF NOT EXISTS `STUDENT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(50) NOT NULL,
  `LASTNAME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `STUDENT`
--

INSERT INTO `STUDENT` (`ID`, `FIRSTNAME`, `LASTNAME`, `EMAIL`, `USERNAME`) VALUES
(1, 'Mark', 'Webb', 'mw@asd.com', 'MarkW'),
(2, 'Meeli', 'Vyas', 'mv@asd.com', 'MeeliV'),
(3, 'Hello', 'World', 'hw@as.com', 'HelloW'),
(4, 'Yongxing', 'Sun', 'ys@sgrs.com', 'YongxingS'),
(6, 'Prasanthi', 'Yerneni', 'py@sgrs.com', 'PrasanthiY'),
(7, 'Curtis', 'Stroud', 'cs@sgrs.com', 'CurtisS');

-- --------------------------------------------------------

--
-- Table structure for table `STUDENT_BOOK`
--

CREATE TABLE IF NOT EXISTS `STUDENT_BOOK` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) NOT NULL,
  `STAFF_ID` int(11) NOT NULL,
  `COURSE_ID` int(11) NOT NULL,
  `TERM` varchar(50) NOT NULL,
  `OVERALL_MARKS` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `STUDENT_BOOK`
--

INSERT INTO `STUDENT_BOOK` (`ID`, `STUDENT_ID`, `STAFF_ID`, `COURSE_ID`, `TERM`, `OVERALL_MARKS`) VALUES
(1, 2, 5, 2, 'aa', 83.88888888888889),
(2, 1, 5, 2, 'aa', 89.13888888888889),
(3, 1, 5, 5, 'Spring 2016', 41.25),
(4, 1, 5, 4, 'Spring 2016', 60),
(5, 2, 5, 4, 'Spring 2016', 60),
(6, 4, 5, 4, 'Spring 2016', 60),
(7, 1, 5, 6, 'Spring 2016', 90),
(8, 2, 5, 6, 'Spring 2016', 96.7),
(9, 4, 5, 6, 'Spring 2016', 100),
(10, 2, 5, 5, 'Spring 2016', 20),
(11, 1, 5, 8, 'Spring 2016', 0),
(12, 1, 8, 9, 'Spring 2016', 0),
(13, 2, 8, 9, 'Spring 2016', 0),
(14, 4, 8, 9, 'Spring 2016', 0),
(15, 6, 8, 9, 'Spring 2016', 0),
(16, 7, 8, 9, 'Spring 2016', 0);
