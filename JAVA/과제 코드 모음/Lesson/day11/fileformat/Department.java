package Lesson.day11.fileformat;

import java.io.Serializable;

public class Department implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String name;
    Employee leader;
    
    public Department(String name, Employee leader) {
        this.name = name;
        this.leader = leader;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Employee getLeader() {
        return this.leader;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.leader;
    }
}
