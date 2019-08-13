/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.mb;

import capsoft.ejbs.AccountHeadsFacade;
import capsoft.entities.AccountHeads;
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
@Named(value = "accountHeadsMB")
@RequestScoped
public class AccountHeadsMB {

    @Inject
    private AccountHeadsFacade accountHeadsFacade;
    
    private AccountHeads accountHeads;
    private List<AccountHeads> accountHeadses;

    public AccountHeadsMB() {
    }

    @PostConstruct
    public void init() {
        accountHeads = new AccountHeads();
        accountHeadses = accountHeadsFacade.findAll();
    }

    public AccountHeads getAccountHeads() {
        return accountHeads;
    }

    public void setAccountHeads(AccountHeads accountHeads) {
        this.accountHeads = accountHeads;
    }

    public List<AccountHeads> getAccountHeadses() {
        return accountHeadses;
    }

    public void setAccountHeadses(List<AccountHeads> accountHeadses) {
        this.accountHeadses = accountHeadses;
    }

    
    
    
    
    
    public void save(ActionEvent actionEvent) {
        accountHeadsFacade.create(accountHeads);

        accountHeads = new AccountHeads();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Save"));
        JSFUtil.refresh();
    }

    public void edit(ActionEvent actionEvent) {

        accountHeadsFacade.edit(accountHeads);
        accountHeads = new AccountHeads();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Edit"));
        JSFUtil.refresh();
    }

    public void delete(ActionEvent actionEvent) {
        accountHeadsFacade.remove(accountHeads);
        accountHeads = new AccountHeads();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Delete"));
        JSFUtil.refresh();
    }

}
