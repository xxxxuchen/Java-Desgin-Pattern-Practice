package chapter8.visitor;

public class School extends HomeUnit
{
	private final Person aDirector;
	
	public School(String pName, Building pBuilding, Person pDirector)
	{
		super(pName, pBuilding);
		aDirector = pDirector;
		addMember(pDirector);
	}
	
	@Override
	public String name()
	{
		return "School of " + super.name();
	}
	
	public Person director()
	{
		return aDirector;
	}
}
