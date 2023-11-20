package chapter8.visitor;

public class Committee extends AbstractUnit
{
	private final Person aChair;
	
	public Committee(String pName, Person pChair)
	{
		super(pName);
		aChair = pChair;
	}
	
	@Override
	public String name()
	{
		return super.name() + " committee";
	}
	
	public Person chair()
	{
		return aChair;
	}
}
