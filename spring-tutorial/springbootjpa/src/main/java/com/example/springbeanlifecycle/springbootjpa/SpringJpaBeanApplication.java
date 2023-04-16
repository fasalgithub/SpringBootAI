package com.example.springbeanlifecycle.springbootjpa;

import com.example.springbeanlifecycle.springbootjpa.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaBeanApplication implements CommandLineRunner
{
	@Autowired
	private StudentRepo studentRepo;

	public static void main(String[] args)
	{
		SpringApplication.run(SpringJpaBeanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
//		studentRepo.getStudentByMarkInBetween(10,100).stream().forEach(System.out::println);

		/*studentRepo.getStudentByBranch("ECE").stream().forEach(System.out::println);
		studentRepo.getStudentByBatchWithNative("ECE").stream().forEach(System.out::println);
		studentRepo.getStudentByBranchNamedParameter("ECE").stream().forEach(System.out::println);*/

		studentRepo.listOfStudentsCountByMark().stream().forEach(studentCountByMarks -> {
			System.out.println(studentCountByMarks.getMyStudentName() + " : "+studentCountByMarks.getMyStudentCount());
		});
	}
}

