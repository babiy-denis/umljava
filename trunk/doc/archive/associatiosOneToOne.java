import java.util.*;
public class associatiosOneToOne.java  
{	
	static final  long serialVersionUID=0;
	public static class Man
	{
		private String name;
		private String surnane;
		private Man (String n, String m)
		{
			this.name = n;
			this.surname = m;			
		}
	}
	 
	public static  class Employee extends Man
	{		
		private String profession;
		
		public void getProfession()
		{
				return 
		}
		
		public void getProfession()
		{
				return 
		}
	}

	public static class Husband extends Man
	{
		public String name, surname;
		public  EuWife wife;		
		public EuHusband(String n, String m)
		{
			this.name = n;
			this.surname = m;			
		}
	}

	public static void main(String[] args)
	{		
		
		EuWife sarah = new EuWife("Sarah", "O'Connor");
		EuHusband john = new EuHusband("John", "O'Connor");
		sarah.husband = john;
		john.wife = sarah;
		System.out.println("European: "+sarah.husband.name);

		EuWife asa = new EuWife("Asa", "Beah");
		EuWife aia = new EuWife("Aia", "Beah");
		EaHusband ahmed = new EaHusband("Ahmed", "Beah");
		ahmed.wife[0] = asa;
		ahmed.wife[1] = aia;		
		System.out.println("Array/Eastern: "+ahmed.wife[0].name+", "+ahmed.wife[1].name);
		
		//////// exp
		
		ahmed.EuWife2.add(asa);		
		ahmed.EuWife2.add(aia);
		System.out.println("Collection/Easten Husband:");
		Iterator iter =  ahmed.EuWife2.iterator();
		while(iter.hasNext())
			((EuWife) iter.next()).sayName();
	}
}
