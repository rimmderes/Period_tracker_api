# My Moon
Logo
<h2 align="center">Control your flow</h2>

## Project Description
Our full-stack project is a period tracker website which allows users to track their cycles, read articles and comment on them. We want to facilate healthy conversation and increase general knowledge of female health through the use of selected articles and comment.

## Key Features

## MVP
CRUD Functionality
- Create user, comment and cycle
- Read user, article, comment and cycle
- Update user, comment and cycle
- Delete comment

We decided to not give users the power to post and delete articles as a way of preventing the potential spread of misinformation and prevent distribution of malicious articles being viewed by young members of our app. Users can still post and delete comments as a method of communication. Ideally, the app would also have bot to monitor comments to ensure there are no hateful and derogatory comments, ensuring a safe space that allows users to be vulnerable if they want, and to also make a few article recommendation in the comment threads if necessary.

Diagrams - UML, ERD

## Tech Stack
- Java
- Spring Boot
- Spring Framework (dependencies: Spring Web, Spring Boot DevTools, PostgreSQL Driver, Spring Data JPA)
- PostgreSQL
- Postman (for testing)
- Postico (for testing)
- Git & GitHub


## Routes ##
localhost:8080...
|HTTP Request Path             |Request Type|                  Description            |
|:----------------------------:|:-----------|:----------------------------------------|
|.../users                      |GET         | Display all users                       |
|.../users/1                    |GET         | Find user by id                         |
|.../user/cycle/1/11            |PATCH       | Adding cycle to user                    |
|.../user/comment/1             |PATCH       | Adding comment to user                  |
|.../user                       |POST        | Add a new user                          |
|.../cycle                      |GET         | Display all cycles                      |
|.../cycle/startdate            |GET         | Find cycle by start date                |
|.../cycle/1                    |PATCH       | Update cycle by id                      |
|.../cycle                      |POST        | Add a new cycle                         |
|.../articles                   |GET         | Display all articles                    |
|.../articles/1                 |GET         | Find article by id                      |
|.../articles/title?title=Menstruation Tips        |GET         | Find article by title               |
|.../articles/tag?tags=FEMALE_HEALTH     |GET         | Filter articles based on tags          |
|.../articles/1/comments        |GET         | Get articles' comments                 |
|.../comments                   |GET         | Display all comments                   |
|.../comments/1                 |GET         | Find comment by id                     |
|.../comments                   |POST        | Create a comment                       |
|.../comments/1                 |PATCH       | Update a comment by id                 |
|.../comments/1                 |DELETE      | Delete comment by id                   |

## Testing

## Completed Extensions
We managed to complete several extensions during the course of the full-stack project.

The backend extensions we managed to complete were:
- Filter articles by tags
- Find article by title
- Allow users to like an article and remove like if they click twice
- Able to see the number of likes each article has

## Futher Possible Extensions
- Different account types for different users

## Installation Instructions
Git clone this repo in the terminal using the command `git clone` SSH key.

In the terminal type in the command `createdb period_tracker_api` to create a database. It will not run without this database.

Once this is done, you can run this DemoApplication and test in Postman and Postico.

## Next steps
Once you run this server-side application, you can also run our client-side project to get a full understanding of our full-stack project.

You can view our front-end project in GitHub using this link.

In the terminal, type in `git clone` Front-end SSH key.

Then type `npm start` to start up the single page application in http://localhost:3000.

## Thank you
