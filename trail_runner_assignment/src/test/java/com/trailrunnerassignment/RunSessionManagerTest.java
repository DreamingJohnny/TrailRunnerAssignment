package com.trailrunnerassignment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class RunSessionManagerTest {

private RunSessionManager testRunsesSessionManager;

@BeforeEach
public void setup()
{
 testRunsesSessionManager = new RunSessionManager();
 testRunsesSessionManager.addRunSession(new RunSession(LocalDate.of(2024, 12, 28), 7,4500));
 testRunsesSessionManager.addRunSession(new RunSession(LocalDate.of(2025, 1, 1), 7,4400));
 testRunsesSessionManager.addRunSession(new RunSession(LocalDate.of(2025, 1, 3), 7,4700));
}
    
@Test
public void canAddRuns()
{
    testRunsesSessionManager.addRunSession(new RunSession(LocalDate.of(2025, 1, 4), 7,4800));
   int temp = testRunsesSessionManager.getNumberOfRuns();
   assertEquals(4, temp);
}

@Test
public void canDeleteRuns()
{
int temp = testRunsesSessionManager.getLastestRunSession().getId();
System.out.println(temp);
testRunsesSessionManager.deleteRunSession(temp);
int runs = testRunsesSessionManager.getNumberOfRuns();
   assertEquals(2, runs);
}
//Om det här testet failar så behöver du updatera expected till mellen skillnaden mellan datumet som sparat och dagens datum
@Test
public void canGetDaySinceLastRun()
{
   int temp = testRunsesSessionManager.daysSinceLastRun();
    assertEquals(10, temp);
}

@Test
public void canGetTotalDistanceRun()
{
    float temp = testRunsesSessionManager.getTotalDistanceRun();
    assertEquals(21, temp);
}
@Test
public void canGetAverageDistanceOfRun()
{
    float temp = testRunsesSessionManager.getAverageDistanceOfRunSession();
    assertEquals(7, temp);
}


}
