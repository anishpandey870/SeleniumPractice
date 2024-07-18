Feature: User login

  Scenario: Successful login
    Given the user is on the nopcommerce login page
    When the user enter valid credentials(username:"anish@gmail.com",password:"anish@123")
    And the user click on login button
    Then the user should be redirected to the My Account page
    And the user should see the welcome message