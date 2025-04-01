package jay.net.masterjsfapp.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class ChangePassword implements Serializable {

    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

    // Simulated stored password (replace with real DB logic)
    private String storedPassword = "password123";

    // Getter & Setter
    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getStoredPassword() {
        return storedPassword;
    }

    public void setStoredPassword(String storedPassword) {
        this.storedPassword = storedPassword;
    }

    public void changePassword() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (!currentPassword.equals(storedPassword)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Current password is incorrect"));
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "New passwords do not match"));
            return;
        }

        // Simulate password update
        storedPassword = newPassword;
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Password changed successfully"));
    }
}
