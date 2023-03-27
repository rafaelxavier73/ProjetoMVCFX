package mvcfx.util;

public class Session {
    
    private static int recoveryCode;
    private static String userName;

    public static int getRecoveryCode() {
        return recoveryCode;
    }

    public static void setRecoveryCode(int recoveryCode) {
        Session.recoveryCode = recoveryCode;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Session.userName = userName;
    }
    
    

}
