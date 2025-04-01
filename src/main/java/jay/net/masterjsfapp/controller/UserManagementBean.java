package jay.net.masterjsfapp.controller;

import jay.net.masterjsfapp.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserManagementBean implements Serializable {

    private List<User> userList = new ArrayList<>();
    private User selectedUser = new User();

    public UserManagementBean() {
        // Sample Data
        userList.add(new User(1, "John Doe", "john@example.com"));
        userList.add(new User(2, "Jane Smith", "jane@example.com"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void prepareNewUser() {
        this.selectedUser = new User();
    }

    public void saveUser() {
        if (selectedUser.getId() == 0) {
            selectedUser.setId(userList.size() + 1);
            userList.add(selectedUser);
        }
    }

    public void editUser(User user) {
        this.selectedUser = user;
    }

    public void deleteUser(User user) {
        userList.remove(user);
    }
}
