package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.FIBA;
import model.Player;

public class StartController implements Initializable{
	
	private FIBA fiba;

    @FXML
    private ListView<Player> playersList;

    @FXML
    private Button butAddPlayer;

    @FXML
    private Label name;

    @FXML
    private Label age;

    @FXML
    private Label team;

    @FXML
    private Label pointsPerMatch;

    @FXML
    private Label reboundsPerMatch;

    @FXML
    private Label assistsPerMatch;

    @FXML
    private Label stealingsPerMatch;

    @FXML
    private Label blocksPerMatch;

    @FXML
    private Button butFilterPlayersByPoints;

    @FXML
    private Button butFilterPlayersByRebounds;

    @FXML
    private Button butFilterPlayersByAssists;

    @FXML
    private Button butFilterPlayersByStealings;

    @FXML
    private Button butFilterPlayersByBlocks;

    @FXML
    private Button butSave;

    @FXML
    private Button butLoadPlayers;
    
    public StartController() {
    	fiba = new FIBA();
    }

    @FXML
    void addPlayer(ActionEvent event) {
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addPlayer.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setTitle("Add a player");
    		stage.setResizable(false);
    		stage.setScene(new Scene(root1));  
    		stage.show();
    	}catch(FileNotFoundException e ) {
    		e.printStackTrace();
    	}catch(IOException s) {
    		s.printStackTrace();
    	}
    }

    @FXML
    void filterPlayersByAssists(ActionEvent event) {

    }

    @FXML
    void filterPlayersByBlocks(ActionEvent event) {

    }

    @FXML
    void filterPlayersByPoints(ActionEvent event) {

    }

    @FXML
    void filterPlayersByRebounds(ActionEvent event) {

    }

    @FXML
    void filterPlayersByStealings(ActionEvent event) {

    }

    @FXML
    void loadPlayers(ActionEvent event) {

    }
    
    public void addPlayerTxt() {
    	
    }
    
    public void refreshListView() {
    	ArrayList<Player> p = fiba.getPlayersPreorden();
    	playersList.getItems().addAll(p);
    }
    
    public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("datas/saved.dat", true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(fiba);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException s) {
			s.printStackTrace();
		}finally {
			try {
				if(oos != null) {
					oos.close();
				}
				if(fos != null) {
					fos.close();
				}
			} catch(IOException s) {
				s.printStackTrace();
			}
		}
	}
    
    public void readSerializable() {
    	FileInputStream fis = null;
		ObjectInputStream oos = null;
		try {
			fis = new FileInputStream("datas/saved.dat");
			oos = new ObjectInputStream(fis);
			fiba = (FIBA) oos.readObject();
			refreshListView();
		} catch (FileNotFoundException e) {
		       e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        
		    } finally {
		        try {
		             if (oos != null) {
		            	 oos.close();
		             }
		             if (fis != null) {
		            	 fis.close();
		             } 
		        } catch (IOException e) {
		             e.printStackTrace();
		        }
		    }
    }
       
    public void read() {
    	try {
    		File file = new File("datas/dataBase.csv");
    		FileReader fr = new FileReader(file);
    		BufferedReader br = new BufferedReader(fr);
    		String m = br.readLine();
    		m = br.readLine();
    		boolean finished = false;
    		Player p;
    		int i = 0;
    		while(m != null && !finished && i < 100) {
    			String[] line = m.split(",");
    			if(line[2].equals("0")) {
    				finished = true;
    			} else {
    				String l1 = line[2].isEmpty() ? "0" : line[2];
    				String l2 = line[1].isEmpty() ? "0" : line[1];
    				int l3 = line[4].isEmpty() ? 0 : Integer.parseInt(line[4]);
    				double l4 = line[7].isEmpty() ? 0 : Double.parseDouble(line[7]);
    				double l5 = line[12].isEmpty() ? 0 : Double.parseDouble(line[12]);
    				double l6 = line[13].isEmpty() ? 0 : Double.parseDouble(line[13]);
    				double l7 = line[14].isEmpty() ? 0 : Double.parseDouble(line[14]);
    				double l8 = line[15].isEmpty() ? 0 : Double.parseDouble(line[15]);
    				p = new Player(l1,l2,l3,l4,l5,l6,l7,l8);
    				fiba.addPlayerByPoints(p);
        			m = br.readLine();
        			i++;
    			}
    		}
    		save();
    		br.close();
    		fr.close();
    	}catch(FileNotFoundException s) {
    		s.printStackTrace();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		read();
		readSerializable();
	}
	
}
