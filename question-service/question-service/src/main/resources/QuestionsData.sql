USE questiondb;
insert into questions (id, question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category) values
    (1, 'What is the output of the following Java code snippet?
int x = 5; System.out.println(x++);', '4', '5', '6', 'compiler error','5','easy', 'java');


insert into questions (id, question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category) values
    (2, 'In Java, what is the default value of an uninitialized boolean variable?', 'true', 'false', '0', 'null','false','easy', 'java');


insert into questions (id, question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category) values
    (3, 'Which Java keyword is used to explicitly throw an exception?', 'try', 'throw', 'catch', 'finally','throw','easy', 'java');


insert into questions (id, question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category) values
    (4, 'What does the ''static'' keyword mean in Java?', 'It indicates that a variable is constant.',
     'It indicates that a method can be accessed without creating an instance of the class.',
     'It indicates that a class cannot be extended.', 'It indicates that a variable is of primitive type.',
     'It indicates that a method can be accessed without creating an instance of the class.','easy', 'java');


insert into questions (id, question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category) values
    (5, 'What is the correct way to declare a constant variable in Java?', 'final int x = 5;', 'static int x = 5;', 'readonly int x = 5;',
     'constant int x = 5;','final int x = 5;','easy', 'java');


insert into questions (id, question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category) values
    (6, 'Which loop in Java allows the code to be executed at least once?', 'for loop', 'while loop', 'do-while loop', 'switch loop','do while loop','easy', 'java');

insert into questions (id, question_title, option1, option2, option3, option4, correct_answer, difficulty_level, category) values
    (7, 'Which Java operator is used to concatenate two strings?', '+', '-', '*', '/','+','easy', 'java');