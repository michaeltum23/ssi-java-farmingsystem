/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmingsystem.model;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author MTUMANGAN
 */
public class User {

    private int id;
    private String userId;
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String birthDate;
    private String contactNumber;
    private String houseNo;
    private String streetAddress;
    private String cityAddress;
    private InputStream profielImage;
    private byte validId;
    private String email;
    private String userType;
    private Boolean active;
    private File file;
    private byte[] userImage;
    private String verifyCode;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public User() {
    }

    public User(int id, String username, String email, String password, String verifyCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.verifyCode = verifyCode;
    }
    
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    

    public User(int id, String userId, String username, String password,
            String firstName, String middleName, String lastName, String gender,
            String birthDate, String contactNumber, String houseNo,
            String streetAddress, String cityAddress, InputStream profielImage,
            byte validId, String email, String userType, Boolean active, File file, byte[] userImage,
            String verifyCode) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contactNumber = contactNumber;
        this.houseNo = houseNo;
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.profielImage = profielImage;
        this.validId = validId;
        this.email = email;
        this.userType = userType;
        this.active = active;
        this.file = file;
        this.userImage = userImage;
        this.verifyCode = verifyCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public InputStream getProfielImage() {
        return profielImage;
    }

    public void setProfielImage(InputStream profielImage) {
        this.profielImage = profielImage;
    }

    public byte getValidId() {
        return validId;
    }

    public void setValidId(byte validId) {
        this.validId = validId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    
}
