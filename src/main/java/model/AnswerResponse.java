package model;

import java.util.List;

public class AnswerResponse {
    public static class AnswerData {
        private int count;
        private boolean is_show_answer;
        private float my_score;
        private int my_count;
        private boolean is_right;
        private boolean is_correct;
        private List<String> answer;
        private List<String> my_answer;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public boolean isIs_show_answer() {
            return is_show_answer;
        }

        public void setIs_show_answer(boolean is_show_answer) {
            this.is_show_answer = is_show_answer;
        }

        public float getMy_score() {
            return my_score;
        }

        public void setMy_score(float my_score) {
            this.my_score = my_score;
        }

        public int getMy_count() {
            return my_count;
        }

        public void setMy_count(int my_count) {
            this.my_count = my_count;
        }

        public boolean isIs_right() {
            return is_right;
        }

        public void setIs_right(boolean is_right) {
            this.is_right = is_right;
        }

        public boolean isIs_correct() {
            return is_correct;
        }

        public void setIs_correct(boolean is_correct) {
            this.is_correct = is_correct;
        }

        public List<String> getAnswer() {
            return answer;
        }

        public void setAnswer(List<String> answer) {
            this.answer = answer;
        }

        public List<String> getMy_answer() {
            return my_answer;
        }

        public void setMy_answer(List<String> my_answer) {
            this.my_answer = my_answer;
        }
    }

    private AnswerData data;

    public AnswerData getData() {
        return data;
    }

    public void setData(AnswerData data) {
        this.data = data;
    }
}
