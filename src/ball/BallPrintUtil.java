package ball;

import java.text.DecimalFormat;
import java.util.List;

public class BallPrintUtil {

    public static void printBalls(List<Ball> redBallsCopy) {
        System.out.println();
        System.out.println("------------");
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.no);
        }

        System.out.println();

        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.count);
        }

        System.out.println();
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            DecimalFormat df = new DecimalFormat("00.0  ");
            System.out.printf("%s" ,df.format(ball.percent));
        }
        System.out.println();
        System.out.println("------------");
    }
    public static void printBalls20(List<Ball> redBallsCopy) {
        System.out.println();
        System.out.println("20------------20");
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.no);
        }

        System.out.println();

        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.count20);
        }

        System.out.println();
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            DecimalFormat df = new DecimalFormat("00.0  ");
            System.out.printf("%s" ,df.format(ball.percent20));
        }
        System.out.println();
        System.out.println("20------------20");
    }
    public static void printBalls30(List<Ball> redBallsCopy) {
        System.out.println();
        System.out.println("30------------30");
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.no);
        }

        System.out.println();

        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.count30);
        }

        System.out.println();
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            DecimalFormat df = new DecimalFormat("00.0  ");
            System.out.printf("%s" ,df.format(ball.percent30));
        }
        System.out.println();
        System.out.println("30------------30");
    }
    public static void printBalls50(List<Ball> redBallsCopy) {
        System.out.println();
        System.out.println("30------------30");
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.no);
        }

        System.out.println();

        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.count50);
        }

        System.out.println();
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            DecimalFormat df = new DecimalFormat("00.0  ");
            System.out.printf("%s" ,df.format(ball.percent50));
        }
        System.out.println();
        System.out.println("50------------50");
    }

    public static void printBalls100(List<Ball> redBallsCopy) {
        System.out.println();
        System.out.println("100------------100");
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.no);
        }

        System.out.println();

        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.count100);
        }

        System.out.println();
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            DecimalFormat df = new DecimalFormat("00.0  ");
            System.out.printf("%s" ,df.format(ball.percent100));
        }
        System.out.println();
        System.out.println("100------------100");
    }


    public static void printBalls10(List<Ball> redBallsCopy) {
        System.out.println();
        System.out.println("10------------10");
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.no);
        }

        System.out.println();

        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.count10);
        }

        System.out.println();
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            DecimalFormat df = new DecimalFormat("00.0  ");
            System.out.printf("%s" ,df.format(ball.percent10));
        }
        System.out.println();
        System.out.println("10------------10");
    }



    public static void printBalls100_10(List<Ball> redBallsCopy) {
        System.out.println();
        System.out.println("100-10------------100-10");
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            System.out.printf("%-6d" ,ball.no);
        }

        System.out.println();
        for(Ball ball : redBallsCopy){
            if(ball.no==0)continue;
            DecimalFormat df = new DecimalFormat("00.0  ");
            if(ball.percent100-ball.percent10+ball.percent100<0){

                System.out.printf("%s" ,df.format(0));
            } else
                System.out.printf("%s" ,df.format(ball.percent100-ball.percent10+ball.percent100));
        }
        System.out.println();
        System.out.println("100-10------------100-10");
    }
}
