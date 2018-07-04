
import java.util.*;
public class Driver
{
    public static void main(String[] args)
    {
        VoteSystem newVote=new VoteSystem();
        newVote.addQues(true,"1+1=?");
        newVote.addAns("1");
        newVote.addAns("2");
        newVote.addAns("3");
        newVote.setCorrect(2);
        for(int i=0;i<20;i++)
        {
            Random rand=new Random();
            String ID=Integer.toString(rand.nextInt(1000));
            Student std=new Student(ID,rand.nextInt(2)+1);
            newVote.addStudent(std);
        }
        System.out.println(newVote.getStatis());
    }
}