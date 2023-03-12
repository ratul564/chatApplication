# 1. Framework and Language used
* I have created Spring Boot project with the help of Java language<br>
# 2. Functions used
* Functions used in Controller<br>
  <br>
* Functions used in Controller for Users - createUser( setUser, validateUserRequest ), getUsers, 
  login( validateLogin ), updateUser, deleteUser
* Functions used in Controller for Status - createStatus, setStatus
* Functions used in Controller for ChatHistory - saveMessage( setChatHistory, validateRequest ), getChatsByUserId, 
  conversationBetweenTwoUsers<br>
  <br>
* Functions used in Service<br>
  <br> 
* Functions used in service for Users - getUsers, createResponse, deleteUserByUserId, saveUser, login, updateUser
* Functions used in service for Status - saveStatus
* Functions used in service for ChatHistory - getChatsByUserId, saveMessage, getConversation<br>
  <br>
* Functions used in Dao layer<br>
  <br>
* Functions used in Dao layer for Users -<br>
  In Dao layer for UserRepository I made one interface call as UserRepository and extended it by JpaRepository<br>
  findByUsername, getUserByUserId, getAllUsers, deleteUserByUserId
* Functions used in Dao layer for Status -<br>
  In Dao layer for StatusRepository I made one interface call as StatusRepository and extended it by JpaRepository<br>
* Functions used in Dao layer for ChatHistory -<br>
  In Dao layer for ChatHistoryRepository I made one interface call as ChatHistoryRepository and extended it by 
  JpaRepository<br>
  getChatsByUserId, getConversation 
  
# 3. Data structure
* I have used MySQL database in this project
# 4. project summery<br>
I created one application name as Chat Application. Mention dependencies in below <br>
1. Spring Web,<br> 2. Spring Dev tools,<br>3. Lombok,<br>4. JPA,<br>5. Json,<br>6. MySQL,<br>7. Swagger