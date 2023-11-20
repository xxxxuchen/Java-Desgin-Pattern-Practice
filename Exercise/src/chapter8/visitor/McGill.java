package chapter8.visitor;

public class McGill
{
	public static void main(String[] args)
	{
		University mcgill = new University("McGill University", new Person(Title.PROF, "Christopher Manfredi"));
		
		Faculty science = new Faculty("Science", new Person(Title.PROF, "Bruce Lennox"));
		Faculty arts = new Faculty("Arts", new Person(Title.PROF, "Lisa Shapiro"));
		
		School cs = new School("Computer Science", Building.MCCONNELL, new Person(Title.PROF, "Mathieu Blanchette"));
		Department math = new Department("Mathematics and Statistics", Building.BURNSIDE, new Person(Title.PROF, "Christian Genest"));
		Department linguistics = new Department("Linguistics", Building.PENFIELD1085, new Person(Title.PROF, "Michael Wagner"));
		
		Committee academic = new Committee("Academic", new Person(Title.PROF, "David Bowie"));

		Committee undergrad = new Committee("Undergraduate", new Person(Title.PROF, "Brigitte Pientka"));
		Committee scholarships = new Committee("Scholarships", new Person(Title.PROF, "Martin Robillard"));
		Committee graduation = new Committee("Graduation", new Person(Title.PROF, "Prakash Panangaden"));
		Committee curriculum = new Committee("Curriculum", new Person(Title.PROF, "Louis Prima"));
		
		mcgill.addUnit(science);
		mcgill.addUnit(arts);
		
		science.addUnit(cs);
		science.addUnit(math);
		science.addUnit(academic);

		arts.addUnit(linguistics);
		
		cs.addUnit(undergrad);
		undergrad.addUnit(graduation);
		cs.addUnit(scholarships);
		math.addUnit(curriculum);
		
		cs.addMember(new Person(Title.PROF, "Oana Balmau"));
		cs.addMember(new Person(Title.DR, "Giulia Alberini"));
		cs.addMember(new Person(Title.PROF, "Clark Verbrugge"));
		cs.addMember(new Person(Title.PROF, "Vetta, Adrian"));
		
		math.addMember(new Person(Title.PROF, "Vetta, Adrian"));
		math.addMember(new Person(Title.PROF, "Jessica Lin"));
		math.addMember(new Person(Title.PROF, "Sabok, Marcin"));
		
		linguistics.addMember(new Person(Title.PROF, "Heather Goad"));
		linguistics.addMember(new Person(Title.PROF, "Bernhard Schwarz"));
		linguistics.addMember(new Person(Title.PROF, "Morgan Sonderegger"));

		for (Unit unit : cs.subunits()){
			System.out.println(unit);
		}
	}
}
