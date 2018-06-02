package menuPrincipal;


import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import interfaces.Tela;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JList;
import java.awt.Toolkit;

public class TelaPrincipal implements Tela {

	private JFrame frmTocadorDeMusica;
	private JList<String> listaMusica;
	private JLabel lblAddMusicImg;
	private JLabel lblAddMusic;
	DefaultListModel<String> modelo;
	private ArrayList<String> musicas;
	private JLabel lblPlay;
	private JLabel lblListaDeMusicas;
	private JLabel lblUserProfile;

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		frmTocadorDeMusica = new JFrame();
		frmTocadorDeMusica.setResizable(false);
		frmTocadorDeMusica.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		frmTocadorDeMusica.setTitle("Tocador de musica em alta qualidade mas com nome duvidoso");
		frmTocadorDeMusica.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\felip\\eclipse-workspace\\lp2\\icon\\icons8-notas-musicais-filled-50.png"));
		frmTocadorDeMusica.setBounds(100, 100, 852, 503);
		frmTocadorDeMusica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTocadorDeMusica.getContentPane().setLayout(null);
		listaMusica = new JList();
		lblAddMusicImg = new JLabel("");
		lblAddMusic = new JLabel("Add Musica");
		modelo = new DefaultListModel();
		 
		lblAddMusicImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMusicImg.setIcon(new ImageIcon("C:\\Users\\felip\\eclipse-workspace\\lp2\\icon\\icons8-musical-80.png"));
		lblAddMusicImg.setBounds(21, 49, 64, 64);
		frmTocadorDeMusica.getContentPane().add(lblAddMusicImg);
		
		
		listaMusica.setBounds(116, 49, 450, 404);
		frmTocadorDeMusica.getContentPane().add(listaMusica);
		
    	
		listaMusica.setModel(modelo);

		
		lblAddMusic.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 16));
		lblAddMusic.setBounds(10, 112, 96, 23);
		frmTocadorDeMusica.getContentPane().add(lblAddMusic);
		
		lblPlay = new JLabel("");
		lblPlay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tocarMusica(listaMusica.getSelectedValue().toString());
			}
		});
		lblPlay.setIcon(new ImageIcon("C:\\Users\\felip\\eclipse-workspace\\lp2\\icon\\look-kuya-kim-meets-his-kalokalike.png"));
		lblPlay.setBounds(10, 389, 64, 64);
		frmTocadorDeMusica.getContentPane().add(lblPlay);
		
		lblListaDeMusicas = new JLabel("Lista De Musicas");
		lblListaDeMusicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeMusicas.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 18));
		lblListaDeMusicas.setBounds(116, 24, 450, 14);
		frmTocadorDeMusica.getContentPane().add(lblListaDeMusicas);
		
		lblUserProfile = new JLabel("");
		lblUserProfile.setIcon(new ImageIcon("C:\\Users\\felip\\eclipse-workspace\\lp2\\icon\\icons8-usu\u00E1rio-80.png"));
		lblUserProfile.setBounds(746, 11, 80, 80);
		frmTocadorDeMusica.getContentPane().add(lblUserProfile);
		
		/*******************************************************************/
		/*Funcao de click para adicionar musica*/
		lblAddMusicImg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				modelo = addMusic(modelo);
				
			}
		});	
		/*******************************************************************/
		/*Funcao de click para adicionar musica*/
		lblAddMusic.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				modelo = addMusic(modelo);
			}
		});
	}
	
	public DefaultListModel<String> addMusic(DefaultListModel<String> modelo) {
		String temp = "";
		
		JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        	temp = chooser.getSelectedFile().getAbsolutePath();
    		modelo.addElement(temp);
    		return modelo;
        }
        return modelo;
	}
	
	
	public void tocarMusica(ArrayList<String> playlist){
		for(int i = 0; i < playlist.size(); i++) {
			try{
	            FileInputStream stream = new FileInputStream(playlist.get(i));
	            BufferedInputStream buffer = new BufferedInputStream(stream);
	            System.out.println("Executando...");
	            System.out.println("Terminado");
	        }
	        catch (Exception e) {
	            System.out.println("Erro ao tocar a musica: " + e.getMessage());
	            e.printStackTrace();
	        }
		}
	}
	
	public void tocarMusica(String musica){
		try{
            FileInputStream stream = new FileInputStream(musica);
            BufferedInputStream buffer = new BufferedInputStream(stream);
            System.out.println("Executando...");
            System.out.println("Terminado");
        }
        catch (Exception e) {
            System.out.println("Erro ao tocar a musica: " + e.getMessage());
            e.printStackTrace();
        }
	}

	@Override
	public void ativa() {
		frmTocadorDeMusica.setVisible(true);
	}
}

