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
		//jspsmartupload���ֻ֧��GBK����֧��utf-8
		request.setCharacterEncoding("GBK");
		com.jspsmart.upload.SmartUpload su = new SmartUpload();
		response.setContentType("text/html; charset=GBK");
		su.initialize(getServletConfig(), request, response);
		// �趨�ϴ�����
		// ����ÿ���ϴ��ļ�����󳤶ȡ�
		// su.setMaxFileSize(10000);
		// �������ϴ����ݵĳ��ȡ�
		// su.setTotalMaxFileSize(20000);
		// �趨�����ϴ����ļ���ͨ����չ�����ƣ�,������doc,txt�ļ���
		// su.setAllowedFilesList("doc,txt");
		// �趨��ֹ�ϴ����ļ���ͨ����չ�����ƣ�,��ֹ�ϴ�����exe,bat,jsp,htm,html��չ�����ļ���û����չ�����ļ���
		// su.setDeniedFilesList("exe,bat,jsp,htm,html,,");
		PrintWriter out = response.getWriter();
		try {
			su.upload();

			int count = su.save("/upload", SmartUpload.SAVE_VIRTUAL);
			out.println(count + "���ļ��ϴ�<br>");

			// ��һ��ȡ�ϴ��ļ���Ϣ��ͬʱ�ɱ����ļ���
			for (int i = 0; i < su.getFiles().getCount(); i++) {
				com.jspsmart.upload.File file = su.getFiles().getFile(i);

				// ���ļ������������
				if (file.isMissing())
					continue;

				else {
					// ��ʾ��ǰ�ļ���Ϣ
					out.println("<br/>�ļ�����" + file.getFileName() + "�����ȣ�"
							+ file.getSize());
					// �����ã���Ϊͨ��eclipse���е�tomcat��ʵ��Ŀ¼������Ŀ��λ��
					out.println("<br/>ʵ���ϴ���λ��"
							+ request.getSession().getServletContext()
									.getRealPath(""));
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace().toString());
		}

	}

}
