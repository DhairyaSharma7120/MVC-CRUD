package Controller.java;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import DAO.regDAO;
import VO.regVO;

/**
 * Servlet implementation class regController
 */
@WebServlet("/regController")
public class regController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String s1 = request.getParameter("firstname");
		String s2 = "y";
		s2 = request.getParameter("lastname");
		System.out.println(" fn is "+s1+" ln is "+s2);
		int flag = Integer.parseInt(request.getParameter("submit"));
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("delete"));
//			System.out.print(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("wait");
		}
		System.out.println("flag is  " + flag);
//		System.out.println("id is "+ id);
		
		regVO v = new regVO();
		v.setFn(s1);
		v.setLn(s2);
		
		regVO s = new regVO();
		s.setFn(s1);
		s.setLn(s2);
		
		
		
		regVO y = new regVO();
		try {
			if(id != -1){
			y.setId(id);}
//		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("hello");
		}		
		regDAO d = new regDAO();
		if(flag == 1){
			System.out.println("entering insert....................................");
			if(v.getFn() != "" && v.getLn() != ""){
			d.insert(v);
			System.out.println("added ");	
			}	
			else{
				System.out.println("fill all");
			}
		}
		if(flag == 2){
			System.out.println("entering search....................................");
			d.search(v);
		}
		if(flag == 3){
			System.out.println("entering deletion .....................................");
			d.delete(y);
		}
		if(flag == 4){
			System.out.println("entering updation...................................");
//			d.edit(v);
		}
		
		
		
		
		
		ArrayList<Object> l = d.search(s);
		HttpSession sess = request.getSession();
		
		sess.setAttribute("list", l);
//		System.out.println(l);
//		System.out.println(l.isEmpty());
		if(l.isEmpty()){
//			System.out.println("empty");
			response.sendRedirect("reg.jsp");
		}else{
//			System.out.println("not empty");
//			System.out.println(l);
			response.sendRedirect("reg.jsp");
		}
		
	}

}
