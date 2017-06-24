package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import play.libs.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's products page.
 */
public class TestController extends Controller {


    public Result response1()
    {
        return ok("Hello World\n" + request());
    }

    public Result response2()
    {
        return ok("Hello world!");
    }

    public Result response3()
    {
        return notFound();
    }

    public Result response4()
    {
        return notFound("<h1>Page not found</h1>").as("text/html");
    }

    public Result response5()
    {
        return internalServerError("Oops");
    }

    public Result response6()
    {
        return status(488, "Strange response type");
    }

    public Result response7()
    {
        return redirect("http://google.com");
    }

    public Result parameter1(String para)
    {
        return ok("Hello " + para);
    }

    public Result parameter2(Integer para)
    {
        return ok("Hello " + para);
    }

    public Result parameter3(String para)
    {
        return ok("Hello " + para);
    }

    public Result parameter4(Integer para)
    {
        return ok("Hello " + para);
    }

    public Result parameter5(String para)
    {
        return ok("Hello " + para);
    }

    public Result redirect1()
    {
        return redirect(controllers.routes.TestController.response1());
    }

    public Result redirect2()
    {
        return redirect(controllers.routes.TestController.parameter1("World"));
    }

    public Result responseType1()
    {
        return ok("Hello World!");
    }

    public Result responseType2()
    {
        return ok("<h1>Hello World!</h1>").as("text/html");
    }

    public Result responseType3()
    {
        response().setHeader(CACHE_CONTROL, "max-age=3600");
        response().setHeader(ETAG, "xxx");

        return ok("<h1>Hello World!</h1>").as("text/html");
    }

    public Result responseType4()
    {
        ArrayList<String> data = new ArrayList<String>();
        data.add("John");
        data.add("Mark");

        return ok(Json.toJson(data));
    }

    public Result responseType5()
    {
        return ok("<h1>Hello World!</h1>", "iso-8859-1").as("text/html; charset=iso-8859-1");
    }

    public Result responseType6()
    {
        response().setCookie(
                "theme",        // name
                "blue",         // value
                3600,           // maximum age
                "/",   // path
                "localhost", // domain
                false,          // secure
                true            // http only
        );
        return ok("<h1>Hello World!</h1>").as("text/html");
    }

    public Result responseType7()
    {
        session("connected", "user@gmail.com");
        return ok("<h1>Hello World!</h1>").as("text/html");
    }

    public Result responseType8()
    {
        String user = session("connected");
        if(user != null) {
            return ok("Hello " + user);
        } else {
            return unauthorized("Oops, you are not connected");
        }
    }

    public Result responseType9()
    {
        session().clear();
        return ok("Bye");
    }

    public Result responseType10()
    {
        flash("success", "The item has been created");
        return redirect(controllers.routes.TestController.responseType11());
    }

    public Result responseType11()
    {
        String message = flash("success");
        if(message == null) {
            message = "Welcome!";
        }
        return ok(message);
    }
}