package com.example.quizapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvRequiredQuestions, tvCurrentQuestion;
    Button buttonA, buttonB, buttonC, buttonD, buttonSubmit;

    int score = 0;
    int currentQuestionIndex = 0;
    int requiredQuestions;
    int totalQuestions;
    String selectedAnswer = "";
    private List<QuestionAnswer> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        ActionBar supportActionBar = getSupportActionBar();

        if (supportActionBar != null) {
            supportActionBar.setDisplayShowHomeEnabled(true);
        }

        tvRequiredQuestions = findViewById(R.id.require_question);
        tvCurrentQuestion = findViewById(R.id.question);
        buttonA = findViewById(R.id.answerA);
        buttonB = findViewById(R.id.answerB);
        buttonC = findViewById(R.id.answerC);
        buttonD = findViewById(R.id.answerD);
        buttonSubmit = findViewById(R.id.submit);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);

        questions = new ArrayList<>();
        questions.add(new QuestionAnswer("Which company owns Android?","Google","Google","Apple", "Nokia","Samsung"));
        questions.add(new QuestionAnswer("Which one is not a programming language?","Cobra","Java","Kotlin","Cobra","Python"));
        questions.add(new QuestionAnswer("Who is the owner of Tesla?","Elon Musk","Ranchodas","P.Duterte","Melon Mask","Elon Musk"));
        questions.add(new QuestionAnswer("Who owns Apple?","Vanguard Grp","Snow White","Vanguard Grp","Tim Cook","Steve Knob"));
        questions.add(new QuestionAnswer("Which of the following is a web browser?","Firefox","Spider web","King Bowser","Sa Pari","Firefox"));
        questions.add(new QuestionAnswer("What was the name of first operating system?","GM-NAA I/O","GM-NAA I/O","GYM KA NA","EPOC","JIYOO I/O"));
        questions.add(new QuestionAnswer("Where was the world wide web invented?","Switzerland","New York","Switzerland","Germany","Ghana"));
        questions.add(new QuestionAnswer("Which institution is credited with creating the first website?","CERN","WHO","NASA","CERN","NATO"));
        questions.add(new QuestionAnswer("When was the first email sent?","1971","1982","1971","1992","1911"));
        questions.add(new QuestionAnswer("Do you think you will pass this semester?","Yes","Yes","No","Maybe","Don't care."));
        totalQuestions = questions.size();
        requiredQuestions = totalQuestions/2;
        Collections.shuffle(questions);
        questions = questions.subList(0, 5);
        tvRequiredQuestions.setText("Required Questions: " + requiredQuestions);
        loadNewQuestion();
    }
    public void onClick(View view){
        buttonA.setBackgroundColor(Color.WHITE);
        buttonB.setBackgroundColor(Color.WHITE);
        buttonC.setBackgroundColor(Color.WHITE);
        buttonD.setBackgroundColor(Color.WHITE);
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit){
            if(selectedAnswer.equals(questions.get(currentQuestionIndex).getCorrectAnswer())) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.DKGRAY);
        }
    }
    public void loadNewQuestion(){
        if(currentQuestionIndex == requiredQuestions){
            finishQuiz(requiredQuestions);
            return;
        }
        tvCurrentQuestion.setText(questions.get(currentQuestionIndex).getQuestion());
        buttonA.setText(questions.get(currentQuestionIndex).getOptionA());
        buttonB.setText(questions.get(currentQuestionIndex).getOptionB());
        buttonC.setText(questions.get(currentQuestionIndex).getOptionC());
        buttonD.setText(questions.get(currentQuestionIndex).getOptionD());
    }
    public void finishQuiz(int requiredQuestions){
        String passStatus = "";
        switch(score) {
            case 0:
            case 1:
            case 2:
                passStatus = "Please try again!";
                break;
            case 3:
                passStatus = "Good job!";
                break;
            case 4:
                passStatus = "Excellent work!";
                break;
            case 5:
                passStatus = "You are a genius!";
                break;
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score + " out of " + requiredQuestions)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }
    public void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

}