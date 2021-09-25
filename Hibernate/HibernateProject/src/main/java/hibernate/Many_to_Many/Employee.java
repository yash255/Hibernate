package hibernate.Many_to_Many;

import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	private int eid;
	private String name;
	@ManyToMany
	@JoinTable(
			name="emp_learn",
	        joinColumns = {@JoinColumn(name="eid")},
	        inverseJoinColumns = {@JoinColumn(name="pid")}
			)
	private List<Project> projects;
	
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	public Employee(int eid, String name, List<Project> projects) {
		super();
		this.eid = eid;
		this.name = name;
		this.projects = projects;
	}
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
