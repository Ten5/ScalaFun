package code.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Question
 *
 * Count maximum number of giants that can be destroyed before they reach the city
 *
 * Given two arrays dist[] and speed[] consisting of N integers, where dist[i] is the initial distance of the ith giant from the city and speed[i] is the speed of the ith giant.
 * One giant can be eliminated every minute. Therefore, at any time t, at most t giants can be killed.
 * If more giants are able to reach the city in time t, then the game is over.
 * The task is to find the maximum number of giants that can be eliminated before losing, or N if all of the giants can be eliminated before they reach the city.
 *
 * Examples:
 *
 * Input: dist[] = [1, 3, 4], speed[] = [1, 1, 1]
 * Output: 3
 * Explanation: At the start of minute 0, the distances of the  giants are [1, 3, 4]. The first giant is eliminated.
 * At the start of 1st minute, the distances of the giants are [X, 2, 3]. No giant is eliminated.
 * At the start of 2nd minute, the distances of the giants are [X, 1, 2]. The second giant is eliminated.
 * At the start of 3rd minute, the distances of the giants are [X, X, 1]. The third  giant is eliminated.
 * All 3  giants can be eliminated.
 *
 * Input: dist[] = [1, 1, 2, 3], speed[] = [1, 1, 1, 1]
 * Output: 1
 */


public class MaxGiantKill {

    public static void main(String args[]) {

        // Input
        int dist[] = {2, 5, 5, 5, 8};
        int speed[] = {1, 1, 1, 1, 2};

        // Create objects
        List<GiantDistance> gd = new ArrayList<GiantDistance>();
        for(int i = 0; i < dist.length; i++) {
            gd.add(new GiantDistance(dist[i], speed[i]));
        }

        Collections.sort(gd, (o1, o2) -> o1.remainingDist - o2.remainingDist);

        int result = 0;
        int count = 1;
        int lastVal = 0;
        int previous = 0;
        int i = 0;

        for(i = 0; i < gd.size(); i++) {
            GiantDistance current = gd.get(i);

            if(current.remainingDist == previous) {
                count++;
                continue;
            }
            else if(Math.abs(count - lastVal) >= 0) {
                count = 1;
            }
            else break;

            if(i > 0)
                lastVal = gd.get(i - 1).remainingDist;

            previous = current.remainingDist;
        }

        if(i < gd.size())
            result = i;
        else
            result = gd.size();

        System.out.println("Giants killed " + result);
    }

    static class GiantDistance {
        int dist;
        int speed;
        int remainingDist;

        public GiantDistance(int d, int s) {
            this.dist = d;
            this.speed = s;
            this.remainingDist = d / s;
        }
    }
}
