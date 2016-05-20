package servlet;

import com.jspsmart.upload.SmartUpload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
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
		//jspsmartupload组件只支持GBK，不支持utf-8
		request.setCharacterEncoding("GBK");
		com.jspsmart.upload.SmartUpload su = new SmartUpload();
		response.setContentType("text/html; charset=GBK");
		su.initialize(getServletConfig(), request, response);
		// 设定上传限制
		// 限制每个上传文件的最大长度。
		// su.setMaxFileSize(10000);
		// 限制总上传数据的长度。
		// su.setTotalMaxFileSize(20000);
		// 设定允许上传的文件（通过扩展名限制）,仅允许doc,txt文件。
		// su.setAllowedFilesList("doc,txt");
		// 设定禁止上传的文件（通过扩展名限制）,禁止上传带有exe,bat,jsp,htm,html扩展名的文件和没有扩展名的文件。
		// su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
		PrintWriter out = response.getWriter();
		try {
			su.upload();

			int count = su.save("/upload", SmartUpload.SAVE_VIRTUAL);
			out.println(count + "个文件上传<br>");

			// 逐一提取上传文件信息，同时可保存文件。
			for (int i = 0; i < su.getFiles().getCount(); i++) {
				com.jspsmart.upload.File file = su.getFiles().getFile(i);

				// 若文件不存在则继续
				if (file.isMissing())
					continue;

				else {
					// 显示当前文件信息
					out.println("<br/>文件名：" + file.getFileName() + "　长度："
							+ file.getSize());
					// 调试用，因为通过eclipse运行的tomcat的实际目录不是项目的位置
					out.println("<br/>实际上传的位置"
							+ request.getSession().getServletContext()
									.getRealPath(""));
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace().toString());
		}

	}

}
