package br.edu.ifpe.controller;


import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.validation.UsuarioModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController {

    private UsuarioModel instance;
    private Usuario cadUsuario;
    private Usuario selectdUsuario;

    public UsuarioController() {
        this.instance = new UsuarioModel();
        this.cadUsuario = new Usuario();
    }

    public String registrarUsuario() throws Exception {
        this.instance.inserir(this.cadUsuario);
        this.cadUsuario = new Usuario();
        return null;
    }

    public UsuarioModel getInstance() {
        return instance;
    }

    public void setInstance(UsuarioModel instance) {
        this.instance = instance;
    }

    public Usuario getCadFunc() {
        return cadUsuario;
    }

    public void setCadFunc(Usuario cadUsuario) {
        this.cadUsuario = cadUsuario;
    }

    public Usuario getSelectdFunc() {
        return selectdUsuario;
    }

    public void setSelectdFunc(Usuario selectdUsuario) {
        this.selectdUsuario = selectdUsuario;
    }

}
