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
* [ ] User can post photos to Social feed
* [ ] User can click a reaction to view the user profile
* [ ] User can pull to refresh for real-time Sports and Social data
* [ ] User can favorite sports rather than manually entering them in the Profile
* [ ] User can view games and scores for more than two sports

**Stretch Stories**

* [ ] User can click livestreaming link to watch the game
* [ ] User can view a map to see games by location
* [ ] User can view a calendar for games and set reminders

### 2. Screen Archetypes

* Login
   * [x] User can log in if they already have an account
   * [x] User can click on "Sign Up" button to create an account
   - [x] Login UI

* Sign up
   * [x] User can create an account to access the app
   * [x] Sign up UI
   
* Sports
   * [x] User can select sports
   * [x] Sports UI

* Games / Scores
   * [x] User can view games and scores for the selected sport
   * [x] Games / Scores UI

* Social
    * [x] User can post their reaction of a game
    * [x] User can view reactions posted by other users
    * [x] Social UI

* Profile
   * [x] User can logout from the app
   * [x] User can update their profile information
   * [x] User can use the smartphone camera to add a profile image
   * [x] Profile UI

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Sports
* Social
* Profile

**Flow Navigation** (Screen to Screen)

* Login
  * Sports
* Login
  * Sign up
* Sign up
  * Login
* Sign up
  * Sports 
* Sports
  * Games
* Games
  * Sports
* Games
  * Scores
* Scores
  * Games

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
   | favSports      | String   | user-entered favorite sports |
   
#### Reaction

   | Property     | Type     | Description |
   | -------------| -------- | ------------|
   | objectId     | String   | unique id for the comment (default field) |
   | user         | Pointer  | pointer to objectId (from User class) of user posting comment |
   | comment      | String   | comment text |
   | createdAt    | DateTime | date/time when post is created |

### Networking
* Games / Scores Page
  * (Read/GET): Query games and scores for selected sport from API
* Social Page
  * (Create/POST): Create a comment and post it to the Social stream
  * (Read/GET): Query all reactions from database
* Profile Page
  * (Read/GET) Query logged in User object
  * (Update/PUT) Update user profile attributes

## Final Version of the SportCave App (12/19)

<img src="FinalGif_SportCave.gif" width=500><br>

