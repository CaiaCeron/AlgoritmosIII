package com.mycompany.versaobeta.controllers;

import com.mycompany.versaobeta.models.Produtoentrada;
import com.mycompany.versaobeta.controllers.util.JsfUtil;
import com.mycompany.versaobeta.controllers.util.JsfUtil.PersistAction;
import com.mycompany.versaobeta.facads.ProdutoentradaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("produtoentradaController")
@SessionScoped
public class ProdutoentradaController implements Serializable {

    @EJB
    private com.mycompany.versaobeta.facads.ProdutoentradaFacade ejbFacade;
    private List<Produtoentrada> items = null;
    private Produtoentrada selected;

    public ProdutoentradaController() {
    }

    public Produtoentrada getSelected() {
        return selected;
    }

    public void setSelected(Produtoentrada selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProdutoentradaFacade getFacade() {
        return ejbFacade;
    }

    public Produtoentrada prepareCreate() {
        selected = new Produtoentrada();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProdutoentradaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProdutoentradaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProdutoentradaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Produtoentrada> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Produtoentrada getProdutoentrada(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Produtoentrada> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Produtoentrada> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Produtoentrada.class)
    public static class ProdutoentradaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProdutoentradaController controller = (ProdutoentradaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "produtoentradaController");
            return controller.getProdutoentrada(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Produtoentrada) {
                Produtoentrada o = (Produtoentrada) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Produtoentrada.class.getName()});
                return null;
            }
        }

    }

}
