public class Student
{
    private String ID;
    private int choice;
    
    public Student(String in)
    {
        ID=in;
    }
    public Student(String in,int inChoice)
    {
        ID=in;
        choice=inChoice;
    }
    public void setID(String in)
    {
        ID=in;
    }
    public String getID()
    {
        return ID;
    }
    public void setChoice(char in)
    {
        if(in>90)
            in-=32;
        choice=in-64;
        
    }
    public void setChoice(int in)
    {
        choice=in;
    }
    public int getChoice()
    {
        return choice;
    }
}