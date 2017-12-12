import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends Actor
{
    private int studentNumber;
    private String firstName;
    private String lastName;
    private int gradeLevel;
    private double average;
    private boolean it;
    private String upKey;
    private String downKey;
    private String leftKey;
    private String rightKey;
    private int itDelay;
    
    public Student( int number, String first, String last, int grade, double avg, boolean isIt )
    {
       studentNumber = number;
       firstName = first;
       lastName = last;
       gradeLevel = grade;
       average = avg;
       it = isIt;
       
       if( studentNumber == 1 )
       {
           upKey = "w";
           downKey = "s";
           leftKey = "a";
           rightKey = "d";
       }
       else if( studentNumber == 2 )
       {
           upKey = "u";
           downKey = "j";
           leftKey = "h";
           rightKey = "k";
       }
       else
       {
           upKey = "up";
           downKey = "down";
           leftKey = "left";
           rightKey = "right";
       }
       
       itDelay = 200;
       
       if( it == true )
       {
           setImage("ppl1.png");
       }
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public int getGradeLevel()
    {
        return gradeLevel;
    }
    
    public boolean it()
    {
        return it;
    }
    
    public double average()
    {
        return average;
    }
    
    public String toString()
    {
        return String.format("Name: %15s, %10s\nGrade: %26d\nAvg: %27.1f%% ", lastName, firstName, gradeLevel, average);
    }
    
    private void checkCollision()
    {
        Actor otherStudent = getOneIntersectingObject(Student.class);
        if( otherStudent != null )
        {
            if( itDelay >= 200 )
            {
                if( it == true )
                {
                    it = false;
                    setImage("ppl3.png");
                    itDelay = 0;
                }
                else
                {
                    it = true;
                    setImage("ppl1.png");
                    itDelay = 0;
                }
            }
        }
    }
    
    private void movement()
    {
        
        if( Greenfoot.isKeyDown(upKey) == true)
        {
            setLocation( getX(), getY() - 3 );
            
        }
        
        if( Greenfoot.isKeyDown(downKey) == true)
        {
            setLocation( getX(), getY() + 3 );
            
        }
        
        if( Greenfoot.isKeyDown(leftKey) == true)
        {
            setLocation( getX() - 3 , getY() );
            
        }
        
        if( Greenfoot.isKeyDown(rightKey) == true)
        {
            setLocation( getX() + 3 , getY() );
            
        }
    }
    
    /**
     * Act - do whatever the Student wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        checkCollision();
        movement();
        
        if( Greenfoot.mouseClicked(this))
        { 
            System.out.println( toString() );
        }
        
        itDelay++;
    }    
}
