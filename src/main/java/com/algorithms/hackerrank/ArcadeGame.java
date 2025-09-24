package com.algorithms.hackerrank;

import java.util.*;

/**
 * An arcade game player wants to climb to the top of the leaderboard and track their ranking.
 * The game uses Dense Ranking, so its leaderboard works like this:
 *
 * The player with the highest score is ranked number  on the leaderboard.
 * Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
 * Example
 *
 *
 *
 * The ranked players will have ranks , , , and , respectively. If the player's scores are ,  and , their rankings after each game are ,  and . Return .
 *
 * Function Description
 *
 * Complete the climbingLeaderboard function in the editor below.
 *
 * climbingLeaderboard has the following parameter(s):
 *
 * int ranked[n]: the leaderboard scores
 * int player[m]: the player's scores
 */
public class ArcadeGame {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Remove duplicates and sort in descending order
        List<Integer> uniqueScores = new ArrayList<>(new HashSet<>(ranked));
        uniqueScores.sort(Collections.reverseOrder());

        List<Integer> result = new ArrayList<>();
        int index = uniqueScores.size() - 1;

        for (int score : player) {
            while (index >= 0 && score >= uniqueScores.get(
                    index)) {
                index--;
            }
            result.add(index + 2);  // +1 for rank, +1 because index is 0-based
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        List<Integer> player = Arrays.asList(105, 110, 115);

        List<Integer> result = climbingLeaderboard(ranked, player);
        for (int rank : result) {
            System.out.println(rank);
        }
    }
}
