package project.persistence.entities;



/**
 * The class for the Postit Note itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */

public class BMI {
    
    private double BMIIndex;
    private String idealWeight;

    // Notice the empty constructor, because we need to be able to create an empty Exercise to add
    // to our model so we can use it with our form
    public BMI() {
    }
    
    public BMI(double BMIIndex, String idealWeight) {
        this.BMIIndex = BMIIndex;
    	this.idealWeight = idealWeight;

    }
    
    public double getBMIIndex() {
        return BMIIndex;
    }

    public void setBMIIndex(double BMIIndex) {
        this.BMIIndex = BMIIndex;
    }

	public String getIdealWeight() {
		return idealWeight;
	}

	public void setIdealWeight(String idealWeight) {
		this.idealWeight = idealWeight;
	}

}