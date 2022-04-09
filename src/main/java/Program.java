import model.AnswerResponse;
import model.CourseResponse;
import model.ProblemResponse;
import model.SkuIdResponse;
import util.Request;
import util.RequestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        getAllProblems(11561585);
        //AnswerResponse response = RequestUtil.answerProblem(11561618, 17204265, List.of("C"));
        System.out.println();
    }

    public static void getAllProblems(int classroomId) {
        CourseResponse courseInfo = RequestUtil.getCourseInfo(classroomId);
        List<CourseResponse.Chapter> chapters = courseInfo.getData().getCourse_chapter();
        for (CourseResponse.Chapter chapter : chapters) {
            System.out.println("processing chapter " + chapter.getId());
            int leafId = 0;
            for (CourseResponse.Leaf leaf : chapter.getSection_leaf_list()) {
                if (leaf.getLeaf_list() != null) {
                    continue;
                }
                leafId = leaf.getId();
            }
            System.out.println("\tproblem leaf id " + leafId);
            SkuIdResponse skuIdResponse = RequestUtil.getSkuId(classroomId, leafId);
            int skuId = skuIdResponse.getData().getSku_id();
            int exerciseId = skuIdResponse.getData().getContent_info().getLeaf_type_id();
            System.out.println("\tskuId " + skuId + " exerciseId " + exerciseId);
            ProblemResponse response = RequestUtil.getProblemInfo(exerciseId, skuId);
            System.out.println("\t" + response.getData().getExercise_id() + " has " + response.getData().getProblems().size() );
            for (ProblemResponse.Problem problem : response.getData().getProblems()) {
                answerProblem(classroomId, problem);
            }
        }
    }

    public static void answerProblem(int classroomId, ProblemResponse.Problem problem) {
        String type = problem.getContent().getType();
        List<ProblemResponse.Problem.Option> options = problem.getContent().getOptions();
        List<List<String>> combinations = new ArrayList<>();
        if ("SingleChoice".equals(type) || "Judgement".equals(type)) {
            options.forEach(o -> combinations.add(List.of(o.getKey())));
        } else {
            fillCombinations(combinations, options);
        }
        for (List<String> combination : combinations) {
            System.out.println("\t\ttry " + combination + " on problem " + problem.getProblem_id());
            AnswerResponse response = RequestUtil.answerProblem(classroomId, problem.getProblem_id(), combination);
            while (response == null || response.getData() == null) {

                System.out.println("\t\tdetected");
                RequestUtil.resetPostRequestAgent();
                sleep();

                System.out.println("\t\ttry " + combination + " on problem " + problem.getProblem_id());
                response = RequestUtil.answerProblem(classroomId, problem.getProblem_id(), combination);
            }
            if (response.getData().getAnswer() != null) {
                break;
            }
            /*sleep();*/
        }
        /*System.out.println();
        sleep();*/
    }

    private static Random random = new Random();
    public static void sleep() {
        try {
            int interval = random.nextInt(30000, 32000);
            Thread.sleep(interval);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillCombinations(List<List<String>> combinations, List<ProblemResponse.Problem.Option> options) {
        for (int size = 1; size <= options.size(); size++) {
            fillCombinationsWithSize(combinations, options, size);
        }
    }

    private static void fillCombinationsWithSize(List<List<String>> combinations, List<ProblemResponse.Problem.Option> options, int size) {
        fill(combinations, options, new ArrayList<>(), 0, size);
    }

    private static void fill(List<List<String>> combinations, List<ProblemResponse.Problem.Option> options, List<String> currents, int index, int size) {
        if (currents.size() == size) {
            combinations.add(new ArrayList<>(currents));
            return;
        }
        for (int i = index; i < options.size(); i++) {
            currents.add(options.get(i).getKey());
            fill(combinations, options, currents, i + 1, size);
            currents.remove(currents.size() - 1);
        }
    }
}
