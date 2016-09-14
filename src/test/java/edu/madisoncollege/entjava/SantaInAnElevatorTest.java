package edu.madisoncollege.entjava;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 9/13/16.
 */
public class SantaInAnElevatorTest {
    @Test
    public void readInputFile() throws Exception {
        SantaInAnElevator testSanta = new SantaInAnElevator();

        assertEquals("How many floors are  there?",0,
         testSanta.readInputFile("/home/student/IdeaProjects/Santa-Exercise-Week2/src/main/resources/SantaUpDown.txt"));


    }

    @Test
    public void processDirection() throws Exception {
        SantaInAnElevator testSanta = new SantaInAnElevator();

        assertEquals("Passed in '(' should return 1",1,testSanta.processDirection('('));
        assertEquals("Passed in ')' should return -1",-1,testSanta.processDirection(')'));
    }

}