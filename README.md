SiquoiaQuiz
===========

SiquoiaQuiz


ALTER TABLE `siquoia`.`question` ADD COLUMN `que_verified` VARCHAR(45) NOT NULL  AFTER `correct_option` ;


ALTER TABLE `siquoia`.`question` CHANGE COLUMN `question_id` `question_id` BIGINT(20) NOT NULL AUTO_INCREMENT  ;



New Files::::::::::::::::::::::::::::


Command Package:::::::::::

QuestionCommand.java
SelectCategoryCommand.java
SelectUnverifiedQuestion.java
VerifyQueCommand.java
ViewSubmitedResultCommand.java

impl Package::::::::::::::

QuestionImpl.java

Mapper Package:::::::::::

QuizMapper.java

jsp::::::::::::::::::::::
AddQuestion.jsp
SuccessPAge.jsp
VerifyQue.jsp
viewSubmittedResult.jsp

Changed Files::::::::::::::::::::::::::

Model Package:::

Category.java
Question.java
Quiz.java

View Package:::
CommandFactory.java


jsp::
Home.jsp
