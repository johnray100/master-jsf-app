package jay.net.masterjsfapp.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {
    public static void addMessage(String summary, String detail, String severity) {
        FacesMessage.Severity facesSeverity;
        switch (severity) {
            case "info":
                facesSeverity = FacesMessage.SEVERITY_INFO;
                break;
            case "warn":
                facesSeverity = FacesMessage.SEVERITY_WARN;
                break;
            case "error":
                facesSeverity = FacesMessage.SEVERITY_ERROR;
                break;
            default:
                facesSeverity = FacesMessage.SEVERITY_INFO;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(facesSeverity, summary, detail));
    }
}
