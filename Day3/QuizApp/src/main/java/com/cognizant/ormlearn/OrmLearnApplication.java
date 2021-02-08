package com.cognizant.ormlearn;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.service.AttemptService;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	
	public static AttemptService attemptService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	

	public static void testGetAttempt() {
		Attempt attempt = attemptService.getAttempt(1, 1);
		System.out.println(attempt.toString());
	}

	public static void testGetAttempt2() {
		Attempt attempt = attemptService.getAttemptDetail(1, 1);
		Set<AttemptQuestion> attemptQuestions = attempt.getAttemptQuestion();
		for (AttemptQuestion attemptQuestion : attemptQuestions) {
			System.out.println(attemptQuestion.getQuestion().getTxt());
			Set<AttemptOption> attemptOptions = attemptQuestion.getAttemptOption();
			int i = 1;
			for (AttemptOption attemptOption : attemptOptions) {
				System.out.print(i + ")\t");
				System.out.print(attemptOption.getOptions().getText() + "\t");
				System.out.print(attemptOption.getOptions().getScore() + "\t");
				System.out.println(attemptOption.isSelected());
				i++;
			}
		}
	}



	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);		

		attemptService = context.getBean(AttemptService.class);	
		testGetAttempt();
		testGetAttempt2();
	}
}