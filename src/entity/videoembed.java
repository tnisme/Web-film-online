package entity;

public class videoembed {
	int id;
	String title;
	String poster;
	String description ;
	int year;
	String genre ;
	int view;
	boolean active;
	String link;
	
	public videoembed() {
		// TODO Auto-generated constructor stub
	}

	public videoembed(int id, String title, String poster, String description, int year, String genre, int view,
			boolean active, String link) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.description = description;
		this.year = year;
		this.genre = genre;
		this.view = view;
		this.active = active;
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
