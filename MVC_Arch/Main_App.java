package MVC_Arch;

public class Main_App {

	public static void main(String[] args) {
		
		//create a new Person obj
		Person person = new Person();
		
		//create a new Person_View obj
		Person_View view = new Person_View();
		
		//create a new Person_Controller obj
		PersonController controller = new PersonController(person,view);
		
		controller.setPersonName("Karthik");
		controller.setPersonAge(30);
		
		//update the view
		controller.updateView();
		
	}

}
