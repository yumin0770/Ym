package study.baek;


public class Solution2 {
   
   public static void main(String[] args) {
         
         int[][] score1 = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
         int[][] score2 = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
         
         int[] answer1 = solution(score1);
         int[] answer2 = solution(score2);
         
         
        
         // [1, 2, 4, 3]
         for(int i : answer1) 
       
         System.out.print(i + " ");
         
         System.out.println();
         // [4, 4, 6, 2, 2, 1, 7]
         for(int i : answer2)
            System.out.print(i + " ");
      }
   
       public static int[] solution(int[][] score) {
    	   //위에 값을 매개 변수로 가져옴. 이름(score)는 중요하지 않고 반환형이 중요함
           int[] answer = new int[score.length];
           
          double[] avg = new double[score.length];
          
          int rank = 1;
          
          // 평균값 계산 후 avg 배열에 담기
          for(int i = 0; i < score.length; i++) {
             avg[i] = (score[i][0] + score[i][1]) / 2.0;
             //System.out.println("평균값" + avg[i]);
          } // 인덱스별 평균
          
          System.out.println("--------------------");
          
          for(int j = 0; j < score.length; j++) {
             rank=1;
             //System.out.println("이거는? = " + avg[j]);
             
             for(int i = 0; i< score.length; i++) {
                if(avg[j] < avg[i]) {
                   rank++;
                }
             answer[j] = rank; 
             }
          }
           return answer;
       }
   }