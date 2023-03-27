package mvcfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mvcfx.model.service.RecoveryService;
import mvcfx.util.AlertUtil;
import mvcfx.util.Session;

public class RecoveryController implements Initializable{
    
    private final RecoveryService recoveryService = new RecoveryService();
    
    @FXML
    private TextField jTextFieldCodigoRecuperacao;
    @FXML
    private PasswordField jPasswordFieldNovaSenha;
    @FXML
    private PasswordField jPasswordFieldConfirmaNovaSenha;
    @FXML
    private Button jButtonAlteraSenha;
    @FXML
    private Button jButtonFechar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // force the field to be numeric only
        jTextFieldCodigoRecuperacao.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                jTextFieldCodigoRecuperacao.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
    
    @FXML
    public void handleButtonAlteraSenha() throws IOException{
        
        if(validateFields()){
        
            if(checkRecoveryCode(Integer.parseInt(jTextFieldCodigoRecuperacao.getText()))){

                if(checkPasswords()){

                    if(recoveryService.updatePassword(Session.getUserName(), jPasswordFieldNovaSenha.getText())){
                        AlertUtil.show("Alteração de Senha", "Senha alterada com sucesso", Alert.AlertType.INFORMATION);
                        handleButtonFechar();
                    }

                } else{
                    AlertUtil.show("Alteração de senha", "Senhas informadas não conferem", Alert.AlertType.ERROR);
                }            

            } else{
                AlertUtil.show("Código de Recuperação", "Código de recuperação incorreto", Alert.AlertType.ERROR);
            }
            
        } else{
            AlertUtil.show("Validação de Dados", "Preencha todos os campos", Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    public void handleButtonFechar() throws IOException{
        Stage stage = (Stage) jButtonFechar.getScene().getWindow();
        stage.close();                
    }
    
    private boolean validateFields(){
        if(jTextFieldCodigoRecuperacao.getText().isEmpty()) return false;
        else if(jPasswordFieldNovaSenha.getText().isEmpty()) return false;
        else if(jPasswordFieldConfirmaNovaSenha.getText().isEmpty()) return false;
        else return true;
    }
    
    private boolean checkRecoveryCode(int code){
        return(Session.getRecoveryCode() == code);
    }

    private boolean checkPasswords() {
        return(jPasswordFieldNovaSenha.getText().equals(jPasswordFieldConfirmaNovaSenha.getText()));
    }
    
    


}
