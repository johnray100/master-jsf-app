package jay.net.masterjsfapp.controller;

import jay.net.masterjsfapp.helper.FacesUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Random;

@ManagedBean
@ViewScoped
public class TwoFactorAuthBean implements Serializable {

    private String twoFACode;
    private String generatedCode = generateNewCode();

    public String getTwoFACode() {
        return twoFACode;
    }

    public void setTwoFACode(String twoFACode) {
        this.twoFACode = twoFACode;
    }

    public void verifyCode() {
        if (twoFACode != null && twoFACode.equals(generatedCode)) {
            FacesUtils.addMessage("Success", "2FA verification successful!", "info");
        } else {
            FacesUtils.addMessage("Error", "Invalid 2FA code.", "error");
        }
    }

    public void resendCode() {
        generatedCode = generateNewCode();
        FacesUtils.addMessage("Info", "A new 2FA code has been sent to your email.", "info");
    }

    private String generateNewCode() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000)); // Generates a 6-digit random code
    }
}
