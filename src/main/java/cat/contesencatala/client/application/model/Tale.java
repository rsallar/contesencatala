package cat.contesencatala.client.application.model;

public class Tale {
	
	public String id;
	public String title;
	public String author;
	public boolean favorite;
	public String photoCreditUrl;
	public boolean newTale;
	
	public Tale(String id, String title, String author, String photoCreditUrl) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.photoCreditUrl = photoCreditUrl;
	}
	
	public Tale(String id, String title, String author, String photoCreditUrl, boolean isNew) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.photoCreditUrl = photoCreditUrl;
		this.newTale = isNew;
	}

}
