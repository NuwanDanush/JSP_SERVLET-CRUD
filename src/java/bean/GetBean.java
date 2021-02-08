/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

/**
 *
 * @author nuwan_d
 */
public class GetBean {

    private String username;
    private String phone;
    private String email;
    private String roll;
    
    public GetBean(String username, String phone, String email, String roll) {
        
        this.username = username;
        this.phone =  phone;
        this.email = email;
        this.roll = roll;
        
    }

    public GetBean() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param emsil the email to set
     */
    public void setEmail(String emsil) {
        this.email = emsil;
    }

    /**
     * @return the roll
     */
    public String getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(String roll) {
        this.roll = roll;
    }

}
