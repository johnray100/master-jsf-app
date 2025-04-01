package jay.net.masterjsfapp.controller;

import jay.net.masterjsfapp.helper.FacesUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class VerifyAccountBean implements Serializable {
    private String verificationCode;
    private final String correctCode = "123456"; // Simulated correct code

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public void verifyAccount() {
        if (verificationCode != null && verificationCode.equals(correctCode)) {
            FacesUtils.addMessage("Success", "Your account has been verified!", "info");
        } else {
            FacesUtils.addMessage("Error", "Invalid verification code.", "error");
        }
    }

    public void resendCode() {
        FacesUtils.addMessage("Info", "A new verification code has been sent to your email.", "info");
    }
}
