CREATE TABLE questions (
	id_question SERIAL PRIMARY KEY,
	question VARCHAR(322) UNIQUE NOT NULL);
	
CREATE TABLE answers (
	id_question INT REFERENCES questions(id_question),
	id_answer SERIAL PRIMARY KEY,
	answer_option VARCHAR(322) NOT NULL);	
	
CREATE TABLE right_answers(
	id_question INT REFERENCES questions(id_question),
	right_answer VARCHAR(322) UNIQUE NOT NULL);

INSERT INTO questions(id_question, question)
VALUES 	(1,'Количество материков на земле?'),
	   	(2,'Столица Австралии?'),
	   	(3,'Какая команда используется для копирования удаленного репозитория?'),
		(4,'Что будет в результате выполнения операции 2 + 2 == 5 && 12 / 4 == 3 || 2 == 5 % 3');


INSERT INTO answers (id_answer, answer_option)
VALUES (1,'1) - 6 | 2) - 4 | 3) - 7 | 4) - 5'),
		(2,'1) - Сидней| 2) - Мельбурн | 3) - Канберра |  4) - Брисберн'),
		(3,'1) - commit | 2) - push | 3) - clone |  4) - copy'),
		(4,'1) - false | 2) - true | 3) - null | 4) - 0');

INSERT INTO right_answers /*????????????????*/
VALUES  (1, '6'),
		(2, 'Канберра'),
		(3, 'clone'),
		(4, 'true');
SELECT * FROM right_answers

SELECT questions.question, answers.answer_option
FROM questions 
INNER JOIN answers on questions.id_question = answers.id_answer;


