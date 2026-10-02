package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }


    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void same_object(){
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals("string"));
        assertEquals(false, team.equals("string"));



    }

    @Test
    public void equals_compares_name_and_members() {
        // T T
        Team same = new Team("test-team");
        assertEquals(true, team.equals(same));

        // T F
        Team sameNameDifferentMembers = new Team("test-team");
        sameNameDifferentMembers.addMember("Alice");
        assertEquals(false, team.equals(sameNameDifferentMembers));


        // F F (also F T tech)
        Team differentName = new Team("other-team");
        assertEquals(false, team.equals(differentName));
    }

    @Test
    public void hash_code() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }



   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
