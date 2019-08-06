package util;

import java.io.*;

/**
 * @version 1.0
 * @author xiaomeichao
 * @date 2014-08-25
 * @description  生成结束标识文件
 */

public class CreateEndFileUtil{
    private final String fileId = "05"; //文件ID
    private final String fileType = "txt"; //文件类型
    private String filePathFeild;//文件路径
    private String fileNameFeild;//文件名

    public static final String END_FILE_LASTFIX = ".end";

    public static void main(String[] args) {
        String filePath = "E:\\test\\";
        String fileName = "writedFile";

        if(filePath==null||"".equals(filePath.trim())||fileName==null||"".equals(fileName.trim())){
            //return "1";
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n")
                    .append(EnterInAccUtil.feildFormat4Str("1234", 8)).append(EnterInAccUtil.feildFormat4Str("english", 8)).append("\n");

            writeFile4TXT(stringBuilder.toString(),filePath,fileName,"0");
//		fileName = fileName.replace(EnterInAccConstant.FILE_LASTFIX, EnterInAccConstant.END_FILE_LASTFIX);
        fileName = fileName+END_FILE_LASTFIX;

        //CASFileCreator createFile = CreateFileFactory.getCASFileCreator(fileId,fileType);

            writeFile4TXT("",filePath,fileName,"0");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 将字符串写TXT文件
     * @param fileContent
     */
    public static void writeFile4TXT(String fileContent,String filePath,String fileName,String appendFlag) throws Exception{

        new File(filePath).mkdir();

        File file = new File(filePath+fileName);

        if(file.exists()&&appendFlag!=null&&"0".equals(appendFlag)){
            file.delete();
        }
        BufferedWriter fileWriter = null;

        if(fileContent==null){
            return;
        }
        try {
            fileWriter = new BufferedWriter( new OutputStreamWriter( new FileOutputStream( file, true ), "GBK" ) );
            fileWriter.write(fileContent);
        } catch (Exception e) {
            throw new Exception("生成文件失败");
        }finally{
            if(fileWriter!=null)
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    //Trace.logWarning(Trace.COMPONENT_FILE, "文件对象关闭异常", e);
                }
        }
    }

}
