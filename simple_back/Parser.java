public class Parser{
	public Parser() {
	}

	public String getActionFromResquest(String query) {
		if (query.contains("GET") == true) {
			String action = "";
			System.out.println(query);
			action = query.substring(5, query.indexOf("HTTP/1.1"));
			return action;
		} else
		return "";
	}
}