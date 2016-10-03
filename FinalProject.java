/*
School name: Virginia International University

Course Name and Number: Design and Analysis of Algorithms, CMP 561 A

Date: 04-19-2015

Assignment Reference: Project

GROUP MEMBERS:		
1)	SHARVANI RACHARLA (SID:10000123867) - Team Lead 
2)	SAI KRISHNA AMMISETTI (SID:10000127144)
3)	CHANDRA KIRAN GUNDU ( SID:10000128310)
4)	VIJAYA LAKSHMI DADI (SID:10000127952)
5)	SUCHETHA ANKSAPUR (SID:10000127600)
6)	VENKATESWARA REDDY(SID: 10000128888)
*/
import java.io.*;
import java.util.*;

public class FinalProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runtime rt = Runtime.getRuntime();
		FinalProject obj = new FinalProject();
		long mem,mem0;
		
		
		
		List<AgeAndSalary> arraylist = new ArrayList<AgeAndSalary>();
		List<AgeAndSalary> vector = new Vector<AgeAndSalary>();
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcess("finalprojectdata.csv", arraylist);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by arraylist is: "+mem0);
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcess("finalprojectdata.csv", vector);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by vector is: "+mem0);
		System.out.println("-------------------------------");
		Set<AgeAndSalary> hashset = new HashSet<AgeAndSalary>();
		Set<AgeAndSalary> linkedhashset = new LinkedHashSet<AgeAndSalary>();
		Set<AgeAndSalary> treeset = new TreeSet<AgeAndSalary>();
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcess("finalprojectdata.csv", hashset);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by hashset is: "+mem0);
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcess("finalprojectdata.csv", linkedhashset);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by linkedhashset is: "+mem0 );
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcess("finalprojectdata.csv", treeset);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by treeset is: "+mem0 );
		System.out.println("-------------------------------");
		Map<String, AgeAndSalary> hashtable = new Hashtable<String, AgeAndSalary>();
		Map<String, AgeAndSalary> hashmap = new HashMap<String, AgeAndSalary>();
		Map<String, AgeAndSalary> linkedhashmap = new LinkedHashMap<String, AgeAndSalary>();
		Map<String, AgeAndSalary> treemap = new TreeMap<String, AgeAndSalary>();
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcessMap("finalprojectdata.csv", hashmap);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by hashmap is: "+mem0);
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcessMap("finalprojectdata.csv", hashtable);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by hashtable is: "+mem0);
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcessMap("finalprojectdata.csv", linkedhashmap);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by linkedhashmap is: "+mem0);
		
		mem = rt.totalMemory() - rt.freeMemory();
		obj.readDataFileAndProcessMap("finalprojectdata.csv", treemap);
		mem0 = rt.totalMemory() - rt.freeMemory() - mem;
		System.out.println ("Memory used by treemap is: "+mem0);
		
		

long starttime;

		starttime = System.currentTimeMillis();
		obj.performListIndexUpdate(arraylist);
		System.out.println("Time taken to update arraylist structure :: "
				+ (System.currentTimeMillis() - starttime));
				
		starttime = System.currentTimeMillis();
		obj.performListIndexUpdate(vector);
		System.out.println("Time taken to update vector structure :: "
				+ (System.currentTimeMillis() - starttime));
		System.out.println("-------------------------------");
		starttime = System.currentTimeMillis();
		obj.performCollectionUpdate(hashset);
		System.out.println("Time taken to update hashset structure :: "
				+ (System.currentTimeMillis() - starttime));

		
		starttime = System.currentTimeMillis();
		obj.performCollectionUpdate(linkedhashset);
		System.out.println("Time taken to update linkedhashset structure :: "
				+ (System.currentTimeMillis() - starttime));
		
		
		System.out.println("-------------------------------");
		starttime = System.currentTimeMillis();
		obj.performMapUpdate(hashmap);
		System.out.println("Time taken to update hashmap structure :: "
				+ (System.currentTimeMillis() - starttime));
				
		starttime = System.currentTimeMillis();
		obj.performMapUpdate(hashtable);
		System.out.println("Time taken to update hashtable structure :: "
				+ (System.currentTimeMillis() - starttime));		

		
		starttime = System.currentTimeMillis();
		obj.performMapUpdate(linkedhashmap);
		System.out.println("Time taken to linear search Elements in LinkedHashMAp :: "
				+ (System.currentTimeMillis() - starttime));
				
		
	
		
	}

	public void readDataFileAndProcess(String path,
			Collection<AgeAndSalary> text) {
		String line;

		StringTokenizer st;
		try

		{

			BufferedReader inFile = new BufferedReader(new FileReader(path));

			while ((line = inFile.readLine()) != null)
			{
				st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					AgeAndSalary a = new AgeAndSalary();
					a.setId(st.nextToken());
					a.setAge(st.nextToken());
					a.setSalary(st.nextToken());
					text.add(a);
				} // while not end of file

			}
			inFile.close();
		} catch (IOException e) {
			System.err.println(e);

			System.exit(2);
		}
	}

	public void readDataFileAndProcessMap(String path,
			Map<String, AgeAndSalary> text) {
		String line;

		StringTokenizer st;
		try

		{

			BufferedReader inFile = new BufferedReader(new FileReader(path));

			while ((line = inFile.readLine()) != null)

			{

				st = new StringTokenizer(line, ",");

				while (st.hasMoreTokens()) {
					AgeAndSalary a = new AgeAndSalary();
					a.setId(st.nextToken());
					a.setAge(st.nextToken());
					a.setSalary(st.nextToken());
					text.put(a.getId(), a);
				} // while not end of file

			}
			inFile.close();
		} catch (IOException e) {
			System.err.println(e);

			System.exit(2);
		}
	}

	

	public void performCollectionUpdate(Collection<AgeAndSalary> collection) {
		AgeAndSalary a = new AgeAndSalary();
		for (int i = 0; i < 200000; i++) {
			if (collection.contains(i)&&(i==Integer.valueOf(a.getId())))
			{
				int salary;
				salary = Integer.valueOf(a.getSalary());
				if(salary<30000)
				{
					int bonus = salary + 1000;
					a.setSalary(String.valueOf(bonus));
					collection.add(a);
				}
			}
		}
	}
	
	public void performListIndexUpdate(List<AgeAndSalary> c) {
		AgeAndSalary a = new AgeAndSalary();
		for (int i = 0; i < 200000; i++) {
			if (c.contains(i)&&(i==Integer.valueOf(a.getId())))
			{
				int salary;
				salary = Integer.valueOf(a.getSalary());
				if(salary<30000)
				{
					int bonus = salary + 1000;
					a.setSalary(String.valueOf(bonus));
					c.add(a);
				}
			}
		}
	}
	
	

	public void performMapUpdate(Map<String, AgeAndSalary> map) {
		AgeAndSalary a = new AgeAndSalary();
		for (int i = 0; i < 200000; i++) {
			try{
				if (map.containsKey(i)&&(i==Integer.valueOf(a.getId())))
			{
				int salary;
				salary = Integer.valueOf(a.getSalary());
				if(salary<30000)
				{
					int bonus = salary + 1000;
					a.setSalary(String.valueOf(bonus));
					map.put(a.getId(), a);
				}
			}
			}
			catch (Exception e)
			{						
				System.err.println(e);
				System.exit(2);
			}
		}
	}
}

class AgeAndSalary implements Comparable<AgeAndSalary>
{
	private String age, salary;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	
	@Override
	public int compareTo(AgeAndSalary o) {
		// TODO Auto-generated method stub

		return id.compareTo(((AgeAndSalary) o).id);

	}
}
