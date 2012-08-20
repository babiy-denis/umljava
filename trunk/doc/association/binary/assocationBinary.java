public class assocationBinary 
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
		private IdCard iCard;
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
		
		public void setIdCard(IdCard c)
		{
			iCard = c;
		}
		
		public IdCard getIdCard()
		{
			return iCard;
		}
	
	}

	public static class IdCard
	{
		private String dateExpire;
		private int number;
		
		public IdCard(int n)
		{
			number = n;
		}
		
		public void setNumber(int newNumber)
		{
			number = newNumber;
		}
		
		public int getNumber()
		{
			return number;
		}
		
		public void setDateExpire(String newDateExpire)
		{
			dateExpire = newDateExpire;
		}
		
		public String getDateExpire()
		{
			return dateExpire;
		}
	}
	

	public static void main(String[] args)
	{
		
		Employee sysEngineer = new Employee("John", "Connor", "Manager");
		IdCard card = new IdCard(123);
		card.setDateExpire("2010-12-01");
		sysEngineer.setIdCard(card);

		System.out.println(sysEngineer.getName() +" is "+ sysEngineer.getPosition() +" and his ID card expire "
						   +sysEngineer.getIdCard().dateExpire);
	}
}
