package com.ncr.test.pyramid;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.data.PyramidGenerator;
import com.ncr.test.pyramid.data.impl.RandomPyramidGenerator;
import com.ncr.test.pyramid.solver.PyramidSolver;
import com.ncr.test.pyramid.solver.impl.NaivePyramidSolver;

/**
 * TASK: This is your 1st task. 
 * Please look at the {@link com.ncr.test.pyramid.solver.impl.NaivePyramidSolver} and
 * <ul>
 *   <li>describe or fix the bugs and problems. Comment your changes.
 *   <li>describe or implement test scenarios you need to prove its correctness.
 * </ul>
 */
public class OurProgram {

    /**
     * This doesn't get the correct number
     */
    public static void main(String[] args) {
        final PyramidGenerator generator = new RandomPyramidGenerator(5, 99);
        final Pyramid pyramid = generator.generatePyramid();

        System.out.println(pyramid);

        final PyramidSolver solver = new NaivePyramidSolver();

        System.out.println("This result is wrong, do you know why ?");
        System.out.println("It was wrong due to below statement:");
        System.out.println("if (row == 0) return 0;  this wrong at row 0 means first row we should return max not zero");
        System.out.println("And correct approach is:");
        System.out.println("if(row ==0) return pyramid.get(row, column);  correct approach is return data of row and col");
        System.out.println("correct output is:");
        System.out.println(solver.pyramidMaximumTotal(pyramid));

        System.out.println();
    }
}