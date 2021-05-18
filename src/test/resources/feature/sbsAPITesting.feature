@sbsAPItesting
Feature: Get all .mp3 audio files (archiveAudio) and validate the response

  @archiveAudio
  Scenario Outline: Get all .mp3 audio files (archiveAudio) and validate the response
    Given the request for archiveAudio is send
    When the response returns status code as <status>
    Then fetch all the mpThree audio files and validate the expected values are returned
    And fetch the program and validate it is "Greek" for all the dates
    And fetch the channelName and validate it is "SBSRadio1"
    And verify "<field>" is present for all the audioTracks
    And verify the response time is less than <milliseconds> seconds

    Examples:
      | status | milliseconds | field             |
      | 200    | 5000         | analogueFrequency |



