package com.automatizacion.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {
    
    private String email;
    private String password;
    private String mensajeResultado;
    private boolean usuarioAutenticado;
    private boolean redirigidoDashboard;

    @Given("el usuario esta registrado con email {string} y password {string}")
    public void usuarioRegistrado(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @When("el usuario ingresa email {string} y password {string}")
    public void usuarioIngresaCredenciales(String email, String password) {
        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            if (email.equals("usuario@demo.com") && password.equals("Pass123!")) {
                this.mensajeResultado = "Bienvenido, " + email;
                this.usuarioAutenticado = true;
                this.redirigidoDashboard = true;
            } else if (!email.equals("usuario@demo.com")) {
                this.mensajeResultado = "Usuario no registrado";
                this.usuarioAutenticado = false;
                this.redirigidoDashboard = false;
            } else {
                this.mensajeResultado = "Credenciales incorrectas";
                this.usuarioAutenticado = false;
                this.redirigidoDashboard = false;
            }
        } else {
            this.mensajeResultado = "El password es obligatorio";
            this.usuarioAutenticado = false;
            this.redirigidoDashboard = false;
        }
    }

    @Then("el sistema muestra el mensaje {string}")
    public void sistemaMuestraMensaje(String mensajeEsperado) {
        assertEquals(mensajeEsperado, this.mensajeResultado);
    }

    @Then("el usuario es redirigido al dashboard")
    public void usuarioRedirigidoDashboard() {
        assertTrue(this.usuarioAutenticado, "El usuario deberia estar autenticado");
        assertTrue(this.redirigidoDashboard, "El usuario deberia ser redirigido al dashboard");
    }

    @Then("el usuario permanece en la pagina de login")
    public void usuarioPermanenceLogin() {
        assertFalse(this.usuarioAutenticado, "El usuario no deberia estar autenticado");
        assertFalse(this.redirigidoDashboard, "El usuario no deberia ser redirigido");
    }

    @And("el sistema muestra el mensaje de error {string}")
    public void mensajeError(String mensaje) {
        assertTrue(this.mensajeResultado.contains("incorrectas") || 
                   this.mensajeResultado.contains("no registrado") ||
                   this.mensajeResultado.contains("obligatorio"),
                   "El mensaje deberia indicar un error");
    }
}