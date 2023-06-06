/* In the world of Dota2, there are two parties: the Radiant and the Dire. The Dota2 senate consists of senators 
coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is 
a round-based procedure. In each round, each senator can exercise one of the two rights:
1)- Ban one senator's right: A senator can make another senator lose all his rights in this and all the following 
rounds.
2)- Announce the victory: If this senator found the senators who still have rights to vote are all from the same 
party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant 
party and the Dire party. Then if there are n senators, the size of the given string will be n. The round-based 
procedure starts from the first senator to the last senator in the given order. This procedure will last until the 
end of voting. All the senators who have lost their rights will be skipped during the procedure. Suppose every 
senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce 
the victory and change the Dota2 game. The output should be "Radiant" or "Dire"
* Eg 1 :   senate = "RD"      Victor = "RADIANT"
* Eg 2 :   senate = "RDD"     Victor = "DIRE"   
* Eg 3 :   senate = "RDDR"    Victor = "RADIANT"
*/
import java.util.*;
public class Dota
{
      public String PredictVictor(String senate)
      {
            int radiant = 0, dire = 0;     //*  Variable declaration -> O(1)
            for(int i = 0; i < senate.length(); i++)     //! Checking -> O(N)
            {
                  if(senate.charAt(i) == 'R')
                        radiant++;   // Counting the number of Radiant party votes...
                  else
                        dire++;    // Counting the number of Dire part votes...
            }
            if(dire == radiant)   // If both party have same votes...
            {
                  if(senate.charAt(0) == 'R')    // The first vote decides the Victor...
                        return "RADIANT";
                  else
                        return "DIRE";
            }
            if(radiant > dire)     // If Radiant party has greater votes...
                  return "RADIANT";
            return "DIRE";     // If Dire party has greater votes...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            String x;
            System.out.print("Enter the sequence : ");
            x = sc.next();
            Dota dota = new Dota();     // Object creation...
            System.out.println("The Victor Organisation is : "+dota.PredictVictor(x));   // Function calling...
            sc.close();
      }
}



//! Time Complexity -> O(N)
//* Space Complexity -> O(1)

// 1. The Victor will be determined by the number of Votes...
// 2. In case of equal votes, the first voting party always wins...