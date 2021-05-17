package ball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GetNextSerialsModel {

    public static void getNextSerials() throws IOException {
        List<Integer> predictSet = new ArrayList<>();
        List<Integer> predictB = new ArrayList<>();
        int shot = 0;
        List<Set<Integer>> red = new ArrayList<Set<Integer>>();
        List<Integer> blue = new ArrayList<>();
        List<Ball> redBalls = new ArrayList<>();
        List<Ball> blueBalls = new ArrayList<>();
        for(int i=0;i<34; ++i){
            Ball ball = new Ball();
            ball.no=i;
            redBalls.add(ball);
        }
        for(int i=0;i<17; ++i){
            Ball ball = new Ball();
            ball.no=i;
            blueBalls.add(ball);
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("f:\\\\study\\caipiao\\data.txt"));
        String str = null;
        int count = 0;
        ShotTotalBall shotTotalBall = new ShotTotalBall();
        while((str=bufferedReader.readLine())!=null && str.length()>0){
            count++;

            if(count==172){
                System.out.print("");
            }
            calcBall(predictSet,predictB,shotTotalBall, red, blue, redBalls, blueBalls, str, count);
            getPredictSet2(predictSet,predictB, redBalls, blueBalls, count);
        }

        System.out.println("count=" + count + ",shotRedTotal=" + shotTotalBall.red + ",shotBlueTotal=" + shotTotalBall.blue);
    }

    private static ShotTotalBall calcBall(List<Integer> predictSet, List<Integer> predictB,ShotTotalBall shotTotalBall, List<Set<Integer>> red, List<Integer> blue, List<Ball> redBalls, List<Ball> blueBalls, String str, int count) {
        int shot=0,shotB=0;
        String[] sstr = str.split("[    \t]+");
        Set<Integer> rs = new HashSet<>();
        red.add(rs);
        for(int i=1; i<7; ++i){
            int tmp = Integer.parseInt(sstr[i]);
            if(predictSet.contains(tmp)){
                shot++;
            }
            rs.add(tmp);
            redBalls.get(tmp).count++;
            redBalls.get(tmp).count10++;
            redBalls.get(tmp).count20++;
            redBalls.get(tmp).count30++;
            redBalls.get(tmp).count50++;
            redBalls.get(tmp).count100++;
        }

        if(count>10){
            for(Ball ball : redBalls) {
                if (red.get(count - 11).contains(ball.no)) {
                    ball.count10--;
                }
            }
        }
        if(count>20){
            for(Ball ball : redBalls) {
                if (red.get(count - 21).contains(ball.no)) {
                    ball.count20--;
                }
            }
        }
        if(count>30){
            for(Ball ball : redBalls) {
                if (red.get(count - 31).contains(ball.no)) {
                    ball.count30--;
                }
            }
        }
        if(count>50){

            for(Ball ball : redBalls) {
                if (red.get(count - 51).contains(ball.no)) {
                    ball.count50--;
                }
            }
        }
        if(count>100){
            for(Ball ball : redBalls) {
                if (red.get(count - 101).contains(ball.no)) {
                    ball.count100--;
                }
            }
        }
        Integer tmp = Integer.parseInt(sstr[7]);
        if(predictB.contains(tmp)){
            shotB++;
        }
        blue.add(tmp);
        blueBalls.get(tmp).count++;
        blueBalls.get(tmp).count10++;
        blueBalls.get(tmp).count20++;
        blueBalls.get(tmp).count30++;
        blueBalls.get(tmp).count50++;
        blueBalls.get(tmp).count100++;
        if(count>10){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 11).equals(ball.no)) {
                    blueBalls.get(ball.no).count10--;
                }
            }
        }
        if(count>20){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 21).equals(ball.no)) {
                    blueBalls.get(ball.no).count20--;
                }
            }
        }
        if(count>30){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 31).equals(ball.no)) {
                    blueBalls.get(ball.no).count30--;
                }
            }
        }
        if(count>50){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 51).equals(ball.no)) {
                    blueBalls.get(ball.no).count50--;
                }
            }
        }
        if(count>100){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 101).equals(ball.no)) {
                    blueBalls.get(ball.no).count100--;
                }
            }
        }

        for(int i=1;i<34; ++i){
            redBalls.get(i).percent = (redBalls.get(i).count*1000/count)/10.0f;
            int tmpBy = count<10?count:10;
            redBalls.get(i).percent10 = (redBalls.get(i).count10*1000/tmpBy)/10.0f;
            tmpBy = count<20?count:20;
            redBalls.get(i).percent20 = (redBalls.get(i).count20*1000/tmpBy)/10.0f;
            tmpBy = count<30?count:30;
            redBalls.get(i).percent30 = (redBalls.get(i).count30*1000/tmpBy)/10.0f;
            tmpBy = count<50?count:50;
            redBalls.get(i).percent50 = (redBalls.get(i).count50*1000/tmpBy)/10.0f;
            tmpBy = count<100?count:100;
            redBalls.get(i).percent100 = (redBalls.get(i).count100*1000/tmpBy)/10.0f;
        }
        for(int i=1;i<17; ++i){
            blueBalls.get(i).percent = (blueBalls.get(i).count*1000/count)/10.0f;
            int tmpBy = count<10?count:10;
            blueBalls.get(i).percent10 = (blueBalls.get(i).count10*1000/tmpBy)/10.0f;
            tmpBy = count<20?count:20;
            blueBalls.get(i).percent20 = (blueBalls.get(i).count20*1000/tmpBy)/10.0f;
            tmpBy = count<30?count:30;
            blueBalls.get(i).percent30 = (blueBalls.get(i).count30*1000/tmpBy)/10.0f;
            tmpBy = count<50?count:50;
            blueBalls.get(i).percent50 = (blueBalls.get(i).count50*1000/tmpBy)/10.0f;
            tmpBy = count<100?count:100;
            blueBalls.get(i).percent100 = (blueBalls.get(i).count100*1000/tmpBy)/10.0f;
        }

