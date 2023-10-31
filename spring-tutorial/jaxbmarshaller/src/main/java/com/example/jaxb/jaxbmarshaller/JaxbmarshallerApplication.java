package com.example.jaxb.jaxbmarshaller;

import com.example.jaxb.jaxbmarshaller.bean.*;
import com.example.jaxb.jaxbmarshaller.service.MarshallingUnmarshalling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JaxbmarshallerApplication implements CommandLineRunner {

	@Autowired
	private MarshallingUnmarshalling marshallingUnmarshalling;

	public static void main(String[] args) {
		SpringApplication.run(JaxbmarshallerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		Request request = new Request();
		request.setRequestId("101");
		request.setRequestName("request 101");
		request.setRequestAddress(new RequestAddress("request Address 101", Arrays.asList("Rd","Dir")));

		Request request1 = new Request();
		request1.setRequestId("102");
		request1.setRequestName("request 102");
		request1.setRequestAddress(new RequestAddress("request Address 102", Arrays.asList("Rd","Dir")));

	  /*  Request request = new Request();
		request.setRequestId("101");
		request.setRequestName("request 101");
		request.setRequestAddress(new RequestAddress("request Address 101", Arrays.asList("Rd","Dir")));

		String msg = marshallingUnmarshalling.marshal("Request", Request.class,request);
		System.out.println(msg);

		Request msgObject = (Request)marshallingUnmarshalling.unMarshal(msg);
		System.out.println(msgObject);*/

		ProviderAdaptorRequest providerAdaptorRequest = new ProviderAdaptorRequest();
		providerAdaptorRequest.setCommit(Boolean.TRUE);
		providerAdaptorRequest.setConnectionMode(ConnectionMode.API);

		DataHolder dataHolder = new DataHolder();
		dataHolder.addData("Hello","Java");
		dataHolder.addData("Hi","Python");

		providerAdaptorRequest.setHeaders(dataHolder);
		ProviderMaintenanceServiceIBRequestRoot providerMaintenanceServiceIBRequestRoot = new ProviderMaintenanceServiceIBRequestRoot();
		providerMaintenanceServiceIBRequestRoot.setHeader(new Header(1,"2022-02-09","101","011","190","09","Taxentity"));
		providerMaintenanceServiceIBRequestRoot.setRequests(Arrays.asList(request,request1));
		providerAdaptorRequest.setPayLoad(providerMaintenanceServiceIBRequestRoot);

		String msg = marshallingUnmarshalling.marshal("ProviderAdaptorRequest",ProviderAdaptorRequest.class,providerAdaptorRequest);
		System.out.println(msg);

		ProviderAdaptorRequest providerAdaptorRequest1 = (ProviderAdaptorRequest)marshallingUnmarshalling.unMarshal(msg);
		System.out.println(providerAdaptorRequest1);


	}
}
