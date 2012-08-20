import java.util.*;
public class assocationMultiply
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
		private Set room = new HashSet();
		
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
		
		public void setRoom(Room newRoom)
		{
			room.add(newRoom);
		}
		
		public Set  getRoom()
		{
			return room;
		}
		
		public void  deleteRoom(Room r)
		{
			room.remove(r);
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
	
	
	public static class Room
	{
		private int number;
		
		public Room(int n)
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
	}
	
	public static void main(String[] args)
	{
		
		Employee sysEngineer = new Employee("John", "Connor", "Manager");
		IdCard card = new IdCard(123);
		card.setDateExpire("2010-12-01");
		sysEngineer.setIdCard(card);

		Room room101 = new Room(101);
		Room room321 = new Room(321);
		sysEngineer.setRoom(room101);
		sysEngineer.setRoom(room321);
		
		System.out.println(sysEngineer.getName() +" is "+ sysEngineer.getPosition() +" and his ID card expire "
						   +sysEngineer.getIdCard().dateExpire + " work in rooms:");
		
		Iterator iter =  sysEngineer.getRoom().iterator();
		while(iter.hasNext())
			System.out.println( ((Room) iter.next()).getNumber());
	}
}
