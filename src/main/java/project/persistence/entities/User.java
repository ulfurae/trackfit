package project.persistence.entities;

import java.util.Date;

import javax.persistence.*;

/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "User") // If you want to specify a table name, you can do so here
public class User {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String username;
    private String pass; 
    private String fullName;
    private Date birthday;
    private int height;
    private int weight;
    private int fatPercentage;

    // Notice the empty constructor, because we need to be able to create an empty Exercise to add
    // to our model so we can use it with our form
    public User() {
    }
    
    public User(String username, String pass, String fullName, Date birthday, int height, int weight, int fatPercentage) {
        this.username = username;
    	this.pass = pass;
        this.fullName = fullName;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.fatPercentage = fatPercentage;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getFatPercentage() {
		return fatPercentage;
	}

	public void setFatPercentage(int fatPercentage) {
		this.fatPercentage = fatPercentage;
	}

}
