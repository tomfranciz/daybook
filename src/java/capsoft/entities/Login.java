/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l"),
    @NamedQuery(name = "Login.findByCode", query = "SELECT l FROM Login l WHERE l.code = :code"),
    @NamedQuery(name = "Login.findByUserName", query = "SELECT l FROM Login l WHERE l.userName = :userName"),
    @NamedQuery(name = "Login.findByPassword", query = "SELECT l FROM Login l WHERE l.password = :password"),
    @NamedQuery(name = "Login.findByDesignation", query = "SELECT l FROM Login l WHERE l.designation = :designation"),
    @NamedQuery(name = "Login.findByClosedOn", query = "SELECT l FROM Login l WHERE l.closedOn = :closedOn")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Size(max = 60)
    @Column(name = "userName")
    private String userName;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 60)
    @Column(name = "designation")
    private String designation;
    @Column(name = "closedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedOn;
    @OneToMany(mappedBy = "login")
    private Collection<LoginAccountHeads> loginAccountHeadsCollection;
    @OneToMany(mappedBy = "login")
    private Collection<Register> registerCollection;

    public Login() {
    }

    public Login(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(Date closedOn) {
        this.closedOn = closedOn;
    }

    @XmlTransient
    public Collection<LoginAccountHeads> getLoginAccountHeadsCollection() {
        return loginAccountHeadsCollection;
    }

    public void setLoginAccountHeadsCollection(Collection<LoginAccountHeads> loginAccountHeadsCollection) {
        this.loginAccountHeadsCollection = loginAccountHeadsCollection;
    }

    @XmlTransient
    public Collection<Register> getRegisterCollection() {
        return registerCollection;
    }

    public void setRegisterCollection(Collection<Register> registerCollection) {
        this.registerCollection = registerCollection;
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
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.entities.Login[ code=" + code + " ]";
    }
    
}
