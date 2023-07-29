package com.example.quiz_app;

public class Questions {


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    private String question;
    private String variantA;



    private String variantB;

    public String getVariantA() {
        return variantA;
    }

    public void setVariantA(String variantA) {
        this.variantA = variantA;
    }

    public String getVariantB() {
        return variantB;
    }

    public void setVariantB(String variantB) {
        this.variantB = variantB;
    }

    public String getVariantC() {
        return variantC;
    }

    public void setVariantC(String variantC) {
        this.variantC = variantC;
    }

    public String getVariantD() {
        return variantD;
    }

    public void setVariantD(String variantD) {
        this.variantD = variantD;
    }

    public Questions(String question, String variantA, String variantB, String variantC, String variantD, String answer) {
        this.question = question;
        this.variantA = variantA;
        this.variantB = variantB;
        this.variantC = variantC;
        this.variantD = variantD;
        this.answer = answer;
    }

    private String variantC;
    private String variantD;
    private String answer;

}
