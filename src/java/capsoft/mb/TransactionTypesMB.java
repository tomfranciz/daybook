/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.mb;

import capsoft.ejbs.TransactionTypesFacade;
import capsoft.entities.AccountHeads;
import capsoft.entities.TransactionTypes;
import capsoft.utils.JSFUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author informatica
 */
@Named(value = "transactionTypesMB")
@RequestScoped
public class TransactionTypesMB {

    
    @Inject
    private TransactionTypesFacade transactionTypesFacade;
    
    private TransactionTypes transactionTypes;
    private List<TransactionTypes> transactionTypesList;
    
    public TransactionTypesMB() {
    }
    
    
    
    @PostConstruct
    public void init() {
        transactionTypes = new TransactionTypes();
        transactionTypesList = transactionTypesFacade.findAll();
    }

    public TransactionTypes getTransactionTypes() {
        return transactionTypes;
    }

    public void setTransactionTypes(TransactionTypes transactionTypes) {
        this.transactionTypes = transactionTypes;
    }

    public List<TransactionTypes> getTransactionTypesList() {
        return transactionTypesList;
    }

    public void setTransactionTypesList(List<TransactionTypes> transactionTypesList) {
        this.transactionTypesList = transactionTypesList;
    }

    
    
    
    public void save(ActionEvent actionEvent) {
        transactionTypesFacade.create(transactionTypes);

        transactionTypes = new TransactionTypes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Save"));
        JSFUtil.refresh();
    }

    public void edit(ActionEvent actionEvent) {

        transactionTypesFacade.edit(transactionTypes);
        transactionTypes = new TransactionTypes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Edit"));
        JSFUtil.refresh();
    }

    public void delete(ActionEvent actionEvent) {
        transactionTypesFacade.remove(transactionTypes);
        transactionTypes = new TransactionTypes();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Delete"));
        JSFUtil.refresh();
    }
    
}
