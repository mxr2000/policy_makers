package model;

import java.util.List;


public class ProblemResponse {


    /**
     * type Problem = {
     *     problem_id: number,
     *     content: {
     *         library_id: number,
     *         ProblemID: number,
     *         Type: string,
     *         max_retry: number,
     *         TemplateID: number,
     *         ProblemType: number,
     *         LibraryID: number,
     *         Options: {
     *             value: string,
     *             key: string
     *         }[],
     *         HasRemark: boolean,
     *         template_id: number
     *     },
     *     score: number,
     *     user: {
     *         count: number,
     *         my_count: number,
     *         is_show_answer: boolean,
     *         is_show_explain: boolean
     *     }
     * }
     */
    public static class Problem {
        public static class Option {
            private String value;
            private String key;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public Option() {
            }

            public Option(String key, String value) {
                this.value = value;
                this.key = key;
            }
        }
        public static class ProblemUserInfo {
            private int count;
            private int my_count;
            private boolean is_show_answer;
            private boolean is_show_explain;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getMy_count() {
                return my_count;
            }

            public void setMy_count(int my_count) {
                this.my_count = my_count;
            }

            public boolean isIs_show_answer() {
                return is_show_answer;
            }

            public void setIs_show_answer(boolean is_show_answer) {
                this.is_show_answer = is_show_answer;
            }

            public boolean isIs_show_explain() {
                return is_show_explain;
            }

            public void setIs_show_explain(boolean is_show_explain) {
                this.is_show_explain = is_show_explain;
            }

            public ProblemUserInfo() {
            }
        }
        public static class ProblemContent {
            private int library_id;
            private int ProblemID;
            private String Type;
            private int max_retry;
            private int TemplateID;
            private int ProblemType;
            private int LibraryID;
            private List<Option> Options;
            private boolean HasRemark;
            private int template_id;

            public ProblemContent() {
            }

            public int getLibrary_id() {
                return library_id;
            }

            public void setLibrary_id(int library_id) {
                this.library_id = library_id;
            }

            public int getProblemID() {
                return ProblemID;
            }

            public void setProblemID(int problemID) {
                ProblemID = problemID;
            }

            public String getType() {
                return Type;
            }

            public void setType(String type) {
                Type = type;
            }

            public int getMax_retry() {
                return max_retry;
            }

            public void setMax_retry(int max_retry) {
                this.max_retry = max_retry;
            }

            public int getTemplateID() {
                return TemplateID;
            }

            public void setTemplateID(int templateID) {
                TemplateID = templateID;
            }

            public int getProblemType() {
                return ProblemType;
            }

            public void setProblemType(int problemType) {
                ProblemType = problemType;
            }

            public int getLibraryID() {
                return LibraryID;
            }

            public void setLibraryID(int libraryID) {
                LibraryID = libraryID;
            }

            public List<Option> getOptions() {
                return Options;
            }

            public void setOptions(List<Option> options) {
                Options = options;
            }

            public boolean isHasRemark() {
                return HasRemark;
            }

            public void setHasRemark(boolean hasRemark) {
                HasRemark = hasRemark;
            }

            public int getTemplate_id() {
                return template_id;
            }

            public void setTemplate_id(int template_id) {
                this.template_id = template_id;
            }
        }

        private int problem_id;
        private ProblemContent content;
        private int score;
        private ProblemUserInfo user;

        public int getProblem_id() {
            return problem_id;
        }

        public void setProblem_id(int problem_id) {
            this.problem_id = problem_id;
        }

        public ProblemContent getContent() {
            return content;
        }

        public void setContent(ProblemContent content) {
            this.content = content;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public ProblemUserInfo getUser() {
            return user;
        }

        public void setUser(ProblemUserInfo user) {
            this.user = user;
        }

        public Problem() {
        }
    }

    public static class ProblemResponseData {
        private int max_retry;
        private int show_answer;
        private List<Problem> problems;
        private int exercise_id;

        public int getMax_retry() {
            return max_retry;
        }

        public void setMax_retry(int max_retry) {
            this.max_retry = max_retry;
        }

        public int getShow_answer() {
            return show_answer;
        }

        public void setShow_answer(int show_answer) {
            this.show_answer = show_answer;
        }

        public List<Problem> getProblems() {
            return problems;
        }

        public void setProblems(List<Problem> problems) {
            this.problems = problems;
        }

        public int getExercise_id() {
            return exercise_id;
        }

        public void setExercise_id(int exercise_id) {
            this.exercise_id = exercise_id;
        }

        public ProblemResponseData() {
        }
    }

    private ProblemResponseData data;
    private boolean success;
    private String msg;

    public ProblemResponseData getData() {
        return data;
    }

    public void setData(ProblemResponseData data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ProblemResponse() {
    }
}
