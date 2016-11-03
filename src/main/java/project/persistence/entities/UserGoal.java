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
    private int[] unitGoal;
    private Date startDate;
    private Date endDate;
    private String status;

    // Notice the empty constructor, because we need to be able to create an empty Exercise to add
    // to our model so we can use it with our form
    public UserGoal() {
    }
    
    public UserGoal(int userID, int exerciseID, int[] unitGoal, Date startDate, Date endDate, String status) {
        this.userID = userID;
        this.exerciseID = exerciseID;
    	this.unitGoal = unitGoal;
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

	public int[] getUnitGoal() {
		return unitGoal;
	}

	public void setUnitGoal(int[] unitGoal) {
		this.unitGoal = unitGoal;
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
