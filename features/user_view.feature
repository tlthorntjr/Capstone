Feature: Login

    Scenario: User submits valid login
        Given I am a valid user
        When I submit my login information
        Then I should see my pending tickets

