/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "login_account_heads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginAccountHeads.findAll", query = "SELECT l FROM LoginAccountHeads l"),
    @NamedQuery(name = "LoginAccountHeads.findByCode", query = "SELECT l FROM LoginAccountHeads l WHERE l.code = :code")})
public class LoginAccountHeads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @JoinColumn(name = "accountHeads", referencedColumnName = "code")
    @ManyToOne
    private AccountHeads accountHeads;
    @JoinColumn(name = "login", referencedColumnName = "code")
    @ManyToOne
    private Login login;

    public LoginAccountHeads() {
    }

    public LoginAccountHeads(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public AccountHeads getAccountHeads() {
        return accountHeads;
    }

    public void setAccountHeads(AccountHeads accountHeads) {
        this.accountHeads = accountHeads;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginAccountHeads)) {
            return false;
        }
        LoginAccountHeads other = (LoginAccountHeads) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.entities.LoginAccountHeads[ code=" + code + " ]";
    }
    
}
