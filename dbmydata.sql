-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 24, 2017 at 11:23 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbmydata`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `cmpasgbyemp`(IN `ecod` INT)
    NO SQL
select cmpaccno,cmpdat,cmpdsc,cmpsts,(select count(*) from
tbvst where vstcmpcod=a.cmpcod) nov,(select ifnull(avg(vstfed),0) from tbvst where
vstcmpcod=a.cmpcod) fed from tbcmp a where cmpasgempcod=ecod
order by cmpdat desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cmpforcurmon`()
    NO SQL
select cmpaccno,cmpdat,cmpdsc,cmpsts,empnam,(select count(*) from
tbvst where vstcmpcod=a.cmpcod) nov,(select ifnull(avg(vstfed),0) from tbvst where
vstcmpcod=a.cmpcod) fed from tbcmp a,tbemp where cmpasgempcod=empcod
and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate())
order by cmpdat desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delcmp`(IN `cpcod` INT)
    NO SQL
delete from tbcmp where cmpcod=cpcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delemp`(IN `ecod` INT)
    NO SQL
delete from tbemp where empcod=ecod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deltb`(IN `ano` INT)
    NO SQL
delete from tbacc where accno=ano$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `delvst`(IN `vcod` INT)
    NO SQL
delete from tbvst where vstcod=vcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dispcurrmonthrep`()
    NO SQL
begin
SELECT (select empnam from tbemp where empcod=a.cmpasgempcod) nam,cmpcod,cmpaccno,cmpdat,cmpdsc
FROM tbcmp a
WHERE MONTH(cmpdat) = MONTH(CURRENT_DATE());
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspcmp`()
    NO SQL
select * from tbcmp order by cmpcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspemp`()
    NO SQL
select * from tbemp order by empcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspempbyloc`(IN `loc` VARCHAR(100))
    NO SQL
select * from tbemp where emploc=loc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dsptb`()
    NO SQL
select * from tbacc order by accno$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `dspvst`()
    NO SQL
select * from tbvst order by vstcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `empprfformon`()
    NO SQL
select empnam,emppic,(select count(*) from tbcmp where cmpasgempcod=
a.empcod and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate()))
noc,(select count(*) from tbcmp where cmpasgempcod=
a.empcod and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate()) and cmpsts='C') nc,(select count(*) from tbcmp where cmpasgempcod=
a.empcod and month(cmpdat)=month(curdate()) and year(cmpdat)=year(curdate()) and cmpsts='A') na,(select ifnull(avg(vstfed),0) from tbvst where vstcmpcod in
(select cmpcod from tbcmp where cmpasgempcod=a.empcod and month(cmpdat)
=month(curdate()) and year(cmpdat)=year(curdate()))) fed from tbemp a order by empnam$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findcmp`(IN `cpcod` INT)
    NO SQL
begin
select * from tbcmp where cmpcod=cpcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findemp`(IN `ecod` INT)
    NO SQL
select * from tbemp where empcod=ecod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findtb`(IN `ano` INT)
    NO SQL
select * from tbacc where accno=ano$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findvst`(IN `vcod` INT)
    NO SQL
select * from tbvst where vstcod=vcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inscmp`(IN `cpano` INT, IN `cpdat` DATETIME, IN `cpdsc` VARCHAR(1000), IN `cpempcod` INT, IN `cpsts` CHAR(1))
    NO SQL
insert into tbcmp values(null,cpano,NOW(),cpdsc,cpempcod,cpsts)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insemp`(IN `enam` VARCHAR(100), IN `epic` VARCHAR(100), IN `eloc` VARCHAR(100), IN `ephnno` VARCHAR(100))
    NO SQL
insert into tbemp values(null,enam,epic,eloc,ephnno)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `instb`(IN `anam` VARCHAR(100), IN `adat` DATETIME, IN `aadd` VARCHAR(100), IN `aloc` VARCHAR(100), IN `aphnno` VARCHAR(100), IN `atyp` VARCHAR(100))
    NO SQL
insert into tbacc values(null,anam,adat,aadd,aloc,aphnno,atyp)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insvst`(IN `vdat` DATETIME, IN `vcpcod` INT, IN `vdsc` VARCHAR(100), IN `vfed` VARCHAR(100))
    NO SQL
insert into tbvst values(null,NOW(),vcpcod,vdsc,vfed)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updcmp`(IN `cpsts` CHAR(1), IN `cpcod` INT)
    NO SQL
begin
update tbcmp set cmpsts=cpsts where cmpcod=cpcod;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updemp`(IN `ecod` INT, IN `enam` VARCHAR(100), IN `epic` VARCHAR(100), IN `eloc` VARCHAR(100), IN `ephnno` VARCHAR(100))
    NO SQL
update tbemp set empnam=enam , emppic=epic , emploc=eloc , empphnno=ephnno where empcod=ecod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updtb`(IN `ano` INT, IN `anam` VARCHAR(100), IN `aadd` VARCHAR(100), IN `aloc` VARCHAR(100), IN `aphnno` VARCHAR(100), IN `atyp` VARCHAR(100))
    NO SQL
update tbacc set accnam=anam , accadd=aadd , accloc=aloc , accphnno=aphnno , acctyp=atyp where accno=ano$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updvst`(IN `vcod` INT, IN `vdat` DATETIME, IN `vcpcod` INT, IN `vdsc` VARCHAR(100), IN `vfed` VARCHAR(100))
    NO SQL
update tbvst set vstdat=vdat , vstcmpcod=vcpcod , vstdsc=vdsc , vstfed=vfed where vstcod=vcod$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbacc`
--

