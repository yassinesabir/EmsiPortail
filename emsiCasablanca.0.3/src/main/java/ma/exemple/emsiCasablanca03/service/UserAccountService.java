package ma.exemple.emsiCasablanca03.service;

import ma.exemple.emsiCasablanca03.entities.EmsiUser;
import ma.exemple.emsiCasablanca03.entities.UserRole;

public interface UserAccountService {
    EmsiUser addNewStudent(String firstname, String lastname, String username, String email, String password, String phone, String sector, String level, Integer usergroup);
    EmsiUser addNewTeacher(String firstname, String lastname, String username,String email, String password, String phone, String assignment);
    EmsiUser addNewAdmin(String username, String email, String password, String phone);
    EmsiUser addNewSectorManager(String firstname, String lastname, String username,String email, String password, String phone, String assignment, String level);
    UserRole addNewRole (String role);
    void addRoleToUser (String username, String role);
    void deleteRoleFromUser (String username, String role);
    EmsiUser loadUserByUsername(String username);
}