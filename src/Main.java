import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    private static final String EXAM_PATH = "src/exam.txt";

    public static void main(String[] args) {
        Exam exam = null;
        try {
            exam = new Exam(EXAM_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Question> questions = exam.getQuestions();

        for (Question question : questions) {
            System.out.println(question.getQuestion());

            for (String possibleAnswer : question.getPossibleAnswers()) {
                System.out.println(possibleAnswer);
            }
            System.out.println();
        }

    }
}
