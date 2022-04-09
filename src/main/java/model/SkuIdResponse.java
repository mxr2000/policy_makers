package model;

public class SkuIdResponse {

    public static class SkuIdData {
        private int sku_id;
        private SkuIdContentInfo content_info;

        public SkuIdContentInfo getContent_info() {
            return content_info;
        }

        public void setContent_info(SkuIdContentInfo content_info) {
            this.content_info = content_info;
        }

        public int getSku_id() {
            return sku_id;
        }

        public void setSku_id(int sku_id) {
            this.sku_id = sku_id;
        }

        public static class SkuIdContentInfo {
            private int leaf_type_id;

            public int getLeaf_type_id() {
                return leaf_type_id;
            }

            public void setLeaf_type_id(int leaf_type_id) {
                this.leaf_type_id = leaf_type_id;
            }

            public SkuIdContentInfo(int leaf_type_id) {
                this.leaf_type_id = leaf_type_id;
            }
        }
    }

    private SkuIdData data;

    public SkuIdData getData() {
        return data;
    }

    public void setData(SkuIdData data) {
        this.data = data;
    }
}
