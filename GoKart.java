public class GoKart {
    private String name;
    private String typeOfCar;
    private String strokeEngine;
    private int option;
    private int numberOfLaps;
    private boolean safetySet;

    // Constructor
    public GoKart(String name, String typeOfCar, String strokeEngine, int option, int numberOfLaps, boolean safetySet) {
        this.name = name;
        this.typeOfCar = typeOfCar;
        this.strokeEngine = strokeEngine;
        this.option = option;
        this.numberOfLaps = numberOfLaps;
        this.safetySet = safetySet;
    }
    //set data
    public void setGoKart(String name, String typeOfCar, String strokeEngine, int option, int numberOfLaps, boolean safetySet) {
        this.name = name;
        this.typeOfCar = typeOfCar;
        this.strokeEngine = strokeEngine;
        this.option = option;
        this.numberOfLaps = numberOfLaps;
        this.safetySet = safetySet;
    }

    // Getter methods
    public String getName()
    { 
        return name; 
    }
    public String getTypeOfCar()
    {
        return typeOfCar; 
    }
    public String getStrokeEngine()
    {
        return strokeEngine; 
    }
    public int getOption()
    {
        return option; 
    }
    public int getNumberOfLaps()
    {
        return numberOfLaps; 
    }
    public boolean isSafetySet()
    {
        return safetySet; 
    }

    // Override toString() for proper display of object data
    @Override
    public String toString() 
    {
        return String.format(
            "|%-10s|%-15s|%-10s|%-20s|%-10d|%-10s",
            name,                        // Customer Name
            typeOfCar,                   // Type of Car
            strokeEngine,                // Engine Stroke
            (option == 1 ? "Quick Experience" : "Race Adventure"), // Option Description
            numberOfLaps,                // Number of Laps
            (safetySet ? "Yes" : "No")   // Safety Set Description
        );
    }
}
