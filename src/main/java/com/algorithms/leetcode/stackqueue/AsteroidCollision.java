package com.algorithms.leetcode.stackqueue;

import java.util.Stack;

/*
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array
represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 */
public class AsteroidCollision {

    /*
        Initialize an empty list called res to store the final result.

        Iterate through each element a in the asteroids list.

        Check the current asteroid a and the last asteroid in the res list (if it exists) to
         determine whether there will be a collision or not.

        The while loop while res and a < 0 < res[-1]: checks if the res list is not empty and if the current asteroid
        a is negative (moving left) while the last asteroid in res (res[-1]) is positive (moving right). This condition
         represents the potential for a collision.

        If there's a potential collision, we need to resolve it:

        If the magnitude of the current asteroid a is greater than the last asteroid's magnitude in res (-a > res[-1]),
         then the current asteroid will destroy the last asteroid in res. So, we pop the last asteroid from res using
         res.pop().

        If the magnitude of the current asteroid a is equal to the last asteroid's magnitude in res (-a == res[-1]),
        both asteroids will collide and destroy each other. So, we pop the last asteroid from res using res.pop().

        If neither of the above conditions is met, it means the current asteroid a will pass safely without any
         collision, and we break out of the while loop.

        If the while loop finishes without encountering a collision, i.e., the current asteroid a is not destroyed
        by any other asteroid in res, we add the current asteroid a to the res list using res.append(a).
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) stack.push(asteroid);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);
                if (stack.peek() == -asteroid)
                    stack.pop();
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length -1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
