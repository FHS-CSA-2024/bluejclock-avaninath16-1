package src.main.java;


public class ClockDisplay12Hour

{
    //Extend ClockDisplaySeconds to include a seconds field.
    //Update all methods and parameters to accomodate this changepackage src.main.java;

    //Implement 2 private NumberDisplay objects. 
    //  One for hours and one for minutes
    //Implement a private String for the display
    private NumberDisplay hours;
    boolean beforeNoon;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String display;
    //Implement a constructor that takes no parameters
    //The constructor should set hours as a NumberDisplay object with 24 as the limit
    //The constructor should set minutes as a NumberDisplay object with 60 as the limit
    //The constructor should call the method updateDisplay before finishing
    public ClockDisplay12Hour(){
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        beforeNoon = true;
        updateDisplay();
    }
    //Implement a constructor that takes 2 parameters, hour and minute
    //The constructor should set hours as a NumberDisplay object with 24 as the limit
    //The constructor should set minutes as a NumberDisplay object with 60 as the limit
    //The constructor should call the method setTime with the parameters passed in
    public ClockDisplay12Hour(int hour, int minute, int second, boolean beforeNoon){
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        this.beforeNoon = beforeNoon;
        setTime(hour,minute,second);
            
    }
    
    //Implement a method timeTick that takes no parameters and returns nothing
    //The method should increase the minute value by one each run
    //The hours should increase when the minutes roll over
    //The updateDisplay method should be called before finishing
    public void timeTick(){
        minutes.increment();
        //checking to see if value rolled over to zero
        if(minutes.getValue() == 0){
            hours.increment();
        }
        if (hours.getValue() == 0){
            hours.increment();
            beforeNoon = !beforeNoon;
        }
    
        updateDisplay();
    }
    
    public void timeTickSec(){
        seconds.increment();
        if (seconds.getValue() == 0){
            timeTick();
        }
        updateDisplay();
    }
    //Implement a method setTime that takes in 2 parameters, hour and minute
    //The method should set the hours value and minutes value
    //The updateDisplay method should be called before finishing
    public void setTime(int hour, int minute, int second){
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }
    //Implement a method getTime that takes no parameter and returns a String
    //The return String should be formatted as HH:MM and report out the current time
    public String getTime(){
        return display;
    }
    //Implement a method updateDisplay that takes no parameters and returns nothing
    //The method should update the displayString with the current time in a format
    //  HH:MM
    public void updateDisplay(){
        String newDisplay = "";
        newDisplay += hours.getDisplayValue();
        newDisplay += ":";
        newDisplay += minutes.getDisplayValue();
        newDisplay += ":";
        newDisplay += seconds.getDisplayValue();
        if (beforeNoon = true){
            newDisplay += "AM";
        }
        else {
            newDisplay += "PM";
        }
        display = newDisplay;
    }
}

