package com.example.quizapplication;

import java.util.ArrayList;
/*
public class QuestionAnswer {

    public static String question[] = {
            "Which company owns Android?",
            "Which one is not a programming language?",
            "Who is the owner of Tesla?",
            "Who owns Apple?",
            "Which of the following is a web browser?",
            "What was the name of first operating system?",
            "Where was the world wide web invented?",
            "Which institution is credited with creating the first website?",
            "When was the first email sent?",
            "Do you think you will pass this semester?"
    };
    public static String[][] answers = {
            {"Google","Apple", "Nokia","Samsung"},
            {"Java","Kotlin","Cobra","Python"},
            {"Ranchodas","P.Duterte","Melon Mask","Elon Musk"},
            {"Snow White","Vanguard Grp","Tim Cook","Steve Knob"},
            {"Spider web","King Bowser","Sa Pari","Firefox"},
            {"GM-NAA I/O","GYM KA NA","EPOC","JIYOO I/O"},
            {"United States","Switzerland","Germany","United Kingdom"},
            {"United Nations","NASA","CERN","NATO"},
            {"1982","1971","1992","1971"},
            {"Yes","No","Maybe","Don't care."}
    };
    public static String correctAnswers[] = {
            "Google","Cobra","Elon Musk","Vanguard Grp",
            "Google Chrome","GM-NAA I/O","Switzerland",
            "CERN","1971","Yes"
    };
}
*/

public class QuestionAnswer {
    private String question;
    private String correctAnswer;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private ArrayList<QuestionAnswer> questions;

    public QuestionAnswer(String question, String correctAnswer, String optionA,String optionB, String optionC, String optionD){
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    public String getOptionA() {
        return optionA;
    }
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }
    public String getOptionB() {
        return optionB;
    }
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }
    public String getOptionC() {
        return optionC;
    }
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }
    public String getOptionD() {
        return optionD;
    }
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
}

