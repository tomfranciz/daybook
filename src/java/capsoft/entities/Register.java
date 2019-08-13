/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.entities;

import capsoft.entities.enumeration.Currency;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "register")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Register.findAll", query = "SELECT r FROM Register r"),
    @NamedQuery(name = "Register.findByCode", query = "SELECT r FROM Register r WHERE r.code = :code"),
    @NamedQuery(name = "Register.findByTransactionDate", query = "SELECT r FROM Register r WHERE r.transactionDate = :transactionDate"),
    @NamedQuery(name = "Register.findByAmount", query = "SELECT r FROM Register r WHERE r.amount = :amount"),
    @NamedQuery(name = "Register.findByDescription", query = "SELECT r FROM Register r WHERE r.description = :description")})
public class Register implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Long code;
    @Column(name = "transactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    
     @Enumerated(EnumType.STRING)
    private Currency currency;
    
    @JoinColumn(name = "credit", referencedColumnName = "code")
    @ManyToOne
    private AccountHeads credit;
    @JoinColumn(name = "debit", referencedColumnName = "code")
    @ManyToOne
    private AccountHeads debit;
    @JoinColumn(name = "login", referencedColumnName = "code")
    @ManyToOne
    private Login login;

    public Register() {
    }

    public Register(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

      public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountHeads getCredit() {
        return credit;
    }

    public void setCredit(AccountHeads credit) {
        this.credit = credit;
    }

    public AccountHeads getDebit() {
        return debit;
    }

    public void setDebit(AccountHeads debit) {
        this.debit = debit;
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
        if (!(object instanceof Register)) {
            return false;
        }
        Register other = (Register) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.entities.Register[ code=" + code + " ]";
    }
    
}
