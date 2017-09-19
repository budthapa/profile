-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: profile
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `description` varchar(20000) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_date` tinyblob,
  `view_count` int(11) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqyvjif1i2geaeuvkh3n1jrnn4` (`category_id`),
  KEY `FKpxk2jtysqn41oop7lvxcp6dqq` (`user_id`),
  CONSTRAINT `FKpxk2jtysqn41oop7lvxcp6dqq` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKqyvjif1i2geaeuvkh3n1jrnn4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','<h2 style=\"text-align: justify;\" data-blogger-escaped-style=\"text-align: justify;\"><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\">Change page orientation in OpenOffice Writer</span></h2>\r\n<p class=\"separator\" style=\"clear: both; text-align: justify;\" data-blogger-escaped-style=\"clear: both; text-align: justify;\"><a style=\"clear: left; float: left; margin-bottom: 1em; margin-right: 1em;\" href=\"http://www.openoffice.org/ui/VisualDesign/gifs/Icons/OOo30_final_mimetype/Galaxy_OOo3_writer-app_256.png\" data-blogger-escaped-style=\"clear: left; float: left; margin-bottom: 1em; margin-right: 1em;\"><br /><img title=\"\" src=\"https://images-blogger-opensocial.googleusercontent.com/gadgets/proxy?url=http%3A%2F%2Fwww.openoffice.org%2Fui%2FVisualDesign%2Fgifs%2FIcons%2FOOo30_final_mimetype%2FGalaxy_OOo3_writer-app_256.png&amp;container=blogger&amp;gadget=a&amp;rewriteMime=image%2F*\" alt=\"Change page orientation in openoffice writer step by step\" width=\"200\" height=\"200\" border=\"0\" data-orig-src=\"http://www.openoffice.org/ui/VisualDesign/gifs/Icons/OOo30_final_mimetype/Galaxy_OOo3_writer-app_256.png\" /></a></p>\r\n<div style=\"text-align: justify;\" data-blogger-escaped-style=\"text-align: justify;\">\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">OpenOffice Writer is the free alternatives of various paid office suite software. I am using it myself for long time and find it perfect for word processing. Afterall, It is opensource and free. But most of the people are stuck when they have to change single page orientation into landscape and again into portrait mode. It was hard to me in the beginning but I figured it out anyhow. I will show you easy way to change orientation in single page in openoffice writer.</span></p>\r\n</div>\r\n<h3 style=\"text-align: justify;\" data-blogger-escaped-style=\"text-align: justify;\"><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">Step by step guide for changing orientation in single page in OpenOffice Writer.</span></h3>\r\n<div>\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">&nbsp;</span></p>\r\n</div>\r\n<div>\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">&nbsp;</span></p>\r\n</div>\r\n<div>\r\n<ol>\r\n<li style=\"text-align: justify;\" data-blogger-escaped-style=\"text-align: justify;\"><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">First open openoffice writer. I know you have done already. Default mode is portrait mode.</span><a style=\"margin-left: 1em; margin-right: 1em;\" href=\"http://3.bp.blogspot.com/-4ceaDaK2NjI/UokK3aEkqRI/AAAAAAAAAcM/hciRoAPPRfU/s1600/change+orientation+in+openoffice+writer.png\" data-blogger-escaped-style=\"margin-left: 1em; margin-right: 1em;\"><img title=\"\" src=\"https://3.bp.blogspot.com/-4ceaDaK2NjI/UokK3aEkqRI/AAAAAAAAAcM/hciRoAPPRfU/s1600/change+orientation+in+openoffice+writer.png\" alt=\"Change page orientation in openoffice writer step by step\" width=\"640\" height=\"340\" border=\"0\" /></a></li>\r\n<li>\r\n<div style=\"text-align: justify;\" data-blogger-escaped-style=\"text-align: justify;\">\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">Now, click Insert Menu in Menu bar. Then, Click Manual Break as shown in figure.</span></p>\r\n</div>\r\n<p class=\"separator\" style=\"clear: both; text-align: justify;\" data-blogger-escaped-style=\"clear: both; text-align: justify;\">&nbsp;</p>\r\n<span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\"><a style=\"margin-left: 1em; margin-right: 1em;\" href=\"http://3.bp.blogspot.com/-mbJcOVE4ruU/UokK06hvHMI/AAAAAAAAAb0/ZpS2gQFrAL8/s1600/change+orientation+in+openoffice+writer+1.png\" data-blogger-escaped-style=\"margin-left: 1em; margin-right: 1em;\"><img title=\"\" src=\"https://3.bp.blogspot.com/-mbJcOVE4ruU/UokK06hvHMI/AAAAAAAAAb0/ZpS2gQFrAL8/s1600/change+orientation+in+openoffice+writer+1.png\" alt=\"Change page orientation in openoffice writer step by step\" width=\"640\" height=\"339\" border=\"0\" /></a><br /></span>\r\n<div style=\"text-align: justify;\" data-blogger-escaped-style=\"text-align: justify;\">\r\n<p>&nbsp;</p>\r\n</div>\r\n</li>\r\n<li>\r\n<div class=\"\" style=\"clear: both; text-align: justify;\" data-blogger-escaped-style=\"clear: both; text-align: justify;\">\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">Insert Break dialog box will appear. Now, In this Dialog box, click Page Break radio button and Select Landscape from the Style selection</span></p>\r\n</div>\r\n<p class=\"separator\" style=\"clear: both; text-align: justify;\" data-blogger-escaped-style=\"clear: both; text-align: justify;\"><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\"><a style=\"margin-left: 1em; margin-right: 1em;\" href=\"http://4.bp.blogspot.com/-mscfqRnleqg/UokK2GhOCdI/AAAAAAAAAb8/L9qeG3ccLCY/s1600/change+orientation+in+openoffice+writer+2.png\" data-blogger-escaped-style=\"margin-left: 1em; margin-right: 1em;\"><img title=\"\" src=\"https://4.bp.blogspot.com/-mscfqRnleqg/UokK2GhOCdI/AAAAAAAAAb8/L9qeG3ccLCY/s1600/change+orientation+in+openoffice+writer+2.png\" alt=\"Change page orientation in openoffice writer step by step\" width=\"640\" height=\"339\" border=\"0\" /></a></span></p>\r\n<hr class=\"more\" /></li>\r\n<li>\r\n<p class=\"separator\" style=\"clear: both;\" data-blogger-escaped-style=\"clear: both;\"><span style=\"text-align: justify; font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large; text-align: justify;\">Your document will change into Landscape mode. Start typing your content. Once finished, if you want to change to the portrait mode again. Repeat step 3. But this time, select Default from the style selection drop down menu. Click OK button and you are done.</span><a style=\"font-family: \'arial\' , \'helvetica\' , sans-serif; font-size: x-large; margin-left: 1em; margin-right: 1em; text-align: center;\" href=\"http://1.bp.blogspot.com/-r6nSWwT0DLY/UokK23932AI/AAAAAAAAAcE/4iPvLC9BDkw/s1600/change+orientation+in+openoffice+writer+3.png\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: x-large; margin-left: 1em; margin-right: 1em; text-align: center;\"><img title=\"\" src=\"https://1.bp.blogspot.com/-r6nSWwT0DLY/UokK23932AI/AAAAAAAAAcE/4iPvLC9BDkw/s1600/change+orientation+in+openoffice+writer+3.png\" alt=\"Change page orientation in openoffice writer step by step\" width=\"640\" height=\"339\" border=\"0\" /></a></p>\r\n</li>\r\n<li>\r\n<p class=\"separator\" style=\"clear: both; text-align: justify;\" data-blogger-escaped-style=\"clear: both; text-align: justify;\"><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">All done now. Hope you found it useful</span></p>\r\n</li>\r\n</ol>\r\n<p>&nbsp;</p>\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">Download open office from https://www.openoffice.org/download/</span></p>\r\n</div>',NULL,'Step by step guide for changing orientation in single page in OpenOffice Writer',NULL,0,2,NULL),(2,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','<h2><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\"> Simple Calculator in Java using Swing</span></h2>\r\n<h3><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\"><a href=\"https://drive.google.com/folderview?id=0B4Q-a2ykktYBVXF4OVdfRmNsLVU&amp;usp=sharing\" data-blogger-escaped-target=\"_blank\">Download Calculator v1.1</a></span></h3>\r\n<p><a title=\"Buddhi Bal Thapa calculator\" href=\"https://drive.google.com/file/d/0B4Q-a2ykktYBMy1lYTVWcW80djQ/edit?usp=sharing\" target=\"_blank\" rel=\"noopener noreferrer\">Calculator</a></p>\r\n<h3><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\"><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\"><strong>Link will be updated soon. For the time being, you can use the above link<br /></strong></span></span></h3>\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\">What\'s New?</span></p>\r\n<div>\r\n<ul>\r\n<li><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\">Can record the clicks made by user</span></li>\r\n<li><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\">Improved interface</span></li>\r\n</ul>\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\"><strong>Features</strong></span></p>\r\n<p>&nbsp;</p>\r\n<ul>\r\n<li><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\">Runs on any platform&nbsp;</span></li>\r\n<li><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\">Portable</span></li>\r\n</ul>\r\n</div>\r\n<p class=\"separator\" style=\"clear: both; text-align: center;\" data-blogger-escaped-style=\"clear: both; text-align: center;\"><a style=\"margin-left: 1em; margin-right: 1em; text-align: center;\" href=\"https://images-blogger-opensocial.googleusercontent.com/gadgets/proxy?url=http%3A%2F%2F1.bp.blogspot.com%2F-5OW0ZIBg4Pw%2FUxDUjAThH4I%2FAAAAAAAAAl8%2F1gVrHZC66go%2Fs1600%2Fcalc.png&amp;container=blogger&amp;gadget=a&amp;rewriteMime=image%2F*\" data-blogger-escaped-style=\"margin-left: 1em; margin-right: 1em; text-align: center;\"><img src=\"https://1.bp.blogspot.com/-5OW0ZIBg4Pw/UxDUjAThH4I/AAAAAAAAAl8/1gVrHZC66go/s1600/calc.png\" width=\"320\" height=\"290\" border=\"0\" /></a></p>\r\n<p><a style=\"clear: left; float: left; margin-bottom: 1em; margin-right: 1em;\" href=\"http://1.bp.blogspot.com/-5OW0ZIBg4Pw/UxDUjAThH4I/AAAAAAAAAl8/1gVrHZC66go/s1600/calc.png\" data-blogger-escaped-style=\"clear: left; float: left; margin-bottom: 1em; margin-right: 1em;\">&nbsp;</a></p>\r\n<p class=\"separator\" style=\"clear: both; text-align: center;\" data-blogger-escaped-style=\"clear: both; text-align: center;\">&nbsp;</p>\r\n<p><a style=\"display: inline; margin-left: 1em; margin-right: 1em; text-align: center;\" href=\"http://3.bp.blogspot.com/-KpagtSpMIjY/UxDU5lE4FCI/AAAAAAAAAmE/bRsSX036_SA/s1600/calc1.png\" data-blogger-escaped-style=\"display: inline !important; margin-left: 1em; margin-right: 1em; text-align: center;\"><img src=\"https://3.bp.blogspot.com/-KpagtSpMIjY/UxDU5lE4FCI/AAAAAAAAAmE/bRsSX036_SA/s1600/calc1.png\" width=\"320\" height=\"290\" border=\"0\" /></a></p>\r\n<p class=\"separator\" style=\"clear: both; text-align: center;\" data-blogger-escaped-style=\"clear: both; text-align: center;\">&nbsp;</p>\r\n<div class=\"\" style=\"clear: both; text-align: center;\" data-blogger-escaped-style=\"clear: both; text-align: center;\">\r\n<p><a style=\"clear: right; display: inline; float: right; margin-bottom: 1em; margin-left: 1em; text-align: left;\" href=\"http://3.bp.blogspot.com/-KpagtSpMIjY/UxDU5lE4FCI/AAAAAAAAAmE/bRsSX036_SA/s1600/calc1.png\" data-blogger-escaped-style=\"clear: right; display: inline !important; float: right; margin-bottom: 1em; margin-left: 1em; text-align: left;\"><br /></a><a style=\"font-family: \'arial\' , \'helvetica\' , sans-serif; font-size: x-large;\" href=\"https://drive.google.com/file/d/0B4Q-a2ykktYBMy1lYTVWcW80djQ/edit?usp=sharing\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: x-large;\" data-blogger-escaped-target=\"_blank\">Download calculator v1.0</a></p>\r\n</div>\r\n<div>\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif;\">This is the screenshot of simple calculator built using Java programming language.</span><img style=\"font-family: \'arial\' , \'helvetica\' , sans-serif; text-align: center;\" title=\"\" src=\"https://4.bp.blogspot.com/-5Toavlp5b2s/Uw5XU114gFI/AAAAAAAAAhU/EIWraZRs8DM/s1600/Screenshot+from+2014-02-27+02:48:42.png\" alt=\"simple calculator in java swing\" width=\"320\" height=\"272\" border=\"0\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; text-align: center;\" /><a style=\"display: inline; margin-left: 1em; margin-right: 1em; text-align: center;\" href=\"http://4.bp.blogspot.com/-MCW6m1HYxcQ/Uw6sp-_96EI/AAAAAAAAAhk/t5rJYr96DMU/s1600/Screenshot+from+2014-02-27+08:49:40.png\" data-blogger-escaped-style=\"display: inline !important; margin-left: 1em; margin-right: 1em; text-align: center;\"><img title=\"\" src=\"https://4.bp.blogspot.com/-MCW6m1HYxcQ/Uw6sp-_96EI/AAAAAAAAAhk/t5rJYr96DMU/s1600/Screenshot+from+2014-02-27+08:49:40.png\" alt=\"simple calculator in java swing\" width=\"320\" height=\"276\" border=\"0\" /></a></p>\r\n<p>&nbsp;</p>\r\n</div>\r\n<p class=\"separator\" style=\"clear: both; text-align: center;\" data-blogger-escaped-style=\"clear: both; text-align: center;\"><a style=\"margin-left: 1em; margin-right: 1em;\" href=\"http://3.bp.blogspot.com/-r7zPwGWmBjU/Uw6sp9PwnTI/AAAAAAAAAhs/RSJvKW6D1VE/s1600/Screenshot+from+2014-02-27+08:50:04.png\" data-blogger-escaped-style=\"margin-left: 1em; margin-right: 1em;\"><img title=\"\" src=\"https://3.bp.blogspot.com/-r7zPwGWmBjU/Uw6sp9PwnTI/AAAAAAAAAhs/RSJvKW6D1VE/s1600/Screenshot+from+2014-02-27+08:50:04.png\" alt=\"simple calculator in java swing\" width=\"320\" height=\"273\" border=\"0\" /></a></p>\r\n<p><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\"><br /></span> <span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">Download it from </span><a style=\"font-family: \'arial\' , \'helvetica\' , sans-serif; font-size: x-large;\" href=\"https://drive.google.com/file/d/0B4Q-a2ykktYBMy1lYTVWcW80djQ/edit?usp=sharing\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: x-large;\" data-blogger-escaped-target=\"_blank\">here</a><span style=\"font-family: \'arial\',\'helvetica\',sans-serif; font-size: x-large;\" data-blogger-escaped-style=\"font-family: Arial, Helvetica, sans-serif; font-size: large;\">. Comment if you need source code.</span></p>',NULL,'Simple Calculator in Java using Swing','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx',0,1,NULL),(3,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','<p>Checking anagram for two String in Java</p>\r\n<p>Two strings are called anagram if they contain the same frequency of the character. for eg. the anagram of DOG is GOD, OGD, ODG</p>\r\n<p>GDO, DGO etc. Similarly, the anagram of HELLO is ELLOH, HEOLL, OELLH, EOHLL, LLOHE, LLHEO etc.</p>\r\n<p>&nbsp;</p>\r\n<p>There are many solutions to check for anagram. One of which is:</p>\r\n<p>&nbsp;</p>\r\n<pre class=\"language-java\"><code>import java.io.*;\r\nimport java.util.*;\r\n\r\npublic class CheckAnagram {\r\n    static boolean isAnagram(String a, String b) {\r\n        String []arr1 = a.toLowerCase().split(\"\");\r\n        String []arr2 = b.toLowerCase().split(\"\");\r\n        \r\n        Arrays.sort(arr1);\r\n        Arrays.sort(arr2);\r\n        \r\n        StringBuffer sb1 = new StringBuffer();\r\n        StringBuffer sb2 = new StringBuffer();\r\n        \r\n        for(int i=0;i&lt;arr1.length;i++){\r\n            sb1.append(arr1[i]);\r\n        }\r\n        for(int j=0;j&lt;arr2.length;j++){\r\n            sb2.append(arr2[j]);\r\n        }\r\n        \r\n        return (sb1.toString().matches(sb2.toString()))?true:false;\r\n        \r\n    }\r\n\r\n  public static void main(String[] args) {\r\n    \r\n        Scanner scan = new Scanner(System.in);\r\n        String a = scan.next();\r\n        String b = scan.next();\r\n        scan.close();\r\n        boolean ret = isAnagram(a, b);\r\n        System.out.println( (ret) ? \"Anagrams\" : \"Not Anagrams\" );\r\n    }\r\n}\r\n</code></pre>\r\n<p>&nbsp;</p>\r\n<p>You can run the program by passing words to compare.</p>\r\n<p>\"<strong>word</strong>\" and \"<strong>drow</strong>\" will show anagram</p>\r\n<p>\"<strong>cat</strong>\" and \"<strong>tac</strong>\" will show anagram</p>\r\n<p>\"<strong>hello</strong>\" and \"<strong>elloha</strong>\" is not anagram</p>\r\n<p>so on.</p>',NULL,'How to check if two String are Anagram in Java','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx',0,1,NULL),(4,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','<p>Live video and audio streaming with ffmpeg and ffserver</p>\r\n<p>This is a guide on how to stream video using ffserver and ffmpeg in ubnutu. The ffmpeg ffserver version used is 3.3-1~16.04.york1. You can download ffserver from <a title=\"ffmpeg\" href=\"https://ffmpeg.org\" target=\"_blank\" rel=\"noopener noreferrer\">ffmpeg.org</a>. I\'m using linux mint 18. So, I\'ve downloaded ffmpeg from the repository. You can follow the link below to install the latest version of ffmpeg.</p>\r\n<p><a title=\"Install ffmpeg in linux mint 18 using command line\" href=\"budthapa.pro\" target=\"_blank\" rel=\"noopener noreferrer\">Install ffmpeg in linux mint 18 using command line</a>.</p>\r\n<p>First, we need to setup our ffserver.conf to stream the audio and video properly. ffserver.conf file is usually located in /etc/ffserver.conf. You can either edit the ffserver.conf or create your own .conf file. I\'ll be creating my own .conf file named livestream.conf</p>\r\n<p>In console, type</p>\r\n<p><code></code></p>\r\n<pre class=\"language-markup\"><code>sudo nano /etc/livestream.conf</code></pre>\r\n<p><code></code></p>\r\n<p>Blank .ffm file will be created. Now, enter the required properties for streaming live video using ffserver</p>\r\n<pre class=\"language-markup\"><code>#Default port\r\nHTTPPort 8090\r\nHTTPBindAddress 0.0.0.0\r\nMaxHTTPConnections 2000\r\nMaxClients 1000\r\nMaxBandwidth 100000\r\nCustomLog -\r\n\r\n#############################################################\r\n\r\n&lt;Feed video.ffm&gt;\r\n  File /tmp/video.ffm                    # this creates a temp video.ffm file where streams are read/write\r\n  FileMaxSize 1G\r\n  ACL allow localhost\r\n  ACL allow 127.0.0.1\r\n  ACL allow 192.168.0.0 192.168.255.255\r\n&lt;/Feed&gt;\r\n\r\n&lt;Stream stream&gt;\r\n# streaming for webm file\r\n# run : ffserver -f /etc/ffserver.conf\r\n# run : ffmpeg -i videoname.mp4 http://localhost:8090/video.ffm\r\n# error : encoder setup failed\r\n  Feed video.ffm\r\n  Format webm\r\n\r\n# Audio settings\r\n  AudioCodec vorbis\r\n  AudioBitRate 64                             # Audio bitrate\r\n\r\n# Video settings\r\n  VideoCodec libvpx\r\n  VideoSize 720x486                           # Video resolution\r\n  VideoFrameRate 30                           # Video FPS\r\n  AVOptionVideo flags +global_header          # Parameters passed to encoder\r\n\r\n  AVOptionVideo cpu-used 0\r\n  AVOptionVideo qmin 10                       # lower the better, min 0\r\n  AVOptionVideo qmax 42                       # higher outputs bad quality, max 63\r\n  AVOptionVideo quality good\r\n  AVOptionAudio flags +global_header\r\n  PreRoll 15\r\n  StartSendOnKey\r\n  VideoBitRate 400                            # Video bitrate\r\n&lt;/Stream&gt;\r\n\r\n \r\n\r\n###########################################################################\r\n\r\n# Audio only\r\n# run ffmpeg -i audio.mp3 http://localhost:8090/audio.ffm\r\n# run http://localhost:8090/audio in vlc or browser\r\n\r\n&lt;Feed audio.ffm&gt;\r\n  File /tmp/audio.ffm\r\n  FileMaxSize 1G\r\n  ACL allow localhost\r\n  ACL allow 127.0.0.1\r\n  ACL allow 192.168.0.0 192.168.255.255\r\n&lt;/Feed&gt;\r\n\r\n&lt;Stream audio&gt;\r\n  Feed audio.ffm\r\n  Format mp2                                     #audio format\r\n  AudioCodec libmp3lame                          #audio codec\r\n  AudioBitRate 64                                #audio bitrate\r\n  AudioChannels 1                                #audio channel, 1 for mono and 2 for stereo\r\n  AudioSampleRate 44100\r\n  NoVideo                                        #discard video\r\n&lt;/Stream&gt;\r\n\r\n####################################################################\r\n#view status of ffserver\r\n&lt;Stream stat.html&gt;\r\n  Format status\r\n  ACL allow localhost\r\n  ACL allow 192.168.0.0 192.168.255.255\r\n&lt;/Stream&gt;\r\n\r\n \r\n\r\n# Redirect index.html to the appropriate site\r\n\r\n&lt;Redirect index.html&gt;\r\n  URL http://www.ffmpeg.org/\r\n&lt;/Redirect&gt;</code></pre>\r\n<p>&nbsp;</p>\r\n<p>We have to be careful while chosing the properties for streaming, you can play around with them and use which is appropriate for you. But, video bitrate, size, frame rate, audio bitrate, codec used must be accurate.</p>\r\n<p>After all the properties are set we\'ve to start ffserver first. If you will start the ffmpeg without starting the ffserver, it will show the error like tcp connection refused like this:</p>\r\n<pre class=\"language-markup\"><code>[tcp @ 0x56347fda1360] Connection to tcp://localhost:8090 failed: Connection refused\r\nhttp://localhost:8090/video.ffm: Connection refused</code></pre>\r\n<p>start the ffserver by typing</p>\r\n<pre class=\"language-markup\"><code>ffserver -f /etc/livestream.conf</code></pre>\r\n<p>FFserver will fetch the file located at /etc and start the ffserver</p>\r\n<p>Output in console:</p>\r\n<pre class=\"language-markup\"><code>Fri May 12 20:53:02 2017 FFserver started.</code></pre>\r\n<p>Now start ffmpeg so that we can pass the input video and stream it to video.ffm we described inside livestream.conf file</p>\r\n<pre class=\"language-markup\"><code>ffmpeg -i Big\\ Buck\\ Bunny.mp4 http://localhost:8090/video.ffm</code></pre>\r\n<p>We can define all other properties in the above command line like video size, framerate, audio and video codec as well. For more, please visit the ffmpeg documentation.</p>\r\n<p>If everything went well ffmpeg will start writing data to video.ffm located in /tmp directory.</p>\r\n<p>Now, we can read the data from our browser or vlc media player.</p>\r\n<p>In the browser, enter the following link</p>\r\n<p><a title=\"ffsever live streaming\" href=\"http://localhost:8090/stream\" target=\"_blank\" rel=\"noopener noreferrer\">http://localhost:8090/stream</a></p>\r\n<p>In vlc, go to media&gt;stream&gt;network and enter the streaming url and press play button.</p>\r\n<p>&nbsp;</p>\r\n<p>We can now stream live video using ffmpeg and ffserver.</p>\r\n<p>&nbsp;</p>',NULL,'Live video streaming with ffmpeg and ffserver','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx',0,3,NULL),(5,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','<h1 id=\"mcetoc_1bhhb7eev0\">Custom error handling in Spring Boot 404 not found and 5xx internal server error</h1>\r\n<p>&nbsp;</p>\r\n<p>We are familiar with the well known whitelabel error in Spring Boot. It appears when the application will not find the resource the user is looking for or any internal application error. This application will demonstrate on how to handle these errors. Spring Boot 1.5.3 has made it easy to handle such error by providing the easy implementation on the user side.</p>\r\n<p>First, let us create a simple Spring Boot application. You can use any IDE or go to <a title=\"Create new Spring Boot project\" href=\"start.spring.io\" target=\"_blank\" rel=\"noopener\">start.spring.io</a> and create your project. After creating your project, run it as Java application (In eclipse, right click the project -&gt; Run as -&gt; Java Application) or Spring Boot application if you have STS installed. You can download the source code from <a title=\"Custom error handling in Spring Boot\" href=\"https://github.com/budthapa/Custom-error-handling-in-Spring-Boot\" target=\"_blank\" rel=\"noopener\">here</a>. Now, try to access <em>localhost:8080</em> and you\'ll see the first whitelabel error because spring boot application is looking for <em>index.html</em> but we haven\'t defined anything in our application. So, you\'ll see the error like this.</p>\r\n<p><a title=\"White label error image\" href=\"https://www.flickr.com/photos/155454895@N07/shares/T33PsP\" target=\"_blank\" rel=\"noopener\"><img src=\"https://farm5.staticflickr.com/4223/34184592444_b325e3038c_b.jpg\" alt=\"White label error\" width=\"623\" height=\"290\" /></a></p>\r\n<p>&nbsp;</p>\r\n<p>Now, let us create <em>index.html</em> inside <code>src/main/resources/templates</code> folder like in the below picture</p>\r\n<p><img src=\"https://farm5.staticflickr.com/4196/34217679703_9a4a3d207a_m.jpg\" alt=\"index page\" width=\"132\" height=\"240\" /></p>\r\n<p>and write something like this.</p>\r\n<pre class=\"language-markup\"><code>&lt;!DOCTYPE html&gt;\r\n&lt;html&gt;\r\n	&lt;head&gt;\r\n 	&lt;meta charset=\"UTF-8\"/&gt;\r\n	&lt;title&gt;Spring Boot Custom error handling&lt;/title&gt;\r\n&lt;/head&gt;\r\n&lt;body&gt;\r\n	&lt;p&gt;Demo application for custom error handling in Spring Boot&lt;/p&gt;\r\n&lt;/body&gt;\r\n&lt;/html&gt;</code></pre>\r\n<p>&nbsp;</p>\r\n<p>Let\'s create a PageController and define the route to index.html, this way we\'ll not see the whitelabel error when we try to access <em>localhost:8080</em></p>\r\n<p>&nbsp;</p>\r\n<pre class=\"language-java\"><code>package pro.budthapa.controller;\r\n\r\nimport org.springframework.stereotype.Controller;\r\nimport org.springframework.web.bind.annotation.GetMapping;\r\n\r\n@Controller\r\npublic class PageController {\r\n    private static final String INDEX= \"index\";\r\n    \r\n    @GetMapping(\"/\")\r\n    public String index(){\r\n	return INDEX;\r\n    }\r\n}\r\n</code></pre>\r\n<p>Now, try to access <em>localhost:8080</em>, you\'ll be greeted with your index.html page</p>\r\n<p><img src=\"https://farm5.staticflickr.com/4223/34864431012_bf6f2f34aa_b.jpg\" alt=\"Demo application for handling custom error in spring boot\" width=\"584\" height=\"230\" /></p>\r\n<h2 id=\"mcetoc_1bhhd3u552\">Handle 404 error in Spring Boot</h2>\r\n<p>But if you want to access other resources like <code>localhost:8080/something</code> then you\'ll get the whitelabel error with status code 404. To handle this, let us create a error folder inside src/main/resources/templates/. Inside this folder create a file named <em>404.html</em></p>\r\n<p><img src=\"https://farm5.staticflickr.com/4245/34217679823_b62cb63954_m.jpg\" alt=\"Error folder\" width=\"192\" height=\"240\" /></p>\r\n<p>Write some messages inside 404.html page that is easy for the user to understand or your own messages</p>\r\n<pre class=\"language-markup\"><code>&lt;!DOCTYPE html&gt;\r\n&lt;html&gt;\r\n&lt;head&gt;\r\n    &lt;meta charset=\"UTF-8\"/&gt;\r\n    &lt;title&gt;404 Not found&lt;/title&gt;\r\n&lt;/head&gt;\r\n&lt;body&gt;\r\n    &lt;p&gt;404 Error. Oops! The resource you are looking is not found.&lt;/p&gt;\r\n&lt;/body&gt;\r\n&lt;/html&gt;</code></pre>\r\n<p>Try to access <em>localhost:8080/asfd</em> or any non existent url and you\'ll be greeted with the custom 404 not found message</p>\r\n<p><img src=\"https://farm5.staticflickr.com/4251/34864431282_58865b08d2_b.jpg\" alt=\"spring boot 404 not found\" width=\"564\" height=\"195\" /></p>\r\n<p>&nbsp;</p>\r\n<h2 id=\"mcetoc_1bhhd2l241\">Let us handle the 500 Internal server error in Spring Boot</h2>\r\n<p>First, let us create method named <strong>about</strong> inside the <strong>PageController</strong> and point it to <strong>about.html</strong> page.</p>\r\n<pre class=\"language-java\"><code>package pro.budthapa.controller;\r\n\r\nimport org.springframework.stereotype.Controller;\r\nimport org.springframework.web.bind.annotation.GetMapping;\r\n\r\n@Controller\r\npublic class PageController {\r\n	private final String INDEX= \"index\";\r\n	private final String ABOUT= \"about\";\r\n	\r\n	@GetMapping(\"/\")\r\n	public String index(){\r\n		return INDEX;\r\n	}\r\n	\r\n	@GetMapping(\"/about\")\r\n	public String about(){\r\n		return ABOUT;\r\n	}\r\n	\r\n}\r\n</code></pre>\r\n<p>Now, run <em>localhost:8080/about</em> in your browser, but wait! there is not any <strong>about.html</strong> page defined in our project. You\'ll now get error with status code 500</p>\r\n<p><img src=\"https://farm5.staticflickr.com/4274/34184592434_389a08ed1f_b.jpg\" alt=\"500 internal server error spring boot\" width=\"1024\" height=\"285\" /></p>\r\n<p>To handle this error, create <strong>5xx.html</strong> file inside the previous <strong>/error</strong> folder. Here, 5xx means 500, 501, 503, etc.</p>\r\n<p>Write meaningful message inside this <strong>5xx.html</strong> page</p>\r\n<pre class=\"language-markup\"><code>&lt;!DOCTYPE html&gt;\r\n&lt;html&gt;\r\n&lt;head&gt;\r\n    &lt;meta charset=\"UTF-8\"/&gt;\r\n    &lt;title&gt;5xx error handling&lt;/title&gt;\r\n&lt;/head&gt;\r\n&lt;body&gt;\r\n    &lt;p&gt;Handling error with status code 5xx. eg: 500, 503 etc.	&lt;/p&gt;\r\n&lt;/body&gt;\r\n&lt;/html&gt;</code></pre>\r\n<p>Now, try to run <em>localhost:8090/about </em>in your browser and you\'ll get the above message you\'ve defined.</p>\r\n<p><img src=\"https://farm5.staticflickr.com/4204/34217679813_5f9e0e509e_b.jpg\" alt=\"handling 500 internal server error in spring boot\" width=\"591\" height=\"324\" /></p>\r\n<p>We\'ve created our own custom error handling in Spring Boot. You can download the source code from <a title=\"Custom error handling in Spring Boot\" href=\"https://github.com/budthapa/Custom-error-handling-in-Spring-Boot\" target=\"_blank\" rel=\"noopener\">here</a>.</p>',NULL,'Custom error handling in Spring Boot 404 not found and 5xx internal server error','¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx',0,1,NULL);
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `career`
--

