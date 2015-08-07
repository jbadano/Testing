Meta:
@regression

Narrative:
In order to find customers by companies
As a user
I want to find the rigth customers by company

Scenario: No Customers finded by company
Given A company name company1
When Start to find by company
Then The customers obtained are
|rut|dv|name|lastName|email|company|

Scenario: No Customers finded by company
Given A company name nisum
When Start to find by company
Then The customers obtained are
|rut|dv|name|lastName|email|company|
|16080585|4|Jorge|Badano|jbadano@nisum.com|nisum|
|12075627|3|Emilio|Badano|ebadano@nisum.com|nisum|
