Feature: Book a Hotel

  Scenario: Create a new booking
    Given Book a hotel with "firstname","lastname", 1234,true,"checkin","checkout","additionalneeds"
    When the user calls the "POST" API 
    Then the API call is successful with status code 200
  
  Scenario: Retrieve the created booking
    Given a booking exists with the 1234
    When the user calls the "GET" API 
    Then the API call is successful with status code 200

  Scenario: Update the created booking
    Given a booking exists with the 1234	
    And user update the booking details with 1234,"checkin","checkout"
    When the user calls the "PUT" API 
    Then the API call is successful with status code 200
   
  Scenario: Delete the created booking
    Given a booking exists with the 1234
    When the user calls the "DELETE" API 
    Then the API call is successful with status code 201