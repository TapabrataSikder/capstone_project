Feature: Prabank End-toend Flow

Scenario Outline: Successfull ACcess of the account
	Given registration page should open in default browser
	When register using data from "src/test/resources/data/reg_data.csv"
	Then login success to dashboard
	
	