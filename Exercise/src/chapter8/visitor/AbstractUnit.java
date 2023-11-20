package chapter8.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractUnit implements Unit
{
	private final List<Unit> aUnits = new ArrayList<>();
	private final String aName;
	
	protected AbstractUnit(String pName)
	{
		aName = pName;
	}
	
	public void addUnit(Unit pUnit)
	{
		aUnits.add(pUnit);
	}
	
	@Override
	public String name()
	{
		return aName;
	}
	
	@Override
	public List<Unit> subunits()
	{
		return Collections.unmodifiableList(aUnits);
	}
	
	@Override
	public String toString()
	{
		return name();
	}
}
