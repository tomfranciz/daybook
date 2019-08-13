/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "transaction_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionTypes.findAll", query = "SELECT t FROM TransactionTypes t"),
    @NamedQuery(name = "TransactionTypes.findByCode", query = "SELECT t FROM TransactionTypes t WHERE t.code = :code"),
    @NamedQuery(name = "TransactionTypes.findByTransactionType", query = "SELECT t FROM TransactionTypes t WHERE t.transactionType = :transactionType")})
public class TransactionTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "code")
    private String code;
    @Size(max = 20)
    @Column(name = "transactionType")
    private String transactionType;
    @OneToMany(mappedBy = "transactionType")
    private Collection<AccountHeads> accountHeadsCollection;

    public TransactionTypes() {
    }

    public TransactionTypes(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @XmlTransient
    public Collection<AccountHeads> getAccountHeadsCollection() {
        return accountHeadsCollection;
    }

    public void setAccountHeadsCollection(Collection<AccountHeads> accountHeadsCollection) {
        this.accountHeadsCollection = accountHeadsCollection;
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
        if (!(object instanceof TransactionTypes)) {
            return false;
        }
        TransactionTypes other = (TransactionTypes) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.entities.TransactionTypes[ code=" + code + " ]";
    }
    
}
