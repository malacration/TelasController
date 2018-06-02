package menuPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaManipMusic {

	private JFrame frame;
	private JList<String> list;
	private JLabel lblAdd;
	private JLabel lblRemover;
	private JLabel lblRemoverAll;
	private JLabel lblAdicionar;
	private JLabel lblRemover_1;
	private JLabel lblRemoverTodos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaManipMusic window = new TelaManipMusic();
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
	public TelaManipMusic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 400, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		list = new JList<String>();
		list.setBounds(10, 11, 374, 330);
		frame.getContentPane().add(list);
		
		lblAdd = new JLabel("");
		lblAdd.setVerticalAlignment(SwingConstants.TOP);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setIcon(new ImageIcon("C:\\Users\\felip\\eclipse-workspace\\lp2\\icon\\telaManipMusic\\icons8-mais-filled-50.png"));
		lblAdd.setBounds(20, 352, 50, 50);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblRemover = new JLabel("");
		lblRemover.setVerticalAlignment(SwingConstants.TOP);
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setIcon(new ImageIcon("C:\\Users\\felip\\eclipse-workspace\\lp2\\icon\\telaManipMusic\\icons8-excluir-filled-50.png"));
		lblRemover.setBounds(160, 352, 50, 50);
		frame.getContentPane().add(lblRemover);
		
		lblRemoverAll = new JLabel("New label");
		lblRemoverAll.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemoverAll.setIcon(new ImageIcon("C:\\Users\\felip\\eclipse-workspace\\lp2\\icon\\telaManipMusic\\icons8-lixo-filled-50.png"));
		lblRemoverAll.setBounds(308, 352, 50, 50);
		frame.getContentPane().add(lblRemoverAll);
		
		
		lblAdicionar = new JLabel("Adicionar");
		lblAdicionar.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		lblAdicionar.setBounds(10, 398, 70, 14);
		frame.getContentPane().add(lblAdicionar);
		
		
		lblRemover_1 = new JLabel("Remover");
		lblRemover_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		lblRemover_1.setBounds(150, 398, 70, 14);
		frame.getContentPane().add(lblRemover_1);
		
		
		lblRemoverTodos = new JLabel("Remover Todos");
		lblRemoverTodos.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		lblRemoverTodos.setBounds(281, 399, 103, 14);
		frame.getContentPane().add(lblRemoverTodos);
	}

}
