/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.mb;

import capsoft.ejbs.RegisterFacade;
import capsoft.entities.Register;
import capsoft.entities.TransactionTypes;
import capsoft.entities.enumeration.Currency;
import capsoft.utils.JSFUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author informatica
 */
@Named(value = "registerMB")
@RequestScoped
public class RegisterMB {

    @Inject
    private RegisterFacade registerFacade;

    private Register register;
    private List<Register> registers;

    public RegisterMB() {
    }

    @PostConstruct
    public void init() {
        register = new Register();
        registers = registerFacade.findAll();
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public void save(ActionEvent actionEvent) {
        registerFacade.create(register);

        register = new Register();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Save"));
        JSFUtil.refresh();
    }

    public void edit(ActionEvent actionEvent) {

        registerFacade.edit(register);
        register = new Register();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Edit"));
        JSFUtil.refresh();
    }

    public void delete(ActionEvent actionEvent) {
        registerFacade.remove(register);
        register = new Register();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Sucess", "Delete"));
        JSFUtil.refresh();
    }

    public List<SelectItem> getCurrencies() {
        List<SelectItem> list = new ArrayList<>();
        for (Currency currency : Currency.values()) {
            list.add(new SelectItem(currency, currency.getInitials()));
        }
        return list;

    }
}
