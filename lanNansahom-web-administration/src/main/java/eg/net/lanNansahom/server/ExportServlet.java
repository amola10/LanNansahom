package eg.net.lanNansahom.server;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import eg.net.gxt.client.ClientException;
import eg.net.gxt.client.widget.ComboBoxBean;
import eg.net.lanNansahom.shared.beans.LookupBean;
import eg.net.lanNansahom.shared.beans.MartyrBean;
import eg.net.lanNansahom.shared.beans.RelativeBean;
import eg.net.lanNansahom.shared.beans.SearchVictimsBean;
import eg.net.lanNansahom.shared.beans.VictimBean;
import eg.net.lanNansahom.shared.beans.VideoBean;

public class ExportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 533511709039562531L;

	private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

	private final boolean inCloudMode = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		process(arg0, arg1);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<? extends VictimBean> victims = searchVicitims(request);
			response.setContentType("application/vnd.ms-excel");
			boolean isMartyr = Boolean.valueOf(request.getParameter("isMartyr"));

			HSSFWorkbook workbook = new HSSFWorkbook();
			createBasicDataSheet(workbook, victims, isMartyr);
			createPersonalDataSheet(workbook, victims);
			createTextSheet(workbook, victims);
			createVideosSheet(workbook, victims);
			createContactsSheet(workbook, victims);
			// Write the output
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.close();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	private void createBasicDataSheet(HSSFWorkbook workbook, List<? extends VictimBean> victims, boolean isMartyr) {
		HSSFSheet sheet = workbook.createSheet("Basic Data");

		// create Header
		HSSFRow row = sheet.createRow((short) 0);
		row.createCell((short) 0).setCellValue("Id");
		row.createCell((short) 1).setCellValue("Name");
		row.createCell((short) 2).setCellValue("Injury Date");
		row.createCell((short) 3).setCellValue("Injury Area");
		if (isMartyr) {
			row.createCell((short) 4).setCellValue("Death Date");
			row.createCell((short) 5).setCellValue("Death Area");
		}

		int rowNumber = 1;
		for (VictimBean bean : victims) {
			row = sheet.createRow((short) rowNumber);
			row.createCell((short) 0).setCellValue(bean.getId());
			row.createCell((short) 1).setCellValue(bean.getName());
			if (bean.getInjuryDate() != null) {
				row.createCell((short) 2).setCellValue(format.format(bean.getInjuryDate()));
			}
			row.createCell((short) 3)
					.setCellValue(bean.getInjuryArea() != null ? bean.getInjuryArea().getName() : null);

			if (isMartyr) {
				MartyrBean martyrBean = (MartyrBean) bean;
				if (martyrBean.getDeathDate() != null) {
					row.createCell((short) 4).setCellValue(format.format(martyrBean.getDeathDate()));
				}
				row.createCell((short) 5).setCellValue(
						martyrBean.getDeathArea() != null ? martyrBean.getDeathArea().getName() : null);
			}
			rowNumber++;
		}
		if (!inCloudMode) {
			sheet.autoSizeColumn((short) 0);
			sheet.autoSizeColumn((short) 1);
			sheet.autoSizeColumn((short) 2);
			sheet.autoSizeColumn((short) 3);
			if (isMartyr) {
				sheet.autoSizeColumn((short) 4);
				sheet.autoSizeColumn((short) 5);
			}
		}

	}

	private void createPersonalDataSheet(HSSFWorkbook workbook, List<? extends VictimBean> victims) {
		HSSFSheet sheet = workbook.createSheet("Personal Data");

		// create Header
		HSSFRow row = sheet.createRow((short) 0);
		row.createCell((short) 0).setCellValue("Id");
		row.createCell((short) 1).setCellValue("Name");
		row.createCell((short) 2).setCellValue("Age");
		row.createCell((short) 3).setCellValue("Birthday");
		row.createCell((short) 4).setCellValue("Education");
		row.createCell((short) 5).setCellValue("Job");
		row.createCell((short) 6).setCellValue("Address");
		row.createCell((short) 7).setCellValue("Residence Area");

		int rowNumber = 1;
		for (VictimBean bean : victims) {
			row = sheet.createRow((short) rowNumber);
			row.createCell((short) 0).setCellValue(bean.getId());
			row.createCell((short) 1).setCellValue(bean.getName());
			if (bean.getAge() != null)
				row.createCell((short) 2).setCellValue(bean.getAge());
			if (bean.getBirthDate() != null) {
				row.createCell((short) 3).setCellValue(format.format(bean.getBirthDate()));
			}
			row.createCell((short) 4).setCellValue(bean.getEducation() != null ? bean.getEducation().getName() : null);
			row.createCell((short) 5).setCellValue(bean.getJob() != null ? bean.getJob().getName() : null);
			row.createCell((short) 6).setCellValue(bean.getAddress());
			row.createCell((short) 7).setCellValue(
					bean.getResidenceArea() != null ? bean.getResidenceArea().getName() : null);
			rowNumber++;
		}

		if (!inCloudMode) {
			sheet.autoSizeColumn((short) 0);
			sheet.autoSizeColumn((short) 1);
			sheet.autoSizeColumn((short) 2);
			sheet.autoSizeColumn((short) 3);
			sheet.autoSizeColumn((short) 4);
			sheet.autoSizeColumn((short) 5);
			sheet.autoSizeColumn((short) 6);
			sheet.autoSizeColumn((short) 7);
		}
	}

	private void createTextSheet(HSSFWorkbook workbook, List<? extends VictimBean> victims) {
		HSSFSheet sheet = workbook.createSheet("Text");

		// create Header
		HSSFRow row = sheet.createRow((short) 0);
		row.createCell((short) 0).setCellValue("Id");
		row.createCell((short) 1).setCellValue("Name");
		row.createCell((short) 2).setCellValue("Description");
		row.createCell((short) 3).setCellValue("Injury Description");

		int rowNumber = 1;
		for (VictimBean bean : victims) {
			row = sheet.createRow((short) rowNumber);
			row.createCell((short) 0).setCellValue(bean.getId());
			row.createCell((short) 1).setCellValue(bean.getName());
			row.createCell((short) 2).setCellValue(bean.getDescription());
			row.createCell((short) 3).setCellValue(bean.getMedicalDescription());
			rowNumber++;
		}

		if (!inCloudMode) {
			sheet.autoSizeColumn((short) 0);
			sheet.autoSizeColumn((short) 1);
		}

	}

	private void createVideosSheet(HSSFWorkbook workbook, List<? extends VictimBean> victims) {
		HSSFSheet sheet = workbook.createSheet("Videos");

		// create Header
		HSSFRow row = sheet.createRow((short) 0);
		row.createCell((short) 0).setCellValue("Id");
		row.createCell((short) 1).setCellValue("Name");
		row.createCell((short) 2).setCellValue("Video");
		row.createCell((short) 3).setCellValue("Created By");

		int rowNumber = 1;
		for (VictimBean bean : victims) {
			row = sheet.createRow((short) rowNumber);
			row.createCell((short) 0).setCellValue(bean.getId());
			row.createCell((short) 1).setCellValue(bean.getName());

			for (VideoBean videoBean : bean.getVideos()) {
				row = sheet.createRow((short) rowNumber);
				row.createCell((short) 2).setCellValue("http://www.youtube.com/watch?v=" + videoBean.getUrl());
				row.createCell((short) 3).setCellValue(videoBean.getOwner());

				rowNumber++;

			}
			rowNumber++;
		}
		if (!inCloudMode) {
			sheet.autoSizeColumn((short) 0);
			sheet.autoSizeColumn((short) 1);
			sheet.autoSizeColumn((short) 2);
			sheet.autoSizeColumn((short) 3);
		}
	}

	private void createContactsSheet(HSSFWorkbook workbook, List<? extends VictimBean> victims) {
		HSSFSheet sheet = workbook.createSheet("Contacts");

		// create Header
		HSSFRow row = sheet.createRow((short) 0);
		row.createCell((short) 0).setCellValue("Id");
		row.createCell((short) 1).setCellValue("Name");
		row.createCell((short) 2).setCellValue("Relative Name");
		row.createCell((short) 3).setCellValue("Relation");
		row.createCell((short) 4).setCellValue("Home Number");
		row.createCell((short) 5).setCellValue("Mobile Number");
		row.createCell((short) 6).setCellValue("Email");
		row.createCell((short) 7).setCellValue("Is Contact Published");

		int rowNumber = 1;
		for (VictimBean bean : victims) {
			row = sheet.createRow((short) rowNumber);
			row.createCell((short) 0).setCellValue(bean.getId());
			row.createCell((short) 1).setCellValue(bean.getName());

			for (RelativeBean relativeBean : bean.getRelatives()) {
				if (relativeBean.hasContact()) {
					row = sheet.createRow((short) rowNumber);
					row.createCell((short) 2).setCellValue(relativeBean.getName());
					row.createCell((short) 3).setCellValue(
							relativeBean.getRelationship() != null ? relativeBean.getRelationship().getName() : null);
					row.createCell((short) 4).setCellValue(relativeBean.getHomeNumber());
					row.createCell((short) 5).setCellValue(relativeBean.getMobileNumber());
					row.createCell((short) 6).setCellValue(relativeBean.getEmail());
					row.createCell((short) 7).setCellValue(relativeBean.getContatctPublished() ? "yes" : "no");
					rowNumber++;

				}
			}
			rowNumber++;
		}

		if (!inCloudMode) {
			sheet.autoSizeColumn((short) 0);
			sheet.autoSizeColumn((short) 1);
			sheet.autoSizeColumn((short) 2);
			sheet.autoSizeColumn((short) 3);
			sheet.autoSizeColumn((short) 4);
			sheet.autoSizeColumn((short) 5);
			sheet.autoSizeColumn((short) 6);
			sheet.autoSizeColumn((short) 7);
		}
	}

	private List<? extends VictimBean> searchVicitims(HttpServletRequest request) throws ClientException {

		SearchVictimsBean bean = new SearchVictimsBean();
		bean.setName(request.getParameter("name"));
		if (request.getParameter("areaId") != null) {
			bean.setArea(new LookupBean(Integer.valueOf(request.getParameter("areaId")), ""));
		}

		if (request.getParameter("age") != null) {
			bean.setAge(Integer.valueOf(request.getParameter("age")));
		}

		if (request.getParameter("isMartyr") != null) {
			bean.setMartyr(Boolean.valueOf(request.getParameter("isMartyr")));
		}

		if (request.getParameter("educationId") != null) {
			bean.setEducation(new LookupBean(Integer.valueOf(request.getParameter("educationId")), ""));
		}

		if (request.getParameter("jobId") != null) {
			bean.setJob(new LookupBean(Integer.valueOf(request.getParameter("jobId")), ""));
		}

		if (request.getParameter("id") != null) {
			bean.setId(Integer.valueOf(request.getParameter("id")));
		}

		if (request.getParameter("published") != null) {
			bean.setPublished(new ComboBoxBean(request.getParameter("published")));
		}

		if (request.getParameter("date") != null) {
			try {
				bean.setDate(format.parse(request.getParameter("date")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		AdministrationRemoteServiceImpl service = new AdministrationRemoteServiceImpl();
		return service.searchVictims(bean);

	}
}
