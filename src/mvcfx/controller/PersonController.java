package mvcfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mvcfx.model.service.PersonService;
import mvcfx.util.AlertUtil;

public class PersonController implements Initializable{
    
    private final PersonService personService = new PersonService();
    
    @FXML
    private TextField jTextFieldNome;
    @FXML
    private TextField jTextFieldEndereco;
    @FXML
    private TextField jTextFieldCpf;
    @FXML
    private TextField jTextFieldRg;
    @FXML
    private ComboBox jComboBoxSexo;
    @FXML
    private Button jButtonSalvar;
    @FXML
    private Button jButtonLimpar;
    @FXML
    private Button jButtonFechar;
    
    @FXML
    private static AnchorPane jPanelPrincipal;

    public static AnchorPane getjPanelPrincipal() {
        return jPanelPrincipal;
    }

    public static void setjPanelPrincipal(AnchorPane jPanelPrincipal) {
        PersonController.jPanelPrincipal = jPanelPrincipal;
    }
        

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //preenche a combobox
        ObservableList<String> listSexo = FXCollections.observableArrayList("Não informado", "Feminino", "Masculino");
        jComboBoxSexo.setItems(listSexo);
        
        //configura o textfield para aceitar apenas números e limita o números de dígitos
        jTextFieldCpf.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                jTextFieldCpf.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (jTextFieldCpf.getText().length() > 11) {
                String s = jTextFieldCpf.getText().substring(0, 11);
                jTextFieldCpf.setText(s);
            }
        });
        
        //configura o textfield para aceitar apenas números
        jTextFieldRg.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                jTextFieldRg.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
    
    @FXML
    public void handleButtonSalvar() throws IOException{
        
        if(validateFields()){
            if(personService.insertPerson(jTextFieldNome.getText(), jTextFieldCpf.getText(), 
                    jTextFieldRg.getText(), jComboBoxSexo.getSelectionModel().getSelectedItem().toString(), 
                    jTextFieldEndereco.getText())){
                AlertUtil.show("Confirmação de Cadastro", "Pessoa cadastrada com sucesso", Alert.AlertType.INFORMATION);
                handleButtonFechar();
            } else{
                AlertUtil.show("Erro ao Cadastrar", "Não foi possível cadastrar a Pessoa", Alert.AlertType.ERROR);
            }
        } else{
            AlertUtil.show("Validação de Dados", "Preencha todos os campos", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    public void handleButtonLimpar() throws IOException{
        jTextFieldNome.clear();
        jTextFieldEndereco.clear();
        jTextFieldRg.clear();
        jTextFieldCpf.clear();      
        jComboBoxSexo.getSelectionModel().select(0);
    }
    
    @FXML
    public void handleButtonFechar() throws IOException{
        jPanelPrincipal.getChildren().clear();                
    }
    
    private boolean validateFields(){
        if(jTextFieldNome.getText().isEmpty()) return false;
        else if(jTextFieldEndereco.getText().isEmpty()) return false;
        else if(jTextFieldCpf.getText().isEmpty()) return false;
        else if(jTextFieldRg.getText().isEmpty()) return false;
        else if(jComboBoxSexo.getSelectionModel().isEmpty()) return false;
        else return true;
    }

}
