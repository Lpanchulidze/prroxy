package ProxyDesignPattern;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {     // დაყოვნების იმიტაცია
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {  //გამოაქვს სერვერთან დაკავშირების ტექსტები
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    private HashMap<String, Video> getRandomVideos() {  //ხუთი ვიდეოს მოძებნის იმიტაცია
        System.out.print("Downloading populars... ");

        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<String, Video>();
        hmap.put("catzzzzzzzzz", new Video.VideoBuild().setId("sadgahasgdas").setTitle("Catzzzz.avi").build());
        hmap.put("mkafksangasj", new Video.VideoBuild().setId("mkafksangasj").setTitle("Dog play with ball.mp4").build());
        hmap.put("dancesvideoo", new Video.VideoBuild().setId("asdfas3ffasd").setTitle("Dancing video.mpq").build());
        hmap.put("dlsdk5jfslaf", new Video.VideoBuild().setId("dlsdk5jfslaf").setTitle("Barcelona vs RealM.mov").build());
        hmap.put("3sdfgsd1j333", new Video.VideoBuild().setId("3sdfgsd1j333").setTitle("Programing lesson#1.avi").build());

        System.out.print("Done!" + "\n");
        return hmap;
    }

    private Video getSomeVideo(String videoId) { // რანდომული ვიდეოს ძებნის იმიტაცია
        System.out.print("Downloading video... ");

        experienceNetworkLatency();
        Video video = new Video.VideoBuild().setId(videoId).setTitle("Some video title").build();

        System.out.print("Done!" + "\n");
        return video;
    }

}
