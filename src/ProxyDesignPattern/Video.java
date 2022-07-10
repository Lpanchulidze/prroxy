package ProxyDesignPattern;

public class Video {
    public String id;
    public String title;
    public String data;

    /*Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }*/

    private Video(VideoBuild videoBuild) {
        this.id = videoBuild.id;
        this.title = videoBuild.title;
        this.data = "Random video.";
    }

    public static class VideoBuild {
        private String id;
        private String title;

        public VideoBuild setId(String id) {
            this.id = id;
            return this;
        }
        public VideoBuild setTitle(String title) {
            this.title = title;
            return this;
        }
        public Video build() {
            return new Video(this);
        }
    }
}