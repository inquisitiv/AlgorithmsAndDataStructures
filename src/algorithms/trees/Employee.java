package algorithms.trees;

import java.util.ArrayList;

class Employee {

	   String id;
	   Employee manager;
	   ArrayList<Employee> reportees;
	   int score;


	   public Employee(String id, Employee manager, ArrayList<Employee> reportees) {
	   
		this.id = id;
        this.manager = manager;
        this.reportees = reportees;
        this.score = 1; 
        for(Employee emp : reportees) {
          this.score = this.score + emp.score;
        }

	   }
	   
	   
	  public void AddReportee(Employee emp){

	    if(reportees == null){   
		reportees = new ArrayList<Employee>();
	    }
	    
	    reportees.add(emp);
	    update();
	    
	  }


	  public void update() {
	    this.score++;
	    if(manager!=null){
	     this.manager.update();
	    }
	  }


    public int hashCode() {
     return id.hashCode();
    }
    
    public boolean equals(Employee emp) {
		if(emp.id==id) {
			return true;
		} else {
			return false;
		}
    	
    }
    public String toString() {
		return "score : " + score;
    }
}