/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.entities;

import capsoft.entities.enumeration.Currency;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "account_heads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountHeads.findAll", query = "SELECT a FROM AccountHeads a"),
    @NamedQuery(name = "AccountHeads.findByCode", query = "SELECT a FROM AccountHeads a WHERE a.code = :code"),
    @NamedQuery(name = "AccountHeads.findByAccountName", query = "SELECT a FROM AccountHeads a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "AccountHeads.findByAccountCode", query = "SELECT a FROM AccountHeads a WHERE a.accountCode = :accountCode")})
public class AccountHeads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Size(max = 35)
    @Column(name = "accountName")
    private String accountName;
    
   
       
    @Size(max = 8)
    @Column(name = "accountCode")
    private String accountCode;
    @JoinColumn(name = "transactionType", referencedColumnName = "code")
    @ManyToOne
    private TransactionTypes transactionType;
    @OneToMany(mappedBy = "accountHeads")
    private Collection<LoginAccountHeads> loginAccountHeadsCollection;
    @OneToMany(mappedBy = "credit")
    private Collection<Register> registerCollection;
    @OneToMany(mappedBy = "debit")
    private Collection<Register> registerCollection1;

    public AccountHeads() {
    }

    public AccountHeads(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

  
    
    
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypes transactionType) {
        this.transactionType = transactionType;
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

    @XmlTransient
    public Collection<Register> getRegisterCollection1() {
        return registerCollection1;
    }

    public void setRegisterCollection1(Collection<Register> registerCollection1) {
        this.registerCollection1 = registerCollection1;
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
        if (!(object instanceof AccountHeads)) {
            return false;
        }
        AccountHeads other = (AccountHeads) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.entities.AccountHeads[ code=" + code + " ]";
    }
    
}
