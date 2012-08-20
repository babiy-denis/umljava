public class generalization  
{	
	public static class Man
	{
		protected String name;
		protected String surname;		
		
		public void setName(String newName)
		{
			name = newName;			
		}
		
		public String getName()
		{
			return name;

		}
		
		public void setSurname(String newSurname)
		{
			name = newSurname;			
		}
		
		public String getSurname()
		{
			return surname;

		}
	}	 
	
	// наследуем класс Man
	public static class Employee extends Man
	{
		private String position;
				
		public  Employee(String n, String s, String p)
		{
			name = n;
			surname = s;
			position = p;
		}
		
		public void setPosition(String newPosition)
		{
				position = newPosition;
		}
		
		public String getPosition()
		{
				return position;
		}
	}

	public static void main(String[] args)
	{
		
		Employee sysEngineer = new Employee("John", "Connor", "Manager");
		System.out.println(sysEngineer.getName() +" is "+ sysEngineer.getPosition());
	}
}