//            System.out.println("predictSet=" + predictSet);
//            System.out.println("rs=" + rs);
//            System.out.println("count=" + count);
        if(shot>=4){
            shotTotalBall.red++;
            System.out.println("count=" + count + ",shot=" + shot);
            System.out.println("predictSet=" + predictSet);
//            BallPrintUtil.printBalls10(redBalls);
//            BallPrintUtil.printBalls20(redBalls);
//            BallPrintUtil.printBalls30(redBalls);
//            BallPrintUtil.printBalls50(redBalls);
//            BallPrintUtil.printBalls100(redBalls);
//            BallPrintUtil.printBalls100_10(redBalls);
            System.out.println(str);
        }
        if(shotB>=1){
            shotTotalBall.blue++;
            System.out.println("count=" + count + ",shotB=" + shotB);
            System.out.println("predictB=" + predictB);
            BallPrintUtil.printBalls10(blueBalls);
            BallPrintUtil.printBalls20(blueBalls);
            BallPrintUtil.printBalls30(blueBalls);
            BallPrintUtil.printBalls50(blueBalls);
            BallPrintUtil.printBalls100(blueBalls);
            BallPrintUtil.printBalls100_10(blueBalls);
            System.out.println(str);
        }
        return shotTotalBall;
    }

    private static void getPredictSet(List<Integer> predictSet, List<Ball> redBalls, List<Ball> blueBalls, int count) {
        List<Ball> redBallsCopy = new ArrayList<>();
        List<Ball> blueBallsCopy = new ArrayList<>();
        for(int i=0;i<34; ++i){
            Ball ball = new Ball();
            ball.no=i;
            redBallsCopy.add(redBalls.get(i));
        }
        for(int i=0;i<17; ++i){
            Ball ball = new Ball();
            ball.no=i;
            blueBallsCopy.add(blueBalls.get(i));
        }
        Collections.sort(redBallsCopy, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o2.count100-o1.count100;
            }
        });

        predictSet.clear();
        int pickNum = 8;
        int additionCnt = 1;

        List<Ball> predictList = getMostPossible(predictSet, redBallsCopy, pickNum);

