package br.edu.ifpe.controller;

import br.edu.ifpe.controller.md5.CriptografiaMD5;
import br.edu.ifpe.model.classes.Bike;
import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.classes.Usuario;
import br.edu.ifpe.model.validation.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioController {
    
    private Usuario cadUsuario;
    private Endereco end;
    private Bike bike;
    private final UsuarioModel instaceUSUARIOMODEL;
    private List<Bike> list;
    public UsuarioController() {
        this.bike = new Bike();
        this.end = new Endereco();
        cadUsuario = new Usuario();
        list = new ArrayList<>();
        this.instaceUSUARIOMODEL = new UsuarioModel();
    }
    
    public Usuario getUsuarioLogado() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuarioLogado");
    }
    
    public void setUsuarioLogado(Usuario usuarioLogado) {
        FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("usuarioLogado", usuarioLogado);
    }
    
    public String realizarLogin(String senha, String email) throws Exception {
        Usuario user = null;
        String rediricionarPagina = "";
        senha = CriptografiaMD5.md5(senha);
        user = instaceUSUARIOMODEL.recuperar(email, senha);
        
        if (user != null) {
            
            if (user.getSenha().equalsIgnoreCase(senha)) {
                this.setUsuarioLogado(user);
                rediricionarPagina = "menuUsuario.xhtml";
                
            } else {
                user = null;
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login!",
                                "Senha ou Login Inválidos"));
                
            }
        } else {
            user = null;
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no Login!",
                            "Senha ou Login Inválidos"));
        }
        
        return rediricionarPagina;
    }
    
    public String registrarUsuario() throws Exception {
        String ret = "";
        
        cadUsuario.setSenha(CriptografiaMD5.md5(cadUsuario.getSenha()));
        cadUsuario.setEndereco(end);
        
       
        this.instaceUSUARIOMODEL.inserir(this.cadUsuario);
        this.end = new Endereco();
        this.cadUsuario = new Usuario();
        ret = "login.xhtml";
        
        return ret;
        
    }
    
    public String cadastrarBike() throws Exception {
           
        this.bike.setUsuario(getUsuarioLogado());
        list.add(this.bike);
        
        getUsuarioLogado().setBikes(list);
        instaceUSUARIOMODEL.alterar(getUsuarioLogado());
        
        return "index.xhtml";
        
    }
   
    public String alterarUsuario() throws Exception {
        getUsuarioLogado().setSenha(CriptografiaMD5.md5(getUsuarioLogado().getSenha()));
        instaceUSUARIOMODEL.alterar(getUsuarioLogado());
        return "mostrarDadosUsuario.xhtml";
    }
    
    public Usuario getCadUsuario() {
        return cadUsuario;
    }
    
    public void setCadUsuario(Usuario cadUsuario) {
        this.cadUsuario = cadUsuario;
    }
    
    public Endereco getEnd() {
        return end;
    }
    
    public void setEnd(Endereco end) {
        this.end = end;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
    
    
}
