@SignUp
Feature: Sign up
    As a new user
    I want to make sign up in the web app with my information
    In order to create account

  Background:
    Given I start sign up page

  Scenario: Successful sign up
    When I fill with "Andres", "Sanjuan", "andre.sanjuan@company.com", "AdminAdmin123", "1950-01-13"
    And I selected gendre "man"
    And I click in create account
    Then I expect to get alert with "Bienvenido Andres Sanjuan" message

  Scenario Outline: Failed Sign up
    When I fill with "<name>", "<lastname>", "<email>", "<password>", "<birthdate>"
    And I selected gendre "<gendre>"
    And I click in create account
    Then I expect to get "<error>" message
    Examples:
        | name            | lastname | email                        | password  | birthdate  | gendre| error                                 |
        |                 | Perez    | juan.perez@company.com       | out$1919* | 1950-01-13 | man   | El nombre es obligatorio              |
        | Juan            |          | carolina.lopez@company.com   | 3434RED%  | 1980-01-01 | woman | El apellido es obligatorio            |
        | Julian          | Lopera   |                              | 1234569*  | 1933-12-24 | man   | El correo electrónico es obligatorio  |
        | Julian          | Lopera   | julian.lopera@               | 1234569*  | 1933-12-24 | man   | El correo electrónico no es válido    |
        | Daniel          | Lopez    | daniel.lopez@company.com     |           | 2001-12-12 | man   | La constraseña es obligatoria         |
        | Rosario         | Sanchez  | rosario.sanchez@company.com  | Abc123*$% |            | woman | La fecha de nacimiento es obligatoria |