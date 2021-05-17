//package ball;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class GetNextSerials2 {
//
//    public void getNextSerials() throws IOException {
//        List<Set<Integer>> red = new ArrayList<Set<Integer>>();
//        List<Integer> blue = new ArrayList<>();
//        List<Ball> redBalls = new ArrayList<>();
//        List<Ball> blueBalls = new ArrayList<>();
//        for(int i=1;i<34; ++i){
//            Ball ball = new Ball();
//            ball.no=i;
//            redBalls.add(ball);
//        }
//        for(int i=1;i<17; ++i){
//            Ball ball = new Ball();
//            ball.no=i;
//            blueBalls.add(ball);
//        }
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("G:\\caipiao\\data.txt"));
//        String str = null;
//        int count = 0;
//        while((str=bufferedReader.readLine())!=null && str.length()>0){
//            count++;
//            String[] sstr = str.split("[    \t]+");
//            Set<Integer>
//            for(int i=1; i<7; ++i){
//                int tmp = Integer.parseInt(sstr[i]);
//                redBalls.get(tmp).count++;
//                if(count<11){
//                    redBalls.get(tmp).count10++;
//                    redBalls.get(tmp).count20++;
//                    redBalls.get(tmp).count30++;
//                    redBalls.get(tmp).count50++;
//                    redBalls.get(tmp).count100++;
//                } else if(count<21){
//                    redBalls.get(tmp).count20++;
//                    redBalls.get(tmp).count30++;
//                    redBalls.get(tmp).count50++;
//                    redBalls.get(tmp).count100++;
//                } else if(count<31){
//                    redBalls.get(tmp).count30++;
//                    redBalls.get(tmp).count50++;
//                    redBalls.get(tmp).count100++;
//                } else if(count<51){
//                    redBalls.get(tmp).count50++;
//                    redBalls.get(tmp).count100++;
//                } else if(count<101){
//                    redBalls.get(tmp).count100++;
//                }
//            }
//            int tmp = Integer.parseInt(sstr[7]);
//            blueBalls.get(tmp).count++;
//            if(count<11){
//                blueBalls.get(tmp).count10++;
//                blueBalls.get(tmp).count20++;
//                blueBalls.get(tmp).count30++;
//                blueBalls.get(tmp).count50++;
//                blueBalls.get(tmp).count100++;
//            } else if(count<21){
//                blueBalls.get(tmp).count20++;
//                blueBalls.get(tmp).count30++;
//                blueBalls.get(tmp).count50++;
//                blueBalls.get(tmp).count100++;
//            } else if(count<31){
//                blueBalls.get(tmp).count30++;
//                blueBalls.get(tmp).count50++;
//                blueBalls.get(tmp).count100++;
//            } else if(count<51){
//                blueBalls.get(tmp).count50++;
//                blueBalls.get(tmp).count100++;
//            } else if(count<101){
//                blueBalls.get(tmp).count100++;
//            }
//
//            for(int i=1;i<34; ++i){
//                redBalls.get(i).percent = (redBalls.get(i).count*1000/count)/10.0f;
//                redBalls.get(i).percent10 = (redBalls.get(i).count10*1000/10)/10.0f;
//                redBalls.get(i).percent20 = (redBalls.get(i).count20*1000/20)/10.0f;
//                redBalls.get(i).percent30 = (redBalls.get(i).count30*1000/30)/10.0f;
//                redBalls.get(i).percent50 = (redBalls.get(i).count50*1000/50)/10.0f;
//                redBalls.get(i).percent100 = (redBalls.get(i).count100*1000/100)/10.0f;
//            }
//            for(int i=1;i<17; ++i){
//                blueBalls.get(i).percent = (blueBalls.get(i).count*1000/count)/10.0f;
//                blueBalls.get(i).percent10 = (blueBalls.get(i).count10*1000/10)/10.0f;
//                blueBalls.get(i).percent20 = (blueBalls.get(i).count20*1000/20)/10.0f;
//                blueBalls.get(i).percent30 = (blueBalls.get(i).count30*1000/30)/10.0f;
//                blueBalls.get(i).percent50 = (blueBalls.get(i).count50*1000/50)/10.0f;
//                blueBalls.get(i).percent100 = (blueBalls.get(i).count100*1000/100)/10.0f;
//            }
//        }
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        int[] countRed = new int[34];
//        int[] countBlue = new int[17];
//        Set<Integer> checkSet = new HashSet<>();
//        checkSet.add(1);checkSet.add(2);checkSet.add(9);checkSet.add(16);checkSet.add(26);checkSet.add(32);checkSet.add(6);;checkSet.add(10);
//
////        checkSet.add(3);checkSet.add(5);checkSet.add(13);checkSet.add(20);checkSet.add(23);checkSet.add(28);checkSet.add(29);;checkSet.add(33);
//        int count = 0;
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("G:\\caipiao\\data.txt"));
//        String str = null;
//
//        //1 2 9 16 26 32
//        int matchNum  = 0;
//        while((str=bufferedReader.readLine())!=null && str.length()>0){
//            count++;
//            matchNum=0;
//            String[] sstr = str.split("[    \t]+");
//            for(int i=1; i<7; ++i){
//                int tmp = Integer.parseInt(sstr[i]);
//                countRed[tmp]++;
//                if(checkSet.contains(tmp)){
//                    matchNum++;
//                }
//            }
//            if(matchNum>=4){
//                System.out.println(str);
//            }
//            int tmp = Integer.parseInt(sstr[7]);
//            countBlue[tmp]++;
//        }
//        for(int i=1;i<34; ++i){
//            System.out.printf("%-6d" ,i );
//        }
//
//        System.out.println();
//        for(int i=1;i<34; ++i){
//            System.out.printf("%-6d" ,countRed[i] );
//        }
//
//        System.out.println();
//        for(int i=1;i<34; ++i){
//            System.out.printf("%.1f  " ,countRed[i]/(count*1.0d)*100 );
//        }
//        System.out.println();
//        // 1 2 9 16 26 32
//        for(int i=1;i<17; ++i){
//            System.out.print(countBlue[i] +",");
//        }
//
//        System.out.println();
//
//        System.out.println(count);
//    }
//}
