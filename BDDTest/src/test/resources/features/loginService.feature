Feature: LoginService will provide an Feature to authenticate users with customerId & password

  Scenario: Successful Login with 200 OK(POST/ customers/authenticate/login)
    Given the customer with CustomerId "1234" and password "abcd"
    When Mobile App calls "/customers/authenticate/login" with given details
    Then Mobile App receives 200 Response