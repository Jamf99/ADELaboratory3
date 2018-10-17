package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AddPlayerDialog {

    @FXML
    private ListView<?> playersList;

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
    private Button butLoadPlayers;

    @FXML
    void addP(ActionEvent event) {

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

}
