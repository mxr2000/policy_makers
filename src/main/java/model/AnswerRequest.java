package model;

import java.util.List;

public class AnswerRequest {
    private int classroom_id;
    private int problem_id;
    private List<String> answer;

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public AnswerRequest(int classroom_id, int problem_id, List<String> answer) {
        this.classroom_id = classroom_id;
        this.problem_id = problem_id;
        this.answer = answer;
    }

    public int getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(int problem_id) {
        this.problem_id = problem_id;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
