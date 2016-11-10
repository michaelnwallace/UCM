import static org.junit.Assert.*;

import org.junit.Test;


public class BBallTest {

	@Test
	public void testGameScore ( ) {
		int[] teamScore = new int[BBall.MAX_QUARTERS];
		for (int i : teamScore)
			i = BBall.DEFAULT;
		assertEquals(0, BBall.gameScore(teamScore));
		teamScore[0] = 5;
		assertEquals(5, BBall.gameScore(teamScore));
		teamScore[2] = 3;
		assertEquals(8, BBall.gameScore(teamScore));
		teamScore[2] = 2;
		assertEquals(7, BBall.gameScore(teamScore));
		teamScore[4] = 100;
		assertEquals(107, BBall.gameScore(teamScore));
	}

	@Test
	public void testResult ( ) {
		BBall.MAX_QUARTERS = 13;
		BBall.NUM_QUARTERS = 4;
		BBall.quarter=4;
		int [ ] visitors2 = {2, 0, 0, BBall.DEFAULT};
		int [ ] visitors1 = {1, 0, 0, BBall.DEFAULT};
		int [ ] home2 = {2, 0, BBall.DEFAULT, BBall.DEFAULT};
		int [ ] home1 = {1, 0, 0, BBall.DEFAULT};
		assertEquals("The visiting team won 2 to 1 in Regulation", BBall.result(home1, visitors2));
		assertEquals("The home team won 2 to 1 in Regulation", BBall.result(home2, visitors1));
		BBall.quarter=5;
		assertEquals("The visiting team won 2 to 1 in 1 Overtime", BBall.result(home1, visitors2));
		assertEquals("The home team won 2 to 1 in 1 Overtime", BBall.result(home2, visitors1));
		BBall.quarter =6;
		assertEquals("The home team won 2 to 1 in 2 Overtimes", BBall.result(home2, visitors1));
	}

	@Test
	public void testGameIsOver ( ) {
		int [ ] visitors2 = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [ ] visitors1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [ ] home2 = {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int [ ] home1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		assertEquals ("quarter 8, team HOME, tied", false, BBall.gameIsOver (8, 2, visitors1, home1));
		assertEquals ("quarter 8, team VISITOR, visitor", true, BBall.gameIsOver (8, 1, visitors2, home1));
		assertEquals ("quarter 4, team HOME, visitor", false, BBall.gameIsOver (4, 2, visitors2, home1));
		assertEquals ("quarter 5, team VISITOR, home", true, BBall.gameIsOver (5, 1, visitors1, home2));
		assertEquals ("quarter 6, team VISITOR, visitor", true, BBall.gameIsOver (6, 1, visitors2, home1));

	}
}
