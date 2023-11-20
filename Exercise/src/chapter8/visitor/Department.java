package chapter8.visitor;

public class Department extends HomeUnit
{
	private final Person aChair;
	
	public Department(String pName, Building pBuilding, Person pChair)
	{
		super(pName, pBuilding);
		aChair = pChair;
		addMember(pChair);
	}
	
	@Override
	public String name()
	{
		return "Department of " + super.name();
	}
	
	public Person chair()
	{
		return aChair;
	}
}
