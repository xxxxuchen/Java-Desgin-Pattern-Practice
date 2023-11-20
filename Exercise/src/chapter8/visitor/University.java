package chapter8.visitor;

public class University extends AbstractUnit
{
	private final Person aPrincipal;
	
	public University(String pName, Person pPrincipal)
	{
		super(pName);
		aPrincipal = pPrincipal;
	}
	
	public Person principal()
	{
		return aPrincipal;
	}
}