//            if(count>20) {
//
//                printBalls(redBallsCopy);
//            }
        Collections.sort(redBallsCopy, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o2.count10-o1.count10;
            }
        });
        int removeCnt = 0;
        int percentTh = 31;
        for(Ball ball : redBallsCopy){
            if(ball.percent10<percentTh || removeCnt>=additionCnt){
                break;
            }
            if(ball.percent10>=percentTh && predictSet.contains(ball.no)){
                removeCnt++;
                removeNo(predictSet, ball.no);
            }
        }
        Iterator<Ball> it = predictList.iterator();
        while(it.hasNext()){
            if(removeCnt>=additionCnt){
                break;
            }
            Ball ball = it.next();
            if(ball.percent10<=11){
                continue;
            }
            removeNo(predictSet, ball.no);
            it.remove();
            removeCnt++;
        }
    }


    private static void getPredictSet2(List<Integer> predictSet,List<Integer> predictB, List<Ball> redBalls, List<Ball> blueBalls, int count) {
        List<Ball> redBallsCopy = new ArrayList<>();
        List<Ball> blueBallsCopy = new ArrayList<>();
        for(int i=0;i<34; ++i){
            Ball ball = new Ball();
            ball.no=i;
            redBallsCopy.add(redBalls.get(i));
        }
        for(int i=0;i<17; ++i){
            Ball ball = new Ball();
            ball.no=i;
            blueBallsCopy.add(blueBalls.get(i));
        }

        predictSet.clear();
        predictB.clear();;

        if(count==172){
            System.out.print("");
        }

        int pickNum = 8;
        int additionCnt = 3;
        List<Ball> predictList = getMostPossible(predictSet, redBallsCopy, pickNum);
        removeAddition(predictSet, redBallsCopy, additionCnt, predictList);
        addMax10Min100(predictSet, redBallsCopy,1,1);

        int pickBNum = 10;
        int additionBCnt = 10;
        List<Ball> predictBList = getMostPossible(predictB, blueBallsCopy, pickBNum);
        removeAddition(predictB, blueBallsCopy, additionBCnt, predictBList);
        addMax10Min100(predictB, blueBallsCopy,0,0);
        Collections.sort(blueBallsCopy, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return (int)(o1.percent-o2.percent);
            }
        });
        int addMax100 = 0;
        for(Ball ball : blueBallsCopy){
            if(addMax100>=1) break;
            if(ball.no==0||predictB.contains(ball.no)){
                continue;
            }
            predictB.add(ball.no);
            addMax100++;
        }
        int addMin100 = 0;
        for(int i=blueBallsCopy.size()-1; i>=0; i--){
            Ball ball = blueBallsCopy.get(i);
            if(addMin100>=1) break;
            if(ball.no==0||predictB.contains(ball.no)){
                continue;
            }
            predictB.add(ball.no);
            addMin100++;
        }
    }

    private static List<Ball> getMostPossible(List<Integer> predictSet, List<Ball> ballsCopy, int pickNum) {
        Collections.sort(ballsCopy, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                double x  = 3;
                return (int)(((o2.percent-o2.percent10)*x + o2.percent)-((o1.percent-o1.percent10)*x + o1.percent));
            }
        });
        List<Ball> predictList = new ArrayList<>();
        for (int i = 0; i < pickNum; ++i) {
            int no = ballsCopy.get(i).no;
            predictSet.add(no);
            predictList.add(0, ballsCopy.get(i));
        }
        return predictList;
    }

    private static void removeAddition(List<Integer> predictB, List<Ball> ballsCopy, int additionBCnt, List<Ball> predictBList) {

        Collections.sort(ballsCopy, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o2.count10-o1.count10;
            }
        });
        int removeBCnt = 0;
        int percentBTh = 31;
        for(Ball ball : ballsCopy){
            if(ball.percent10<percentBTh || removeBCnt>=additionBCnt){
                break;
            }
            if(ball.percent10>=percentBTh && predictB.contains(ball.no)){
                removeBCnt++;
                removeNo(predictB, ball.no);
            }
        }
        Iterator<Ball> itb = predictBList.iterator();
        while(itb.hasNext()){
            if(removeBCnt>=additionBCnt){
                break;
            }
            Ball ball = itb.next();
            removeNo(predictB, ball.no);
            itb.remove();
            removeBCnt++;
        }
    }

    private static void addMax10Min100(List<Integer> predictSet, List<Ball> redBallsCopy, int pickMax10Num, int pickMin100Num) {
        int addMax10 = 0;
        for(Ball ball : redBallsCopy){
            if(addMax10>=pickMax10Num) break;
            if(predictSet.contains(ball.no)){
                continue;
            }
            predictSet.add(ball.no);
            addMax10++;
        }
        Collections.sort(redBallsCopy, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return (int)(o1.percent100-o2.percent100);
            }
        });
        int addMin100 = 0;
        for(Ball ball : redBallsCopy){
            if(addMin100>=pickMin100Num) break;
            if(ball.no==0||predictSet.contains(ball.no)){
                continue;
            }
            predictSet.add(ball.no);
            addMin100++;
        }
    }

    private static void removeNo(List<Integer> predictSet, int no) {
        Iterator<Integer> it = predictSet.iterator();
        while(it.hasNext()){
            if(it.next()==no){
                it.remove();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        GetNextSerialsModel.getNextSerials();
    }
}
