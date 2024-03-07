package com.example.jaxb.jaxbmarshaller;

import com.example.jaxb.jaxbmarshaller.bean.*;
import com.example.jaxb.jaxbmarshaller.service.MarshallingUnmarshalling;
import com.example.jaxb.jaxbmarshaller.service.ObjectMemoryManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class JaxbmarshallerApplication implements CommandLineRunner {

    @Autowired
    private MarshallingUnmarshalling marshallingUnmarshalling;
    @Autowired
    private ObjectMemoryManagement objectMemoryManagement;

    public static void main(String[] args) {
        SpringApplication.run(JaxbmarshallerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Request request1 = new Request();
        request1.setRequestId("101");
        request1.setRequestName("request 101");
        request1.setRequestAddress(new RequestAddress("request Address 101", Arrays.asList("Rd", "Dir")));

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
        dataHolder.addData("Hello", "Java");
        dataHolder.addData("Hi", "Python");
        dataHolder.addData("Hey", "Java script");
        dataHolder.addData("Heyy!", "C#");
        dataHolder.addData("Heyy!!", "C++");

        providerAdaptorRequest.setHeaders(dataHolder);
        ProviderMaintenanceServiceIBRequestRoot providerMaintenanceServiceIBRequestRoot = new ProviderMaintenanceServiceIBRequestRoot();
        providerMaintenanceServiceIBRequestRoot.setHeader(new Header(1, "2022-02-09", "101", "011", "190", "09", "Taxentity"));

        List<Request> requests = IntStream.range(0, 1000).mapToObj(num -> {
            Request request = new Request();
            request.setRequestId(num + "");
            request.setRequestName("request " + num + "");
            request.setRequestAddress(new RequestAddress("request Address " + num + "", Arrays.asList("Rd", "Dir : num")));
            return request;
        }).collect(Collectors.toCollection(ArrayList::new));

        providerMaintenanceServiceIBRequestRoot.setRequests(requests);
        providerAdaptorRequest.setPayLoad(providerMaintenanceServiceIBRequestRoot);

       /* String beforeConvertingObject = marshallingUnmarshalling.marshal("ProviderAdaptorRequest", ProviderAdaptorRequest.class, providerAdaptorRequest);

        writeUsingOutputStream("C:\\playground\\Qtree\\file handling\\Input.txt", beforeConvertingObject);*/

        String beforeConvertingObject = fileReader("C:\\playground\\Qtree\\file handling\\Input.txt");
        //beforeConvertingObject = beforeConvertingObject.substring(2, beforeConvertingObject.length() - 1);
        //System.out.println(beforeConvertingObject);

        ProviderAdaptorRequest providerAdaptorRequest1 = (ProviderAdaptorRequest) marshallingUnmarshalling.unMarshal(beforeConvertingObject);
        objectMemoryManagement.printObjectSize(providerAdaptorRequest1);

        //System.out.println(providerAdaptorRequest1);

        String afterConvertingObject = marshallingUnmarshalling.marshal("ProviderAdaptorRequest", ProviderAdaptorRequest.class, providerAdaptorRequest1);
        //System.out.println(afterConvertingObject);
        writeUsingOutputStream("C:\\playground\\Qtree\\file handling\\output.txt", afterConvertingObject);


    }

    private static void writeUsingOutputStream(String fileName, String src) {

        try (OutputStream os = new FileOutputStream(new File(fileName));) {
            os.write(src.getBytes(), 0, src.length());
            System.out.println("file written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileReader(String fileName) throws IOException {
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public void fileWriter(String fileName, String src, boolean condition) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(src);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
  }
