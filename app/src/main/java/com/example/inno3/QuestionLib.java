package com.example.inno3;

public class QuestionLib {
    public String[] mQuestions = {
            "Kuinka virkeä olet?",
            "Sisällä vai ulkona?",
            "Maksullinen vai ilmainen?"
    };

    private String mChoices [][] = {
        {"Väsynyt", "Normaali", "Virkeä"},
        {"Sisällä", "Ulkona", "Ei väliä"},
        {"Ilmainen", "Maksullinen", "Ei väliä"},

    };
    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }
    public String getChoice1(int a){
        String choice1 = mChoices[a][0];
        return choice1;
    }
    public String getChoice2(int a){
        String choice2 = mChoices[a][1];
        return choice2;
    }
    public String getChoice3(int a){
        String choice3 = mChoices[a][2];
        return choice3;
    }
}
