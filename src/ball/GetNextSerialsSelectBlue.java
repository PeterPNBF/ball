package ball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GetNextSerialsSelectBlue {

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
        BufferedReader bufferedReader = new BufferedReader(new FileReader("G:\\\\caipiao\\data.txt"));
        String str = null;
        int count = 0;
        ShotTotalBall shotTotalBall = new ShotTotalBall();
        Map<Integer, Integer> shotMap = new HashMap<>();
        while((str=bufferedReader.readLine())!=null && str.length()>0){
            count++;

            if(count==172){
                System.out.print("");
            }
            calcBall(shotMap,predictSet,predictB,shotTotalBall, red, blue, redBalls, blueBalls, str, count);
            getPredictSet2(predictSet,predictB, redBalls, blueBalls, count);
        }

        System.out.println("count=" + count + ",shotRedTotal=" + shotTotalBall.red + ",shotBlueTotal=" + shotTotalBall.blue);
        Collections.sort(predictSet);
        Collections.sort(predictB);
        System.out.println("------------------------END RED-------------------------");
        BallPrintUtil.printBalls10(redBalls);
        BallPrintUtil.printBalls20(redBalls);
        BallPrintUtil.printBalls30(redBalls);
        BallPrintUtil.printBalls50(redBalls);
        BallPrintUtil.printBalls100(redBalls);
        BallPrintUtil.printBalls100_10(redBalls);
        System.out.println("------------------------END BLUE-------------------------");
        BallPrintUtil.printBalls10(blueBalls);
        BallPrintUtil.printBalls20(blueBalls);
        BallPrintUtil.printBalls30(blueBalls);
        BallPrintUtil.printBalls50(blueBalls);
        BallPrintUtil.printBalls100(blueBalls);
        BallPrintUtil.printBalls100_10(blueBalls);
        System.out.println("shotMap=" + shotMap);
        System.out.println("红球：" + predictSet);
        System.out.println("篮球：" + predictB);
        System.out.println();
        for(int i=0; i<7; ++i){
            System.out.print("红球：[");
            boolean isF = true;
            for(int j=0;j<7;++j){
                if(j==i){
                    continue;
                }
                if(isF){
                    System.out.print(predictSet.get(j));
                    isF = false;
                }else {
                    System.out.print(", " + predictSet.get(j));
                }
            }
            System.out.println("]");
            if(predictB.size()>i){
                System.out.println("篮球：[" + predictB.get(i) + "]");
            } else {
                System.out.println("篮球：[]");
            }
            if(i==4){
                System.out.println();
            }
        }
        for(int i=7; i<10; ++i){
            System.out.println("红球：[]");

            if(predictB.size()>i){
                System.out.println("篮球：[" + predictB.get(i) + "]");
            } else {
                System.out.println("篮球：[]");
            }
        }
        List<Integer> lastRedList = new ArrayList<>(red.get(red.size()-1));
        Collections.sort(lastRedList);
        checkShot(lastRedList, blue.get(blue.size()-1));
    }
    public static void checkShot(List<Integer> redKeyList, Integer blueKey) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("G:\\\\caipiao\\pick.txt"));
            String str = null;
            int count = 0;
            ShotTotalBall shotTotalBall = new ShotTotalBall();
            Map<Integer, Integer> shotMap = new HashMap<>();
            List<Integer> redList = new ArrayList<>();
            while ((str = bufferedReader.readLine()) != null) {
                if(str==null || str.length()==0){continue;}
                String[] ballStrArr = str.split("[ \\[\\],]");
                if(ballStrArr.length<1){
                    continue;
                }
                int shotRed = 0;
                int shotBlue = 0;
                if (ballStrArr.length > 5) {
                    for (String ballStr : ballStrArr) {
                        try {
                            Integer ball = Integer.parseInt(ballStr);
                            redList.add(ball);
                        } catch (NumberFormatException e) {
                            //
                        }
                    }
                } else {
                    for (String ballStr : ballStrArr) {
                        try {
                            Integer ball = Integer.parseInt(ballStr);

                            List<Integer> shotList = new ArrayList<>();
                            for (Integer redBall : redList) {
                                if (redKeyList.contains(redBall)) {
                                    shotRed++;
                                    shotList.add(redBall);
                                }
                            }
                            if (blueKey == ball) {
                                shotBlue++;
                            }
                            if ((shotRed < 3 && shotBlue == 1)) {
                                printShotInfo("中六等奖5块钱", redKeyList, redList, ball, shotList);
                            }
                            if ((shotRed + shotBlue == 4)) {
                                printShotInfo("中五等奖10块钱", redKeyList, redList, ball, shotList);
                            }
                            if ((shotRed + shotBlue == 5)) {
                                printShotInfo("中四等奖200块钱", redKeyList, redList, ball, shotList);
                            }
                            if ((shotRed == 5 && shotBlue == 1)) {
                                printShotInfo("中三等奖3000块钱", redKeyList, redList, ball, shotList);
                            }
                            if ((shotRed == 6 && shotBlue == 0)) {
                                printShotInfo("中二等奖浮动奖，最高300万", redKeyList, redList, ball, shotList);
                            }
                            if ((shotRed == 6 && shotBlue == 1)) {
                                printShotInfo("中一等奖浮动奖，最高1000万", redKeyList, redList, ball, shotList);
                            }
                        } catch (NumberFormatException e) {
                            //
                        }
                    }
                    redList.clear();
                }
            }
        } catch (Exception e){

        }
    }

    private static void printShotInfo(String level, List<Integer> redKeyList, List<Integer> redList, Integer ball, List<Integer> shotList) {
        System.out.println(level + "： 红球：" + shotList + "， 篮球：" + ball);
        System.out.println("选择的红球："+ redList + "， 篮球：" + ball);
        System.out.println("开出的红球："+ redKeyList + "， 篮球：" + ball);
    }

    private static ShotTotalBall calcBall(Map<Integer, Integer> shotMap, List<Integer> predictSet, List<Integer> predictB,ShotTotalBall shotTotalBall, List<Set<Integer>> red, List<Integer> blue, List<Ball> redBalls, List<Ball> blueBalls, String str, int count) {
        int shot=0,shotB=0;
        String[] sstr = str.split("[    \t]+");
        Set<Integer> rs = new HashSet<>();
        red.add(rs);
        for(int i=1; i<7; ++i){
            int tmp = Integer.parseInt(sstr[i]);
            if(predictSet.contains(tmp)){
                shot++;
            }
            if(red.size()>3){
                if(red.get(red.size()-2).contains(tmp) && red.get(red.size()-3).contains(tmp) && red.get(red.size()-4).contains(tmp)){
                    Integer shotTmp = shotMap.get(-2);
                    if(shotTmp==null){
                        shotTmp = 1;
                    } else {
                        shotTmp++;
                    }
                    shotMap.put(-2,shotTmp);
                }
            }
            rs.add(tmp);
            redBalls.get(tmp).count++;
            redBalls.get(tmp).count8++;
            redBalls.get(tmp).count10++;
            redBalls.get(tmp).count12++;
            redBalls.get(tmp).count20++;
            redBalls.get(tmp).count30++;
            redBalls.get(tmp).count50++;
            redBalls.get(tmp).count100++;
        }
        if(count>8){
            for(Ball ball : redBalls) {
                if (red.get(count - 9).contains(ball.no)) {
                    ball.count8--;
                }
            }
        }        if(count>10){
            for(Ball ball : redBalls) {
                if (red.get(count - 11).contains(ball.no)) {
                    ball.count10--;
                }
            }
        }
        if(count>12){
            for(Ball ball : redBalls) {
                if (red.get(count - 13).contains(ball.no)) {
                    ball.count12--;
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
        blueBalls.get(tmp).count8++;
        blueBalls.get(tmp).count10++;
        blueBalls.get(tmp).count12++;
        blueBalls.get(tmp).count20++;
        blueBalls.get(tmp).count30++;
        blueBalls.get(tmp).count50++;
        blueBalls.get(tmp).count100++;
        if(count>8){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 9).equals(ball.no)) {
                    blueBalls.get(ball.no).count8--;
                }
            }
        }
        if(count>10){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 11).equals(ball.no)) {
                    blueBalls.get(ball.no).count10--;
                }
            }
        }
        if(count>12){
            for(Ball ball : blueBalls) {
                if (blue.get(count - 13).equals(ball.no)) {
                    blueBalls.get(ball.no).count12--;
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
            if(redBalls.get(i).percent10>51){
                Integer shotTmp = shotMap.get(-1);
                if(shotTmp==null){
                    shotTmp = 1;
                } else {
                    shotTmp++;
                }
                shotMap.put(-1,shotTmp);
            }
            tmpBy = count<8?count:8;
            redBalls.get(i).percent8 = (redBalls.get(i).count8*1000/tmpBy)/10.0f;
            tmpBy = count<12?count:12;
            redBalls.get(i).percent12 = (redBalls.get(i).count12*1000/tmpBy)/10.0f;
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
            tmpBy = count<8?count:8;
            blueBalls.get(i).percent8 = (blueBalls.get(i).count8*1000/tmpBy)/10.0f;
            tmpBy = count<12?count:12;
            blueBalls.get(i).percent12 = (blueBalls.get(i).count12*1000/tmpBy)/10.0f;
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
        Integer shotCnt = shotMap.get(shot);
        if(shotCnt!=null){
            shotCnt++;
        } else {
            shotCnt = 1;
        }
        shotMap.put(shot,shotCnt);
        if(shot>=4){
            shotTotalBall.red++;
            System.out.println("count=" + count + ",shot=" + shot);
            System.out.println("predictSet=" + predictSet);
            System.out.println(str);
            BallPrintUtil.printBalls10(redBalls);
            BallPrintUtil.printBalls20(redBalls);
            BallPrintUtil.printBalls30(redBalls);
            BallPrintUtil.printBalls50(redBalls);
            BallPrintUtil.printBalls100(redBalls);
            BallPrintUtil.printBalls100_10(redBalls);
        }
        if(shotB>=1){
            shotTotalBall.blue++;
            System.out.println("count=" + count + ",shotB=" + shotB);
            System.out.println("predictB=" + predictB);
            System.out.println(str);
            BallPrintUtil.printBalls10(blueBalls);
            BallPrintUtil.printBalls20(blueBalls);
            BallPrintUtil.printBalls30(blueBalls);
            BallPrintUtil.printBalls50(blueBalls);
            BallPrintUtil.printBalls100(blueBalls);
            BallPrintUtil.printBalls100_10(blueBalls);
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

        int pickBNum = 6;
        int additionBCnt = 6;
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
        predictB.add(blueBallsCopy.get(3).no);
        predictB.add(blueBallsCopy.get(4).no);
        predictB.add(blueBallsCopy.get(6).no);
        predictB.add(blueBallsCopy.get(7).no);
        predictB.add(blueBallsCopy.get(9).no);
        predictB.add(blueBallsCopy.get(12).no);
        predictB.add(blueBallsCopy.get(15).no);
//        for(Ball ball : blueBallsCopy){
//            addMax100++;
//            // 1:11 2:9 3:14 4:14 5:10 6:16 7:14 8:11 9:15 10:11 11:10 12:16 13:8 14:7 15:15 16:11
//            //13:176 12:175 11:168 10:163 9:151 8:138 7:133 6:111 5:101 4:92 3:78 2:66 1:60 0:48
//            if(ball.no==0||predictB.contains(ball.no)){
//                continue;
//            }
//            if(addMax100==0) {
//                predictB.add(ball.no);
//            }
//            if(addMax100==8) {
//                predictB.add(ball.no);
//            }
//            if(addMax100==9) {
//                predictB.add(ball.no);
//            }
//            if(addMax100==6) {
//                predictB.add(ball.no);
//            }
//            if(addMax100==2) {
//                predictB.add(ball.no);
//            }
//            if(addMax100==3) {
//                predictB.add(ball.no);
//            }
//        }
//        int addMin100 = 0;
//        for(int i=blueBallsCopy.size()-1; i>=0; i--){
//            Ball ball = blueBallsCopy.get(i);
//            if(addMin100>=0) break;
//            if(ball.no==0||predictB.contains(ball.no)){
//                continue;
//            }
//            predictB.add(ball.no);
//            addMin100++;
//        }
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
                return (int)(o1.percent50-o2.percent50);
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
        GetNextSerialsSelectBlue.getNextSerials();
    }
}