DROP TABLE IF EXISTS `career`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `career` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` tinyblob,
  `end_date` tinyblob,
  `join_date` tinyblob,
  `location` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_date` tinyblob,
  `website` varchar(255) DEFAULT NULL,
  `resume_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrfa4rx0u68pso7sls4vprhaw2` (`resume_id`),
  CONSTRAINT `FKrfa4rx0u68pso7sls4vprhaw2` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `career`
--

LOCK TABLES `career` WRITE;
/*!40000 ALTER TABLE `career` DISABLE KEYS */;
/*!40000 ALTER TABLE `career` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (3,'FFmpeg'),(2,'Misc'),(1,'Programming');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` tinyblob,
  `email` varchar(255) NOT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `subject` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','fundingteam+budthapa.pro@getabusinessfunded.com','Hi, letting you know that http://GetaBusinessFunded.com can find your business a SBA or private loan for $2,000 - $350K Without high credit or collateral. \r\n \r\nFind Out how much you qualify for here: \r\n \r\nhttp://GetaBusinessFunded.com/i.php?url=budthapa.pro&id=e76 \r\n \r\nMinimum requirements include your company being established for at least a year and with current gross revenue of at least 120K. Eligibility and funding can be completed in as fast as 48hrs. Terms are personalized for each business so I suggest applying to find out exactly how much you can get on various terms. \r\n \r\nThis is a free service from a qualified lender and the approval will be based on the annual revenue of your business. These funds are Non-Restrictive, allowing you to spend the full amount in any way you require including business debt consolidation, hiring, marketing, or Absolutely Any Other expense. \r\n \r\nIf you need fast and easy business funding take a look at these programs now as there is limited availability. \r\n \r\nClick Here: http://GetaBusinessFunded.com/i.php?id=e76 \r\n \r\nHave a great day, \r\nThe Get a Business Funded Team \r\n \r\nunsubscribe/remove - http://getabusinessfunded.com/r.php?url=budthapa.pro&id=e76','GetaBusinessFunded','inquiry');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `end_date` tinyblob,
  `college_name` varchar(255) DEFAULT NULL,
  `start_date` tinyblob,
  `updated_date` tinyblob,
  `resume_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjyor7xegks1vh01tajsof6gb4` (`resume_id`),
  CONSTRAINT `FKjyor7xegks1vh01tajsof6gb4` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` varchar(20000) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `created_date` tinyblob,
  `user_email` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `language_tools` varchar(255) DEFAULT NULL,
  `current_location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (1,'<p><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://acclaim-production-app.s3.amazonaws.com/images/0110fe50-8cd6-4ed5-9385-1701053f4528/large_blob.png\" alt=\"Buddhi Bal Thapa\" width=\"200\" height=\"200\" /></p>\r\n<h1 id=\"mcetoc_1bh4eel6k0\" style=\"text-align: center;\">Buddhi Bal Thapa</h1>\r\n<p style=\"text-align: center;\"><strong>OCAJP 8</strong></p>\r\n<p>&nbsp;</p>\r\n<p>I\'m a Web developer. I use Java as my primary language for development. Learning is a never ending process, that being said I\'m always in the process of learning new tools and technologies. I\'ve used <a title=\"Play framework \" href=\"https://www.playframework.com/\" target=\"_blank\" rel=\"noopener noreferrer\">Play framework</a>, <a title=\"Ninja framework\" href=\"http://ninjaframework.org/\" target=\"_blank\" rel=\"noopener noreferrer\">Ninja framework</a> and currently using <a title=\"Spring Boot\" href=\"http://spring.io/\" target=\"_blank\" rel=\"noopener noreferrer\">Spring Boot</a> and I\'m definitely loving it. I occassionaly write about stuff I\'ve learned and about the technologies that I\'m currently learning. You can check it <a title=\"Buddhi Bal Thapa Blogs\" href=\"../blog/all\" target=\"_blank\" rel=\"noopener noreferrer\">here.</a></p>\r\n<hr />\r\n<p>&nbsp;</p>\r\n<p><strong>Employment</strong></p>\r\n<p>Software Developer at OrioleSoft Technologies, Nepal, July 2015 - present</p>\r\n<ul>\r\n<li>Planned, designed and developed new feature, functionality for software applications per customer or internal specifications</li>\r\n<li>Designed, built and maintained efficient, reusable, and reliable Java code</li>\r\n<li>Identified and debugged defects in designated application code</li>\r\n<li>Developed and documented the internal procedures that are used in conjunction with report writing</li>\r\n</ul>\r\n<p>&nbsp;</p>\r\n<p>Web Developer at Bajra Technologies Nepal, September 2014 &ndash; June 2015</p>\r\n<ul>\r\n<li>Implemented the concept of live video streaming and video on demand</li>\r\n<li>Successfully used ffmpeg, ffserver for video manipulation like video length calculation, thumbnail generation, video conversion and Apple HLS for generating playlist for videos</li>\r\n<li>Developed the functionality for playing videos on various devices like mobile and desktop browsers</li>\r\n</ul>\r\n<p>&nbsp;</p>\r\n<p><strong>Education</strong></p>\r\n<p>B.Sc. Information Technology,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Sikkim Manipal University, India 2011-2014</p>\r\n<p><strong>Certification</strong></p>\r\n<p><a title=\"Oracle Certified Associate, Java SE 8 Programmer\" href=\"https://www.youracclaim.com/org/oracle/badge/oracle-certified-associate-java-se-8-programmer\" target=\"_blank\" rel=\"noopener\">Oracle Certified Associate, Java SE 8 Programmer</a></p>\r\n<p>&nbsp;</p>\r\n<p><strong>Technical Skills</strong></p>\r\n<ul>\r\n<li>Experience in developing applications using Spring Boot, Ninja framework</li>\r\n<li>Working knowledge of MySQL, Hibernate, Bootstrap</li>\r\n<li>Experience in using version control system like GIT, Bitbucket, project management using Redmine, bitrix etc.</li>\r\n<li>Knowledge about web services, REST architecture, UML diagrams</li>\r\n<li>Basic knowledge of android platform</li>\r\n</ul>\r\n<p>&nbsp;</p>\r\n<hr />\r\n<p>Want to chat or something, you can also contact me directly from <a title=\"Contact Me\" href=\"../contact\" target=\"_blank\" rel=\"noopener noreferrer\">here</a>.</p>',0,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','budthapa@gmail.com',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `authentication_code` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `join_date` tinyblob,
  `name` varchar(60) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `update_date` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'',NULL,'cfde0623-13a1-4886-896c-833135f667ed',NULL,'budthapa@gmail.com',NULL,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','your name','$2a$10$mUf8CUUKwz2Oh8YTlDOG1OqjL5JLbBdq88i2xZqqCvHJk7BHOfqYS',NULL,NULL),(3,'',NULL,'591ba6f7-8089-45d9-b62e-a704f1fdb30d',NULL,'kasturitech16@gmail.com',NULL,'¬\í\0sr\0\rjava.time.Ser•]„º\"H²\0\0xpw\0\0\áx','your name','$2a$10$NBPjxh.YZE0Uk1ScrLxpr.HzAiVZDQM9zYe1aFJj1iW2QRkzw.Qn6',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,1),(3,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-31 20:59:27
