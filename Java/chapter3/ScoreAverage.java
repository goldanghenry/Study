package chapter3;
// 2차원 배열 연습
public class ScoreAverage {
    public static void main(String[] args){
        double score[][] = {
            {3.4, 3.3},
            {2.6, 4.0},
            {3.1, 3.7},
            {4.3, 4.0}
        };

        double sum = 0.0;
        for(int year=0;year<score.length; year++){
            for(int term=0; term<score[0].length;term++){
                sum += score[year][term];
            }
        }
        int n = score.length;
        int m = score[1].length;
        System.out.println(n+"년 전체 평점 평균은 "+(sum/(n*m)));
    }
}