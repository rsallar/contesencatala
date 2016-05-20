package cat.contesencatala.client.application.model;

public class Tale {
	
	public String id;
	public String title;
	public String author;
	public boolean favorite;
	
	public Tale(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

}