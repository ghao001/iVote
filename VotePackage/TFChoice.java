package VotePackage;
class TFChoice extends Question
{
    public TFChoice()
    {
        addAnswers("");
    }
    //@override
    public void addAnswers(String inAns)
    {
        super.addAnswers("True");
        super.addAnswers("False");
    }
    //@override
    public String getAnswers()
    {
        String output=String.format("1.True\n2.False");
        return output;
    }

}