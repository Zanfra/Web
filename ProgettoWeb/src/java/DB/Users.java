/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;

/**
 *
 * @author zanfra
 */
public class Users implements Serializable{
    private String mail;
    private String password;
    
    public String getmail() {
        return mail;
    }
    
    public String getpassword () {
        return password;
    }
    
    public void setmail (String mail) {
        this.mail=mail;
    }
    
    public void setpassword (String password) {
        this.password=password;
    }
}
