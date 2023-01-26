# Products
 A simple end-to-end project using springboot restful-service and angular front end

 Technologies Used:
 - Springboot
 - Angular
 - Bootstrap
 - MongoDB
 - Java
 - JUnit Testing

 As this project has not been dockerized in container user need to have the following pre-requisite in order to run this project.
 1) Intellij with Maven Added.
 2) Angular CLI pre-installed.
 3) Node pre-installed.
 3) MongoDB pre-installed.

 How to run this project?
 - Please open the backend Springboot Product in IntellijIDE and run the Main class of ProductApplication which is inside com->webs->Product package.
 - To run the Angular Front End, go to the "ProductsFrontEnd" and run the command npm install and install node. Then run the command ng serve --open to launch the application in browser.

 Things to keep in mind
 - User need to enter both the Id and Password in order to activate the Login button.
 - The correct ID is "admin" and correct password is "admin". Please enter only these credentials for authorization as other credentials won't work.

 How does it works?
 - When user enter the website which is running on http://localhost:4200, user will encounter a login authorization view.
 - After user enter the correct ID and password, user will be navigated to the View All Products view where the user can see all the products listed along with their details.
 - User can also delete a product directly from this view itself by clicking on the Delete button.
 - If user wants to add a product then they need to click on "Add Product" button on the side navbar and they will be navigated to a view where they can fill all the details and click on Add button to add the product. 
 - If user wants to delete a product then by clicking on Delete Product present in the side navbar, user will get navigated to the delete view where they can select the ID of Product from the drop down menu which they want to delete.
 - User can also logout by clicking on the logout icon button present in the top menu then they will get navigated back to the login view.

End Points for Using All the services from the Restful API are:
Get a Product using ID: http://localhost:8080/api/v1/getproduct/{productId}
Get all Products: http://localhost:8080/api/v1/getProducts
Update a Product: http://localhost:8080/api/v1/updateproduct
Create a Product: http://localhost:8080/api/v1/saveproduct
Delete a Product: http://localhost:8080/api/v1/deleteproduct/{productId}
Get All Product Category: http://localhost:8080/api/v1/getproductcategory
Create a Product Category: http://localhost:8080/api/v1/saveproductcategory
Delete a Product Category: http://localhost:8080/api/v1/deleteproductcategory/{productCategoryId}

This project also includes JUnit Testing in each layer i.e. Repository, Service and Controller layer of Springboot.


