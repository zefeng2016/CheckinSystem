package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownFile
 */
@WebServlet("/DownFile")
public class DownFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("filename");

		response.reset();
		response.setContentType("application/x-download");

		// 获取的物理路径
		String filedownload = request.getSession().getServletContext()
				.getRealPath("/upload/" + filename);

		String filedisplay = URLEncoder.encode(filename, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ filedisplay);

		java.io.OutputStream outp = null;
		java.io.FileInputStream in = null;
		try {
			outp = response.getOutputStream();
			in = new FileInputStream(filedownload);

			byte[] b = new byte[1024];
			int i = 0;

			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			//删除输出流
			outp.flush();
			outp.close();
			outp=null;
			
			response.flushBuffer();


		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
		}
	}

}
