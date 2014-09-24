package com.blackhawks;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Created by devuser on 9/23/2014.
 */
public class ProcessRequest {
    private final PrintWriter o;
    private final String i;
    private final Socket socket;


    public ProcessRequest(PrintWriter o, BufferedReader in, String i, Socket socket) throws Exception{
        this.o = o;
        this.i = i;
        this.socket = socket;

        while (true) {

            String CRLF = "\r\n";
            String serverLine = "Server responding with: ";
            String statusLine = null;
            String contentTypeLine = null;
            String notFound404 = null;
            String contentLengthLine = "error";
            String headerLine = i;
            ContentType ct = new ContentType();
            System.out.println(headerLine);

            StringTokenizer s = new StringTokenizer(headerLine);
            String temp = s.nextToken();

            if (temp.equals("GET")) {

                String fileName = s.nextToken();
                fileName = "." + fileName;

                FileInputStream fis = null;
                boolean fileExists = true;
                try {
                    fis = new FileInputStream(fileName);
                } catch (FileNotFoundException e) {
                    fileExists = false;
                }
                if (fileExists) {
                    statusLine = "HTTP/1.0 200 OK" + CRLF;
                    contentTypeLine = "Content-type: " + ct.returnType(fileName)
                            + CRLF;
                    contentLengthLine = "Content-Length: "
                            + (new Integer(fis.available())).toString() + CRLF;
                } else {
                    statusLine = "HTTP/1.0 404 Not Found" + CRLF;
                    contentTypeLine = "text/html";
                    notFound404 = "<HTML>"
                            + "<HEAD><TITLE>404 Not Found</TITLE></HEAD>"
                            + "<BODY>404 Not Found"
                            + "<br>usage:http://localhost:5000/"
                            + "</BODY></HTML>";
                }

                // status line.
                o.write(statusLine);
                System.out.println(statusLine);

                // server line.
                o.write(serverLine);
                System.out.println(serverLine);

                // content type line.
                o.write(contentTypeLine);
                System.out.println(contentTypeLine);

                // Content-Length
                o.write(contentLengthLine);
                System.out.println(contentLengthLine);

                // end of the header lines.
                o.write(CRLF);
                System.out.println(CRLF);

                // 404 html.
                if (fileExists) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    o.write(notFound404);
                }

            }
        }

        try {
            o.close();
            in.close();
            //socket.close();
        } catch (IOException e) {
        }


        o.println(i);
        o.flush();
    }



//    private static void sendBytes(FileInputStream fis, PrintWriter os)
//            throws Exception {
//
//        byte[] buffer = new byte[1024];
//        int bytes = 0;
//
//        while ((bytes = fis.read(buffer)) != -1) {
//            os.write(buffer, 0, bytes);
//        }
//    }





}
