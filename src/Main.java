import java.util.*;

/*
-------------------------------------
   -- author
   s21116
   grupa: 14c
   Imie i nazwisko: Błażej Kozieł
-------------------------------------
 */

public class Main {
    public static void main(String[] args) {

        String training = System.getProperty("user.dir")+"\\iris_training.txt";
        String test = System.getProperty("user.dir")+"\\iris_test.txt";
        try {
            Data trainingData = new Data(training);
            Data testData = new Data(test);
            List<List<Double>> t1 = testData.getX();
            String result; int correctAnswers = 0, allAnswers = t1.size();
            System.out.println("Enter \"k\": ");
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
/*
            for (int i=1; i<=120; i++){
                correctAnswers=0;
                for (List<Double> doubles : t1) {
                    result = Classification.classify(Normalization.normalize(trainingData.getX(), doubles), i);
                    if (result.length()==doubles.get(doubles.size()-1)){
                        correctAnswers++;
                    }
                }
                //System.out.println("accuracy of the experiment: "+100*(double) correctAnswers/allAnswers+"");
                System.out.println(correctAnswers);
            }

 */
            for (List<Double> doubles : t1) {
                result = Classification.classify(Normalization.normalize(trainingData.getX(), doubles), k);
                if (result.length()==doubles.get(doubles.size()-1)){
                    correctAnswers++;
                }
            }
            System.out.println("amount of correct answers: "+correctAnswers);
            System.out.println("amount of all answers: "+allAnswers);
            System.out.println("accuracy of the experiment: "+100*(double) correctAnswers/allAnswers+"%");


            int number = trainingData.getX().get(0).size()-1;
            for (;;){
                System.out.println("\nchoose: \n- 1 to enter a vector\n- 2 to leave ");
                int input = in.nextInt();
                if (input==2){
                    break;
                }else if (input==1) {
                    System.out.println("type " + number + " numbers and confirm each of them with enter ");
                    List<Double> array = new ArrayList<>();
                    String q;
                    for (int c = 0; c < number; c++) {
                        q = in.next();
                        q = q.replaceAll(",", ".");
                        array.add(Double.parseDouble(q));
                    }
                    System.out.print("Now, tpye \"k\":  ");
                    k = in.nextInt();
                    q = Classification.classify(Normalization.normalize(trainingData.getX(),array), k);
                    System.out.println("Answer: "+q);
                } else {
                    System.out.println("Incvalid value, please try again");
                }
            }

        } catch (Exception e) {
            System.out.println("Incorrect path/s or file/s is/are empty");
            e.printStackTrace();
        }
    }
}
