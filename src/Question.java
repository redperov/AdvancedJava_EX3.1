import java.util.Collections;
import java.util.List;

public class Question {

    private String question;
    private List<String> possibleAnswers;
    private String correctAnswer;
    private String userAnswer;

    /**
     * Constructor.
     * @param question the question string
     * @param possibleAnswers possible answers to the question
     */
    public Question(String question, List<String> possibleAnswers) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;

        // The correct answer is the first possible answer
        this.correctAnswer = possibleAnswers.get(0);
    }

    public String getQuestion() {
        return this.question;
    }

    /**
     * Returns the possible answers of the question shuffled.
     * @return shuffled possible answers
     */
    public List<String> getPossibleAnswers() {
        Collections.shuffle(this.possibleAnswers);
        return this.possibleAnswers;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
