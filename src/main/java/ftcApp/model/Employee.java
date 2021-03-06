package ftcApp.model;

import ftcApp.model.enums.UserRole;

import javax.persistence.Entity;

@Entity
public class Employee extends User {

    public Employee() { }

    public Employee(String login, String password, String name, UserRole userRole) {
        setLogin(login);
        setPassword(password);
        setUserRole(userRole);
        setName(name);
    }
}
