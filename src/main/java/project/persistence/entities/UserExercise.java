package project.persistence.entities;

import java.util.Date;

import javax.persistence.*;

/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "UserExercise") // If you want to specify a table name, you can do so here
public class UserExercise {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userGoalID;
    private int userID;
    private int exerciseID;
    private int[] unit;
    private Date date;

    // Notice the empty constructor, because we need to be able to create an empty Exercise to add
    // to our model so we can use it with our form
    public UserExercise() {
    }

    public UserExercise(int id, int userGoalID, int userID, int exerciseID, int[] unit, Date date) {
        this.id = id;
        this.userGoalID = userGoalID;
        this.userID = userID;
        this.exerciseID = exerciseID;
        this.unit = unit;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserGoalID() {
        return userGoalID;
    }

    public void setUserGoalID(int userGoalID) {
        this.userGoalID = userGoalID;
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
    
    public int[] getUnit() {
        return unit;
    }

    public void setUnit(int[] unit) {
        this.unit = unit;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
