package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.sound.midi.Soundbank;
import javax.swing.text.html.ListView;
import javax.websocket.Session;



import entity.user;
import entity.video;
import entity.videoembed;


@WebServlet({"/home","/joinsingle","/series","/list","/register","/search","/Action","/Comedy",
	"/Horror","/Family","/login","/logout","/like","/share","/favorite","/sharedone","/admin",
	"/edituser","/editvideo","/table","/addvideo","/adduser","/removeuser","/edituserdone","/removevideo","/editvideodone"})
public class controller extends HttpServlet {
	//index
	ArrayList<video> listreview = new ArrayList<video>();
	ArrayList<video> listfeatured = new ArrayList<video>();
	ArrayList<video> listtopviews = new ArrayList<video>();
	ArrayList<video> listrecently = new ArrayList<video>(); 
	ArrayList<video> listslidebanner = new ArrayList<video>();
	ArrayList<video> listslideview = new ArrayList<video>();
	ArrayList<video> listsearch = new ArrayList<video>(); 
	//genre
	ArrayList<video> listaction = new ArrayList<video>();
	ArrayList<video> listcomedy = new ArrayList<video>();
	ArrayList<video> listhorror = new ArrayList<video>();
	ArrayList<video> listfamily = new ArrayList<video>();
	//list
	ArrayList<video> listaz = new ArrayList<video>();
	ArrayList<video> listza = new ArrayList<video>();
	//series (trong index co san cac array list can)
	//single
	ArrayList<videoembed> single = new ArrayList<videoembed>();
	ArrayList<video> listnext = new ArrayList<video>();
	//favorite
	ArrayList<video> listfavorite = new ArrayList<video>();
	//bien
	int checkadmin =-1;
	String isuser="";
	
	ArrayList<user> listuser = new ArrayList<user>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		loadindex(req,  resp);
		
		
		
		
		
		
		String uri = req.getRequestURI();
		if(uri.contains("home")) {
			req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
		}
		if(uri.contains("series")) {
			req.getRequestDispatcher("/view/series.jsp").forward(req, resp);
		}
		if(uri.contains("list")) {
			req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
		}
		
