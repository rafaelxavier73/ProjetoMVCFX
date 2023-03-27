package mvcfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{
    
    @FXML
    private MenuItem jMenuItemPessoa;
    
    @FXML
    private MenuItem jMenuItemVenda;
    
    @FXML
    private MenuItem jMenuItemProduto;
    
    @FXML
    private MenuItem jMenuItemRelPessoas;

    @FXML
    private AnchorPane jPanelPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    private void openScreen(String resource) throws IOException{
        AnchorPane anchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource(resource));
        jPanelPrincipal.getChildren().setAll(anchorPane);        
    }
    
    @FXML
    public void handleMenuItemPessoa() throws IOException {
        openScreen("/mvcfx/view/PersonView.fxml");    
        PersonController.setjPanelPrincipal(jPanelPrincipal);
    }
    
    @FXML
    public void handleMenuItemProduto() throws IOException {
        openScreen("/mvcfx/view/ProdutoView.fxml");    
    }
    
    @FXML
    public void handleMenuItemVenda() throws IOException {
        openScreen("/mvcfx/view/TelaVendaView.fxml");    
    }
    
    @FXML
    public void handleMenuItemRelPessoas() throws IOException {
        openScreen("/mvcfx/view/RelatorioPessoaView.fxml");    
    }

}
