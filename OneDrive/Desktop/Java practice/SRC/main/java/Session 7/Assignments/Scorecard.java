public class Scorecard {
    private boolean[] results;
    private final int totalQuestions;
    private int answerCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.answerCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount < totalQuestions) {
            results[answerCount] = correct;
            answerCount++;
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}