		if(uri.contains("Action")) {
			req.getRequestDispatcher("/view/action.jsp").forward(req, resp);
		}
		if(uri.contains("Comedy")) {
			req.getRequestDispatcher("/view/comedy.jsp").forward(req, resp);
		}
		if(uri.contains("Horror")) {
			req.getRequestDispatcher("/view/horror.jsp").forward(req, resp);
		}
		if(uri.contains("Family")) {
			req.getRequestDispatcher("/view/family.jsp").forward(req, resp);
		}
		if(uri.contains("favorite")) {		
				req.getRequestDispatcher("/view/favorite.jsp").forward(req, resp);	
		}
		if(uri.contains("admin")) {
			checkadmin(req,resp);
			req.getRequestDispatcher("view/dashboard.jsp").forward(req, resp);
		}
		
		
		if(uri.contains("table")) {
			checkadmin(req,resp);
			req.getRequestDispatcher("view/tables.jsp").forward(req, resp);
		}
		if(uri.contains("adduser")) {
			checkadmin(req,resp);
			req.getRequestDispatcher("/view/adduser.jsp").forward(req, resp);
		}
		if(uri.contains("addvideo")) {
			checkadmin(req,resp);
			req.getRequestDispatcher("/view/addvideo.jsp").forward(req, resp);
		}
	}
	
	
	
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if(uri.contains("register")) {
			
			
			try {
				listreview.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT TOP 7 * FROM dbo.video WHERE active=1 ORDER BY YEAR DESC";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listreview.add(aVideo);
				}
				req.setAttribute("listreview", listreview);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				listfeatured.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT TOP 20 * FROM dbo.video WHERE active = 1 ORDER BY title DESC";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listfeatured.add(aVideo);
				}
				req.setAttribute("listfeatured", listfeatured);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				listtopviews.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT TOP 20 * FROM dbo.video WHERE active = 1 ORDER BY [view] DESC";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listtopviews.add(aVideo);
				}
				req.setAttribute("listtopviews", listtopviews);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				listrecently.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT TOP 12 * FROM dbo.video WHERE active=1 ORDER BY YEAR DESC";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listrecently.add(aVideo);
				}
				req.setAttribute("listrecently", listrecently);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				listslidebanner.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT TOP 3 * FROM dbo.video WHERE active = 1 ORDER BY id DESC ";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listslidebanner.add(aVideo);
				}
				req.setAttribute("listslidebanner", listslidebanner);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				listslideview.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT TOP 18 * FROM dbo.video WHERE active=1 ORDER BY YEAR DESC";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listslideview.add(aVideo);
				}
				req.setAttribute("listslideview", listslideview);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "INSERT INTO dbo.[user] VALUES  ( ?, ?, ?,  0 )";
				PreparedStatement statement = con.prepareStatement(sqlString);
				String userString = req.getParameter("Username");
				String passString = req.getParameter("Password");
				String emailString = req.getParameter("Email");
				statement.setString(1, userString);
				statement.setString(2, passString);
				statement.setString(3, emailString);
				statement.execute();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
		}
		
		if(uri.contains("search")) {
			String searchString = req.getParameter("Search");
			
			try {
				listsearch.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString="SELECT * FROM dbo.video WHERE active = 1 AND title LIKE '"+searchString+"%'";
				Statement statement = con.createStatement();
				
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listsearch.add(aVideo);
				}
				req.setAttribute("listsearch", listsearch);
				req.setAttribute("indexsearch", listsearch.size());
				req.getRequestDispatcher("/view/search.jsp").forward(req, resp);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(uri.contains("joinsingle")) {
			String id = req.getParameter("id");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "UPDATE dbo.video SET [view] = [view] + 1 WHERE id = "+id;
				Statement statement = con.createStatement();
				statement.execute(sqlString);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				single.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT * FROM dbo.video WHERE active = 1 AND id = "+id;
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id1 = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					String link = rSet.getString(9);
					videoembed aVideo = new videoembed(id1, title, poster, description, year, genre, view, active,link);
					single.add(aVideo);
				}
				req.setAttribute("single", single);

				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				listnext.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT TOP 4 * FROM dbo.video WHERE active = 1 ORDER BY NEWID()";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id1 = rSet.getInt(1);
					String title = rSet.getString(2);
					String poster = rSet.getString(3);
					String description = rSet.getString(4); 
					int year = rSet.getInt(5);
					String genre = rSet.getString(6);
					int view = rSet.getInt(7);
					boolean active = rSet.getBoolean(8);
					video aVideo = new video(id1, title, poster, description, year, genre, view, active);
					listnext.add(aVideo);
				}
				req.setAttribute("listnext", listnext);
			} catch (Exception e) {
				// TODO: handle exception
			}
			

			req.getRequestDispatcher("/view/single.jsp").forward(req, resp);
		}
		
		
			if(uri.contains("login")) {
				
				String username = req.getParameter("Username");
				String password = req.getParameter("Password");
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
							"sa", "123");
					String sqlString="SELECT * FROM dbo.[user]";
					Statement statement = con.createStatement();
					ResultSet rSet = statement.executeQuery(sqlString);
					
					while(rSet.next()) {
						if(username.endsWith(rSet.getString(2)) && password.endsWith(rSet.getString(3))) {
							
							if(rSet.getBoolean(5)==false) {
								
								HttpSession session = req.getSession();
								isuser= String.valueOf(rSet.getInt(1));
								session.setAttribute("userid", rSet.getInt(1));
								session.setAttribute("userfullname", rSet.getString(2));
								
								loadindex(req,  resp);
								
								req.getRequestDispatcher("view/index.jsp").forward(req, resp);
							}
							
							if (rSet.getBoolean(5)==true) {
								HttpSession session = req.getSession();
								isuser= String.valueOf(rSet.getInt(1));
								session.setAttribute("userid", rSet.getInt(1));
								session.setAttribute("userfullname", rSet.getString(2));
								loadindex(req,  resp);
								checkadmin=1;
								req.getRequestDispatcher("/view/dashboard.jsp").forward(req, resp);
							}
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}		
				
			}
			
			if(uri.contains("logout")) {
				System.out.println(1);
				HttpSession session = req.getSession();
				session.invalidate();
				loadindex(req,  resp);
				isuser="1";
				checkadmin=-1;
				req.getRequestDispatcher("view/index.jsp").forward(req, resp);
			}
			
			if (uri.contains("like")) {
				String idvideo = req.getParameter("idvideo");
				String userid  = req.getParameter("userid");
				int idint=-1;
				try {
					idint = Integer.parseInt(userid);
				} catch (Exception e) {
					loadindex(req, resp);
					req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
				}
				if(idint>0) {
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
								"sa", "123");
						String sqlString="INSERT INTO dbo.[like] VALUES  ( "+userid+",  "+idvideo+",  GETDATE() )";
						Statement statement = con.createStatement();
						statement.execute(sqlString);
						loadindex(req, resp);
						try {
							single.clear();
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection con1 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
									"sa", "123");
							String sqlString1 = "SELECT * FROM dbo.video WHERE active = 1 AND id = "+idvideo;
							Statement statement1 = con1.createStatement();
							ResultSet rSet = statement1.executeQuery(sqlString1);
							while(rSet.next()) {
								int id1 = rSet.getInt(1);
								String title = rSet.getString(2);
								String poster = rSet.getString(3);
								String description = rSet.getString(4); 
								int year = rSet.getInt(5);
								String genre = rSet.getString(6);
								int view = rSet.getInt(7);
								boolean active = rSet.getBoolean(8);
								String link = rSet.getString(9);
								videoembed aVideo = new videoembed(id1, title, poster, description, year, genre, view, active,link);
								single.add(aVideo);
							}
							req.setAttribute("single", single);

							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						try {
							listnext.clear();
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
									"sa", "123");
							String sqlString2 = "SELECT TOP 4 * FROM dbo.video WHERE active = 1 ORDER BY NEWID()";
							Statement statement2 = con.createStatement();
							ResultSet rSet = statement.executeQuery(sqlString2);
							while(rSet.next()) {
								int id1 = rSet.getInt(1);
								String title = rSet.getString(2);
								String poster = rSet.getString(3);
								String description = rSet.getString(4); 
								int year = rSet.getInt(5);
								String genre = rSet.getString(6);
								int view = rSet.getInt(7);
								boolean active = rSet.getBoolean(8);
								video aVideo = new video(id1, title, poster, description, year, genre, view, active);
								listnext.add(aVideo);
							}
							req.setAttribute("listnext", listnext);
						} catch (Exception e) {
							// TODO: handle exception
						}
						

						req.getRequestDispatcher("/view/single.jsp").forward(req, resp);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}else {
					loadindex(req, resp);
					req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
				}
				
				
			}
			if(uri.contains("share")){
				String idvideo = req.getParameter("idvideo");
				String userid = req.getParameter("userid");
				int idint =-1;
				try {
					idint = Integer.parseInt(userid);
				} catch (Exception e) {
					loadindex(req, resp);
					req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
				}
				if(idint>0) {
					String id = req.getParameter("idvideo");
					try {
						single.clear();
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
								"sa", "123");
						String sqlString = "SELECT * FROM dbo.video WHERE active = 1 AND id = "+id;
						Statement statement = con.createStatement();
						ResultSet rSet = statement.executeQuery(sqlString);
						while(rSet.next()) {
							int id1 = rSet.getInt(1);
							String title = rSet.getString(2);
							String poster = rSet.getString(3);
							String description = rSet.getString(4); 
							int year = rSet.getInt(5);
							String genre = rSet.getString(6);
							int view = rSet.getInt(7);
							boolean active = rSet.getBoolean(8);
							String link = rSet.getString(9);
							videoembed aVideo = new videoembed(id1, title, poster, description, year, genre, view, active,link);
							single.add(aVideo);
						}
						req.setAttribute("single", single);

						
					} catch (Exception e) {
						// TODO: handle exception
					}
					req.getRequestDispatcher("/view/share.jsp").forward(req, resp);
				}
			}
		if(uri.contains("sharedone")) {
			System.out.println(1);
			String idvideo = req.getParameter("idvideo");
			String userid = req.getParameter("userid");
			String email = req.getParameter("email");
			int idint =-1;
			try {
				idint = Integer.parseInt(userid);
			} catch (Exception e) {
				loadindex(req, resp);
				req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
			}
			if(idint>0) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
							"sa", "123");
					String sqlString = "INSERT INTO dbo.share VALUES  ( "+userid+",  "+idvideo+",  N'"+email+"',  GETDATE()  )";
					Statement statement = con.createStatement();
					statement.execute(sqlString);
					
					
					String id = req.getParameter("id");
					
					try {
						single.clear();
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection con1 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
								"sa", "123");
						String sqlString1 = "SELECT * FROM dbo.video WHERE active = 1 AND id = "+id;
						Statement statement1 = con.createStatement();
						ResultSet rSet = statement1.executeQuery(sqlString1);
						while(rSet.next()) {
							int id1 = rSet.getInt(1);
							String title = rSet.getString(2);
							String poster = rSet.getString(3);
							String description = rSet.getString(4); 
							int year = rSet.getInt(5);
							String genre = rSet.getString(6);
							int view = rSet.getInt(7);
							boolean active = rSet.getBoolean(8);
							String link = rSet.getString(9);
							videoembed aVideo = new videoembed(id1, title, poster, description, year, genre, view, active,link);
							single.add(aVideo);
						}
						req.setAttribute("single", single);

						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						listnext.clear();
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
								"sa", "123");
						String sqlString2 = "SELECT TOP 4 * FROM dbo.video WHERE active = 1 ORDER BY NEWID()";
						Statement statement2 = con.createStatement();
						ResultSet rSet = statement2.executeQuery(sqlString2);
						while(rSet.next()) {
							int id1 = rSet.getInt(1);
							String title = rSet.getString(2);
							String poster = rSet.getString(3);
							String description = rSet.getString(4); 
							int year = rSet.getInt(5);
							String genre = rSet.getString(6);
							int view = rSet.getInt(7);
							boolean active = rSet.getBoolean(8);
							video aVideo = new video(id1, title, poster, description, year, genre, view, active);
							listnext.add(aVideo);
						}
						req.setAttribute("listnext", listnext);
					} catch (Exception e) {
						// TODO: handle exception
					}
					

					req.getRequestDispatcher("/view/single.jsp").forward(req, resp);
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		if(uri.contains("adduser")) {
			String usernameString = req.getParameter("username");
			String passwordString = req.getParameter("password");
			String emailString = req.getParameter("email");
			String admin = req.getParameter("admin");
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "INSERT INTO dbo.[user] VALUES  (?,  ?,  ?, ?  )";
				PreparedStatement statement = con2.prepareStatement(sqlString);
				statement.setString(1, usernameString);
				statement.setString(2, passwordString);
				statement.setString(3, emailString);
				statement.setString(4, admin);
				statement.execute();
				
				req.getRequestDispatcher("/view/adduser.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (uri.contains("addvideo")) {
			String titleString = req.getParameter("title");
			String poster = req.getParameter("poster");
			String description = req.getParameter("description");
			String year = req.getParameter("year");
			String genre = req.getParameter("genre");
			String view = req.getParameter("view");
			String active = req.getParameter("active");
			String link = req.getParameter("link");
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "INSERT INTO dbo.video VALUES  ( ? ,  ? , ? , ? ,  ? ,  ? , ? ,  ? )";
				PreparedStatement statement =con2.prepareStatement(sqlString);
				statement.setString(1, titleString);
				statement.setString(2, poster);
				statement.setString(3, description);
				statement.setString(4, year);
				statement.setString(5, genre);
				statement.setString(6, view);
				statement.setString(7, active);
				statement.setString(8, link);
				statement.execute();
				
				req.getRequestDispatcher("/view/addvideo.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(uri.contains("edituser")) {
			String iduserString = req.getParameter("iduser");
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT * FROM dbo.[user] WHERE id = "+iduserString;
				Statement statement = con2.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					req.setAttribute("id", rSet.getInt(1));
					
					req.setAttribute("username", rSet.getString(2));
					req.setAttribute("password", rSet.getString(3));
					req.setAttribute("email", rSet.getString(4));
					req.setAttribute("admin", rSet.getBoolean(5));
				}
				loadindex(req, resp);
				req.getRequestDispatcher("/view/edituser.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(uri.contains("editvideo")) {
			String idvideo = req.getParameter("idvideo");
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "SELECT * FROM dbo.video WHERE id = "+idvideo;
				Statement statement = con2.createStatement();
				ResultSet rSet =statement.executeQuery(sqlString);
				while(rSet.next()) {
					req.setAttribute("id", rSet.getInt(1));
					req.setAttribute("title", rSet.getString(2));
					req.setAttribute("poster", rSet.getString(3));
					req.setAttribute("description", rSet.getString(4));
					req.setAttribute("year", rSet.getInt(5));
					req.setAttribute("genre", rSet.getString(6));
					req.setAttribute("view", rSet.getInt(7));
					req.setAttribute("active", rSet.getBoolean(8));
					req.setAttribute("link", rSet.getString(9));
				}
				loadindex(req, resp);
				req.getRequestDispatcher("/view/editvideo.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(uri.contains("edituserdone")) {
			String iduserString = req.getParameter("iduser");
			
			String usernameString = req.getParameter("username");
			String passwordString = req.getParameter("password");
			String emailString =req.getParameter("email");
			String adminString = req.getParameter("admin");
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString = "UPDATE dbo.[user] SET username = ? , [password] = ? ,email = ? , [admin] = ? WHERE id = ?";
				PreparedStatement st = con2.prepareStatement(sqlString);
				
				st.setString(1, usernameString);
				st.setString(2, passwordString);
				st.setString(3, emailString);
				st.setString(4, adminString);
				st.setString(5, iduserString);
				
				st.execute();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		if(uri.contains("removeuser")) {
			String iduserString = req.getParameter("iduser");
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString ="DELETE dbo.[user] WHERE id = " +iduserString;
				Statement statement = con2.createStatement();
				statement.execute(sqlString);
				req.getRequestDispatcher("/view/dashboard.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(uri.contains("removevideo")) {
			String idvideoString = req.getParameter("idvideo");
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString ="DELETE dbo.video WHERE id =" +idvideoString;
				Statement statement = con2.createStatement();
				statement.execute(sqlString);
				req.getRequestDispatcher("/view/dashboard.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(uri.contains("editvideodone")) {
			String idString = req.getParameter("idvideo");
			String title = req.getParameter("title");
			String poster = req.getParameter("poster");
			String description = req.getParameter("description");
			String year = req.getParameter("year");
			String view = req.getParameter("view");
			String genre = req.getParameter("genre");
			String active = req.getParameter("active");
			String link = req.getParameter("link");
			String sqlString ="UPDATE dbo.video SET title = ?,poster = ?, [description] = ?, [year] = ?,genre=?,[view]=?,active=?,link=? WHERE id=?";
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con2 = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				PreparedStatement statement = con2.prepareStatement(sqlString);
				statement.setString(1, title);
				statement.setString(2, poster);
				statement.setString(3, description);
				statement.setString(4, year);
				statement.setString(5, genre);
				statement.setString(6, view);
				statement.setString(7, active);
				statement.setString(8, link);
				statement.setString(9, idString);
				statement.execute();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}
	
	
	public void loadindex(HttpServletRequest req, HttpServletResponse resp) {
		try {
			listreview.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT TOP 7 * FROM dbo.video WHERE active=1 ORDER BY YEAR DESC";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listreview.add(aVideo);
			}
			req.setAttribute("listreview", listreview);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			listfeatured.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT TOP 20 * FROM dbo.video WHERE active = 1 ORDER BY title DESC";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listfeatured.add(aVideo);
			}
			req.setAttribute("listfeatured", listfeatured);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			listtopviews.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT TOP 20 * FROM dbo.video WHERE active = 1 ORDER BY [view] DESC";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listtopviews.add(aVideo);
			}
			req.setAttribute("listtopviews", listtopviews);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			listrecently.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT TOP 12 * FROM dbo.video WHERE active=1 ORDER BY YEAR DESC";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listrecently.add(aVideo);
			}
			req.setAttribute("listrecently", listrecently);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			listslidebanner.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT TOP 3 * FROM dbo.video WHERE active = 1 ORDER BY id DESC ";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listslidebanner.add(aVideo);
			}
			req.setAttribute("listslidebanner", listslidebanner);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			listslideview.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT TOP 18 * FROM dbo.video WHERE active=1 ORDER BY YEAR DESC";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listslideview.add(aVideo);
			}
			req.setAttribute("listslideview", listslideview);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			listaz.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString ="SELECT * FROM dbo.video WHERE active = 1 ORDER BY title ASC";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listaz.add(aVideo);
			}
			req.setAttribute("indexsize", listaz.size()-1);
			req.setAttribute("indexlist", listaz.size());
			req.setAttribute("listaz", listaz);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			listza.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString ="SELECT * FROM dbo.video WHERE active = 1 ORDER BY title DESC";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listza.add(aVideo);
			}
			
			req.setAttribute("listza", listza);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			listaction.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString ="SELECT * FROM dbo.video WHERE active = 1 AND genre = 'Action'";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listaction.add(aVideo);
			}
			req.setAttribute("indexaction", listaction.size()-1);
			req.setAttribute("listaction", listaction);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			listcomedy.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString ="SELECT * FROM dbo.video WHERE active = 1 AND genre = 'Comedy'";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listcomedy.add(aVideo);
			}
			req.setAttribute("indexcomedy", listcomedy.size()-1);
			req.setAttribute("listcomedy", listcomedy);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			listhorror.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString ="SELECT * FROM dbo.video WHERE active = 1 AND genre = 'Horror'";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listhorror.add(aVideo);
			}
			req.setAttribute("indexhorror", listhorror.size()-1);
			req.setAttribute("listhorror", listhorror);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			listfamily.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString ="SELECT * FROM dbo.video WHERE active = 1 AND genre = 'Family'";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String title = rSet.getString(2);
				String poster = rSet.getString(3);
				String description = rSet.getString(4); 
				int year = rSet.getInt(5);
				String genre = rSet.getString(6);
				int view = rSet.getInt(7);
				boolean active = rSet.getBoolean(8);
				video aVideo = new video(id, title, poster, description, year, genre, view, active);
				listfamily.add(aVideo);
			}
			req.setAttribute("indexfamily", listfamily.size()-1);
			req.setAttribute("listfamily", listfamily);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			
				listfavorite.clear();
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
						"sa", "123");
				String sqlString ="SELECT [like].id,iduser,idvideo,title,[description],poster,[year],genre,[view],active \r\n"
						+ "FROM dbo.video,dbo.[user],dbo.[like] \r\n"
						+ "WHERE iduser=[user].id AND idvideo=video.id AND iduser="+isuser+"\r\n"
						+ "GROUP BY [like].id,iduser,idvideo,title,[description],poster,[year],genre,[view],active";
				Statement statement = con.createStatement();
				ResultSet rSet = statement.executeQuery(sqlString);
				while(rSet.next()) {
					int id = rSet.getInt(3);
					String title = rSet.getString(4);
					String poster = rSet.getString(6);
					String description = rSet.getString(5); 
					int year = rSet.getInt(7);
					String genre = rSet.getString(8);
					int view = rSet.getInt(9);
					boolean active = rSet.getBoolean(10);
					video aVideo = new video(id, title, poster, description, year, genre, view, active);
					listfavorite.add(aVideo);
				}
				req.setAttribute("indexfavorite", listfavorite.size()-1);
				req.setAttribute("listfavorite", listfavorite);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			listuser.clear();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString ="SELECT * FROM dbo.[user]";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				int id = rSet.getInt(1);
				String usernameString = rSet.getString(2);
				String passString = rSet.getString(3);
				String emailString = rSet.getString(4);
				boolean active = rSet.getBoolean(5);
				user aUser = new user(id, usernameString, passString, emailString, active);
				listuser.add(aUser);
				req.setAttribute("indexuser", listuser.size()-1);
				req.setAttribute("listuser", listuser);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT COUNT(*) FROM dbo.[like]";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				req.setAttribute("totallike", rSet.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT COUNT(*) FROM dbo.share";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				req.setAttribute("totalshare", rSet.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=asmjava4",
					"sa", "123");
			String sqlString = "SELECT SUM([view]) FROM dbo.video";
			Statement statement = con.createStatement();
			ResultSet rSet = statement.executeQuery(sqlString);
			while(rSet.next()) {
				req.setAttribute("totalview", rSet.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void checkadmin(HttpServletRequest req, HttpServletResponse resp) {
		if (checkadmin<0) {
			loadindex(req, resp);
			try {
				req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
			} catch (Exception e) {
				
			}
		}
		
	}
}
