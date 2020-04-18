import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam {

    /**
     * Number of lines a single question takes in the exam file.
     */
    private static final int LINES_IN_QUESTION = 5;

    /**
     * The max grade that can be received in the exam.
     */
    private static final int EXAM_MAX_GRADE = 100;

    /**
     * Exam questions
     */
    private List<Question> questions;

    /**
     * Constructor.
     *
     * @param examPath path to the exam's file
     * @throws FileNotFoundException in case the file is not found
     */
    public Exam(String examPath) throws FileNotFoundException {
        this.questions = this.readQuestions(examPath);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Saves the user's answer to the given question.
     *
     * @param question question to answer
     * @param answer   user's answer
     */
    public void submitAnswer(Question question, String answer) {
        question.setUserAnswer(answer);
    }

    /**
     * Calculates the exam's grade.
     *
     * @return grade
     */
    public int calculateGrade() {
        int numOfCorrectAnswers = 0;

        for (Question question : this.questions) {

            if (question.getCorrectAnswer().equals(question.getUserAnswer())) {
                numOfCorrectAnswers++;
            }
        }

        return (numOfCorrectAnswers / this.questions.size()) * EXAM_MAX_GRADE;
    }

    /**
     * Reads the exam's questions from a file to a list.
     *
     * @param examPath path to the exam's file
     * @return list of questions
     * @throws FileNotFoundException in case the file is not found
     */
    private List<Question> readQuestions(String examPath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(examPath));
        List<String> fileLines = new ArrayList<>(LINES_IN_QUESTION);
        List<Question> questions = new ArrayList<>();
        Question currQuestion;

        while (input.hasNext()) {
            fileLines.add(input.nextLine());

            if (fileLines.size() == LINES_IN_QUESTION) {

                // Add the new question to the list of questions
                currQuestion = new Question(fileLines.remove(0), fileLines);
                questions.add(currQuestion);

                // Empty the list of read strings from the file
                fileLines = new ArrayList<>(LINES_IN_QUESTION);
            }
        }
        input.close();

        return questions;
    }
}
