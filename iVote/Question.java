package iVote;
import java.util.*;
class Question
{
    private String questionBody;
    private List<String> answers;
    private static int quesCounter=0;
    private int correctAns;

    public Question()
    {
        this("");
    }
    public Question(String body)
    {
        questionBody=body;
        answers=new ArrayList<Stirng>();
        quesCounter++;
        correctAns=new ArrayList<Integer>();
    }

    public void setQue(String inQue)
    {
        questionBody=inQue;
    } 
    public String getQue()
    {
        return questionBody;
    }
    public void setCorrect(int c)
    {
        if(c<0||c>answers.size())
            throw new IllegalArgumentException();
        else correctAns=c;
    }
    public boolean checkAns(int in)
    {
        if(in==correctAns)
            return true;
        else return false;
    }
    public void addAnswers(String inAns)
    {
        answers.add(inAns);
    }
    public String getAnswers()
    {
        String output="";
        char letter='A';
        for(int i=0;i<answers.size();i++)
        {
            output+=String.format("%c.%s\n",letter,answers.get(i));
            letter++;
        }
        return output;
    }
    public String toStirng()
    {
        String output;
        output=Stirng.format("Problem %d:\n%s\n%s\n",quesCounter,questionBody,getAnswers());
        return output;
    }
    public int getAnsNum()
    {
        return answers.size();
    }
}