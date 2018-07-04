package VotePackage;
import java.util.*;

public class VoteSystem
{
    private Question question;
    private Map<String,Integer> studentsID;
    private boolean queType;
    private int ansNum;
    private Map<Integer,Integer> ansMap;
    private int correctNum;
    public VoteSystem()
    {
        correctNum=0;
        ansNum=0;
        question=new Question();
        studentsID=new HashMap<String,Integer>();
        ansMap=new HashMap<Integer,Integer>();
    }

    /** Adds a question.
     * @param boolean True if add a multiple choice question, false if add a True/False question
     * @param String Question body. */
    public void addQues(boolean type, String body)
    {
        if(type)
            question=new Question(body);
        else question=new TFChoice(body);
    }

    /** Adds a answer for question 
     * @param String answer body */
    public void addAns(String body)
    {
        question.addAnswers(body);
        ansNum++;
        ansMap.put(ansNum,0);
    }

    /** Sets a correct answer for question
     * @param int number of answer
      */
    public void setCorrect(int c)
    {
        question.setCorrect(c);
    }

    /** Takes a student into system 
     * @param Student A Sutdent object
    */
    public void addStudent(Student s)
    {
        if(s.getChoice()<=0||s.getChoice()>question.getAnsNum())
            throw new IllegalArgumentException();
        if(studentsID.containsKey(s.getID()))
        {    
            ansMap.put(studentsID.get(s.getID()),ansMap.get(studentsID.get(s.getID())-1));
            ansMap.put(s.getChoice(),ansMap.get(s.getChoice())+1);
            studentsID.put(s.getID(),s.getChoice());
        }
        else{
            ansMap.put(s.getChoice(),ansMap.get(s.getChoice())+1);
            studentsID.put(s.getID(),s.getChoice());
        }
        if(question.checkAns(s.getChoice()))
            correctNum++;
        
    }

    /** Returns statistics of students' answers 
     * @return String of statistics.
    */
    public String getStatis()
    {
        String result=String.format("%d students answered the question, %d% of them were correct.\n",studentsID.size(),correctNum/studentsID.size());
        for(int i=0;i<ansMap.size();i++)
        {
            int j=i+1;
            result+=String.format("%d% of students choose answer %d",ansMap.get(j)/studentsID.size(),j);
        }
        return result;
    }
    
}