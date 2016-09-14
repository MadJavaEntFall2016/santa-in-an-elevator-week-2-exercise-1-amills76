package edu.madisoncollege.entjava;


import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by paulawaite on 9/7/16.
 *
 * This exercise is taken from the 2015 Advent of Code challenge, Day 1 (http://adventofcode.com/day/1). It will provide you
 * with more practice in our environment, reading files, logging and unit testing.
 *
 * Here is the problem to solve:
 *
 * "Santa is trying to deliver presents in a large apartment building, but he can't find the right floor -
 * the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows
 * the instructions one character at a time.
 *
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.
 *
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 *
 * For example:
 * (()) and ()() both result in floor 0.  <= this would make a good unit test!
 * ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3.
 * ()) and ))( both result in floor -1 (the first basement level).
 * ))) and )())()) both result in floor -3."
 *
 * Your goal is to determine what floor Santa will be on when he uses the directions in the file SantaUpDown.txt
 *
 * Do NOT create a main method in your application, you will use only unit tests to find the answer.
 * Add log4j to your code.  At minimum you should log an error if there is a problem reading the file.
 *
 * When submitting your code, include screenshots showing
 * 1) The answer, i.e., what floor is Santa on?
 * 2) How much code coverage you achieved (what percent?).
 *
 */

public class SantaInAnElevator {

    private int floor;
    private final Logger logger = Logger.getLogger(this.getClass());

    public int readInputFile(String inputFile){

        floor = 0;

        try {
             BufferedReader input = new BufferedReader(
                     new InputStreamReader(
                     new FileInputStream(inputFile)));
            int c;
            while ((c = input.read()) != -1){
                char character = (char) c;
                floor = floor + processDirection(character);
            }
        } catch (FileNotFoundException fileNotFoundEx){
            logger.error("The file was not found.");
            fileNotFoundEx.printStackTrace();
        } catch (IOException ioEx){
            logger.error("Failure during file read.");
            ioEx.printStackTrace();
        } catch (Exception exception){
            logger.error("An unidentified exception was " +
                    "encountered.");
            exception.printStackTrace();
        } finally {

        }

        return floor;
    }


    public int processDirection(char direction){
        int floorModifier = 0;

        if(direction=='(') {
            floorModifier++;
        }else if(direction==')'){
            floorModifier--;
        }

        return floorModifier;
    }

}