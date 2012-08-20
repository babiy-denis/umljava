import java.util.*;
public class associations  
{	
	static final  long serialVersionUID=0;
	public static class Man
	{
		public String name;
		public String surnane;
	}
	 
	/////////////////////////  One-to-One
	public static  class EuWife extends Man
	{		
		public String name, surname;
		public  EuHusband husband;
		
		public EuWife(String n, String m)
		{
			this.name = n;
			this.surname = m;			
		}
		public void sayName()
		{
				System.out.println("My Name is: "+this.name);
		}
	}

	public static class EuHusband extends Man
	{
		public String name, surname;
		public EuWife wife;		
		public EuHusband(String n, String m)
		{
			this.name = n;
			this.surname = m;			
		}
	}

/////////////////////////  One-to-Multiple
	public static class EaHusband extends Man
	{
		public String name, surname;
		public EuWife[]  wife;
		public Set EuWife2 = new HashSet();
		
		public EaHusband(String n, String m)
		{
			this.name = n;
			this.surname = m;
			this.wife = new EuWife[2];
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
