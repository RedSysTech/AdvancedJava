package MVC_Arch;

public class PersonController {

	private Person model;
	private Person_View view;
	
	public void setPersonName(String name) {
		model.setName(name);
	}
	
	public void setPersonAge(int age) {
		model.setAge(age);
	}
	
	public void updateView() {
		view.printPersonDetails(model.getName(), model.getAge());
	}
	
	public PersonController(Person model, Person_View view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	
}