CREATE TABLE IF NOT EXISTS `tbacc` (
  `accno` int(11) NOT NULL AUTO_INCREMENT,
  `accnam` varchar(100) CHARACTER SET latin1 NOT NULL,
  `accrtdat` datetime NOT NULL,
  `accadd` varchar(100) CHARACTER SET latin1 NOT NULL COMMENT 'adress',
  `accloc` varchar(100) CHARACTER SET latin1 NOT NULL COMMENT 'location',
  `accphnno` varchar(100) CHARACTER SET latin1 NOT NULL,
  `acctyp` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`accno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `tbacc`
--

INSERT INTO `tbacc` (`accno`, `accnam`, `accrtdat`, `accadd`, `accloc`, `accphnno`, `acctyp`) VALUES
(1, 'videophone', '2017-07-01 17:21:12', 'sector 16,chandigarh', 'Chandigarh', '7889002288', 'phone set'),
(2, 'videotv', '2017-06-13 10:15:29', 'sector 18,ratan street , delhi', 'Delhi', '8897600310', 'D2h'),
(3, 'videotv', '2017-07-04 13:28:19', 'phase 4', 'Chandigarh', '01752285845', 'D2h'),
(4, 'videonet', '0000-00-00 00:00:00', '2345,partap nagar', 'Punjab', '8886903452', 'broadband'),
(5, 'videomachine', '2017-09-06 00:00:00', 'sec 22,near shastri market,chandigarh', 'chandigarh', '7696888270', 'washing machine');

-- --------------------------------------------------------

--
-- Table structure for table `tbcmp`
--

CREATE TABLE IF NOT EXISTS `tbcmp` (
  `cmpcod` int(11) NOT NULL AUTO_INCREMENT,
  `cmpaccno` int(11) NOT NULL,
  `cmpdat` datetime NOT NULL,
  `cmpdsc` varchar(1000) CHARACTER SET latin1 NOT NULL,
  `cmpasgempcod` int(11) NOT NULL,
  `cmpsts` int(1) NOT NULL,
  PRIMARY KEY (`cmpcod`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `tbcmp`
--

INSERT INTO `tbcmp` (`cmpcod`, `cmpaccno`, `cmpdat`, `cmpdsc`, `cmpasgempcod`, `cmpsts`) VALUES
(2, 1, '2017-06-16 06:22:32', 'phone screen crashed', 4, 0),
(3, 4, '2017-07-12 05:20:23', 'internet service is very poor ', 9, 2),
(4, 3, '2017-08-15 18:14:31', 'dish channels', 5, 1),
(5, 4, '2017-08-16 06:13:21', 'internet connection weak', 3, 3),
(9, 1, '2017-10-23 17:27:49', 'phone is not working properly', 7, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbemp`
--

CREATE TABLE IF NOT EXISTS `tbemp` (
  `empcod` int(11) NOT NULL AUTO_INCREMENT,
  `empnam` varchar(100) CHARACTER SET latin1 NOT NULL,
  `emppic` varchar(50) CHARACTER SET latin1 NOT NULL,
  `emploc` varchar(100) CHARACTER SET latin1 NOT NULL,
  `empphnno` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`empcod`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `tbemp`
--

INSERT INTO `tbemp` (`empcod`, `empnam`, `emppic`, `emploc`, `empphnno`) VALUES
(1, 'Akaash Bansal', 'FilledStar.png', 'Chandigarh', '7141556910'),
(2, 'vivek', 'e1.jpg', 'Delhi', '7009984334'),
(3, 'rajeev sharma', 'e2.jpg', 'Punjab', '7696882700'),
(4, 'Nishi Goel', 'Emp1.jpg', 'sector 22c,Chandigarh', '8427698352'),
(5, 'Aayush', 'Emp2.jpg', 'Chandigarh', '9896602808'),
(6, 'Akshay Goel', 'team2.jpg', 'Punjab', '9872801152'),
(7, 'Neeraj Kataria', 'Emp3.jpg', 'Chandigarh', '9729005670'),
(8, 'Tarun Singla', 'Emp5.jpg', 'Delhi', '7696888270'),
(9, 'Ajay khanna', 'Emp6.jpg', 'Delhi', '8708171338'),
(10, 'Rahul Mishra', 'Emp4.jpg', 'Punjab', '8427334998');

-- --------------------------------------------------------

--
-- Table structure for table `tbvst`
--

CREATE TABLE IF NOT EXISTS `tbvst` (
  `vstcod` int(11) NOT NULL AUTO_INCREMENT,
  `vstdat` datetime NOT NULL,
  `vstcmpcod` int(11) NOT NULL,
  `vstdsc` varchar(1000) CHARACTER SET latin1 NOT NULL,
  `vstfed` varchar(11) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`vstcod`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `tbvst`
--

INSERT INTO `tbvst` (`vstcod`, `vstdat`, `vstcmpcod`, `vstdsc`, `vstfed`) VALUES
(2, '2017-06-26 10:22:25', 45, 'settop box damage', 'good'),
(3, '2016-05-10 04:20:13', 5, 'done', '3'),
(13, '2017-10-25 02:47:13', 5, 'i am closing this connection', '3');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
