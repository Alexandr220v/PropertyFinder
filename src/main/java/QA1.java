/**
 * Created by Alexandr on 22.04.2017.
 */
public class QA1 {

    public double calc(double first , double second, String operation) {


        if (operation.equals("Sum")) {
            double sum = first + second;
            return sum;
        } else if (operation.equals("Diff")) {

            double diff = first - second;
            return diff;
        } else if (operation.equals("Mult")) {
            double mult = first * second;
            return mult;
        } else if (operation.equals("Div")) {
            double div = first / second;
            return div;
        } else
        return -1;
    }

    public static void main(String[] args) {

        QA1 qa1 = new QA1();
        System.out.println(qa1.calc(6,0,"Div"));
        qa1.calc(2,4,"Mult");

    }
}
