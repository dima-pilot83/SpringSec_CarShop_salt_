package ua.kiev.prog.controller;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.kiev.prog.service.TakenServicesService;
import ua.kiev.prog.service.TestDriveService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
public class FileController {


    @Autowired
    private TestDriveService testDriveService;
    @Autowired
    private TakenServicesService takenServicesService;

    private static final Logger log3 = Logger.getLogger(FileController.class);

    @RequestMapping(value = "/downloadFile/{action}", method = RequestMethod.POST)
    public
    @ResponseBody
    void downloadFiles(HttpServletRequest request,
                       HttpServletResponse response, @PathVariable(value = "action") String action) throws IOException {

        ServletContext context = request.getSession().getServletContext();
        String realContextPath = context.getRealPath(request.getContextPath());

        try {
            File downloadFile = new File(realContextPath + "/docfolder/list.doc");
            downloadFile.createNewFile();
        } catch (IOException e) {
            log3.error(e.getMessage());
        }

        try (OutputStream f = new FileOutputStream(realContextPath + "/docfolder/list.doc");
             OutputStreamWriter writer = new OutputStreamWriter(f);
             BufferedWriter out = new BufferedWriter(writer)) {
            if ((action).equals("td")) {
                out.write(testDriveService.getAll().toString());
                out.flush();
            }
            if ((action).equals("ts")) {
                out.write(takenServicesService.getAll().toString());
                out.flush();
            }
        } catch (IOException ex) {
            log3.error(ex.getMessage());
        }


        FileInputStream inputStream = null;
        OutputStream outStream = null;
        try {
            File downloadFile = new File(realContextPath + "/docfolder/list.doc");
            inputStream = new FileInputStream(downloadFile);

            response.setContentLength((int) downloadFile.length());
            response.setContentType(context.getMimeType(realContextPath + "/docfolder/list.doc"));
            // response header
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);
            // Write response
            outStream = response.getOutputStream();
            IOUtils.copy(inputStream, outStream);
        } catch (Exception e) {
            log3.error(e.getMessage());
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
                if (null != inputStream)
                    outStream.close();
            } catch (IOException e) {
                log3.error(e.getMessage());
            }
        }
    }
}
