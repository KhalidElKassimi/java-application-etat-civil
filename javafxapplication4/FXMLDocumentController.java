/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Models.Deces;
import Models.Mariage;
import Models.Personne;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author khalid
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private Tab PersonneTab;
    @FXML
    private TextField tfIdPersonne;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfSexe;
    @FXML
    private TextField tfLieuNaiss;
    @FXML
    private DatePicker dpDateNaiss;
    @FXML
    private TextField tfIdPere;
    @FXML
    private TextField tfIdMere;
    @FXML
    private TableView<Personne> tvPersonne;
    @FXML
    private TableColumn<Personne, Integer> idCol;
    @FXML
    private TableColumn<Personne, String> nomCol;
    @FXML
    private TableColumn<Personne, String> prenomCol;
    @FXML
    private TableColumn<Personne, String> sexeCol;
    @FXML
    private TableColumn<Personne, String> lieuNaissCol;
    @FXML
    private TableColumn<Personne, Date> dateNaissCol;
    @FXML
    private Button btmInsert1;
    @FXML
    private Button btmUpdate1;
    @FXML
    private Button btmDelete1;
    @FXML
    private Tab MariageTab;
    @FXML
    private TextField tfIdMariage;
    @FXML
    private TextField tfIdEpoux;
    @FXML
    private TextField tfIdEpouse;
    @FXML
    private DatePicker dpDateMariage;
    @FXML
    private TextField tfLieuMariage;
    @FXML
    private TableView<Mariage> tvMariage;
    @FXML
    private TableColumn<Mariage, Integer> idMariageCol;
    @FXML
    private TableColumn<Mariage, Date> dateMariageCol;
    @FXML
    private TableColumn<Mariage, String> lieuMariageCol;
    @FXML
    private Button btmInsert2;
    @FXML
    private Button btmDelete2;
    @FXML
    private Button btmUpdate2;
    @FXML
    private Tab DecesTab;
    @FXML
    private TextField tfIdDeces;
    @FXML
    private TextField tfIdFeu;
    @FXML
    private DatePicker dpDateDeces;
    @FXML
    private TextField tfLieuDeces;
    @FXML
    private TextField tfCauseDeces;
    @FXML
    private TableView<Deces> tvDeces;
    @FXML
    private TableColumn<Deces, Integer> idDecesCol;
    @FXML
    private TableColumn<Deces, Date> dateDecesCol;
    @FXML
    private TableColumn<Deces, String> lieuDecesCol;
    @FXML
    private TableColumn<Deces, String> causeDecesCol;
    @FXML
    private Button btmInsert3;
    @FXML
    private Button btmUpdate3;
    @FXML
    private Button btmDelete3;
    @FXML
    private TextField keywordTextField1;
    @FXML
    private TextField keywordTextField2;
    @FXML
    private TextField keywordTextField3;
    @FXML
    private TableColumn<Personne, Integer> idPereCol;
    @FXML
    private TableColumn<Personne, Integer> idMereCol;
    @FXML
    private TableColumn<Mariage, Integer> idEpouxCol;
    @FXML
    private TableColumn<Deces, Integer> idFeuCol;
    @FXML
    private TableColumn<Mariage, Integer> idEpouseCol;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showPersonne();
        showMariage();
        showDeces();
        
        search1();    
        search2();
        search3();
    }  
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource()==btmInsert1){
            insertRecord1();
        }
        else if(event.getSource()==btmInsert2){
            insertRecord2();
        }
        else if(event.getSource()==btmInsert3){
            insertRecord3();
        }
        
        else if(event.getSource()==btmUpdate1){
            updateRecord1();
        }
        
        else if(event.getSource()==btmUpdate2){
            updateRecord2();
        }
        
        else if(event.getSource()==btmUpdate3){
            updateRecord3();
        }
        else if(event.getSource()==btmDelete1){
            deleteRecord1();
        }
        else if(event.getSource()==btmDelete2){
            deleteRecord2();
        }
        else if(event.getSource()==btmDelete3){
            deleteRecord3();
        }
    }
    
    public Connection getConnection(){ 
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/etatcivil", "root","");
            return conn;
            
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
    }
    public ObservableList<Personne> getPersonneList() {
        ObservableList<Personne>  PersonneList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from personne";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Personne personne;
            while(rs.next()){
            personne = new Personne(rs.getInt("Id"), rs.getString("nom"), rs.getString("prenom"), 
                    rs.getString("sexe"), rs.getString("lieuNaiss"), rs.getDate("dateNaiss"), rs.getInt("idPere"), 
                    rs.getInt("idMere")); 
                System.out.println(personne);
            PersonneList.add(personne);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return PersonneList;
    }
    
    public ObservableList<Mariage> getMariageList() {
       ObservableList<Mariage>  MariageList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "Select * from `mariage`";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Mariage mariage;
            while(rs.next()){
            mariage = new Mariage(rs.getInt("idMariage"), rs.getDate("dateMar"), rs.getString("lieuMar"),rs.getInt("idEpoux"), rs.getInt("idEpouse"));
            MariageList.add(mariage);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return MariageList;
    }
    
    ObservableList<Personne>  PersonneList = FXCollections.observableArrayList();
    ObservableList<Mariage>  MariageList = FXCollections.observableArrayList();
    ObservableList<Deces>  DecesList = FXCollections.observableArrayList();
    
    public ObservableList<Deces> getDecesList() {
       ObservableList<Deces>  DecesList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "Select * from `deces`";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Deces deces;
            while(rs.next()){
            deces = new Deces(rs.getInt("idDeces"), rs.getDate("dateDeces"), rs.getString("causeDeces"),rs.getString("lieuDeces"),rs.getInt("idFeu"));
            DecesList.add(deces);
        }//Deces(int idDeces,  Date dateDeces, String causeDeces, String lieuDeces, String nomFeu, String prenomFeu)
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return DecesList;
    }
    
    public void showPersonne(){
        ObservableList<Personne> listPersonne=getPersonneList();
        
        idCol.setCellValueFactory(new PropertyValueFactory<Personne,Integer>("Id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<Personne,String>("Nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<Personne,String>("Prenom"));
        sexeCol.setCellValueFactory(new PropertyValueFactory<Personne,String>("Sexe"));
        lieuNaissCol.setCellValueFactory(new PropertyValueFactory<Personne,String>("lieuNaiss"));
        dateNaissCol.setCellValueFactory(new PropertyValueFactory<Personne,Date>("dateNaiss"));
        idPereCol.setCellValueFactory(new PropertyValueFactory<Personne,Integer>("idPere"));
        idMereCol.setCellValueFactory(new PropertyValueFactory<Personne,Integer>("idMere"));

        
        tvPersonne.setItems(listPersonne);
    }
    
    public void showMariage(){
        ObservableList<Mariage>  mariageList =getMariageList();
        
        idMariageCol.setCellValueFactory(new PropertyValueFactory<Mariage,Integer>("idMariage"));
        idEpouxCol.setCellValueFactory(new PropertyValueFactory<Mariage,Integer>("idEpoux"));
        idEpouseCol.setCellValueFactory(new PropertyValueFactory<Mariage,Integer>("idEpouse"));
        lieuMariageCol.setCellValueFactory(new PropertyValueFactory<Mariage,String>("lieuMariage"));
        dateMariageCol.setCellValueFactory(new PropertyValueFactory<Mariage,Date>("dateMariage"));
         
        
        tvMariage.setItems(mariageList);
        
        
    }
    
    public void showDeces(){
        ObservableList<Deces>  decesList =getDecesList();
        
        idDecesCol.setCellValueFactory(new PropertyValueFactory<Deces,Integer>("idDeces"));
        idFeuCol.setCellValueFactory(new PropertyValueFactory<Deces,Integer>("idPersonne"));
        causeDecesCol.setCellValueFactory(new PropertyValueFactory<Deces,String>("causeDeces"));
        lieuDecesCol.setCellValueFactory(new PropertyValueFactory<Deces,String>("lieuDeces"));
        dateDecesCol.setCellValueFactory(new PropertyValueFactory<Deces,Date>("dateDeces"));
        
        tvDeces.setItems(decesList);
        
    }
    
    private void insertRecord1(){
        String query = "INSERT into personne values("+tfIdPersonne.getText()+",'"+tfNom.getText()+"','"+tfPrenom.getText()+
                "','"+tfSexe.getText()+"','"+tfLieuNaiss.getText()+
                "','"+dpDateNaiss.getValue()+"',"+tfIdPere.getText()+","+tfIdMere.getText()+")";
        executeQuery(query);
        showPersonne();
    }
    
    private void updateRecord1(){
        String query = "UPDATE personne SET nom = '"+tfNom.getText()+"', prenom = '"+tfPrenom.getText()+"', sexe = '"+tfSexe.getText()+"', lieuNaiss = '"
                +tfLieuNaiss.getText()+"', dateNaiss= '"+dpDateNaiss.getValue()+"', idPere = "+tfIdPere.getText()+", idMere = "+tfIdPere.getText()+"";
        executeQuery(query);
        showPersonne();
    }
    
    private void deleteRecord1(){
        String query ="DELETE FROM personne where id="+tfIdPersonne.getText()+"";
        executeQuery(query);
        showPersonne();
    }
    
    private void insertRecord2(){
        String query = "INSERT into mariage values("+tfIdMariage.getText()+",'"
                +dpDateMariage.getValue()+"','"+tfLieuMariage.getText()+"',"+tfIdEpoux.getText()+","+tfIdEpouse.getText()+")";
        executeQuery(query);
        showMariage();
    }
    
    private void updateRecord2(){
        String query = "UPDATE mariage SET dateMar = '"+dpDateMariage.getValue()+"', lieuMar = '"+tfLieuMariage.getText()+"', idEpoux = "+tfIdEpoux.getText()+", idEpouse = "
                +tfIdEpouse.getText()+"";
        executeQuery(query);
        showMariage();
    }
    
    private void deleteRecord2(){
        String query ="DELETE FROM mariage where idMariage="+tfIdMariage.getText()+"";
        executeQuery(query);
        showMariage();
    }
    
    private void insertRecord3(){
        String query = "INSERT into deces values("+tfIdDeces.getText()+",'"
                +dpDateDeces.getValue()+"','"+tfLieuDeces.getText()+"','"+tfCauseDeces.getText()+"',"+tfIdFeu.getText()+")";
        executeQuery(query);
        showDeces();
    }
    
    private void updateRecord3(){
        String query = "UPDATE deces SET dateDeces = '"+dpDateDeces.getValue()+"', lieuDeces = '"+tfLieuDeces.getText()+"', causeDeces = '"+tfCauseDeces.getText()+"', idFeu = "
                +tfIdFeu.getText()+"";
        executeQuery(query);
        showDeces();
    }
    
    private void deleteRecord3(){
        String query ="DELETE FROM deces where idDeces="+tfIdDeces.getText()+"";
        executeQuery(query);
        showDeces();
    }
    
    private void executeQuery(String query){
        Connection conn = getConnection();
        Statement st;
        try{
            st=conn.createStatement();   
            st.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
 
    public void search1(){
        FilteredList<Personne> filteredData = new FilteredList<>(getPersonneList(), b->true);
         
         keywordTextField1.textProperty().addListener((observable, oldValue, newValue) ->{
             filteredData.setPredicate(personne ->{
                 
                 if(newValue.isEmpty() || newValue==null){
                     return true;
                 }
                 
                 String searchKeyword = newValue.toLowerCase();
                 if(personne.getNom().toLowerCase().indexOf(searchKeyword) != -1){
                     return true;
                 }else if(personne.getPrenom().toLowerCase().indexOf(searchKeyword) > -1){
                     return true;
                 }else
                       return false;});
             });
             SortedList<Personne> sortedData = new SortedList<Personne>(filteredData);
             
             sortedData.comparatorProperty().bind(tvPersonne.comparatorProperty());
             tvPersonne.setItems(sortedData);
    }
    
    public void search2(){
        FilteredList<Mariage> filteredData = new FilteredList<>(getMariageList(), b->true);
         
         keywordTextField2.textProperty().addListener((observable, oldValue, newValue) ->{
             filteredData.setPredicate(mariage ->{
                 
                 if(newValue.isEmpty() || newValue==null){
                     return true;
                 }
                 
                 String searchKeyword = newValue.toLowerCase();
                 if(mariage.getLieuMariage().toLowerCase().indexOf(searchKeyword) != -1){
                     return true;
                 }else
                       return false;});
             });
             SortedList<Mariage> sortedData = new SortedList<Mariage>(filteredData);
             
             sortedData.comparatorProperty().bind(tvMariage.comparatorProperty());
             tvMariage.setItems(sortedData);
         
         
    
    }
   
    
    public void search3(){
        FilteredList<Deces> filteredData = new FilteredList<>(getDecesList(), b->true);
         
         keywordTextField3.textProperty().addListener((observable, oldValue, newValue) ->{
             filteredData.setPredicate(deces ->{
                 
                 if(newValue.isEmpty() || newValue==null){
                     return true; 
                 }
                 
                 String searchKeyword = newValue.toLowerCase();
                 if(deces.getLieuDeces().toLowerCase().indexOf(searchKeyword) != -1){
                     return true;
                 }else
                       return false;});
             });
             SortedList<Deces> sortedData = new SortedList<Deces>(filteredData);
             
             sortedData.comparatorProperty().bind(tvDeces.comparatorProperty());
             tvDeces.setItems(sortedData);
        
         
    }
  

    @FXML
    private void handleMouseAction1(javafx.scene.input.MouseEvent event) {
        Personne personne =tvPersonne.getSelectionModel().getSelectedItem();
        tfIdPersonne.setText(""+personne.getId());
        tfNom.setText(personne.getNom());
        tfPrenom.setText(personne.getPrenom());
        tfSexe.setText(personne.getSexe());
        tfLieuNaiss.setText(personne.getLieuNaiss());
        dpDateNaiss.setValue(personne.getDateNaiss().toLocalDate());
        tfIdPere.setText(""+personne.getIdPere());
        tfIdMere.setText(""+personne.getIdMere());
    }

    @FXML
    private void handleMouseAction2(javafx.scene.input.MouseEvent event) {
         Mariage mariage =tvMariage.getSelectionModel().getSelectedItem();
        tfIdMariage.setText(""+mariage.getIdMariage());
        tfIdEpoux.setText(""+mariage.getIdEpoux());
        tfIdEpouse.setText(""+mariage.getIdEpouse());
        tfLieuMariage.setText(mariage.getLieuMariage());
        dpDateMariage.setValue(mariage.getDateMariage().toLocalDate());
    }

    @FXML
    private void handleMouseAction3(javafx.scene.input.MouseEvent event) {
        Deces deces =tvDeces.getSelectionModel().getSelectedItem();
        tfIdDeces.setText(""+deces.getIdDeces());
        tfIdFeu.setText(""+deces.getIdPersonne());
        tfLieuDeces.setText(deces.getLieuDeces());
        dpDateDeces.setValue(deces.getDateDeces().toLocalDate());
        tfCauseDeces.setText(deces.getCauseDeces());
    }
    
    
    
}
