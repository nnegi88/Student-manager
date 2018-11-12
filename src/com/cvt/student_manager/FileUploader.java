package com.cvt.student_manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String upload_path;
	
    public FileUploader() {
        super();
    }
    
    public void init() {
    	upload_path = getServletContext().getInitParameter("upload-path");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> file = upload.parseRequest(request);
			FileOutputStream fileOutputStream = new FileOutputStream(getServletContext().getInitParameter("temp-path"));
			fileOutputStream.write(file.get(0).get());
			fileOutputStream.close();
			request.getRequestDispatcher("append").forward(request, response);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
