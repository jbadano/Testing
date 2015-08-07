Meta:
@regression

Narrative:
In order to validate the rut of a customer
As a customer
I want to validate the rut

Scenario: Customer entered a invalid rut
Given A customer into application
When Customer have the rut 16080585
And Customer have the dv K
And The rut validation is requested
Then The rut validation should return false

Scenario: Customer entered a valid rut
Given A customer into application
When Customer have the rut 16080585
And Customer have the dv 4
And The rut validation is requested
Then The rut validation should return true

