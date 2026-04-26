@login
Feature: Autenticacion de usuario
  Como usuario registrado
  Quiero autenticarme en el sistema
  Para acceder a mi cuenta personal

  Background:
    Given el usuario esta registrado con email "usuario@demo.com" y password "Pass123!"

  Scenario: Login exitoso con credenciales validas
    When el usuario ingresa email "usuario@demo.com" y password "Pass123!"
    Then el sistema muestra el mensaje "Bienvenido, usuario@demo.com"
    And el usuario es redirigido al dashboard

  Scenario: Login fallido con password incorrecto
    When el usuario ingresa email "usuario@demo.com" y password "wrongpass"
    Then el sistema muestra el mensaje de error "Credenciales incorrectas"
    And el usuario permanece en la pagina de login

  Scenario Outline: Login con diferentes combinaciones de credenciales
    When el usuario ingresa email "<email>" y password "<password>"
    Then el sistema muestra el mensaje "<mensaje>"

    Examples:
      | email              | password   | mensaje                     |
      | usuario@demo.com   | Pass123!   | Bienvenido, usuario@demo.com|
      | usuario@demo.com   | wrongpass  | Credenciales incorrectas   |
      | noregio@demo.com   | Pass123!   | Usuario no registrado      |
      | usuario@demo.com   |            | El password es obligatorio |