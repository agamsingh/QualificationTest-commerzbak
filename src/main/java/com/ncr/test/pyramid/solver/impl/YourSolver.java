package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 2nd task. 
 * Please implement the class to satisfy the interface. *
 */

/**
 * Applying, DP in a bottom-up manner we should solve our problem as:
 * [00059] [00207] [00098] [00095]
 * [00087] [00001] [00070] [     ]
 * [00036] [00041] [     ] [     ]
 * [00023] [     ] [     ] [     ]
 *
 * Step-1: adding last value to row above
 * [00059] [00207] [00098] [00095]
 * [00087] [00001] [00070] [     ]
 * [00059] [00064] [     ] [     ]
 *
 * Step-2:adding to row above and retaining max value
 * [00059] [00207] [00098] [00095]
 * [00146] [00065] [00134] [     ]
 *
 * Step-2:adding to row above and retaining max value
 * [00205] [00353] [00232] [00229]
 *
 * Step-3 : ans = max of first row 353
 */
public class YourSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int numberOfRows = pyramid.getRows();
        int res = 0;

        int data[][] = pyramid.getData();
        // Loop for bottom-up calculation
        for (int row = numberOfRows - 2; row >= 0; row--)
        {
            for (int col = 0; col < numberOfRows - row; col++)
            {
                // For each element, check both
                // elements just below the number
                // and below left to the number
                // add the maximum of them to it
                if (col - 1 >= 0)
                    data[row][col] += Math.max(data[row + 1][col],
                            data[row + 1][col - 1]);
                else
                    data[row][col] += data[row + 1][col];

                res = Math.max(res, data[row][col]);
            }
        }
        return res;
    }
    
}
