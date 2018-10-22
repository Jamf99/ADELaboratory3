package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Player;

public class AddPlayerDialog {
	
	private StartController principal;
	private boolean flag = false;
	
	public AddPlayerDialog() {
	}

    @FXML
    private Button butAddPlayer;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtTeam;

    @FXML
    private TextField txtPPM;

    @FXML
    private TextField txtSPM;

    @FXML
    private TextField txtAPM;

    @FXML
    private TextField txtBPM;

    @FXML
    private TextField txtRPM;
    
    public boolean getFlag() {
    	return flag;
    }
    
    public Button getButtAddPlayer() {
    	return butAddPlayer;
    }

    @FXML
    void addP(ActionEvent event) {
    	Player p = new Player(txtName.getText(), txtTeam.getText(), Integer.parseInt(txtAge.getText()),
    			Double.parseDouble(txtPPM.getText()), Double.parseDouble(txtRPM.getText()), Double.parseDouble(txtAPM.getText()),
    			Double.parseDouble(txtSPM.getText()), Double.parseDouble(txtBPM.getText()));
    	flag = true;
    	principal.addPlayer(p);
    }

}
