package project.service;

import org.springframework.stereotype.Service;

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
    public double BMICalculate(int height, int weight){
    	double heightInMeters = height/(double)100;
        double BMI = weight/(heightInMeters*heightInMeters);
        return Math.floor(BMI * 100) / 100;
    }
}
