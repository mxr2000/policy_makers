package util;

import model.*;

import java.util.List;

public class RequestUtil {
    public static CourseResponse getCourseInfo(int classId) {
        Request request = new Request();
        String path = "mooc-api/v1/lms/learn/course/chapter?cid=" + classId + "&sign=xjtu-82PF3807732790N&term=latest&uv_id=2628";
        return request.get(
                path,
                null,
                CourseResponse.class);
    }

    public static ProblemResponse getProblemInfo(int exerciseId, int skuId) {
        Request request = new Request();
        String path = "mooc-api/v1/lms/exercise/get_exercise_list/" + exerciseId + "/" + skuId + "/?term=latest&uv_id=2628";
        return request.get(
                path,
                null,
                ProblemResponse.class);
    }

    public static SkuIdResponse getSkuId(int classroomId, int leafId) {
        Request request = new Request();
        String path = "mooc-api/v1/lms/learn/leaf_info/" + classroomId + "/" + leafId + "/?sign=xjtu-82PF3807732790N&term=latest&uv_id=2628";
        return request.get(
                path,
                null,
                SkuIdResponse.class);
    }

    public static Request postRequest = new Request();

    public static AnswerResponse answerProblem(int classroomId, int problemId, List<String> answers) {
        String path = "mooc-api/v1/lms/exercise/problem_apply/?term=latest&uv_id=2628";
        return postRequest.post(path, new AnswerRequest(classroomId, problemId, answers), AnswerResponse.class);
    }

    public static void resetPostRequestAgent() {
        postRequest.resetAgent();
    }
}
