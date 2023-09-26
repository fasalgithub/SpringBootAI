package com.example.responseentity.ResponseEntity;

import com.example.responseentity.ResponseEntity.model.Cricketer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ResponseEntityApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(ResponseEntityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cricketer cricketer = new Cricketer(null,"batsman","Rohit","1980-2000");
		System.out.println(cricketer);
	}
}

@RestController
@RequestMapping("/cricket")
class CricketerController
{
	List<Cricketer> list = new ArrayList<>();

	@PostConstruct
	public void loadMyCricketers()
	{
		list.add(new Cricketer("100","batsman","Rohit","1980-2000"));
		list.add(new Cricketer("28","batsman","Virat","1988-2000"));
		list.add(new Cricketer("7","Caption","Dhoni","1970-2000"));
	}

	@PreDestroy
	public void end(){
		list.clear();
	}


	@RequestMapping("/cricketers")
	public List<Cricketer> cricketers()
	{
		return list;
	}

	@RequestMapping("/cricketers/{no}")
	public ResponseEntity<Cricketer> cricketer(@PathVariable("no") String jersyNumber)
	{
		Cricketer newCricketer =  list.stream().
				filter(cricketer -> cricketer.getNo().equals(jersyNumber))
				.findFirst()
				.orElse(new Cricketer());

//		ResponseEntity<Cricketer> responseEntity = new ResponseEntity<>(newCricketer,HttpStatus.ACCEPTED);
//		return responseEntity;

		ResponseEntity.ok("Completed");
		ResponseEntity.badRequest().build();
		ResponseEntity.status(HttpStatus.ACCEPTED).body("Completed");

		HttpHeaders headers = new HttpHeaders();
		headers.add("spot","cricket");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(newCricketer);


		/**
		 * ResponseEnity
		 * header
		 * body
		 * status
		 * */

	}

	@DeleteMapping("/cricketers/{no}")
	public ResponseEntity<Void> removeCricker(@PathVariable("no") String jersyNumber)
	{
		Cricketer newCricketer =  list.stream().
				filter(cricketer -> cricketer.getNo().equals(jersyNumber))
				.findFirst()
				.orElse(new Cricketer());
		list.remove(newCricketer);
		return ResponseEntity.status(HttpStatus.LOCKED).build();


	}

}

