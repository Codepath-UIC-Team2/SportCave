Original App Design Project - README Template
===

# SPORTCAVE

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Browse sports categories to view scoring updates for domestic and international games. Connect with other sports fans.

### App Evaluation
- **Category:** Sports / Social
- **Mobile:** Easier to check for updates and post reactions on-the-go, use camera to post photos to reactions feed and update profile photo.
- **Story:** Allows users to view scoring updates for different sports in one location rather than scouring the Internet every time. Connect with fellow sports fans by sharing reactions.
- **Market:** Any sports fan would enjoy this app.
- **Habit:**  Users can check back as often as they'd like, multiple times a day
- **Scope:** Initial features are to view scoring updates and to share reactions with other fans. App can be expanded to include livestreaming links and include pull-to-refresh and search features.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [x] User can create an account to access the app
* [x] User can log in if they already have an account
* [x] User can logout from the app
* [x] User can change pages from Sports -> Social -> Profile
* [x] User can update their profile info and image
* [x] User can view the Social stream
* [x] User can post a reaction
* [ ] User can select their a sport to view the games
* [ ] User can select a game to view the scores

**Optional Nice-to-have Stories**

* [ ] User can post photos to Social feed
* [ ] User can search the Social feed to reactions by #game
* [ ] User can pull to refresh for real-time Sports and Social data
* [ ] User can click livestreaming link to watch the game

### 2. Screen Archetypes

* Login
   * [x] User can log in if they already have an account
   * [x] User should click on "Sign Up" button to create an account
   - [x] Login UI

* Register
   * [x] User must create an account in order to get into the app
   - [x] Signup UI
   
* Profile
   * [x] User should be able to logout
   * [x] User should be able to update their profile information
   - [x] Profile UI
   
* Stream
   * User can select their favourite sports from the list of sports

* Stream Page 2
    * User can post their reaction of the game

* Details
   * User can select different sports to view the game scores
   * User should click on a link to watch the game on the game's website

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

## Hand-Sketched Wireframes
<img src="Codepath_screenshot2.PNG" width=600>
Image URL : https://imgur.com/a/mM8O8yB


### [BONUS] Digital Wireframes & Mockups
URL: https://www.figma.com/file/9bkalDyIyTSFFvTYLGldzO/SportCave?node-id=0%3A1

### [BONUS] Interactive Prototype

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
* Games Page
  * (Read/GET): Query games for selected sport from API
* Scores Page
  * (Read/GET): Query scores for selected game from API
* Social Page
  * (Create/POST): Create a comment and post it to the Social stream
  * (Read/GET): Query all reactions from database
* Profile Page
  * (Read/GET) Query logged in User object
  * (Update/PUT) Update user profile attributes
 
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]



## Sprint 1 (due 11/12)

<img src="SC_Sprint1.gif" width=250><br>

## Sprint 2 (due 11/19)

<img src="SC_Sprint2.gif" width=250><br>

## Sprint 3 (due 11/26)

<img src="SC_Sprint3.gif" height=200 width=375><br>

<img src="SC_update.gif" width=250><br>
