package controllers;

import helper.ApplicationLogger;

import org.slf4j.Logger;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import actions.InitAction;

@With(InitAction.class)
public class Test extends Controller {
	
    public static Result testResponse(String responseCode){
    	ApplicationLogger.setLoggerRequestId(response());
    	Logger logger = ApplicationLogger.getLogger(Test.class);
    	try{
    		logger.debug("Got response code text : " + responseCode);
    		int responseCodeInt = Integer.parseInt(responseCode);
    		switch(responseCodeInt){
    			case 200: return ok("200 response");
    			case 400: return badRequest("bad request");
    			case 401: return unauthorized("unauthorized");
    			case 403: return forbidden("forbidden");
    			case 404: return notFound("not found");
    			case 500: return internalServerError("internal server error");
    			default : throw new Exception("Unhandled response Code");
    		}
	    	
    	} catch (Exception e){
    		logger.error("Error in testResponse " + e.getMessage(), e);
    		return internalServerError("internal server error : " + e.getMessage());
    	}
    }
    
    public static Result status(){
    	ApplicationLogger.setLoggerRequestId(response());
    	Logger logger = ApplicationLogger.getLogger(Test.class);
		logger.debug("into status check");
    	return ok("I am up");
    }
    
}
