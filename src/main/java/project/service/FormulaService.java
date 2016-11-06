package project.service;

import org.springframework.stereotype.Service;
import project.persistence.entities.BMI;

/**
 * Service class that has methods for String Manipulation
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class FormulaService {

    /**
     * Returns the string that is passed to the method in Upper Case
     * @param string String to convert to Upper Case
     * @return String
     */
    public BMI BMICalculate(int height, int weight){
    	BMI bmi = new BMI();
    	double heightInMeters = height/(double)100;
        double BMI = weight/(heightInMeters*heightInMeters);
        double BMIIndex = Math.floor(BMI * 100) / 100;
        String idealWeight;
        
        if(BMIIndex < 18.5) {
        	idealWeight = "Underweight";
        }
        else if(BMIIndex >= 18.5 && BMIIndex <= 24.9) {
        	idealWeight = "Normal weight";
        }
        else if(BMIIndex > 24.9 && BMIIndex < 30) {
        	idealWeight = "Overweight";
        }
        else {
        	idealWeight = "Obesity";
        }
        
        bmi.setBMIIndex(BMIIndex);
        bmi.setIdealWeight(idealWeight);
        return bmi;
    }
}
