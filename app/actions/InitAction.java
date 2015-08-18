package actions;

import helper.ApplicationLogger;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;

import play.libs.F.Promise;
import play.mvc.Http.Context;
import play.mvc.Result;

public class InitAction  extends play.mvc.Action.Simple{
	private Logger logger = ApplicationLogger.getLogger(InitAction.class);
	
	public Promise<Result> call(Context ctx) throws Throwable {
		try{
			String requestId = "GE"+RandomStringUtils.randomAlphanumeric(20);
			ctx.args.put("_req", requestId);
			logger.debug("Got request : " + ctx.request().uri() + " " + ctx.request().method() + " " + ctx.request().path() + " " + requestId);
		} catch(Exception e){
			logger.error("Something went wrong in loaduser action " + e.getMessage(),e);
			return Promise.pure((Result)internalServerError("opps.. something went bad.. we are working on it"));
		}
		Promise<Result> result = delegate.call(ctx);
		return result;
	}

}
