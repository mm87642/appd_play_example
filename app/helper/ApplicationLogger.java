package helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import play.mvc.Http.Context;
import play.mvc.Http.Response;

public class ApplicationLogger{
	private static Logger logger = LoggerFactory.getLogger("NO_REQUESTID");
	
	public static Logger getLogger(Class<?> cls) {
		if(cls == null){
			return logger;
		}
		return LoggerFactory.getLogger(cls);
	}

	public static void setLoggerRequestId(Response response){
		try {
			String requestId="NoRequestId";
			if(Context.current().args.containsKey("_req")){
				requestId = String.valueOf(Context.current().args.get("_req"));
			}
			String prefix=" req="+requestId;
			response.setHeader("request_id", requestId);
			MDC.put("request_id", prefix);
		}catch (Exception e){
			logger.error("Error Setting request Id " + e.getMessage(),e);
		}
	}
	
}
