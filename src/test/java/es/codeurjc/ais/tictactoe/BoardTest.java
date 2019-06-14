package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Board board;
	
	@Before
	 public void setUp() {
		board = new Board();
	 }

	@Test
	public void WinsXtest() {
		// Arrange / Given
		//game.mark(0);
		board.getCell(0).active=false;
		board.getCell(0).value="X";
		//game.mark(1);
		board.getCell(1).active=false;
		board.getCell(1).value="O";
		//game.mark(3);
		board.getCell(3).active=false;
		board.getCell(3).value="X";
		//game.mark(4);
		board.getCell(4).active=false;
		board.getCell(4).value="0";
		//game.mark(6);
		board.getCell(6).active=false;
		board.getCell(6).value="X";
		 
		// Act / When
		 int[] res =board.getCellsIfWinner("X");
		
		 // Assert / Then
		 assertEquals(0,res[0]);
		 assertEquals(3,res[1]);
		 assertEquals(6,res[2]);
		 
	}
	
	@Test
	public void WinsOtest() {
		// Arrange / Given
		//game.mark(1);
		board.getCell(1).active=false;
		board.getCell(1).value="X";
		//game.mark(0);
		board.getCell(0).active=false;
		board.getCell(0).value="O";
		//game.mark(2);
		board.getCell(2).active=false;
		board.getCell(2).value="X";
		//game.mark(4);
		board.getCell(4).active=false;
		board.getCell(4).value="O";
		//game.mark(5);
		board.getCell(5).active=false;
		board.getCell(5).value="X";
		//game.mark(8);
		board.getCell(8).active=false;
		board.getCell(8).value="O";
		 
		// Act / When
		 int[] res = board.getCellsIfWinner("O");
		
		 // Assert / Then
		 assertEquals(0,res[0]);
		 assertEquals(4,res[1]);
		 assertEquals(8,res[2]);
		 
	}
	
	@Test
	public void checkDrawTest() {
		// Arrange / Given
		//game.mark(0);
		board.getCell(0).active=false;
		board.getCell(0).value="O";
		//game.mark(1);
		board.getCell(1).active=false;
		board.getCell(1).value="O";
		//game.mark(2);
		board.getCell(2).active=false;
		board.getCell(2).value="O";
		//game.mark(5);
		board.getCell(5).active=false;
		board.getCell(5).value="O";
		//game.mark(4);
		board.getCell(4).active=false;
		board.getCell(4).value="O";
		//game.mark(6);
		board.getCell(6).active=false;
		board.getCell(6).value="O";
		//game.mark(7);
		board.getCell(7).active=false;
		board.getCell(7).value="O";
		//game.mark(8);
		board.getCell(8).active=false;
		board.getCell(8).value="O";
		//game.mark(3);
		board.getCell(3).active=false;
		board.getCell(3).value="O";
		
		// Act / When
		  boolean res = board.checkDraw();
		
		// Assert / Then
		 assertEquals(true,res);
		 
	}

}
