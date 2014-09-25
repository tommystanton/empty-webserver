package com.blackhawks;

import java.io.*;

public class PartialContent {

    private String readInHolder;
    private String fileRef;
    private int byteCountMax;
    private String returnByByte;

    public PartialContent( String str, int cnt ) throws FileNotFoundException{
        byteCountMax = cnt;
        fileRef = str;
    }

    public String getByteStreamByCount() throws IOException {
        {
            File file = new File(fileRef); //for ex foo.txt
            try {
                FileReader reader = new FileReader(file);
                char[] chars = new char[(int) byteCountMax];
                reader.read(chars);
                returnByByte = new String(chars);
                reader.close();
            } catch (IOException e) {
                returnByByte = "404 File Not Found";
            }
            return returnByByte;
        }
    }

    public String readFileIn() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileRef))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            readInHolder = sb.toString();
            return readInHolder;
        }catch ( IOException e){
            System.out.print("DUDE ERROR WITH YO FILE!!!" + e );
        }

        return null;
    }
}
