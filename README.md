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
[Evaluation of your app across the following attributes]
- **Category:** Sports / Social
- **Mobile:** Easier to check for updates, pull to refresh for real-time data, use camera to post photos to reactions feed and update profile photo.
- **Story:** Allows users to view scoring updates and access livestream links for different sports in one location rather than scouring the Internet every time. Connect with fellow sports fans by sharing reactions.
- **Market:** Any sports fan would enjoy this app.
- **Habit:**  Users can check back as often as they'd like and pull to refresh for updates.
- **Scope:** Initial features are to view scoring updates and to share reactions with other fans. App can be expanded to include livestreaming links.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [x] User must create an account in order to get into the app
* [x] User can log in if they already have an account
* [x] User should be able to logout
* User can select their favourite sports from the list of sports
* User can select different sports to view the game scores
* User can change pages, from Stream, to Profile, to Details

**Optional Nice-to-have Stories**

* User should click on a link to watch the game on the game's website
* User should be able update their profile

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
   * User should be able to update their profile information
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

* Stream
* Details
* Profile

**Flow Navigation** (Screen to Screen)

* Login
  * Stream
* Register
  * Stream 
* Profile
  * Details Page 2
* Stream
  * Detail
* Details
  * Stream

## Wireframes
[Add picture of your hand sketched wireframes in this section]
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

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | userId        | String   | unique id for the user (default field) |
   | username      | String   | user account handle |
   | password      | String   | user account password |
   | email         | String   | user account email |
   | profileName   | String   | user profile name |
   | profileImage  | File     | user profile image |
   | favSports     | Array    | list of user-favorited sports |
   
#### Sport

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | sportId     | String   | unique id for the sport (default field) |
   | sportName   | String   | name of sport |
   | sportImage  | File     | representative image of sport |
   
#### Comment

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | commentId     | String   | unique id for the comment (default field) |
   | commentUser   | String   | username of user posting comment |
   | commentText   | String   | comment text |
   | createdAt     | DateTime | date/time when post is created |
   | commentImage  | File     | (optional) attach image file with comment |

#### Game

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | gameId        | String   | unique id for the game (default field) |
   | game info     | String   | location, time, description of game    |
   | updatedAt     | DateTime | date/time when scores are last updated |

### Networking
* Stream Page
  * (Read/GET): Query all the List of Sport names
* Detail Page
  * (Read/GET): Get all the data of that perticular sport where game detail is assigned to gameId
* Social Page
  * (Create/POST): Create a comment and post it to the twitter.
* Profile Page
  * (Read/GET) Query logged in user object
  * (Update/PUT) Update user profile attributes
 
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]



## Sprint 1 (due 11/12)

<img src="SC_Sprint1.gif" width=250><br>


## Sprint 2 (due 11/19)

<img src="SC_Sprint2.gif" width=250><br>

## Sprint 2 (due 11/26)

<img src="SC_Sprint3.gif" width=250><br>
