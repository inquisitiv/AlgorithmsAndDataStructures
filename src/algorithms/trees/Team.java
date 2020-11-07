package algorithms.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


class Team {

  HashMap<String,Employee> set;

  public  Employee getEmployeeById(String id) {
      return set.get(id);
  }
  
  public int getscore(String id) {
	 return set.get(id).score;
  }
  
   
  public Team(HashMap<String, ArrayList<String>> map) {
  
	  set = new HashMap<String,Employee>();
      for(Entry<String, ArrayList<String>> entry : map.entrySet()) {
    	  Employee mag = getEmployeeById(entry.getKey());
    	  if(mag==null) {
    		  mag = new Employee(entry.getKey(),null,new ArrayList<Employee>());
    		  set.put(entry.getKey(), mag);
    		  System.out.println(set.toString());
    	  }
       for(String reportee : entry.getValue()) {
    	   Employee emp = getEmployeeById(reportee);
     	   if(emp==null) {
     		  emp = new Employee(reportee,mag,new ArrayList<Employee>());
     		  set.put(reportee, emp);
     		  System.out.println(set.toString());
     	   }
    	   mag.AddReportee(emp);		  
       }

      }

  }

  public static void main(String[] args) {
	  
	  HashMap<String, ArrayList<String>> map = new HashMap<>();
	
	  ArrayList<String> list = new ArrayList<String>();
	  list.add("2");
	  list.add("3");
	  list.add("4");
	  map.put("1",list);
	  
	  list = new ArrayList<String>();
	  list.add("5");
	  list.add("6");
	  map.put("2",list);
	  
	  list = new ArrayList<String>();
	  list.add("7");
	  list.add("8");
	  map.put("3",list);
	  
	  list = new ArrayList<String>();
	  list.add("9");
	  list.add("10");
	  map.put("5",list);
	  
	  map.put("4",new ArrayList<String>());
	  map.put("6",new ArrayList<String>());
	  map.put("7",new ArrayList<String>());
	  map.put("8",new ArrayList<String>());
	  map.put("9",new ArrayList<String>());
	  map.put("10",new ArrayList<String>());
	  
      Team team = new Team(map);
      System.out.println(team.getscore("5"));
      System.out.println(team.getscore("1"));
      
  
  
  }

  
}