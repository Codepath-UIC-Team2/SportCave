Original App Design Project
===

# SPORTCAVE

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An Android mobile app—browse sports, view scoring updates for domestic and international games, and connect with fellow sports fans by sharing reactions.

### App Evaluation
- **Category:** Sports / Social
- **Mobile:** Check for scoring updates and post reactions on-the-go, use camera to post photos to reactions feed and update profile photo.
- **Story:** SportCave allows users to receive updates for different sports in one location rather than scouring different platforms for each sport. Present sports scores apps do not incorporate user profiles and social aspects; SportCave provides users the opportunity to connect with fellow fans by sharing reactions.
- **Market:** Any sports fan would enjoy this app.
- **Habit:**  Users can check back as often as they'd like, multiple times a day
- **Scope:** Initial features are to view scoring updates and to share reactions with other fans. App can be expanded to include livestreaming links and map and calendar functionalities.

## Product Spec

### 1. User Stories

**Required Stories**

* [x] User can create an account to access the app
* [x] User can log in if they already have an account
* [x] User can logout from the app
* [x] User can change pages from Sports -> Social -> Profile
* [x] User can update their profile information
* [x] User can use the smartphone camera to add a profile image
* [x] User can view the Social stream
* [x] User can post a reaction
* [x] User can select at least two sports and view games and scores

**Optional Stories**

* [x] Create and update actions are changed in real-time
* [x] User can search reactions in the Social feed
* [x] User can post photos to Social feed
* [x] User can click a username to view the user profile
* [x] User can update their favorite sports via button (Sports page) or text (Profile page) input
* [ ] User can pull to refresh for real-time Sports and Social data
* [ ] User can infinitely scroll the Social stream via Pagination
* [ ] User can view games and scores for more than two sports

**Stretch Stories**

* [ ] User can click livestreaming link to watch the game
* [ ] User can view a map to see games by location
* [ ] User can view a calendar for games and set reminders

### 2. Screen Archetypes

* Login / Sign Up
    * [x] Setup the Parse SDK and connect to the Parse server
    * [x] Accept form input for sign in and sign up and verify it is complete and valid
    * [x] Allow user to sign up for a new account using Parse authentication
    * [x] Allow user to sign in to their account
    * [x] Implement default values for profile input options not displayed
    * [x] The current signed in user is persisted across app restarts
    * [x] Finish activity when navigating away so it's not available in backstack
   
* Stream - Sports
    * [x] Allow user to select from a range of provided sports
    * [x] Display text (sports names)
    * [x] Use the Glide library to display media (sports icons)

* Detail - Games / Scores
    * [x] Use the AsyncHttpClient library to make network requests to each sport API and retrieve games and scores for the selected sport
    * [x] Parse JSON objects retrieved to display team names and scores
    * [x] Use the Glide library to display media (flags, logos) from source data

* Stream - Social
    * [x] Query Parse server to retrieve reactions posted by any user, including 'created at' datetime and profile photos
    * [x] Display 'created at' datetime in relative format
    * [x] Use Glide to display user profile photos in fixed square size
    * [x] Use search bar to query Parse server and retrieve a filtered list of reactions

* Creation - Social
    * [x] Accept and validate text field input for new reaction
    * [x] Send request to Parse server to create new item and attribute to logged in user
    * [x] Manually insert newly posted reaction in Social stream so it is immediately visible without the need for a full refresh 
    
* Profile
    * [x] Query Parse server to retrieve profile information and image for logged in user
    * [x] Use the Glide library to display default or user-selected profile photo
    * [x] Launch smartphone camera to take new profile photo
    * [x] Use the bitmap to display a preview of the photo in the image view 
    * [x] Use text field input to modify profile information
    * [x] Send request to Parse server to save updated profile information for logged in user
    * [x] Allow user to sign out of their account

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Sports
* Social
* Profile

**Flow Navigation** (Screen to Screen)

* Login --> Sports
* Login --> Sign up
* Sign up --> Login
* Sign up --> Sports 
* Sports --> Games/Scores
* Games/Scores --> Sports

## Wireframes

<img src="Codepath_screenshot2.PNG" width=600>
Image URL : https://imgur.com/a/mM8O8yB
URL: https://www.figma.com/file/9bkalDyIyTSFFvTYLGldzO/SportCave?node-id=0%3A1

### Interactive Prototype

<img src="wireframes.gif" width=400>
URL : https://imgur.com/a/WWjdWS2

## Schema 
### Models
#### User

   | Property       | Type     | Description |
   | -------------  | -------- | ------------|
   | objectId       | String   | unique id for the user (default field) |
   | username       | String   | user account handle |
   | password       | String   | user account password |
   | email          | String   | user account email |
   | profileName    | String   | user profile name |
   | profilePicture | File     | user profile image |
   | mySports       | Array    | sports user favorited via button or text input |
   
#### Reaction

   | Property     | Type     | Description |
   | -------------| -------- | ------------|
   | objectId     | String   | unique id for the comment (default field) |
   | user         | Pointer  | pointer to objectId (from User class) of user posting comment |
   | comment      | String   | comment text |
   | createdAt    | DateTime | date/time when post is created |
   | photoReaction   | File     | optional photo attached to reaction post |

### Networking
* Games / Scores Page
  * (Read/GET): Query games and scores for selected sport from API
* Social Page
  * (Create/POST): Create a comment and post it to the Social stream
  * (Read/GET): Query all reactions from database
* Profile Page
  * (Read/GET) Query logged in User object
  * (Update/PUT) Update user profile attributes

## SportCave App - Current Progress (12/22/21)

<img src="SC_Current_12-22.gif" width=200><br>

