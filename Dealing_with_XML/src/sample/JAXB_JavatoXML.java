package sample;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JAXB_JavatoXML {

	public static void main(String[] args)
	{
		//setting the values in POJO class
		Employee e1= new Employee();
		e1.setId(1);
		e1.setName("varshini");
		e1.setSalary(25000);
		try
		{
			//specify the new xml location to store the data in xml format
			File file=new File("C:\\Users\\A07208trng_b4a.03.28\\Downloads\\varshini\\sample.xml");
			//create JAXBContext which will be used to create a Binder
			JAXBContext j=JAXBContext.newInstance(Employee.class);
			//Convert java content to xml format
			Marshaller m=j.createMarshaller();
			//specifying that the output should be in xml format(setting the property to show xml format output)
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			 //calling the marshall method
			m.marshal(e1, file);
			//print in console
			m.marshal(e1, System.out);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
