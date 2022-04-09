package model;

import java.util.List;

public class CourseResponse {

    /**
     * type Leaf = {
     *     id: number,
     *     leaf_type: number,
     *     chapter_id: number,
     *     section_id: number,
     *
     * }
     */
    public static class Leaf {
        private int id;
        private int leaf_type;
        private int chapter_id;
        private int section_id;
        private List<Leaf> leaf_list;

        public Leaf() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLeaf_type() {
            return leaf_type;
        }

        public void setLeaf_type(int leaf_type) {
            this.leaf_type = leaf_type;
        }

        public int getChapter_id() {
            return chapter_id;
        }

        public void setChapter_id(int chapter_id) {
            this.chapter_id = chapter_id;
        }

        public int getSection_id() {
            return section_id;
        }

        public void setSection_id(int section_id) {
            this.section_id = section_id;
        }

        public List<Leaf> getLeaf_list() {
            return leaf_list;
        }

        public void setLeaf_list(List<Leaf> leaf_list) {
            this.leaf_list = leaf_list;
        }
    }


    public static class Chapter {
        private int id;
        private List<Leaf> section_leaf_list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Leaf> getSection_leaf_list() {
            return section_leaf_list;
        }

        public void setSection_leaf_list(List<Leaf> section_leaf_list) {
            this.section_leaf_list = section_leaf_list;
        }

        public Chapter() {
        }
    }

    public static class CourseData {
        private int course_id;
        private List<Chapter> course_chapter;

        public int getCourse_id() {
            return course_id;
        }

        public void setCourse_id(int course_id) {
            this.course_id = course_id;
        }

        public List<Chapter> getCourse_chapter() {
            return course_chapter;
        }

        public void setCourse_chapter(List<Chapter> course_chapter) {
            this.course_chapter = course_chapter;
        }

        public CourseData() {
        }
    }

    private boolean success;
    private CourseData data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CourseData getData() {
        return data;
    }

    public void setData(CourseData data) {
        this.data = data;
    }

    public CourseResponse() {
    }
}
