import java.util.*;
public class UmlRelations
{	
	public static class Man{
		protected String name;
		protected String surname;				
		public void setName(String newName){
			name = newName;			
		}
		public String getName(){
			return name;

		}
		public void setSurname(String newSurname){
			name = newSurname;			
		}
		
		public String getSurname(){
			return surname;

		}
	}	 
	
	// наследуем класс Man
	public static class Employee extends Man{
		private String position;
		private IdCard iCard;
		private Set room = new HashSet();
		private Department department;
		private Set pastPosition = new HashSet();
		public  Employee(String cName, String cSurname, String cPosition){
			name = cName;
			surname = cSurname;
			position = cPosition;
		}
		public void setPosition(String newPosition){				
				// сначала пдолжность заносим в список прежних должностей
				PastPosition pastPosition = new PastPosition(this.getPosition(), this.getDepartment());				
				this.setPastPosition(pastPosition);
				// меняем должность
				position = newPosition;
		}
		public String getPosition(){
				return position;
		}
		public void setIdCard(IdCard c){
			iCard = c;
		}
		public IdCard getIdCard(){
			return iCard;
		}
		public void setRoom(Room newRoom){
			room.add(newRoom);
		}
		public Set  getRoom(){
			return room;
		}
		
		public void  deleteRoom(Room r)
		{
			room.remove(r);
		}
		
		public void setDepartment(Department d)
		{
			department = d;
		}
		
		public Department getDepartment()
		{
			return department;
		}
		
		public void setPastPosition(PastPosition p)
		{
			pastPosition.add(p);
		}
		
		public Set  getPastPosition()
		{
			return pastPosition;
		}
		
		public void deletePastPosition(PastPosition p)
		{
			pastPosition.remove(p);
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
	
	public static class Department implements Unit
	{
		private String name;
		private Set employees = new HashSet();
		
		public Department(String n)
		{
			name = n;
		}
		
		public void setName(String newName)
		{
			name = newName;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void  addEmployee(Employee newEmployee)
		{
			employees.add(newEmployee);
			// связываем сотрудника с этим отделом
			newEmployee.setDepartment(this); 
		}
		
		public Set  getEmployees()
		{
			return employees;
		}
		public void  removeEmployee(Employee e)
		{
			employees.remove(e);
		}
		
		public int getPersonCount()
		{
			return getEmployees().size();
		}
	}
	
	private static class PastPosition
	{
		private String name;
		private Department department;
		public PastPosition(String position, Department dep)
		{
			name = position;
			department = dep;
		}
		
		public void setName(String newName)
		{
			name = newName;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setDepartment(Department d)
		{
			department = d;
		}
		
		public Department getDepartment()
		{
			return department;
		}
	}
	
	public static class Menu
	{
		private static int i=0;
		public static void showEmployees(Employee[] employees)
		{			
			System.out.println("Список сотрудников:");
			for (i=0; i<employees.length; i++)
				if(employees[i] instanceof Employee)
					System.out.println(employees[i].getName() +" - " + employees[i].getPosition());
		}
	}
	
	public interface Unit
	{
		int getPersonCount();
	}
	
	public static void main(String[] args)
	{
		
			 
		// Employee
		
		Employee sysEngineer = new Employee("Жора", "Кустов", "Управделами");
		sysEngineer.setPosition("Инженер");
		
		// второй Employee
		Employee director = new Employee("Федор", "Дубов", "Директор");

		
		
		// IdCard
		IdCard card = new IdCard(123);
		card.setDateExpire("2010-12-01");
		sysEngineer.setIdCard(card);

		// Room
		Room room101 = new Room(101);
		Room room321 = new Room(321);
		sysEngineer.setRoom(room101);
		sysEngineer.setRoom(room321);
		
		// Department
		Department programmersDepartment = new Department("Программисты");
		programmersDepartment.addEmployee(sysEngineer);

		
		// PastPosition		
		sysEngineer.setPosition("Сторож");
		


		// Output
		System.out.println(sysEngineer.getName() +" работает в должности "+ sysEngineer.getPosition()); 
		System.out.println("Удостовирение действует до " + sysEngineer.getIdCard().dateExpire); 
						   
		System.out.println("Может находиться в помещеньях:");
		Iterator iter =  sysEngineer.getRoom().iterator();
		while(iter.hasNext())
			System.out.println( ((Room) iter.next()).getNumber());
		
		System.out.println("Относится к   отделу "+sysEngineer.getDepartment().name);
		
		System.out.println("В отделе "+sysEngineer.getDepartment().name+" работает "
						   +sysEngineer.getDepartment().getPersonCount()+" человек.");
		
		System.out.println("В прошлом работал как:");		
		iter =  sysEngineer.getPastPosition().iterator();
		while(iter.hasNext())
			System.out.println( ((PastPosition) iter.next()).getName());
		
		// Menu
		Menu menu = new Menu();
		
		Employee employees[] = new Employee[10];
		employees[0]= sysEngineer;
		employees[1] = director;
		Menu.showEmployees(employees);
		
		

	}
}
