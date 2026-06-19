package jp.co.aforce.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		String fileName = req.getParameter("name");

		File file = new File("C:\\upload", fileName);

		FileInputStream fis = new FileInputStream(file);

		if (fileName.endsWith(".png")) {
			res.setContentType("image/png");
		} else {
			res.setContentType("image/jpeg");
		}

		OutputStream os = res.getOutputStream();

		byte[] buf = new byte[1024];
		int len;

		while ((len = fis.read(buf)) != -1) {
			os.write(buf, 0, len);
		}

		fis.close();
	}
}
