public class TheReason {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        singSong();
    }

    public static void animateText(String text, long delay) {
        synchronized (lock) {
            for (char c : text.toCharArray()) {
                System.out.print(c);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

    public static void singLyric(String lyric, long speed) {
        animateText(lyric, speed);
    }

    public static void singSong() throws InterruptedException {
        String[][] lyrics = {
            {"I'm not a perfect person", "130"},
            {"There's many things I wish I didn't do", "130"},
            {"But I continue learning", "130"},
            {"I never meant to do those things to you", "110"},
            {"And so I have to say before I go", "120"},
            {"That I just want you to know", "120"},
            {"I've found a reason for me", "140"},
            {"To change who I used to be", "140"},
            {"A reason to start over new", "140"}
        };

        for (int i = 0; i < lyrics.length; i++) {
            String lyric = lyrics[i][0];
            long speed = Long.parseLong(lyrics[i][1]);

            // Sing the current lyric
            singLyric(lyric, speed);

            // Delay of 1 second before the next lyric
            if (i < lyrics.length - 1) { // Avoid delay after the last lyric
                Thread.sleep(2000);
            }
        }
    }
}
