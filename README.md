

Here, in this project, the base endpoint is localhost:8080/beverage . Here, we can add the products to the cart which actually goes through by the session ( one of the requirements of the assignment) .We can also add the bottle and crates to the database in this endpoint through form models which has Bean Validations.

We can check the cart through the “Basket” button in the navigation menu bar (localhost:8088/basket). In this endpoint, we can mention the quantity of the product and add these products to order by the button “Checkout”. Then we can proceed by the “finalize order” button.  Unfortunately we could not resolve some errors when adding Carts for final submit, so ordering cart is not possible, only Bottle is possible.  

After this, the current session will be terminated and the user will be redirected to the order page. In order page, all orders will be shown from the database. 


