

public class Player 

{


	String myColor;

	int myPoints;

	boolean myTurn;


	public Player(String color, int points, boolean turn)

	{

		myColor = color; myPoints = points; myTurn = turn;

	}


	void setPoints(int point)

	{

		myPoints = point;

	}


	void setTurn(boolean newturn)

	{

		myTurn = newturn;

	}


	int getPoints()

	{

		return myPoints;

	}


	boolean getTurn()

	{

		return myTurn;

	}


	public static void main(String[] args) 

	{

		// TODO Auto-generated method stub


	}


}