@playlists
Feature: Create and Delete a playlist
  Scenario: Create new playlist
    Given I login to app
    And If I see Loading element I wait until it disappear
    And I click element Navigation.Playlists
    And If I see Loading element I wait until it disappear
    And I click element Playlists.CreateNewPlaylist_btn
    And I input text Test playlist 2 to field Playlists.NewPlaylist_txtbox
    And I click element Playlists.Create_btn
#    And I can see element Playlist_editor.SlideTitle_verification
    Then I can see text Test playlist 2
    
  Scenario: Delete playlist name
    Given I login to app
    And I click element Navigation.Playlists
    And If I see Loading element I wait until it disappear
    And I input text Test playlist 2 to field Playlists.Search
    And If I see Loading element I wait until it disappear
    And I click element Playlists.item_3dots
    And I click element Playlists.item_delete
    And I click element Playlists.item_delete_Yes
    And If I see Loading element I wait until it disappear
    Then I cannot see text Test playlist 2
    
