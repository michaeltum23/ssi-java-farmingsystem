package farmingsystem.controller;

import com.raven.model.ModelLogin;
import farmingsystem.FarmingConnection;
import farmingsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MTUMANGAN
 */
public class UserImp implements UserController {

    private Connection con;

    public UserImp() {
        try {
            con = FarmingConnection.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public User login(ModelLogin login) throws SQLException {
        User data = null;
        PreparedStatement pst = con.prepareStatement("SELECT id, username, email FROM users WHERE email=? AND password=? AND active=true limit 1");
        pst.setString(1, login.getEmail());
        pst.setString(2, login.getPassword());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int userID = rs.getInt(1);
            String userName = rs.getString(2);
            String email = rs.getString(3);
            data = new User(userID, userName, email, "");
        }
        rs.close();
        pst.close();
        return data;
    }

    @Override
    public void login(User users) {
        try {
            String sql = "SELECT * FROM users WHERE username='"
                    + users.getUsername() + "'and password='" + users.getPassword() + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            System.out.println(users.getUsername());
            System.out.println(users.getPassword());
            if (rs.next()) {
                System.out.println("Login Successfull");
                JOptionPane.showMessageDialog(null, "Login Succesful");
            } else {
                System.out.println("what");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void register(User users) {
        try {
            String sql = "INSERT INTO users(username, password, first_name, middle_name, last_name, gender, birthday, contact_number, house_no, street_address, city_address, email, user_type, active, user_id, profile_image) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getUsername());
            pst.setString(2, users.getPassword());
            pst.setString(3, users.getFirstName());
            pst.setString(4, users.getMiddleName());
            pst.setString(5, users.getLastName());
            pst.setString(6, users.getGender());
            pst.setString(7, users.getBirthDate());
            pst.setString(8, users.getContactNumber());
            pst.setString(9, users.getHouseNo());
            pst.setString(10, users.getStreetAddress());
            pst.setString(11, users.getCityAddress());
            pst.setString(12, users.getEmail());
            pst.setString(13, users.getUserType());
            pst.setBoolean(14, users.getActive());
            pst.setString(15, users.getUserId());
            pst.setBinaryStream(16, users.getProfielImage(), users.getFile().length());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTERED!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public void insertUser(User users) {
        try {
            int rand = (int) (Math.random() * 9999 + 10000);
            String sql = "INSERT INTO users(user_id, username, email, password, user_type, verify_code) VALUES(?,?,?,?,'admin',?)";
            PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            String code = generateVerifyCode();
            pst.setString(1, "admin" + rand);
            pst.setString(2, users.getUsername());
            pst.setString(3, users.getEmail());
            pst.setString(4, users.getPassword());
            pst.setString(5, code);
            pst.execute();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            System.out.println("insert " + id);
            rs.close();
            pst.close();
            users.setId(id);
            users.setVerifyCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User users) {
        try {
            String sql = "UPDATE users SET username=?,password=?,first_name=?,middle_name=?,last_name=?,birthday=?,contact_number=?,house_no=?,street_address=?,city_address =?,email=? WHERE user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getUsername());
            pst.setString(2, users.getPassword());
            pst.setString(3, users.getFirstName());
            pst.setString(4, users.getMiddleName());
            pst.setString(5, users.getLastName());
            pst.setString(6, users.getBirthDate());
            pst.setString(7, users.getContactNumber());
            pst.setString(8, users.getHouseNo());
            pst.setString(9, users.getStreetAddress());
            pst.setString(10, users.getCityAddress());
            pst.setString(11, users.getEmail());

            pst.setString(12, users.getUserId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "UPDATED!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public User get(String userId) {
        User st = new User();
        try {
            String sql = "SELECT * FROM users WHERE user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                st.setUserId(rs.getString("user_id"));
                st.setUsername(rs.getString("username"));
                st.setPassword(rs.getString("password"));
                st.setFirstName(rs.getString("first_name"));
                st.setMiddleName(rs.getString("middle_name"));
                st.setLastName(rs.getString("last_name"));
                st.setBirthDate(rs.getString("birthday"));
                st.setContactNumber(rs.getString("contact_number"));
                st.setHouseNo(rs.getString("house_no"));
                st.setStreetAddress(rs.getString("street_address"));
                st.setCityAddress(rs.getString("city_address"));
                st.setEmail(rs.getString("email"));
                st.setUserImage(rs.getBytes("profile_image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    private int count;

    public int countUser() {
        try {
            String sql = "SELECT COUNT(id) as count_user FROM users ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count_user");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return count;
    }

    @Override
    public List<User> list() {

        List<User> list = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM users ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User st = new User();
                st.setUserId(rs.getString("user_id"));
                st.setUsername(rs.getString("username"));
                st.setPassword(rs.getString("password"));
                st.setFirstName(rs.getString("first_name"));
                st.setMiddleName(rs.getString("middle_name"));
                st.setLastName(rs.getString("last_name"));
                st.setBirthDate(rs.getString("birthday"));
                st.setContactNumber(rs.getString("contact_number"));
                st.setHouseNo(rs.getString("house_no"));
                st.setStreetAddress(rs.getString("street_address"));
                st.setCityAddress(rs.getString("city_address"));
                st.setEmail(rs.getString("email"));
                st.setUserType(rs.getString("user_type"));
                st.setActive(rs.getBoolean("active"));
                st.setUserImage(rs.getBytes("profile_image"));

                list.add(st);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;

    }

    private String generateVerifyCode() throws SQLException, Exception {
        DecimalFormat df = new DecimalFormat("000000");
        Random rand = new Random();
        String code = df.format(rand.nextInt(1000000));
        while (checkDuplicateCode(code)) {
            code = df.format(rand.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException, Exception {
        boolean duplicate = false;
        PreparedStatement pst = con.prepareStatement("SELECT id from users WHERE verify_code=? limit 1");
        pst.setString(1, code);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            duplicate = true;
        }
        rs.close();
        pst.close();
        return duplicate;
    }

    public boolean checkDuplicateUser(String user) throws SQLException, Exception {
        boolean duplicate = false;
        PreparedStatement pst = con.prepareStatement("select id from users where username=? limit 1");
        pst.setString(1, user);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            duplicate = true;
        }
        rs.close();
        pst.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String email) throws SQLException, Exception {
        boolean duplicate = false;
        PreparedStatement pst = con.prepareStatement("SELECT id from users WHERE email=? limit 1");
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            duplicate = true;
        }
        rs.close();
        pst.close();
        return duplicate;
    }

    public void doneVerify(int id) throws SQLException, Exception {
        System.out.println("verify " + id);
        PreparedStatement pst = con.prepareStatement("UPDATE users SET verify_code='Verified', active=true WHERE id=?");
        pst.setInt(1, id);
        pst.execute();
        pst.close();
    }

    public boolean verifyCodeWithUser(int id, String code) throws SQLException, Exception {
        boolean verify = false;
        PreparedStatement pst = con.prepareStatement("SELECT id FROM users WHERE id=? AND verify_code=? limit 1");
        pst.setInt(1, id);
        pst.setString(2, code);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            verify = true;
        }
        rs.close();
        pst.close();
        return verify;
    }
}
