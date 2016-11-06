package project.persistence.entities;

import java.util.Date;

import javax.persistence.*;

/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "UserGoal") // If you want to specify a table name, you can do so here
public class UserGoal {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int userID;
    private int exerciseID; 
    private int unit1;
    private int unit2;
    private Date startDate;
    private Date endDate;
    private String status;

    // Notice the empty constructor, because we need to be able to create an empty Exercise to add
    // to our model so we can use it with our form
    public UserGoal() {
    }
    
    public UserGoal(int userID, int exerciseID, int unit1, int unit2, Date startDate, Date endDate, String status) {
        this.userID = userID;
        this.exerciseID = exerciseID;
    	this.unit1 = unit1;
    	this.unit2 = unit2;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getExerciseID() {
		return exerciseID;
	}

	public void setExerciseID(int exerciseID) {
		this.exerciseID = exerciseID;
	}

	public int getUnit1() {
		return unit1;
	}

	public void setUnit1(int unit1) {
		this.unit1 = unit1;
	}
	
	public int getUnit2() {
		return unit2;
	}

	public void setUnit2(int unit2) {
		this.unit2 = unit2;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
