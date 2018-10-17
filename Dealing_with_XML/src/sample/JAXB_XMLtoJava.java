package sample;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class JAXB_XMLtoJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//read xml file
			File file=new File("C:\\Users\\A07208trng_b4a.03.28\\Downloads\\varshini\\sample.xml");
			//create JAXBContext which will be used to create a Binder
			JAXBContext j=JAXBContext.newInstance(Employee.class);
			//to convert xml data to java content 
			Unmarshaller u= j.createUnmarshaller();
			//unmarshall xml data to java content
			Employee e1= (Employee) u.unmarshal(file);
			System.out.println(e1.getId()+""+e1.getName()+""+e1.getSalary());
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
