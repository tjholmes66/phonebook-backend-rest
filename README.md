# phonebook-backend-rest
The RESTful Back-End of the PhoneBook Web-application

From the start of my career, my first professional programming assignment was to write a PhoneBook application with their proprietary technology.
This was a simple CRUD application, CRUD meaning:   Create, Retrieve, Update, and Delete.

I was expected to insert new names, email, and numbers into this database.
Then I was expected to retrieve users by id, by email, by phone number, and by a partial match of first and/or last name.
Then I was expected to update that record and write it to the database, and finally ... delete a record.

So, every time I learn a new technology, it is useful to use this type of tool.

Since I plan on learning a variety of new technologies on the front-end, I thought it might be useful to construct a RESTful back-end service.
This way, whether I use a SmartGWT front-end, AngularJS front-end, JQuery, HTML5, or Mobile front-end, 
the back-end will stay and remain the same.

This project lays out a well-formed Multi Maven Module project.   

There are five (5) different layers, and I will describe each one of them here, from the farthest back to the RESTful servlet controllers.
There is an idea that each layer is supposed to do one thing very well.

Each layer uses some semblance of Spring, and overall is a Spring MVC project.

1) The first layer is simply the Maven Parent Module which holds the four (4) real work modules.
Obviously, this allows me to built the whole project at once by build the parent maven project.

2) This is the top layer and only consists of the Hibernate Entities.   
It is a personal preference to use Hibernate with Annotations, and name each class with a "Entity" at the end.
Some people name their Hibernate Entity classes with a "DO" at the end for "Data Object" or "DTO" as a "Data Transfer Object"
This layer does not need any unit testing IMHO.  
The research I have done online shows that most do not unit test out a simple POJO (plain old java object).

3) This is where the work starts to get busy, the DAO or Data Access Object layer.
This is the code that reads/writes/deletes data from the database using the Entities from the previous layer.
We can unit test a variety of gets by different criteria, or updating records, or deleting records, or creating new records.
We can make sure this layer is bullet-proof by the amount of unit testing we do for each DAO method.
The actual DAO unit tests ARE Transactional, so that when the database is changed during a test, the database is put back into the same state it was before the test.  The implementation of the DAO's are not themselves transactional, and that is because we DO NOT want any code calling the DAO unless it comes from the Business Services.   This layer does one thing well ... it can read and write data to the database.

*) At this time, these unit tests are fully integrated unit tests with the database, no unit tests are using mocking at this time.
*) At this time, there is no Security on the DAO layer.

4) This is the heart of the back-end, the core of the business logic goes here.   Any number-crunching or calculations needs to be done here.
This layer does not know anything about the Entities, all it knows about it how to access the DAO layer.
Any one method in a business service can make multiple database calls to the database, reading or writing, and then doing whatever it needs to do with that data.   Each of these methods IS transactional, and only commit when we are finished with that method.
We can really tightly test each business method to make sure it does everything we need it to do.
These are also Transactional to make sure the database is in the same state as when we got it.

*) At this time, these unit tests are fully integrated unit tests with the database, no unit tests are using mocking at this time.
*) At this time, there is no Security on the Services layer.

5) The fifth (5th) and final layer are the RESTful web-services themselves. 
As stated in the beginning, this is a Spring Model-View-Controller web-phonebook.
The Controllers are designated by having the @Controller annotation.

In the standard RESTful way, retrieving data with, none, 1 or more parameters is done with an HTTP GET.
Deletes are done with an HTTP DELETE, new records are done with a POST, and updates done with a PUT.

These can also be unit tested by mocking the creation of the web-application context, and then making the appropriate calls to the web-services.  The unit test will make sure that the url is correct, and will accept the parameters that we are passing in.

These web-services are light, super-light, all they do is pass control to a single business unit in the Services layer.  No Transactions are started here, no business logic is here, this layer does not know anything about the DAO layer.  All this layers knows is accepting data in JSON format and sending data back in JSON format.





