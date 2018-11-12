package com.cvt.student_manager;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CsvAppender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String temp_path, data_path;
	
	public CsvAppender() {
		super();
	}

	public void init() {
		data_path = getServletContext().getInitParameter("data-path");
		temp_path = getServletContext().getInitParameter("temp-path");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter();

		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(data_path), StandardCharsets.UTF_16);

			StringBuilder everything = new StringBuilder();
			
			String line = br.readLine();
			while (line != null) {
				everything.append(line);
				everything.append(System.lineSeparator());
				line = br.readLine();
			}
			
			br = Files.newBufferedReader(Paths.get(temp_path), StandardCharsets.UTF_16);
			line = br.readLine();
			while (line != null) {
				everything.append(line);
				everything.append(System.lineSeparator());
				line = br.readLine();
			}
			br.close();
			
			FileOutputStream fs = new FileOutputStream(data_path);
			fs.write(everything.toString().getBytes("UTF-16"));
			fs.close();
			
			request.setAttribute("data", everything);
			request.getRequestDispatcher("/converter").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
