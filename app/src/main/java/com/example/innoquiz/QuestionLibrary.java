package com.example.innoquiz;

public class QuestionLibrary {
    //muutettu publiciksi?
    public String[] mQuestion = {
            "Kuinka virkeä olet?",
            "Sisällä vai ulkona?",
            "Maksullinen vai ilmainen?"
    };
    private String mChoices [][]= {
            {"Väsynyt", "Normaali", "Virkeä"},
            {"Sisällä", "Ulkona", "Molemmat"},
            {"Ilmainen", "Maksullinen", "Molemmat"},


    };

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }
}
