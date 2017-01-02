import javax.swing.JFrame;

import javax.swing.JButton;


import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


public class Board extends JFrame implements ActionListener

{

	/**

	 * 

	 */

	private static final long serialVersionUID = 1L;

	JFrame frame=new JFrame("Connect4"); //creates frame

	JButton[][] grid; //names the grid of buttons

	int myWidth;

	int myLength;

	Player player1 = new Player("Red", 0, true);

	Player player2 = new Player("Black", 0, false);

	static boolean winner = false;


	public Board(int width, int length)

	{ 

		//Player player1 = new Player("Red", 0, true);

		//Player player2 = new Player("Blue", 0, false);

		myWidth = width; myLength = length;

		frame.setLayout(new GridLayout(width,length)); //set layout

		grid=new JButton[width][length]; //allocate the size of grid





		for(int x=0; x<width; x++)

		{

			for(int y=0; y<length; y++)

			{

				//grid[x][y]=new JButton(); //creates new button 

				JButton but = new JButton();

				but.addActionListener(this);

				but.setBackground(Color.WHITE);

				grid[x][y]= but; //creates new button



				frame.add(grid[x][y]); //adds button to grid

			}

		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack(); //sets appropriate size for frame

		frame.setVisible(true); //makes frame visible



		frame.setSize(1000,1000);

		frame.setLocationRelativeTo(null);

	}




	@Override

	public void actionPerformed(ActionEvent e)

	{

		// TODO Auto-generated method stub

		Object source = e.getSource();

		for(int i = 0; i < myWidth; i++)

		{

			for(int j = 0; j < myLength; j++)

			{

				if(source==grid[i][j])

				{

					processClick(i,j);

					return;

				}

			}

		}



	}


	private boolean isValidMove(int x, int y)

	{

		if( !(grid[x][y].getBackground().equals(Color.WHITE)) )

		{

			return false;

		}

		if( x!= myWidth-1 && (grid[x+1][y].getBackground().equals(Color.WHITE)) )

		{

			return false;

		}

		return true;

	}


	private void processClick(int i, int j) 

	{

		// TODO Auto-generated method stub

		if(winner) return;

		if(isValidMove(i, j) == false)

			return;

		if(player1.getTurn() == true)

		{

			grid[i][j].setBackground(Color.RED);

			player1.setTurn(false);

			player2.setTurn(true);

		}

		else

		{

			grid[i][j].setBackground(Color.BLACK);

			player2.setTurn(false);

			player1.setTurn(true);

		}

		String check = checkwinner();

		if(check.equals("Red Wins!") || check.equals("Black Wins!"))

		{

			System.out.println( check );

			return;

		}


	}


	private String checkwinner()

	{ 

		//rows

		for(int i = 0; i < myWidth; i++)

		{

			for(int j = 0; j < myLength - 3; j ++)

			{

				if( !(grid[i][j].getBackground().equals(Color.WHITE)))

				{

					if( (grid[i][j].getBackground().equals(grid[i][j+1].getBackground()) ) &&

							(grid[i][j].getBackground().equals(grid[i][j+2].getBackground())) &&

							(grid[i][j].getBackground().equals(grid[i][j+3].getBackground()) ))

					{

						if(grid[i][j].getBackground().equals(Color.RED))

						{

							winner = true;

							return "Red Wins!";


						}

						else 

						{

							winner = true;

							return "Black Wins!";

						}

					}

				}

			}

		}


		//cols

		for(int i = 0; i < myWidth-3; i++)

		{

			for(int j = 0; j < myLength; j ++)

			{

				if( !(grid[i][j].getBackground().equals(Color.WHITE)))

				{

					if( (grid[i][j].getBackground().equals(grid[i+1][j].getBackground()) ) &&

							(grid[i][j].getBackground().equals(grid[i+2][j].getBackground())) &&

							(grid[i][j].getBackground().equals(grid[i+3][j].getBackground()) ))

					{

						if(grid[i][j].getBackground().equals(Color.RED))

						{

							winner = true;

							return "Red Wins!";


						}

						else 

						{

							winner = true;

							return "Black Wins!";

						}

					}

				}

			}

		}


		//diags


		//top left to bottom right

		for(int i = 0; i < myWidth-3; i++)

		{

			for(int j = 0; j < myLength-3; j++)

			{

				if( !(grid[i][j].getBackground().equals(Color.WHITE)))

				{

					if( (grid[i][j].getBackground().equals(grid[i+1][j+1].getBackground()) ) &&

							(grid[i][j].getBackground().equals(grid[i+2][j+2].getBackground())) &&

							(grid[i][j].getBackground().equals(grid[i+3][j+3].getBackground()) ))

					{

						if(grid[i][j].getBackground().equals(Color.RED))

						{

							winner = true;

							return "Red Wins!";


						}

						else 

						{

							winner = true;

							return "Black Wins!";

						}

					}

				}


			}

		}


		//top right to bottom left

		for(int i = 0; i < myWidth-3; i++)

		{

			for(int j = myLength-1; j >= myLength - 4; j--)

			{

				if( !(grid[i][j].getBackground().equals(Color.WHITE)))

				{

					if( (grid[i][j].getBackground().equals(grid[i+1][j-1].getBackground()) ) &&

							(grid[i][j].getBackground().equals(grid[i+2][j-2].getBackground())) &&

							(grid[i][j].getBackground().equals(grid[i+3][j-3].getBackground()) ))

					{

						if(grid[i][j].getBackground().equals(Color.RED))

						{

							winner = true;

							return "Red Wins!";


						}

						else

						{

							winner = true;

							return "Black Wins!";

						}

					}

				}


			}

		}


		return "";


	}

	public static void main(String[] args) 

	{

		// TODO Auto-generated method stub

		new Board(6,7);//makes new ButtonGrid with 2 parameters



	}


}