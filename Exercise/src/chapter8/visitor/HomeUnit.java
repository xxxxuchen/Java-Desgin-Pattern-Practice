package chapter8.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class HomeUnit extends AbstractUnit
{
	private final Building aBuilding;
	private final List<Person> aMembers = new ArrayList<>();
	
	protected HomeUnit(String pName, Building pBuilding)
	{
		super(pName);
		aBuilding = pBuilding;
	}
	
	public void addMember(Person pPerson)
	{
		aMembers.add(pPerson);
	}
	
	protected Building building()
	{
		return aBuilding;
	}
	
	protected List<Person> members()
	{
		return Collections.unmodifiableList(aMembers);
	}
}
