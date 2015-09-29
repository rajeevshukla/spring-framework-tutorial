import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.BusinessLogicClass;


public class Main {

	public static void main(String[] args) {


		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");

		BusinessLogicClass businessLogicClass=(BusinessLogicClass)applicationContext.getBean("businessLogic");

		businessLogicClass.doProcess();
		businessLogicClass.doProcess(2);
		businessLogicClass.doProcess1();
		
		
	}

}
