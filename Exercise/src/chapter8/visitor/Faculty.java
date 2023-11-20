package chapter8.visitor;

public class Faculty extends AbstractUnit
{
	private final Person aDean;
	
	public Faculty(String pName, Person pDean)
	{
		super(pName);
		aDean = pDean;
	}
	
	@Override
	public String name()
	{
		return "Faculty of " + super.name();
	}
	
	public Person dean()
	{
		return aDean;
	}
}
