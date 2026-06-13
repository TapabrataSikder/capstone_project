Feature: Prabank End-toend Flow

Scenario Outline: Successfull ACcess of the account
	Given registration page should open in default browser
	When register using data from "src/test/resources/data/reg_data.csv"
	Then login success to dashboard
	
Scenario Outline: Successful User Login
    Given I am logged out
    When I login with username "<uname>" and password "<pwd>"
    Then I should be redirected to the dashboard
    
    Examples:
      | uname   | pwd     |
      | john123 | pass123 |