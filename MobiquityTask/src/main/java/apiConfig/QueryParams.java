package apiConfig;

import java.util.HashMap;
import java.util.Map;

public class QueryParams {

	//query params
	public Map<String, Integer> defaultqueryParams(int id){
		Map<String, Integer> queryparam = new HashMap<String, Integer>();
		queryparam.put("userId", id);
		
		return queryparam;

	}

	public Map<String, Integer> queryParamsPostID(int postID){
		Map<String, Integer> queryparam = new HashMap<String, Integer>();
		queryparam.put("postId", postID);

		return queryparam;

	}

}
//queryparam.put("dist_min_GET_ASTERIODS", "10LD");
//queryparam.put("date_min_GET_ASTERIODS", "2020-01-01");
//queryparam.put("date_max_GET_ASTERIODS", "2020-02-02");