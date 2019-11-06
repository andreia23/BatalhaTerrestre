import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * IFPB - TSI - POO 
 * @author Prof. Fausto Ayres
 *
 */
public class Tabuleiro {

	private JFrame frame;
	private JLabel[][] grid;
	private JogoBatalhaTerrestre jogo = new JogoBatalhaTerrestre();
	private JLabel label_tirosT = new JLabel("TIROS");
	private JLabel label_acertosT = new JLabel("ACERTOS");
	private JLabel label_acertos = new JLabel("0");
	private JLabel label_tiros = new JLabel("0");
	private final JLabel label_status = new JLabel("STATUS");
	private final JLabel label_statusT = new JLabel("");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuleiro window = new Tabuleiro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tabuleiro() {
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Matriz de Labels");
		frame.setBounds(100, 100, 815,635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Labels de info do jogo
		label_acertosT.setBounds(693, 40, 70, 15);
		frame.getContentPane().add(label_acertosT);

		label_tirosT.setBounds(693, 93, 70, 15);
		frame.getContentPane().add(label_tirosT);

		label_acertos.setBounds(713, 66, 70, 15);
		frame.getContentPane().add(label_acertos);

		label_tiros.setBounds(713, 110, 70, 15);
		frame.getContentPane().add(label_tiros);

		label_status.setBounds(693, 137, 70, 15);
		frame.getContentPane().add(label_status);

		label_statusT.setBounds(713, 152, 70, 15);
		frame.getContentPane().add(label_statusT);

		//inicializar a matriz de labels

		int n=10;
		grid = new JLabel[n][n];
		for(int y=0; y < n; y++){
			for(int x=0; x < n; x++){
				grid[x][y]=new JLabel();
				frame.getContentPane().add(grid[x][y]);
				grid[x][y].setBounds(x*60, y*60, 60, 60);   //x,y, width, height - 40x40
				grid[x][y].setBackground(Color.pink);
				grid[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				grid[x][y].setVerticalAlignment(SwingConstants.CENTER);
				grid[x][y].setBorder(new LineBorder(Color.BLACK, 1, true)); //arredondado
				grid[x][y].setOpaque(true);

				grid[x][y].addMouseListener(new  MouseAdapter(){
					public void mouseClicked(MouseEvent e){     //click

						///pra modificar a cor - lembra Andreia___________________________________________
						JLabel b = (JLabel)e.getSource();
						int indicex = b.getX()/60;
						int indicey = b.getY()/60;
						try {
							String tiro = jogo.atirar(indicey,indicex);




							///// modificando as cores de acordo com o ststus(alvo,proximo,distante)
							label_statusT.setText(tiro);
							if(tiro == "Alvo") {
								grid[indicex][indicey].setBackground(Color.red);
								label_acertos.setText(Integer.toString(jogo.get_acertos()));
							}
							else {
								if(tiro== "Proximo") {
									grid[indicex][indicey].setBackground(Color.blue);
								}
								else {
									grid[indicex][indicey].setBackground(Color.yellow);
								}
							}
							label_tiros.setText(Integer.toString(jogo.getQuant_tiros()));

							//if true                 

							System.out.println("clicou na celula:"+ indicey  + "-" + indicex);

							if(jogo.terminou() == true) {
								int resposta = JOptionPane.showConfirmDialog(
										frame, "O jogo acabou deseja jogar outra partida ?");
								if(resposta == JOptionPane.YES_OPTION)
									ResetGame();
								else if(resposta == JOptionPane.NO_OPTION)
									System.exit(0);
								else
									System.exit(0);

							}


						}catch(Exception erro) {
							label_statusT.setText(erro.getMessage());
							
						}
					}
					private void ResetGame() {
						//Resetando o tabuleiro
						for(int x = 0; x < n; x++) {
							for(int y = 0; y < n; y++) {
								grid[x][y].setBackground(Color.pink);
							}
						}
						//Novo objeto do jogo
						jogo = new JogoBatalhaTerrestre();

						//Reseta o placar
						label_acertos.setText(Integer.toString(jogo.get_acertos()));
						label_tiros.setText(Integer.toString(jogo.getQuant_tiros()));
					}


				});
			}
		}

	}

}