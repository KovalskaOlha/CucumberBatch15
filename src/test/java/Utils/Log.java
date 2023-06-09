package Utils;


import org.apache.log4j.*;

public class Log {

   public static Logger log = Logger.getLogger(Log.class.getName());

   //when the test starts I should print the logs
   //when my tests stops I should print the logs
   //if I want to print any message in between I should print the logs

   public static void startTestCase(String testCaseName){
      log.info("***************");
      log.info("***************");
      log.info("************"+ testCaseName+"***********");
   }

   public static void endTestCase(String testCaseName){
      log.info("#########");
      log.info("#########");
      log.info("#########"+testCaseName+"#######");
   }

   public static void info(String message){
      log.info(message);
   }

   public static void warning(String warning){
      log.info(warning);
   }
   //===================Maven LIFECYCLE==================
   /*
   Maven life cycle:
   1.Clean (removes all the files generated by the previous build)
   target folder removes but every time when we run test case the target will appear again
   2.Validate (checks the project is correct and all the necessary information is available)
   mostly used by dev
   3.Compile (compile the source code of the project)
   4.Test (runs the test of the project)
   when we test clean, validate and compile run also, selfsufficient to perform
   5.Package (packages the compiled into a distributable format, such as Jar or War files)
   6.Verify (runs and checks on results of integration tests to ensure quality criteria is met)
   7.Install (installs the packages into local repository)
   .m2 Folder-----> the folder that consist all dependancies
   8.Site (generate the documentation for the project)
   mostly used by dev
   9.Deploy (copies the final package to remote repository for sharing with other developers or projects)


   */



}
