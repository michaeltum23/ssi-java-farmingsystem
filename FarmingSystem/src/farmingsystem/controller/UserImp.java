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

    public void deleteInit() {
        PreparedStatement pst;
        try {
            pst = con.prepareStatement("DELETE FROM users WHERE active IS NULL");
            pst.executeQuery();
            pst.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public User login(ModelLogin login) throws SQLException {
        User user = new User();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=? AND active=true limit 1");
        pst.setString(1, login.getEmail());
        pst.setString(2, login.getPassword());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setContactNumber(rs.getString("contact_number"));
            user.setProvince(rs.getString("province"));
            user.setCityAddress(rs.getString("city_address"));
            user.setHouseNo(rs.getString("house_no"));
            user.setStreetAddress(rs.getString("street_address"));
            user.setUserType(rs.getString("user_type"));
            user.setUserImage(rs.getBytes("profile_image"));
        }
        rs.close();
        pst.close();
        return user;
    }

    @Override
    public void login(User users) {
        try {
            String sql = "SELECT * FROM users WHERE email='"
                    + users.getEmail() + "'and password='" + users.getPassword() + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            System.out.println(users.getEmail());
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
            String sql = "UPDATE users "
                    + "SET password=?, first_name=?, middle_name=?, "
                    + "last_name=?, gender=?, birthday=?, contact_number=?, "
                    + "house_no=?, street_address=?, city_address=?, "
                    + "profile_image=?, province=?, "
                    + "civil_status=?, zip_code=?, user_type=? "
                    + "WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getPassword());
            pst.setString(2, users.getFirstName());
            pst.setString(3, users.getMiddleName());
            pst.setString(4, users.getLastName());
            pst.setString(5, users.getGender());
            pst.setString(6, users.getBirthDate());
            pst.setString(7, users.getContactNumber());
            pst.setString(8, users.getHouseNo());
            pst.setString(9, users.getStreetAddress());
            pst.setString(10, users.getCityAddress());
            pst.setBinaryStream(11, users.getProfielImage(), users.getFile().length());
            pst.setString(12, users.getProvince());
            pst.setString(13, users.getCivilStatus());
            pst.setInt(14, users.getZipCode());
            pst.setString(15, users.getUserType());
            pst.setInt(16, users.getId());
            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "REGISTER SUCCESSFUL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User users) {
        if (users != null) {
            try {
                String sql = "INSERT INTO users(email, password, verify_code) VALUES(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                String code = generateVerifyCode();
                pst.setString(1, users.getEmail());
                pst.setString(2, users.getPassword());
                pst.setString(3, code);
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
        } else {

        }
    }

    @Override
    public void update(User users) {
        try {
            String sql = "UPDATE users SET first_name=?,middle_name=?,last_name=?,birthday=?,civil_status=?,gender=?,contact_number=?,email=?,house_no=?,street_address=?,city_address=?,province=?,zip_code=?,profile_image=? WHERE email=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getFirstName());
            pst.setString(2, users.getMiddleName());
            pst.setString(3, users.getLastName());
            pst.setString(4, users.getBirthDate());
            pst.setString(5, users.getCivilStatus());
            pst.setString(6, users.getGender());
            pst.setString(7, users.getContactNumber());
            pst.setString(8, users.getEmail());
            pst.setString(9, users.getHouseNo());
            pst.setString(10, users.getStreetAddress());
            pst.setString(11, users.getCityAddress());
            pst.setString(12, users.getProvince());
            pst.setInt(13, users.getZipCode());
            pst.setBinaryStream(14, users.getProfielImage(), users.getFile().length());
            pst.setString(15, users.getEmail());

            pst.executeUpdate();
            pst.close();
            JOptionPane.showMessageDialog(null, "UPDATED!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public User get(String email) {
        User st = new User();
        try {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                st.setPassword(rs.getString("password"));
                st.setFirstName(rs.getString("first_name"));
                st.setMiddleName(rs.getString("middle_name"));
                st.setLastName(rs.getString("last_name"));
                st.setBirthDate(rs.getString("birthday"));
                st.setGender(rs.getString("gender"));
                st.setCivilStatus(rs.getString("civil_status"));
                st.setContactNumber(rs.getString("contact_number"));
                st.setHouseNo(rs.getString("house_no"));
                st.setStreetAddress(rs.getString("street_address"));
                st.setCityAddress(rs.getString("city_address"));
                st.setEmail(rs.getString("email"));
                st.setProvince(rs.getString("province"));
                st.setUserImage(rs.getBytes("profile_image"));
                st.setZipCode(rs.getInt("zip_code"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    private int count;

    public int countUser(String userType) {
        if (userType.equals("Farmer") || userType.equals("Supplier") || userType.equals("Admin")) {
            try {
                String sql = "SELECT COUNT(id) as count_user FROM users WHERE user_type=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, userType);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count_user");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            try {
                String sql = "SELECT COUNT(id) as count_user FROM users";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count_user");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
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

    @Override
    public void deleteUser(User users) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "DELETE from users  WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, users.getEmail());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "User Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public List<User> searchUser(String search) {
        try {

            Connection con = FarmingConnection.getConnection();

            String sql = "SELECT * FROM users u WHERE lower(CONCAT(u.first_name,u.last_name)) LIKE '%" + search + "%'";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<User> list = new ArrayList<User>();
            while (rs.next()) {
                User st = new User();
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
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return null;

    }

    @Override
    public void addAdmin(User user) {
        try {
            Connection con = FarmingConnection.getConnection();
            String sql = "INSERT INTO users(first_name,middle_name,last_name,birthday,civil_status,gender,contact_number,email,house_no,street_address,city_address,province,zip_code,password,user_type,active,profile_image,verify_code) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getMiddleName());
            pst.setString(3, user.getLastName());
            pst.setString(4, user.getBirthDate());
            pst.setString(5, user.getCivilStatus());
            pst.setString(6, user.getGender());
            pst.setString(7, user.getContactNumber());
            pst.setString(8, user.getEmail());
            pst.setString(9, user.getHouseNo());

            pst.setString(10, user.getStreetAddress());
            pst.setString(11, user.getCityAddress());
            pst.setString(12, user.getProvince());
            pst.setInt(13, user.getZipCode());
            pst.setString(14, user.getPassword());
            pst.setString(15, user.getUserType());
            pst.setBoolean(16, user.getActive());
            pst.setBinaryStream(17, user.getProfielImage(), user.getFile().length());
            pst.setString(18, user.getVerifyCode());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Post Success!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public void insertUserFogot(User users) {
        if (users != null) {
            try {
                String sql = "INSERT INTO forgotpassword(email, password, verify_code) VALUES(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                String code = generateVerifyCode();
                pst.setString(1, users.getEmail());
                pst.setString(2, users.getPassword());
                pst.setString(3, code);
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
        } else {

        }
    }

    public void updateUserNewPassword(User users) {
        try {
            String sql = "UPDATE users SET password=? WHERE email=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, users.getPassword());
            pst.setString(2, users.getEmail());
            pst.executeUpdate();
            pst.close();

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public boolean verifyCodeWithUserForgot(int id, String code) throws SQLException, Exception {
        boolean verify = false;
        PreparedStatement pst = con.prepareStatement("SELECT id FROM forgotpassword WHERE id=? AND verify_code=? limit 1");
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

    public void doneVerifyForgot(int id) throws SQLException, Exception {
        System.out.println("verify " + id);
        PreparedStatement pst = con.prepareStatement("UPDATE forgotpassword SET verify_code='Verified', active=true WHERE id=?");
        pst.setInt(1, id);
        pst.execute();
        pst.close();
    }

    @Override
    public int countCropsPost(User users) {
        int count = 0;
        String sql = "SELECT COUNT(id) as count FROM crops WHERE user_id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, users.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    @Override
    public double sumCrops(User users) {
        double price = 0.00;
        String sql = "SELECT SUM(price) as price FROM crops WHERE user_id=?";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setDouble(1, users.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                price = rs.getDouble("price");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;
    }

    @Override
    public int countOffer(User users) {
        int count = 0;
        String sql = "SELECT COUNT(id) as count FROM offer WHERE user_id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, users.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    @Override
    public int countComplaints(User users) {
        int count = 0;
        String sql = "SELECT COUNT(id) as count FROM complain WHERE user_id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, users.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }
}
