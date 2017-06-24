package controllers;

import play.*;
import play.mvc.*;
import models.Product;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's products page.
 */
public class ProductsController extends Controller {

    public Result list()
    {
        return ok("Hello World1");
    }

    public Result find(String ean)
    {
        return ok("Hello World2");
    }
}
