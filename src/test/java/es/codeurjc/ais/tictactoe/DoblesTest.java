package es.codeurjc.ais.tictactoe;
import org.junit.Test;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerResult;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class DoblesTest {
	
	private TicTacToeGame game;
	private Player p1,p2;
	private Connection c1, c2;
	
	@Before
	public void inicializar(){
		this.game=new TicTacToeGame();
		this.c1=mock(Connection.class);
		this.c2=mock(Connection.class);
		game.addConnection(c1);
		game.addConnection(c2);
		this.p1= new Player(1, "X", "ruben");
		this.p2= new Player(2, "O", "alfonso");
		game.addPlayer(p1);
		verify(c1).sendEvent(EventType.JOIN_GAME, game.getPlayers());
		verify(c2).sendEvent(EventType.JOIN_GAME, game.getPlayers());
		game.addPlayer(p2);
		verify(c1, times(2)).sendEvent(EventType.JOIN_GAME, game.getPlayers());
		verify(c2, times(2)).sendEvent(EventType.JOIN_GAME, game.getPlayers());
	}
	
	@Test
	public void WinsXtest(){
		game.mark(0);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(1);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(3);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(4);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(6);
		WinnerResult result=new WinnerResult();
		result=game.checkWinner();
		assertTrue(result.win);
		assertEquals(0, result.pos[0]);
		assertEquals(3, result.pos[1]);
		assertEquals(6, result.pos[2]);
	}
	
	@Test
	public void WinsOtest(){
		game.mark(1);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(0);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(2);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(4);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(5);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(8);
		WinnerResult result=new WinnerResult();
		result=game.checkWinner();
		assertTrue(result.win);
		assertEquals(0, result.pos[0]);
		assertEquals(4, result.pos[1]);
		assertEquals(8, result.pos[2]);
	}
	
	@Test
	public void checkDrawTest(){
		game.mark(0);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(1);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(2);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(5);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(4);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(6);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(7);
		verify(c2).sendEvent(EventType.SET_TURN, p2);
		verify(c1).sendEvent(EventType.SET_TURN, p2);
		reset(c1);
		reset(c2);
		game.mark(8);
		verify(c2).sendEvent(EventType.SET_TURN, p1);
		verify(c1).sendEvent(EventType.SET_TURN, p1);
		reset(c1);
		reset(c2);
		game.mark(3);
		WinnerResult result=new WinnerResult();
		result=game.checkWinner();
		assertFalse(result.win);
		boolean res=game.checkDraw();
		assertTrue(res);
		
	}
}