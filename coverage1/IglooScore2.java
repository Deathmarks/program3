
/***
* Olympic Igloo Scoring Class
*
* For the Winter Olympics igloo building event there are
* three judges, each of which gives a score from 0 to 50 
* (inclusive), but the lowest score is thrown out and the 
* competitor's overall score is just the sum of the two
* highest scores. This class supports the recording of the
* three judge's scores, and the computing of the competitor's
* overall score.
*
***/

public class IglooScore2
{

   int score1;
   int score2;
   int score3;

public IglooScore2()
{
   score1 = 0;
   score2 = 0;
   score3 = 0;
}

public void recordScores(int s1, int s2, int s3)
{
   score1 = s1;
   score2 = s2;
   score3 = s3;
}

// Copied my implementation of overallScore from Igloo1, don't fix what ain't broke.
public int overallScore()
{
   int maxNum = 0;
   if(score1 < score2){
      maxNum += score2;
      maxNum += (score1 < score3) ? score3 : score1;
   }
   else{
      maxNum += score1;
      maxNum += (score2 < score3) ? score3 : score2;
   }
   return maxNum;
}

public static void main(String args[])
{
   int s1 = -1, s2 = -2, s3 = -3;

   /*With our canned input there is no reason to check if the argument is null.
     If you want to make the argument that accessing a member variable from a "null" memory location produces an error, and is improper, remember that this was not required of IglooScore1. */
   if (args.length != 3) {
      System.err.println("Error: must supply three arguments!");
      return;
   }
   try {
      if((Integer.parseInt(args[0]) <= 50) && (Integer.parseInt(args[0]) >= 0))
         s1 = Integer.parseInt(args[0]);
      if((Integer.parseInt(args[1]) <= 50) && (Integer.parseInt(args[1]) >= 0))
         s2 = Integer.parseInt(args[1]);
      if((Integer.parseInt(args[2]) <= 50) && (Integer.parseInt(args[2]) >= 0))
         s3 = Integer.parseInt(args[2]);
   } catch (Exception e) {
      System.err.println("Error: arguments must be integers between 0 and 50 (inclusive)!");
      return;
   }
   IglooScore2 score = new IglooScore2();
   score.recordScores(s1,s2,s3);
   System.out.println("Overall score: " + score.overallScore());
   return;
}

} // end class

